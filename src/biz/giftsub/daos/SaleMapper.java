package biz.giftsub.daos;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import biz.giftsub.models.Sale;

public interface SaleMapper {

	String SELECT_BY_ID = ""
			+ "SELECT id, campaign_id, "
			+ "sender_name, sender_email, sender_message, "
			+ "recipient_name, recipient_email, "
			+ "gift_name, gift_value, transaction_date, "
			+ "gift_claim_email, otp "
			+ "FROM sale "
			+ "WHERE id=#{saleId}";

	String INSERT = ""
			+ "INSERT INTO sale "
			+ "	(id, campaign_id, "
			+ "		sender_name, sender_email, sender_message, "
			+ "		recipient_name, recipient_email, "
			+ "		gift_name, gift_value, "
			+ "		transaction_date, payment_receipt_id) VALUES "
			+ "	(#{id},#{campaignId}, "
			+ "		#{senderName},#{senderEmail},#{senderMessage}, "
			+ "		#{recipientName},#{recipientEmail}, "
			+ "		#{giftName},#{giftPrice}, "
			+ "		#{saleTimestamp},#{paymentId})";

	String UPDATE_CLAIMED_EMAIL = ""
			+ "UPDATE sale SET "
			+ "gift_claim_email=#{claimedEmail}, "
			+ "otp=#{otp} "
			+ "WHERE id=#{id}";

	String UPDATE_ACTIVATE_OTP = ""
			+ "UPDATE sale SET "
			+ "gift_claim_date=CURRENT_TIMESTAMP "
			+ "WHERE id=#{id}";

	@Insert(INSERT)
	int insertSale(Sale sale);

	@Results(value = {
		@Result(property = "id", column = "id"),
		@Result(property = "campaignId", column = "campaign_id"),
		@Result(property = "giftName", column = "gift_name"),
		@Result(property = "giftPrice", column = "gift_value"),
		@Result(property = "senderName", column = "sender_name"),
		@Result(property = "senderEmail", column = "sender_email"),
		@Result(property = "recipientName", column = "recipient_name"),
		@Result(property = "recipientEmail", column = "recipient_email"),
		@Result(property = "senderMessage", column = "sender_message"),
		@Result(property = "saleTimestamp", column = "transaction_date"),
		@Result(property = "claimedEmail", column = "gift_claim_email"),
		@Result(property = "otp", column = "otp")
	})
	@Select(SELECT_BY_ID)
	Sale getSale(String saleId);

	@Update(UPDATE_CLAIMED_EMAIL)
	int updateSaleClaimedEmail(Sale sale);

	@Update(UPDATE_ACTIVATE_OTP)
	int updateSaleActivateOtp(Sale sale);
	
}
