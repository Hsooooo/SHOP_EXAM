package exam.common.util;

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
}
