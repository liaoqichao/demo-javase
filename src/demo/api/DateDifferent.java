package demo.api;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateDifferent {
	public static int DATE_DIFFER_DAY(Date early,Date late){
		return (int)((late.getTime()-early.getTime())/1000/60/60/24);
	}
	public static int DATE_DIFFER_DAY(String early,String late,DateFormat df)throws ParseException{
		Date d1 = df.parse(early);
		Date d2 = df.parse(late);
		return (int)((d2.getTime()-d1.getTime())/1000/60/60/24);
	}

}
