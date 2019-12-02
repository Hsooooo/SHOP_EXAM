package exam.common.util;

import java.text.DecimalFormat;

public class CommonUtil {
	public static String getString(Object obj) {
		String value = "" + obj;
		try {
			if ( obj ==null) {value="";}
			else {
				if (value.equals("null") || value.length() == 0) value="";
			}
			return value;
		}catch(Exception e) {return "";}
		finally {
			if( value!=null) {value=null;}
		}
	}
	
	public static String objCommaFormat( Object numberObj) {
		String returnStr = "0";
		if(numberObj == null) return "0";
		
		try {
			DecimalFormat df = new DecimalFormat("#,##0.###");
			if((numberObj instanceof Long ) || (numberObj instanceof Integer) || (numberObj instanceof Float) || (numberObj instanceof Double)) {
				returnStr = df.format(numberObj);
			}else {
				returnStr = commaFormat(String.valueOf(numberObj));
			}
		}catch(Exception e) {
			
		}
		return returnStr;
	}
	
	public static String commaFormat(String strNumber) {
		int number = Integer.parseInt(strNumber);
		DecimalFormat df = new DecimalFormat("#,##0");
		return df.format(number);
	}
	public static String commaFormat(int number) {
		DecimalFormat df = new DecimalFormat("#,##0");
		return df.format(number);
	}
	public static String commaFormat(long number) {
		DecimalFormat df = new DecimalFormat("#,##0");
		return df.format(number);
	}
}
