package com.bazinga.pom.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionScripts2 {

	@Test
	public void test1() {
		Assert.assertEquals(12, 13);
	}

	@Test
	public void test2() {
		Assert.assertEquals(12, 13, "mismatch in drop down values");
	}

	@Test
	public void test3() {
		System.out.println("test case 3 started");
		Assert.assertEquals("Hello", "Hello", "words does not match");
		System.out.println("test case 3 ended");
	}
}
