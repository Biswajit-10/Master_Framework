package com.crm.comcast.genericutility;

import java.sql.Date;
import java.util.Random;
import java.util.stream.IntStream;
/**
 * 
 * @author Biswajit
 *
 */
public class JavaUtility {
	/**
	 * 
	 * @param range
	 * @return random integer from 0 to range given...if all the numbers returned then...it will start again from beginning
	 */
	public int getRandomNum(int range) {
		Random random=new Random();
		int i=random.nextInt(range);
		return i;
	}
	public IntStream getRandomNum(int origin,int bound) {
		Random random=new Random();		
		 IntStream i = random.ints(origin, bound);
		return i;
	}
	/**
	 * its used to get the current System date & time
	 * @return
	 */
	public String getSystmeDate() {
		Date date = new Date(0);
		String systemDateAndTime = date.toString();
		return systemDateAndTime;
	}
	/**
	 * its used to get the current System date with YYYY-MM-DD format
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public String getSystmeDate_YYYY_MM__DD() {
		Date date = new Date(0, 0, 0);
		String systemDateAndTime = date.toString();
		System.out.println(systemDateAndTime);
		String[] arr = systemDateAndTime.split(" ");
        String DD = arr[2];
        String YYYY = arr[5];   
        int MM = date.getMonth()+1;
        
        String finalFromat = YYYY+"-"+MM+"-"+DD;
		return finalFromat;	  
	}
	
   
}
