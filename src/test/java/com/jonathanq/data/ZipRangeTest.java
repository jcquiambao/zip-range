package com.jonathanq.data;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for ZipRange class
 * 
 * @author Jonathan Quiambao
 */
public class ZipRangeTest {
	
	private static int ZIP_1 = 10000;
	private static int ZIP_2 = 20000;
	private static int ZIP_3 = 30000;
	private static int ZIP_4 = 40000;
	
	@Test
	public void testIntersectNullOther() {
		ZipRange zip = new ZipRange(ZIP_1, ZIP_2);
		boolean intersect = zip.intersect(null);
		Assert.assertFalse("Expected false, was true", intersect);
	}
	
	@Test
	public void testIntersectNoIntersect() {
		ZipRange zip1 = new ZipRange(ZIP_1, ZIP_2);
		ZipRange zip2 = new ZipRange(ZIP_3, ZIP_4);
		boolean intersect1 = zip1.intersect(zip2);
		boolean intersect2 = zip2.intersect(zip1);
		Assert.assertFalse("Expected false, was true", intersect1);
		Assert.assertFalse("Expected false, was true", intersect2);
	}
	
	@Test
	public void testIntersectSelf() {
		ZipRange zip = new ZipRange(ZIP_1, ZIP_2);
		boolean intersect = zip.intersect(zip);
		Assert.assertTrue("Expected true, was false", intersect);
	}
	
	@Test
	public void testIntersectCompleteContain() {
		ZipRange expectedZip = new ZipRange(ZIP_1, ZIP_4);
		ZipRange zip1 = new ZipRange(ZIP_1, ZIP_4);
		ZipRange zip2 = new ZipRange(ZIP_2, ZIP_3);
		boolean intersect1 = zip1.intersect(zip2);
		boolean intersect2 = zip2.intersect(zip1);
		Assert.assertTrue("Expected true, was false", intersect1);
		Assert.assertTrue("Expected true, was false", intersect2);
		Assert.assertEquals("Expected equal, expected: " + expectedZip 
				+ ", actual: " + zip1, expectedZip, zip1);
		Assert.assertEquals("Expected equal, expected: " + expectedZip 
				+ ", actual: " + zip2, expectedZip, zip2);
	}
	
	@Test
	public void testIntersectEqual() {
		ZipRange expectedZip = new ZipRange(ZIP_1, ZIP_4);
		ZipRange zip1 = new ZipRange(ZIP_1, ZIP_4);
		ZipRange zip2 = new ZipRange(ZIP_1, ZIP_4);
		boolean intersect = zip1.intersect(zip2);
		Assert.assertTrue("Expected true, was false", intersect);
		Assert.assertEquals("Expected equal, expected: " + expectedZip 
				+ ", actual: " + zip1, expectedZip, zip1);
	}
	
	@Test
	public void testIntersect1() {
		ZipRange expectedZip = new ZipRange(ZIP_1, ZIP_4);
		ZipRange zip1 = new ZipRange(ZIP_1, ZIP_3);
		ZipRange zip2 = new ZipRange(ZIP_2, ZIP_4);
		boolean intersect = zip1.intersect(zip2);
		Assert.assertTrue("Expected true, was false", intersect);
		Assert.assertEquals("Expected equal, expected: " + expectedZip 
				+ ", actual: " + zip1, expectedZip, zip1);
	}
	
	@Test
	public void testIntersect2() {
		ZipRange expectedZip = new ZipRange(ZIP_1, ZIP_4);
		ZipRange zip1 = new ZipRange(ZIP_1, ZIP_4);
		ZipRange zip2 = new ZipRange(ZIP_2, ZIP_4);
		boolean intersect = zip1.intersect(zip2);
		Assert.assertTrue("Expected true, was false", intersect);
		Assert.assertEquals("Expected equal, expected: " + expectedZip 
				+ ", actual: " + zip1, expectedZip, zip1);
	}
	
	@Test
	public void testIntersect3() {
		ZipRange expectedZip = new ZipRange(ZIP_1, ZIP_4);
		ZipRange zip1 = new ZipRange(ZIP_1, ZIP_3);
		ZipRange zip2 = new ZipRange(ZIP_1, ZIP_4);
		boolean intersect = zip1.intersect(zip2);
		Assert.assertTrue("Expected true, was false", intersect);
		Assert.assertEquals("Expected equal, expected: " + expectedZip 
				+ ", actual: " + zip1, expectedZip, zip1);
	}
	
	@Test
	public void testIntersect4() {
		ZipRange expectedZip = new ZipRange(ZIP_1, ZIP_4);
		ZipRange zip1 = new ZipRange(ZIP_2, ZIP_4);
		ZipRange zip2 = new ZipRange(ZIP_1, ZIP_3);
		boolean intersect = zip1.intersect(zip2);
		Assert.assertTrue("Expected true, was false", intersect);
		Assert.assertEquals("Expected equal, expected: " + expectedZip 
				+ ", actual: " + zip1, expectedZip, zip1);
	}
	
	@Test
	public void testIntersect5() {
		ZipRange expectedZip = new ZipRange(ZIP_1, ZIP_4);
		ZipRange zip1 = new ZipRange(ZIP_2, ZIP_4);
		ZipRange zip2 = new ZipRange(ZIP_1, ZIP_4);
		boolean intersect = zip1.intersect(zip2);
		Assert.assertTrue("Expected true, was false", intersect);
		Assert.assertEquals("Expected equal, expected: " + expectedZip 
				+ ", actual: " + zip1, expectedZip, zip1);
	}
	
	@Test
	public void testIntersect6() {
		ZipRange expectedZip = new ZipRange(ZIP_1, ZIP_4);
		ZipRange zip1 = new ZipRange(ZIP_1, ZIP_4);
		ZipRange zip2 = new ZipRange(ZIP_1, ZIP_3);
		boolean intersect = zip1.intersect(zip2);
		Assert.assertTrue("Expected true, was false", intersect);
		Assert.assertEquals("Expected equal, expected: " + expectedZip 
				+ ", actual: " + zip1, expectedZip, zip1);
	}
	
}
