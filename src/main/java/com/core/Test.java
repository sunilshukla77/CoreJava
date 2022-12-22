package com.core;

public class Test {

	public static void main(String[] args) {
		int a=3, b=1, c=2;
		b= b^a^c*2;
		if(b>0 && c >0) {
			b=1;
			if(a>a) {
				a=a*a%5;
			}
			c=0;
		}
		System.out.println(a+b+c);
	}

}
