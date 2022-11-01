package com.core.dto;

public class Address implements Cloneable {

	private String City;

	public Address() {
	}

	public Address(String city) {
		super();
		City = city;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Address [City=" + City + "]";
	}

}
