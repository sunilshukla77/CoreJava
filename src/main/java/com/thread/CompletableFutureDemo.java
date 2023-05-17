package com.thread;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureDemo {

	public static void main(String[] args) {

		try {
			List<Integer> list = Arrays.asList(2, 3, 4);
			list.stream()
			.map(num->CompletableFuture.supplyAsync(()-> getNumber(num)))
			.map(CompletableFuture->CompletableFuture.thenApply(n-> n+n))
			.map(t->t.join())
			.forEach(s->System.out.println(s));  


			// Second
			CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
			CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
			CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

			CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);
			
			combinedFuture.get();

			assertTrue(future1.isDone());
			assertTrue(future2.isDone());
			assertTrue(future3.isDone());
			
			String combined = Stream.of(future1, future2, future3)
					  .map(CompletableFuture::join)
					  .collect(Collectors.joining(" "));
			System.out.println(combined);

					assertEquals("Hello Beautiful World", combined);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static int getNumber(int a) {
		return a * a;
	}
}
