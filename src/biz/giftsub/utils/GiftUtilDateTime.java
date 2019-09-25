package biz.giftsub.utils;

import java.sql.Timestamp;

public class GiftUtilDateTime {

	public static Timestamp returnBestTimestamp(Timestamp givenTimestamp, long givenDttm) {
		Timestamp returnTimestamp = givenTimestamp;
		if (null == givenTimestamp) {
			if (givenDttm > 0) {
				returnTimestamp = new Timestamp(givenDttm);
			}
		}
		return returnTimestamp;
	}

	public static long returnBestEpoch(long givenDttm, Timestamp givenTimestamp) {
		long returnDttm = givenDttm;
		if (givenDttm <= 0) {
			if (null != givenTimestamp) {
				returnDttm = givenTimestamp.getTime();
			}
		}
		return returnDttm;
	}

}
