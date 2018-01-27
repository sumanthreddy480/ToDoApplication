package com.todo.common;

import java.security.SecureRandom;

public class Utilities {

	/**
	 * @param int
	 *            Digits No of digits random number to be generated
	 * @return Random number
	 */
	// This method generates eight digit positive random integer
	public static String generateRandom(int digits) {
		boolean flag = true;
		long random = 0;
		String minNumber = "";
		String maxNumber = "";

		try {
			SecureRandom rndm = SecureRandom.getInstance("SHA1PRNG");

			if (digits >= 16)
				digits = 16;
			if (digits <= 0)
				digits = 8;
			for (int i = 0; i < digits; i++) {
				minNumber += "1";
				maxNumber += "9";
			}

			while (flag) {
				random = Math.abs(rndm.nextInt());
				// The below validation is for the eight digit positive number.
				if (random >= Long.parseLong(minNumber) && random <= Long.parseLong(maxNumber)) {
					flag = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.valueOf(random);
	}

}
