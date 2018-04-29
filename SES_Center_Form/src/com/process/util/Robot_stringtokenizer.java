package com.process.util;

import java.util.StringTokenizer;

public class Robot_stringtokenizer {
	public static void main() {
	String a = "20141331099||20151111195";

	StringTokenizer b = new StringTokenizer(a, "\\||");		

	System.out.println(b.countTokens() + " 자의 글자이군? ");



	while (b.hasMoreTokens() == true) {

		System.out.println(b.nextToken());

	}


	}

}
