package Networking;

import java.util.Arrays;

public class functions {
	
	public static String binary;
	
	public static int[] zeros;
	public static int count1 = 0;
	public static int count0 = 0;
	public static int index = 0;
	
	public static String charCount;
	public static int counter = 0;
	public static int bitCount = 0;
	
	public static boolean ready;

	public static void runLength(String b) {
		for (int x = 0; x < b.length(); x++) {
			if ((b.charAt(x) == '0' || b.charAt(x) == '1') && b.charAt(b.length()-1) == '1') 
				ready = true;
			else 
				ready = false;
		}
			
		if (ready == true) {
			for (int a = 0; a < b.length(); a++) {
				if (b.charAt(a) == '1') {
					count1++;
				}
			}
			
			zeros = new int[count1]; 
			
			for (int y = 0; y < b.length(); y++) {
				if (b.charAt(y) == '0') {
					count0++;
				}
				else if (b.charAt(y) == '1') {
					if (count0 != 0) {
						zeros[index] = count0;
						count0 = 0;
					}
					else {
						zeros[index] = 0;
					}
					index++;
				}
				
			}
			
			networkGUI.printer.setText("Step One: Count the zeros\n"
					+ Arrays.toString(zeros) + "\n\n" 
					+ "Step Two: Converting zero counts into binary\n"
					+ "Remember: 0-14 is 4 bits, 15-30 is 8 bits\n"
					+ "Remember: All numbers above 15, start with 15's binary 4 bit of 1111 and end with the 4 bits that add to 15\n"
					+ "Remember: Two 1s next to each other means there are zero 0s between them\n\n");
			
			String getText = networkGUI.printer.getText();
			
			for (int a = 0; a < zeros.length; a++) {
				if (zeros[a] == 0) {
					getText += "0 - 0000\n";
				}
				else if (zeros[a] < 8) {
					if (Integer.toBinaryString(zeros[a]).length() < 2)
						getText += zeros[a] + " - 000" + Integer.toBinaryString(zeros[a]) + "\n";
					else if (Integer.toBinaryString(zeros[a]).length() < 3)
						getText += zeros[a] + " - 00" + Integer.toBinaryString(zeros[a]) + "\n";
					else if (Integer.toBinaryString(zeros[a]).length() < 4)
						getText += zeros[a] + " - 0" + Integer.toBinaryString(zeros[a]) + "\n";
				}
				else if (zeros[a] == 15) {
					getText += zeros[a] + Integer.toBinaryString(zeros[a]) + "\n";
				}
				else if (zeros[a] > 14) {
					if (Integer.toBinaryString(zeros[a]-15).length() < 2)
						getText += zeros[a] + " - 1111 000" + Integer.toBinaryString(zeros[a] -15) + "\n";
					else if (Integer.toBinaryString(zeros[a]-15).length() < 3)
						getText += zeros[a] + " - 1111 00" + Integer.toBinaryString(zeros[a] -15) + "\n";
					else if (Integer.toBinaryString(zeros[a]-15).length() < 4)
						getText += zeros[a] + " - 1111 0" + Integer.toBinaryString(zeros[a] -15) + "\n";
					else
						getText += zeros[a] + " - 1111 " + Integer.toBinaryString(zeros[a] - 15) + "\n"; 
				}
				else {
					getText += zeros[a] + " - " + Integer.toBinaryString(zeros[a]) + "\n";
				}
			}
			
			getText += "\nStep Three: Combine\n";
			
			for (int y = 0; y < zeros.length; y++) {
				if (zeros[y] == 0) {
					getText += "0000 ";
				}
				else if (zeros[y] < 8) {
					if (Integer.toBinaryString(zeros[y]).length() < 2)
						getText += "000" + Integer.toBinaryString(zeros[y]) + " ";
					else if (Integer.toBinaryString(zeros[y]).length() < 3)
						getText += "00" + Integer.toBinaryString(zeros[y]) + " ";
					else if (Integer.toBinaryString(zeros[y]).length() < 4)
						getText += "0" + Integer.toBinaryString(zeros[y]) + " ";
				}
				else if (zeros[y] == 15) {
					getText += Integer.toBinaryString(zeros[y]) + " ";
				}
				else if (zeros[y] > 14) {
					if (Integer.toBinaryString(zeros[y]-15).length() < 2)
						getText += "1111 000" + Integer.toBinaryString(zeros[y] -15) + " ";
					else if (Integer.toBinaryString(zeros[y]-15).length() < 3)
						getText += "1111 00" + Integer.toBinaryString(zeros[y] -15) + " ";
					else if (Integer.toBinaryString(zeros[y]-15).length() < 4)
						getText += "1111 0" + Integer.toBinaryString(zeros[y] -15) + " ";
					else
						getText += "1111 " + Integer.toBinaryString(zeros[y] - 15) + " "; 
				}
				else {
					getText += Integer.toBinaryString(zeros[y]) + " ";
				}
			}
			
			networkGUI.printer.setText(getText);
		}
		else 
			networkGUI.printer.setText("Error. Please check that you only submitted 1s and 0s and that your string ends in a 1. Hit Reset and Try Again");
		ready = false;
	}
	
	public void codeDivision() {
		
	}
	
	public static void asynchronous(String a) {
		for (int x = 0; x < a.length(); x++) {
			if (!Character.isDigit(a.charAt(x))) {
				counter++;
			}
		}
		if (counter == 0) {
			String text = "";
			text += "When calculating the amount of bits sent via an asynchronous connection,\n" +
					"you have to take into account the start bit, stop bit, and parity bit that are\n"
					+ "added to each frame.\n\n" +
					"Each frame is 8 bits for the data plus those 3 aforementioned bits.\n"
					+ "Therefore, each frame is 11 bits long.\n\n";
			
			bitCount = Integer.parseInt(charCount) * 11;
			
			text += "To calculate the amount of bits, you then multiply your number of characters (or bytes) by 11:\n" +
					charCount + " * 11 = " + bitCount +
					"\n\nUsing the asynchronous connection, your " + charCount + " characters were sent using " + bitCount +
					" bits.";
			
			networkGUI.printer.setText(text);
		}
		else {
			networkGUI.printer.setText("Please make sure you only entered only one integer value!");
		}
	}
	
	public static void synchronous(String s) {
		for (int x = 0; x < s.length(); x++) {
			if (!Character.isDigit(s.charAt(x))) {
				counter++;
			}
		}
		if (counter == 0) {
			String text = "";
			
			
			
			networkGUI.printer.setText(text);
		}
		else {
			networkGUI.printer.setText("Please make sure you only entered only one integer value!");
		}
	}
	
	public void crcError() {
		
	}
}
