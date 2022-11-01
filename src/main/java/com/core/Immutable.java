package com.core;

import org.junit.Test;

import com.core.dto.Address;
import com.core.dto.Person;

public class Immutable {

	/**
	 * String is immutable
	 * StringBuffer is mutable and all its public method are synchronizes
	 * 
	 * StringBuilder is also mutable and all its public method are not synchronizes
	 * @throws CloneNotSupportedException
	 * 
	 * Custom Immutable class Person and Address relation
	 */
	@Test
	public void immutableTest() throws CloneNotSupportedException {
		Address ad = new Address();
		ad.setCity("Pune");
		Person per = new Person("Sunil", 35, ad);

		System.out.println(per.toString());

		Address ad1 = per.getAd();
		ad1.setCity("DB");

		System.out.println(per.toString());
	}
	
	/*
	 * 1. Class should be final 
	 * 2. All veriable are private and final 
	 * 3. No setter * complete constructor
	 * 4. Refer Person class and getAddress {address.clone()} 
	 */
}
