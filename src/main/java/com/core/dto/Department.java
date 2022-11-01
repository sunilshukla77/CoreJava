package com.core.dto;

import java.util.Objects;

public class Department {
	private int departmentId;
	private String name;
	private String location;
	
	public Department(int departmentId, String name, String location) {
		super();
		this.departmentId = departmentId;
		this.name = name;
		this.location = location;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "[Department=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(name, other.name);
	}

	
}
