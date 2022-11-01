package com.reactive;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class CompareParadigmsTest {
	private List<String> friendsList = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

	@Test
	public void imperativeStyleTest() {
		// Imperative style using Iterator
		Iterator<String> ittr = friendsList.iterator();
		while (ittr.hasNext()) {
			String friend = ittr.next();
			System.out.print(friend + " ");
		}
	}

	@Test
	public void functionalStyleTest() { // declarative style
		friendsList.forEach(friend -> System.out.print(friend + " "));
	}

	@Test
	public void reactiveStyleTest() { // event style of programming
		// friendsFlux.subscribe(friend -> System.out.print(friend+" "));
	}
}
