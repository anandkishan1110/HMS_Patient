package GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtilitity {
	public static int random() {
		Random ran= new Random();
		int random=ran.nextInt(10);
		return random;
	}
	public static String getSystemDate() {
		Date dt=new Date();
		String date=dt.toString();
		return date;
		
	}
	public static String formatSystemDate() {
		SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date dt=new Date();
		String getDateAndTime=dateformat.format(dt);
		getDateAndTime.replace(":","-");
		return getDateAndTime;
	}

}
