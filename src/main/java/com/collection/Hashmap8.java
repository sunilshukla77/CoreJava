package com.collection;

import java.util.HashMap;
import java.util.Map;

//In Java 7 after calculating hash from hash function if more then one element has 
//same hash than they are searched by linear search so it's complexity is (n). 
//In Java 8 that search is performed by binary search so the complexity will become
//log(n). So, this concept is wrong that hash map searches an object in constant 
//complexity because it is not the case at all times.
public class Hashmap8 {
	
	public static void main(String[] args) {
		Map <String, String> map = new HashMap();
		map.put("sunil", "Ald");
		map.put("sinul", "pune");
		map.put("slnun", "pune");
		
		map.forEach((k,v)-> System.out.println(k.hashCode()+ " "+ k + " " + v));
		
		
		
	}

}
