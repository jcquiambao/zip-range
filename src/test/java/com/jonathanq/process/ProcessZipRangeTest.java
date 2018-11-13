package com.jonathanq.process;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jonathanq.data.ZipRange;

/**
 * Unit tests for ProcessZipRange class
 * 
 * @author Jonathan Quiambao
 */
public class ProcessZipRangeTest {
	
	private static int ZIP_1 = 10000;
	private static int ZIP_2 = 20000;
	private static int ZIP_3 = 30000;
	private static int ZIP_4 = 40000;
	
	private static ProcessZipRange processZipRange;
	private Queue<ZipRange> input;
	private List<ZipRange> output;
	
	@BeforeClass
	public static void prepare() {
		processZipRange = new ProcessZipRange();
	}
	
	@Before
	public void beforeEach() {
		input = new LinkedList<ZipRange>();
		output = new ArrayList<ZipRange>();
	}
	
	@Test
	public void testProcessNullInput() {
		Assert.assertFalse("Expected false, was true", 
				processZipRange.process(null, null));
		Assert.assertFalse("Expected false, was true", 
				processZipRange.process(input, null));
		Assert.assertFalse("Expected false, was true", 
				processZipRange.process(null, output));
	}
	
	@Test
	public void testProcessSingle() {
		List<ZipRange> expected = new ArrayList<ZipRange>();
		ZipRange inputZipRange = new ZipRange(ZIP_1, ZIP_2);
		expected.add(inputZipRange);
		input.add(inputZipRange);
		boolean result = processZipRange.process(input, output);
		Assert.assertTrue("Expected true, was false", result);
		Assert.assertFalse("Expected false, was true", output.isEmpty());
		Assert.assertEquals("Not equal, expected: " + expected 
				+ ", actual: " + output, expected, output);
	}
	
	@Test
	public void testProcessDuplicates() {
		List<ZipRange> expected = new ArrayList<ZipRange>();
		ZipRange inputZipRange = new ZipRange(ZIP_1, ZIP_2);
		expected.add(inputZipRange);
		input.add(inputZipRange);
		input.add(inputZipRange);
		boolean result = processZipRange.process(input, output);
		Assert.assertTrue("Expected true, was false", result);
		Assert.assertFalse("Expected false, was true", output.isEmpty());
		Assert.assertEquals("Not equal, expected: " + expected 
				+ ", actual: " + output, expected, output);
	}
	
	@Test
	public void testProcessMultipleNoIntersect() {
		List<ZipRange> expected = new ArrayList<ZipRange>();
		ZipRange inputZipRange1 = new ZipRange(ZIP_1, ZIP_2);
		ZipRange inputZipRange2 = new ZipRange(ZIP_3, ZIP_4);
		expected.add(inputZipRange1);
		expected.add(inputZipRange2);
		input.add(inputZipRange1);
		input.add(inputZipRange2);
		boolean result = processZipRange.process(input, output);
		Assert.assertTrue("Expected true, was false", result);
		Assert.assertFalse("Expected false, was true", output.isEmpty());
		Assert.assertEquals("Not equal, expected: " + expected 
				+ ", actual: " + output, expected, output);
	}
	
	@Test
	public void testProcessMultipleIntersect1() {
		List<ZipRange> expected = new ArrayList<ZipRange>();
		ZipRange expectedZipRange = new ZipRange(ZIP_1, ZIP_3);
		expected.add(expectedZipRange);
		ZipRange inputZipRange1 = new ZipRange(ZIP_1, ZIP_2);
		ZipRange inputZipRange2 = new ZipRange(ZIP_2, ZIP_3);
		input.add(inputZipRange1);
		input.add(inputZipRange2);
		boolean result = processZipRange.process(input, output);
		Assert.assertTrue("Expected true, was false", result);
		Assert.assertFalse("Expected false, was true", output.isEmpty());
		Assert.assertEquals("Not equal, expected: " + expected 
				+ ", actual: " + output, expected, output);
	}
	
	@Test
	public void testProcessMultipleIntersect2() {
		List<ZipRange> expected = new ArrayList<ZipRange>();
		ZipRange expectedZipRange = new ZipRange(ZIP_1, ZIP_3);
		expected.add(expectedZipRange);
		ZipRange inputZipRange1 = new ZipRange(ZIP_2, ZIP_3);
		ZipRange inputZipRange2 = new ZipRange(ZIP_1, ZIP_2);
		input.add(inputZipRange1);
		input.add(inputZipRange2);
		boolean result = processZipRange.process(input, output);
		Assert.assertTrue("Expected true, was false", result);
		Assert.assertFalse("Expected false, was true", output.isEmpty());
		Assert.assertEquals("Not equal, expected: " + expected 
				+ ", actual: " + output, expected, output);
	}
	
	@Test
	public void testProcessMultipleIntersect3() {
		List<ZipRange> expected = new ArrayList<ZipRange>();
		ZipRange expectedZipRange = new ZipRange(ZIP_1, ZIP_4);
		expected.add(expectedZipRange);
		ZipRange inputZipRange1 = new ZipRange(ZIP_1, ZIP_4);
		ZipRange inputZipRange2 = new ZipRange(ZIP_2, ZIP_3);
		input.add(inputZipRange1);
		input.add(inputZipRange2);
		boolean result = processZipRange.process(input, output);
		Assert.assertTrue("Expected true, was false", result);
		Assert.assertFalse("Expected false, was true", output.isEmpty());
		Assert.assertEquals("Not equal, expected: " + expected 
				+ ", actual: " + output, expected, output);
	}
	
	@Test
	public void testProcessMultipleIntersect4() {
		List<ZipRange> expected = new ArrayList<ZipRange>();
		ZipRange expectedZipRange = new ZipRange(ZIP_1, ZIP_4);
		expected.add(expectedZipRange);
		ZipRange inputZipRange1 = new ZipRange(ZIP_2, ZIP_3);
		ZipRange inputZipRange2 = new ZipRange(ZIP_1, ZIP_4);
		input.add(inputZipRange1);
		input.add(inputZipRange2);
		boolean result = processZipRange.process(input, output);
		Assert.assertTrue("Expected true, was false", result);
		Assert.assertFalse("Expected false, was true", output.isEmpty());
		Assert.assertEquals("Not equal, expected: " + expected 
				+ ", actual: " + output, expected, output);
	}

}
