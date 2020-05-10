package com.bazinga.pom.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionScripts {

	@Test(priority = 1)
	public void test1() {
		String str = "Harish Ghorpade";
		Assert.assertTrue(str.contains("Sachin"), "names are not matching");
	}

	@Test(priority = 2)
	public void test2() {
		Assert.assertFalse(false);
	}

}
