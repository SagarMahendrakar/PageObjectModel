package com.w2a.zoho.rough;

import org.testng.annotations.Test;

public class AbsractB extends AbsractA {

	@Override
	public void name() {
	
		System.out.println("A");
	}
	
	@Test
	public void start() {
		name1();
		
	}
}
