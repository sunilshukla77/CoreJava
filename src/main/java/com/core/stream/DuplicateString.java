package com.core.stream;

import java.util.stream.Stream;

import org.junit.Test;

public class DuplicateString {
	
	@Test
	public void duplicateString() {
		System.out.println();
		String input = "Japan";
		input.chars().forEach(System.out::println);
		
		Stream<String> st = Stream.iterate("", (str) -> str + "x"); 
		System.out.println(st.limit(3).map(str -> str + "y"));
	}
	
	

}
