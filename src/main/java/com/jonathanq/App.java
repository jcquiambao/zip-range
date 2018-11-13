package com.jonathanq;

import com.jonathanq.util.StringUtils;
import com.jonathanq.data.ZipRange;
import com.jonathanq.process.ProcessZipRange;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * This program accepts ZIP code ranges of the form 
 * "[<zip_1>,<zip_2>] [<zip_1>,<zip_2>] ... [<zip_x>,<zip_y>]"
 * and outputs the smallest possible combination of ZIP code ranges
 * that contains all of the input ZIP code ranges
 * 
 * @author Jonathan Quiambao
 */
public class App {
    public static void main( String[] args ) {
    	String userInput = collectInput();
    	Queue<ZipRange> input = null;
    	input = StringUtils.parseInput(userInput);
    	if (input == null || input.isEmpty()) {
    		handleException("Unable to parse input.");
    		return;
    	}
    	List<ZipRange> output = new ArrayList<ZipRange>();
    	ProcessZipRange processor = new ProcessZipRange();
		if (!processor.process(input, output)) {
			handleException("Error processing input.");
		}
    	String outputString = StringUtils.formatOutput(output);
    	System.out.println("Output: " + outputString);
    }
    
    public static String collectInput() {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Input: ");
    	String in = scan.nextLine();
    	scan.close();
    	return in;
    }
    
    private static void handleException(String message) {
    	System.out.println(message);
    }
}
