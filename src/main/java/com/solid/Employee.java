package com.solid;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

// POJO,  DTO Data Transfer Object, Entity Class
public class Employee implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private int age;
	private String address;
	
	public Employee(String id, String name, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
	
	
	
	

}
