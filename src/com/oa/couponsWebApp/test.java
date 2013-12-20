package com.oa.couponsWebApp;

import java.text.*;
import java.util.*;

public class test {
//date manipulation
	public static void main(String[] args) throws ParseException {
		Date currDate=new Date();
		 String target = "4/12/2012";
		    DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		    Date result =  df.parse(target);  
		    System.out.println(result);
		    System.out.println(currDate);

		    
	}

}
