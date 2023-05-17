package com.core.dto;

import java.util.Date;

public final class Person {
	
	private final String  name;
	private final int  age;
	private final Address ad;

	private Date dob;
	
	
	public Person(String name, int age, Address ad) {
		super();
		this.name = name;
		this.age = age;
		this.ad = ad;
	}

	public Person(String name, int age, Address ad, Date dob) {
		super();
		this.name = name;
		this.age = age;
		this.ad = ad;
		this.dob = dob;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public Address getAd() throws CloneNotSupportedException {
		return (Address) ad.clone();
	}


	public Date getDob() {
		return new Date(dob.getTime());
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", ad=" + ad + "]";
	}

}

//StringBuffer is synnchronous
//StringBuilder is not syncronous
