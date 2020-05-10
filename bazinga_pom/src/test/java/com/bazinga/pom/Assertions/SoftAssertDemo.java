package com.bazinga.pom.Assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {

	@Test
	public void softAsrt() {
		System.out.println(System.getProperty("user.dir"));
		SoftAssert ast = new SoftAssert();
		System.out.println("test 1 started");
		ast.assertEquals(12, 13);
		System.out.println("test 1 completed");
		ast.assertAll();

	}
}
