package com.jonathanq.util;

import com.jonathanq.data.ZipRange;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Contains methods for general String manipulation and conversion
 * 
 * @author Jonathan Quiambao
 */
public class StringUtils {
	
	private static int ZIPS_IN_RANGE = 2;
	private static int ZIP_LENGTH = 5;
	
	/**
	 * Parses user input into Queue<ZipRange>
	 * 
	 * @param input String to convert to ZipRange
	 */
	public static Queue<ZipRange> parseInput(String input) {
		if (input == null || input.isEmpty()) {
			return null;
		}
		Queue<ZipRange> output = new LinkedList<ZipRange>();
		String splitInput[] = input.split(" ");
		for (String currentInput : splitInput) {
			ZipRange zip = convertString(currentInput);
			if (zip == null) {
				return null;
			}
			output.add(zip);
		}
		return output;
	}
	
	/**
	 * Converts an input String into a ZipRange object
	 * Input must be of format "[<zip_1>,<zip_2>]"
	 * ZIP codes must be exactly ZIP_LENGTH
	 * 
	 * @param input A String of the form "[12345,67890]"
	 */
	public static ZipRange convertString(String input) {
		if (input == null || input.isEmpty()) {
			return null;
		}
		if (input.charAt(0) != '[' 
				|| input.charAt(input.length() - 1) != ']') {
			return null;
		}
		String strippedString = input.substring(1, input.length() - 1);
		String splitString[] = strippedString.split(",");
		if (splitString.length != ZIPS_IN_RANGE 
				|| splitString[0].length() != ZIP_LENGTH 
				|| splitString[1].length() != ZIP_LENGTH) {
			return null;
		}
		int first;
		int second;
		try {
			first = Integer.valueOf(splitString[0]);
			second = Integer.valueOf(splitString[1]);
		} catch (NumberFormatException e) {
			return null;
		}
		return new ZipRange(first, second);
	}
	
	/**
	 * Converts input List<ZipRange> into formatted String for displaying to user
	 * 
	 * @param input A List<ZipRange> to be formatted for display
	 */
	public static String formatOutput(List<ZipRange> input) {
		if (input == null || input.isEmpty()) {
			return null;
		}
		StringBuilder formattedString = new StringBuilder();
		for (ZipRange zip : input) {
			formattedString.append(zip.toString());
			formattedString.append(" ");
		}
		formattedString.deleteCharAt(formattedString.length() - 1);
		return formattedString.toString();
	}

}
