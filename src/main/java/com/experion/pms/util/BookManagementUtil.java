/**
 * 
 */
package com.experion.pms.util;

import java.util.Random;


/**
 * @author tt
 *
 */
public class BookManagementUtil {

	public static int getRandomNumber() {
		int min = 1000;
		int max = 9999;

		Random r = new Random();
		int randomNo = r.nextInt(max - min + 1) + min;
		return randomNo;
	}
	
	public static void main(String [] args) throws Exception {
		int min = 1000;
		int max = 9999;

		Random r = new Random();
		int randomNo = r.nextInt(max - min + 1) + min;
		System.out.println("Random Number is ...... "+ String.format("%09d", randomNo) );
		
		String pattern = "[-+]?\\d*\\.?\\d+";
		String itemNumber="";
		if ("2062".matches(pattern)) {
			System.out.println("reaxxx");
			itemNumber = String.format("%09d",
					Integer.valueOf("2062"));
		} else {
			itemNumber = "2062";
		}
		
		System.out.println("Integer or String is ...."+itemNumber);
	}
}
