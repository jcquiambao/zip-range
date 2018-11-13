package com.jonathanq.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

import com.jonathanq.data.ZipRange;

/**
 * Unit tests for StringUtils class
 * 
 * @author Jonathan Quiambao
 */
public class StringUtilsTest {
	
	private static int ZIP_1 = 12345;
	private static int ZIP_2 = 67890;
	
	@Test
	public void testParseInputNull() {
		Queue<ZipRange> zipQueue = StringUtils.parseInput(null);
		Assert.assertNull("Expected null", zipQueue);
	}
	
	@Test
	public void testParseInputEmpty() {
		Queue<ZipRange> zipQueue = StringUtils.parseInput("");
		Assert.assertNull("Expected null", zipQueue);
	}
	
	@Test
	public void testParseInputInvalid1() {
		Queue<ZipRange> zipQueue = StringUtils.parseInput("Invalid Input");
		Assert.assertNull("Expected null", zipQueue);
	}
	
	@Test
	public void testParseInputInvalid2() {
		Queue<ZipRange> zipQueue = StringUtils.parseInput("[12345,67890] Invalid");
		Assert.assertNull("Expected null", zipQueue);
	}
	
	@Test
	public void testParseInputInvalid3() {
		Queue<ZipRange> zipQueue = StringUtils.parseInput("Invalid [12345,67890]");
		Assert.assertNull("Expected null", zipQueue);
	}
	
	@Test
	public void testParseInputSingle() {
		Queue<ZipRange> expectedQueue = new LinkedList<ZipRange>();
		expectedQueue.add(new ZipRange(ZIP_1, ZIP_2));
		String input = "[" + ZIP_1 + "," + ZIP_2 + "]";
		Queue<ZipRange> zipQueue = StringUtils.parseInput(input);
		Assert.assertEquals(expectedQueue, zipQueue);
	}
	
	@Test
	public void testParseInputMultiple() {
		Queue<ZipRange> expectedQueue = new LinkedList<ZipRange>();
		expectedQueue.add(new ZipRange(ZIP_1, ZIP_2));
		expectedQueue.add(new ZipRange(ZIP_2, ZIP_1));
		String input = "[" + ZIP_1 + "," + ZIP_2 + "]"
				+ " [" + ZIP_2 + "," + ZIP_1 + "]";
		Queue<ZipRange> zipQueue = StringUtils.parseInput(input);
		Assert.assertEquals(expectedQueue, zipQueue);
	}
	
	@Test
	public void testConvertStringNull() {
		ZipRange zip = StringUtils.convertString(null);
		Assert.assertNull("Expected null", zip);
	}
	
	@Test
	public void testConvertStringEmpty() {
		ZipRange zip = StringUtils.convertString("");
		Assert.assertNull("Expected null", zip);
	}
	
	@Test
	public void testConvertStringInvalid1() {
		ZipRange zip = StringUtils.convertString("Invalid");
		Assert.assertNull("Expected null", zip);
	}
	
	@Test
	public void testConvertStringInvalid2() {
		ZipRange zip = StringUtils.convertString("Invalid,Input");
		Assert.assertNull("Expected null", zip);
	}
	
	@Test
	public void testConvertStringInvalid3() {
		ZipRange zip = StringUtils.convertString("[Invalid,Input]");
		Assert.assertNull("Expected null", zip);
	}
	
	@Test
	public void testConvertStringInvalid4() {
		ZipRange zip = StringUtils.convertString("[Invalid,Input");
		Assert.assertNull("Expected null", zip);
	}
	
	@Test
	public void testConvertStringInvalid5() {
		ZipRange zip = StringUtils.convertString("Invalid,Input]");
		Assert.assertNull("Expected null", zip);
	}
	
	@Test
	public void testConvertStringInvalid6() {
		ZipRange zip = StringUtils.convertString("[" + ZIP_1 + ",Invalid]");
		Assert.assertNull("Expected null", zip);
	}
	
	@Test
	public void testConvertStringInvalid7() {
		ZipRange zip = StringUtils.convertString("[Invalid," + ZIP_1 + "]");
		Assert.assertNull("Expected null", zip);
	}
	
	@Test
	public void testConvertStringInvalid8() {
		ZipRange zip = StringUtils.convertString("[" + ZIP_1 + "1," + ZIP_2 + "1]");
		Assert.assertNull("Expected null", zip);
	}
	
	@Test
	public void testConvertStringInvalid9() {
		ZipRange zip = StringUtils.convertString("[" + ZIP_1 + "1," + ZIP_2 + "]");
		Assert.assertNull("Expected null", zip);
	}
	
	@Test
	public void testConvertStringInvalid10() {
		ZipRange zip = StringUtils.convertString("[" + ZIP_1 + "," + ZIP_2 + "1]");
		Assert.assertNull("Expected null", zip);
	}
	
	@Test
	public void testConvertString() {
		ZipRange zip = StringUtils.convertString("[" + ZIP_1 + "," + ZIP_2 + "]");
		Assert.assertNotNull("Expected not null", zip);
		Assert.assertEquals("Not equal, expected: " + ZIP_1 
				+ ", actual: " + zip.getFirst(),ZIP_1, zip.getFirst());
		Assert.assertEquals("Not equal, expected: " + ZIP_2 
				+ ", actual: " + zip.getSecond(),ZIP_2, zip.getSecond());
	}
	
	@Test
	public void testFormatOutputNull() {
		String output = StringUtils.formatOutput(null);
		Assert.assertNull("Expected null", output);
	}
	
	@Test
	public void testFormatOutputEmpty() {
		String output = StringUtils.formatOutput(new ArrayList<ZipRange>());
		Assert.assertNull("Expected null", output);
	}
	
	@Test
	public void testFormatOutput() {
		String expected = "[" + ZIP_1 + "," 
			+ ZIP_2 +"] [" + ZIP_2 + "," + ZIP_1 + "]";
		List<ZipRange> input = new ArrayList<ZipRange>();
		input.add(new ZipRange(ZIP_1, ZIP_2));
		input.add(new ZipRange(ZIP_2, ZIP_1));
		String actual = StringUtils.formatOutput(input);
		Assert.assertEquals("Not equal, expected: " + expected 
				+ ", actual: " + actual, expected, actual);
	}
}
