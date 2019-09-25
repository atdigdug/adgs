package com.mavin.egifting.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mavin.egifting.controller.reports.FunnelData;
import com.mavin.egifting.dao.TransactionMapper;
import com.mavin.egifting.dao.WebviewAnalyticsMapper;
import com.mavin.egifting.model.Transaction;
import com.mavin.egifting.utils.Status;

//TODO(SriramK) - We will have break this service down by individual reports

@Component
public class ReportsService {

	Logger logger = Logger.getLogger(ReportsService.class);

	@Autowired
	WebviewAnalyticsMapper webviewAnalyticsMapper;
	@Autowired
	TransactionMapper transactionMapper;

	// TODO(SriramK) - Oddly the charting component requires an array ???
	public FunnelData[] getFunnelReportData(String campaignId) {
		logger.info("Entering getFunnelReportData() - " + campaignId);
		Preconditions.checkArgument(!Strings.isNullOrEmpty(campaignId));

		FunnelData[] funnelData = new FunnelData[4];

		int interestCount = webviewAnalyticsMapper.findCountByCampaignId(campaignId);
		funnelData[0] = new FunnelData();
		funnelData[0].setValue(interestCount);
		funnelData[0].setName("Interest");

		List<Transaction> transactions = transactionMapper.findByCampaignId(campaignId);
		long actionCount = transactions.stream().filter(t -> t.getSenderPaymentStatus().equalsIgnoreCase(Status.PAID.toString())).count();
		funnelData[1] = new FunnelData();
		funnelData[1].setValue(Math.toIntExact(actionCount));
		funnelData[1].setName("Action");

		long considerationCount = transactions.stream().filter(t -> t.getRecipientClickedEmailLinkDate() > 0).count();
		funnelData[2] = new FunnelData();
		funnelData[2].setValue(Math.toIntExact(considerationCount));
		funnelData[2].setName("Consideration");

		long convertCount = transactions.stream().filter(t -> t.getRecipientActivationSuccessDate() > 0).count();
		funnelData[3] = new FunnelData();
		funnelData[3].setValue(Math.toIntExact(convertCount));
		funnelData[3].setName("Convert");

		logger.info("Exiting getFunnelReportData() - " + funnelData);
		return funnelData;
	}

}
