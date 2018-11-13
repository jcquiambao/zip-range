package com.jonathanq.process;

import com.jonathanq.data.ZipRange;

import java.util.List;
import java.util.Queue;

/**
 * Processes a given collection of ZipRange and reduces to minimal amount of ZipRanges 
 * 
 * @author Jonathan Quiambao
 */
public class ProcessZipRange {
	/**
	 * Iterates through all input ZipRange and checks for intersection against all
     * ZipRange for output.
	 * 
	 * @param input A Queue<ZipRange> that contains all ZipRange that has yet to be processed
     * @param output A List<ZipRange> that contains all processed ZipRange
	 * @return returns true if successful completion, false if error
	 */
	public boolean process(Queue<ZipRange> input, List<ZipRange> output) {
		if (input == null || output == null) {
			return false;
		}
		if (output.isEmpty() && !input.isEmpty()) {
    		output.add(input.remove());
    	}
    	if (input.isEmpty()) {
    		return true;
    	}
    	ZipRange currentInput = input.remove();
    	boolean combined = false;
    	for (ZipRange check : output) {
    		if (check.intersect(currentInput)) {
    			combined = true;
    			break;
    		}
    	}
    	if (!combined) {
    		output.add(currentInput);
    	}
    	return process(input, output);
	}
}
