package com.Ecommerce.checkOut;

import java.util.Random;

public class RandomEmail {
	
	public static void main(String[] args) {
		
		Random r = new Random();
		int no = r.nextInt(10000);
		
		String email = "aman"+no+"@gmail.com";
		System.out.println(email);
	}

}
