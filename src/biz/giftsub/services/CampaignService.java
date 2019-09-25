package biz.giftsub.services;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import biz.giftsub.daos.CampaignMapper;
import biz.giftsub.enums.CampaignStatus;
import biz.giftsub.models.Campaign;
import biz.giftsub.models.ReportsDto;

@Component
public class CampaignService {

	private static final long ONE_DAY_IN_MILLIS = 1000 * 60 * 60 * 24;

	@Autowired
	CampaignMapper campaignMapper;

	Logger logger = Logger.getLogger(CampaignService.class);

	public List<Campaign> getAllCampaigns(String organizationId) {
		List<Campaign> campaigns = campaignMapper.findAllCampaigns(organizationId);
		return campaigns;
	}

	public Campaign getCampaignById(String campaignId) {
		return campaignMapper.findCampaignById(campaignId);
	}

	public Campaign updateCampaign(Campaign campaignToUpdate) {
		int rows = campaignMapper.updateCampaign(campaignToUpdate);
		if (1 != rows) {
			return null;
		}
		return campaignToUpdate;
	}

	public Campaign createCampaign(Campaign campaignToCreate) {
		campaignToCreate.setId(UUID.randomUUID().toString());
		campaignToCreate.setStatus(CampaignStatus.DRAFT);

		int rows = campaignMapper.insertCampaign(campaignToCreate);
		if (1 != rows) {
			return null;
		}
		return campaignToCreate;
	}

	public Campaign duplicateCampaign(String campaignId) {
		Campaign campaignSource = getCampaignById(campaignId);
		campaignSource.setName("Copy of " + campaignSource.getName());
		campaignSource.setStartDate(0L);
		campaignSource.setEndDate(0L);
		campaignSource.setStartTimestamp(null);
		campaignSource.setEndTimestamp(null);
		Campaign campaignTarget = createCampaign(campaignSource);
		return campaignTarget;
	}

	public Campaign stopCampaign(String campaignId) {
		Campaign campaignToStop = getCampaignById(campaignId);
		if (campaignToStop.getStatus() == CampaignStatus.ACTIVE) {
			campaignToStop.setEndDate(System.currentTimeMillis());
			campaignToStop.setStatus(CampaignStatus.COMPLETED);
			Campaign campaign = updateCampaign(campaignToStop);
			return campaign;
		} else {
			return null;
		}
	}

	public Campaign startCampaign(String campaignId) {
		Campaign campaignToStart = getCampaignById(campaignId);
		if (campaignToStart.getStatus() == CampaignStatus.DRAFT) {
			// Shut down all ACTIVE campaigns
			List<Campaign> campaigns = getAllCampaigns(campaignToStart.getOrganizationId());
			for (Campaign c : campaigns) {
				if (c.getStatus() == CampaignStatus.ACTIVE) {
					stopCampaign(c.getId());
				}
			}

			campaignToStart.setStartDate(System.currentTimeMillis());
			campaignToStart.setStatus(CampaignStatus.ACTIVE);
			Campaign campaign = updateCampaign(campaignToStart);
			return campaign;
		} else {
			return null;
		}
	}

	public Campaign getActiveCampaignFromOrganizationPath(String organizationPath) {
		Campaign c = campaignMapper.findActiveCampaignByOrganizationPath(organizationPath);
		return c;
	}

	public List<ReportsDto> getCampaignGiftsSold(String campaignId) {
		List<ReportsDto> reports = campaignMapper.calcGiftsSold(campaignId);
		Campaign c = getCampaignById(campaignId);
		List<ReportsDto> paddedReports = padDailyChart(c.getStartDate(), c.getEndDate(), reports);
		return paddedReports;
	}

	public List<ReportsDto> getCampaignRevenue(String campaignId) {
		List<ReportsDto> reports = campaignMapper.calcRevenue(campaignId);
		Campaign c = getCampaignById(campaignId);
		List<ReportsDto> paddedReports = padRunningTotalChart(c.getStartDate(), c.getEndDate(), reports);
		return paddedReports;
	}

	public ReportsDto getCampaignFunnel(String campaignId) {
		return campaignMapper.calcFunnel(campaignId);
	}

	public List<ReportsDto> getCampaignNetworkGraph(String campaignId) {
		return campaignMapper.calcNetworkGraph(campaignId);
	}

	private ReportsDto getEmptyReportsDto(long currentDate) {
		ReportsDto padR = new ReportsDto();
		padR.setEpoch(currentDate);
		padR.setIntegerData(0);
		padR.setBigDecimalData(new BigDecimal(0));
		return padR;
	}

	private ReportsDto getRunningTotalReportsDto(long currentDate, ReportsDto r) {
		ReportsDto padR = new ReportsDto();
		padR.setEpoch(currentDate);
		padR.setIntegerData(r.getIntegerData());
		padR.setBigDecimalData(r.getBigDecimalData());
		return padR;
	}

	private List<ReportsDto> padDailyChart(long startDate, long endDate, List<ReportsDto> reports) {
		LocalDate startLocalDate = Instant.ofEpochMilli(startDate).atZone(ZoneId.of("UTC")).toLocalDate();
		long currentDate = startLocalDate.atStartOfDay(ZoneId.of("UTC")).toEpochSecond() * 1000;
		List<ReportsDto> paddedList = new ArrayList<ReportsDto>();
		for (ReportsDto r : reports) {
			while (currentDate < r.getEpoch()) {
				paddedList.add(getEmptyReportsDto(currentDate));
				currentDate += ONE_DAY_IN_MILLIS;
			}
			paddedList.add(r);
			currentDate += ONE_DAY_IN_MILLIS;
		}
		while (currentDate < endDate) {
			paddedList.add(getEmptyReportsDto(currentDate));
			currentDate += ONE_DAY_IN_MILLIS;
		}
		return paddedList;
	}

	private List<ReportsDto> padRunningTotalChart(long startDate, long endDate, List<ReportsDto> reports) {
		LocalDate startLocalDate = Instant.ofEpochMilli(startDate).atZone(ZoneId.of("UTC")).toLocalDate();
		long currentDate = startLocalDate.atStartOfDay(ZoneId.of("UTC")).toEpochSecond() * 1000;
		List<ReportsDto> paddedList = new ArrayList<ReportsDto>();
		ReportsDto finalR = getEmptyReportsDto(currentDate);
		for (ReportsDto r : reports) {
			while (currentDate < r.getEpoch()) {
				paddedList.add(getRunningTotalReportsDto(currentDate, finalR));
				currentDate += ONE_DAY_IN_MILLIS;
			}
			paddedList.add(r);
			currentDate += ONE_DAY_IN_MILLIS;
			finalR = r;
		}
		while (currentDate < endDate) {
			paddedList.add(getRunningTotalReportsDto(currentDate, finalR));
			currentDate += ONE_DAY_IN_MILLIS;
		}
		return paddedList;
	}

}
