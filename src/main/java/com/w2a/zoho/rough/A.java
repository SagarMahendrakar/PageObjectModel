package com.w2a.zoho.rough;

import org.testng.Assert;
import org.testng.annotations.Test;

public class A {

	@Test
	public static void main() {

		name1();

		System.out.println("Word");

	}

	public static void name() {

		try {

			Assert.assertTrue(false);
		} catch (Throwable e) {
			System.out.println("Helloo");

		}
	}

	public static void name1() {

		name();

	}
}
