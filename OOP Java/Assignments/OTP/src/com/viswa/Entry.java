package com.viswa;

import java.util.Random;
import java.util.function.Supplier;


public class Entry {

	public static void main(String[] args) {

		Supplier<String> getOtp = () -> {
			String[] vowels = new String[] {"A", "E", "I", "O", "U" };
		
			Random random = new Random();

			String otp = vowels[random.nextInt(5)];
			
//			String otp = vowels[random.nextInt(vowels.length)] + digit1 + digit2 + digit3 + digit4;

			//			int digit1 = random.nextInt(10);
//			int digit2 = random.nextInt(10);
//			int digit3 = random.nextInt(10);
//			int digit4 = random.nextInt(10);
			
			for(int iTmp = 0; iTmp < 4; iTmp++) {
				otp += random.nextInt(10);
			}
			return otp;
		};

		System.out.println("Otp : " + getOtp.get());
	}

}
