package com.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.core.dto.Product;

public class BasicStream {
	public static void main(String[] args) {
		Collection<String> list = Arrays.asList("a", "b", "c", "d", "a", "d");
		List<String> distinctElements = list.stream().distinct().collect(Collectors.toList());
		System.out.println(distinctElements);

		// Data Array -> int, long, double, char, float Primitive data type.
		// Collection Framework -> Integer, Float, Cherector, String, employee,
		// Stream api-> We have create Strema Stream Creation
		// Stream of Primitives-> IntStream, LongStream, DoubleStream

		// Created Empty Stream
		Stream<String> stringStream = Stream.empty();
		
		Stream.of("Sunil","Raj ji","Ramesh").filter(s-> s.startsWith("R",0)).forEach(System.out::println);
		
		// Stream Can be collections type like list, set, Collection
		// Convert Collection to Stream
		// Convert Array to Stream
		String[] stringArray = new String[] { "a", "b", "C", "d", "b" };
		Stream<String> streamOfArray = Arrays.stream(stringArray);

		// Stream is immutable
		Stream<String> streamBuild = Stream.<String>builder().add("Sunil").add("BVG").add("test").build();
		Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
		System.out.println("Iterate "+ streamIterated.collect(Collectors.toList()));

		// Stream of Primitives-> IntStream, LongStream and DoubleStream
		IntStream intStream = IntStream.range(1, 3).peek(System.out::println);

		Random random = new Random();
		IntStream stream = random.ints(3).peek(System.out::println);
		stream.forEach(System.out::println);

		// Referencing a Stream, Java 8 streams can't be reused.
		Stream<String> st = Stream.of("a", "b", "c", "d", "c").filter(e -> e.contains("c"));
		Optional<String> anyElement = st.findAny();
		System.out.println(anyElement);

		// we need three parts: the source, intermediate operation(s) and a terminal
		// operation.

		List<Product> productList = Arrays.asList(new Product(23, "potatoes"), new Product(14, "orange"),
				new Product(13, "lemon"), new Product(23, "bread"), new Product(13, "sugar"));

		List<String> productNameList = productList.stream().map(Product::getProductname).collect(Collectors.toList());
		System.out.println(productNameList.toString());

	}

}
