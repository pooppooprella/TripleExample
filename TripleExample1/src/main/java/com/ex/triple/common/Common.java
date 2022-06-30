package com.ex.triple.common;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Common {



	/** 날짜 조회
	 * @return ex 20000101010101 + paramMonth
	 */
	public String getCalendarDateYMDHMS_ADDMonth(int paramMonth){
		DecimalFormat decimalFormat = new DecimalFormat("00");// decimalformat
		DecimalFormat NumFormat = new DecimalFormat("0000");// 4
		Calendar rightNow = Calendar.getInstance();//
		if(paramMonth != 0){
			rightNow.add(Calendar.MONTH, paramMonth);
		}
		int year = rightNow.get(Calendar.YEAR);
		int month = rightNow.get(Calendar.MONTH)+1;
		int date = rightNow.get(Calendar.DATE);
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);
		int minute = rightNow.get(Calendar.MINUTE);
		int second = rightNow.get(Calendar.SECOND);

		String result = NumFormat.format(year)+""+ decimalFormat.format(month)+"" + decimalFormat.format(date)+""+decimalFormat.format(hour)+""+decimalFormat.format(minute)+""+decimalFormat.format(second)+"";
		return result;
	}
	/** 날짜 조회
	 * @return ex 2000-01-01010101 + paramMonth
	 */
	public String getCalendarDateY_M_D_ADDMonth(int paramMonth){
		DecimalFormat decimalFormat = new DecimalFormat("00");// decimalformat
		DecimalFormat NumFormat = new DecimalFormat("0000");// 4
		Calendar rightNow = Calendar.getInstance();//
		if(paramMonth != 0){
			rightNow.add(Calendar.MONTH, paramMonth);
		}
		int year = rightNow.get(Calendar.YEAR);
		int month = rightNow.get(Calendar.MONTH)+1;
		int date = rightNow.get(Calendar.DATE);

		String result = NumFormat.format(year)+"-"+ decimalFormat.format(month)+"-" + decimalFormat.format(date)+"";
		return result;
	}
	/** 날짜 조회
	 * @return ex 20000101+ paramMonth
	 */
	public String getCalendarDateYMD_ADDDay(int paramDay){
		DecimalFormat decimalFormat = new DecimalFormat("00");// decimalformat
		DecimalFormat NumFormat = new DecimalFormat("0000");// 4
		Calendar rightNow = Calendar.getInstance();//
		if(paramDay != 0){
			rightNow.add(Calendar.DATE, paramDay);
		}
		int year = rightNow.get(Calendar.YEAR);
		int month = rightNow.get(Calendar.MONTH)+1;
		int date = rightNow.get(Calendar.DATE);

		String result = NumFormat.format(year)+""+ decimalFormat.format(month)+"" + decimalFormat.format(date)+"";
		return result;
	}

    /** 날짜 조회
     * @return ex 20000101+ paramMonth
     */
    public String getCalendarDateY_M_D_ADDDay(int paramDay){
        DecimalFormat decimalFormat = new DecimalFormat("00");// decimalformat
        DecimalFormat NumFormat = new DecimalFormat("0000");// 4
        Calendar rightNow = Calendar.getInstance();//
        if(paramDay != 0){
            rightNow.add(Calendar.DATE, paramDay);
        }
        int year = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH)+1;
        int date = rightNow.get(Calendar.DATE);

        String result = NumFormat.format(year)+"-"+ decimalFormat.format(month)+"-" + decimalFormat.format(date)+"";
        return result;
    }

	/** 날짜 조회
	 * @return ex 2000-01-01+ paramMonth
	 */
	public String getCalendarDateY_M_D_ADDYear(int paramDay){
		DecimalFormat decimalFormat = new DecimalFormat("00");// decimalformat
		DecimalFormat NumFormat = new DecimalFormat("0000");// 4
		Calendar rightNow = Calendar.getInstance();//
		if(paramDay != 0){
			rightNow.add(Calendar.YEAR, paramDay);
		}
		int year = rightNow.get(Calendar.YEAR);
		int month = rightNow.get(Calendar.MONTH)+1;
		int date = rightNow.get(Calendar.DATE);

		String result = NumFormat.format(year)+"-"+ decimalFormat.format(month)+"-" + decimalFormat.format(date)+"";
		return result;
	}

	/** 날짜 조회
	 * @return ex 20000101+ paramMonth
	 */
	public String getCalendarDateYMD_ADDYear(int paramDay){
		DecimalFormat decimalFormat = new DecimalFormat("00");// decimalformat
		DecimalFormat NumFormat = new DecimalFormat("0000");// 4
		Calendar rightNow = Calendar.getInstance();//
		if(paramDay != 0){
			rightNow.add(Calendar.YEAR, paramDay);
		}
		int year = rightNow.get(Calendar.YEAR);
		int month = rightNow.get(Calendar.MONTH)+1;
		int date = rightNow.get(Calendar.DATE);

		String result = NumFormat.format(year)+""+ decimalFormat.format(month)+"" + decimalFormat.format(date)+"";
		return result;
	}


		/** 날짜 조회
		 * @return ex 20000101010101 + 6month
		 */
		public String getCalendarDateYMDHMS_ADD6MONTH(){
			DecimalFormat decimalFormat = new DecimalFormat("00");// decimalformat
  			DecimalFormat NumFormat = new DecimalFormat("0000");// 4
  			Calendar rightNow = Calendar.getInstance();// 
  			rightNow.add(Calendar.MONTH, 6);
  			int year = rightNow.get(Calendar.YEAR);
  			int month = rightNow.get(Calendar.MONTH)+1;
  			int date = rightNow.get(Calendar.DATE);
  			int hour = rightNow.get(Calendar.HOUR_OF_DAY);
  			int minute = rightNow.get(Calendar.MINUTE);
  			int second = rightNow.get(Calendar.SECOND);
  			
  			String result = NumFormat.format(year)+""+ decimalFormat.format(month)+"" + decimalFormat.format(date)+""+decimalFormat.format(hour)+""+decimalFormat.format(minute)+""+decimalFormat.format(second)+"";
  			return result;
		}
		
		/** 날짜 조회
		 * @return ex 20000101010101
		 */
		public String getCalendarDateYMDHMS(){
			DecimalFormat decimalFormat = new DecimalFormat("00");// decimalformat
  			DecimalFormat NumFormat = new DecimalFormat("0000");// 4
  			Calendar rightNow = Calendar.getInstance();// 
  			int year = rightNow.get(Calendar.YEAR);
  			int month = rightNow.get(Calendar.MONTH) + 1;
  			int date = rightNow.get(Calendar.DATE);//
  			int hour = rightNow.get(Calendar.HOUR_OF_DAY);
  			int minute = rightNow.get(Calendar.MINUTE);
  			int second = rightNow.get(Calendar.SECOND);

  			String result = NumFormat.format(year)+""+ decimalFormat.format(month)+"" + decimalFormat.format(date)+""+decimalFormat.format(hour)+""+decimalFormat.format(minute)+""+decimalFormat.format(second)+"";
  			return result;
		}

		/** String To Date(스트링 을 날짜로 변환)
		 * @param strDate(스트링 날짜:YYYYMMDDhhmmss)
		 * @return Date
		 */
		public static Calendar stringToCalendar(String strDate){
			Calendar rtnDate = null;
			if(strDate.length() >= 14){
				try {
					rtnDate = Calendar.getInstance();
					rtnDate.set(Calendar.YEAR, Integer.parseInt(strDate.substring(0,4)));
					rtnDate.set(Calendar.MONTH, Integer.parseInt(strDate.substring(4,6)));
					rtnDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(strDate.substring(6,8)));
					rtnDate.set(Calendar.HOUR_OF_DAY, Integer.parseInt(strDate.substring(8,10)));
					rtnDate.set(Calendar.MINUTE, Integer.parseInt(strDate.substring(10,12)));
					rtnDate.set(Calendar.SECOND, Integer.parseInt(strDate.substring(12,14)));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return rtnDate;
		}

	
}
