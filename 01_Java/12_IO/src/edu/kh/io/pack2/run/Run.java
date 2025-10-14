package edu.kh.io.pack2.run;

import edu.kh.io.pack2.model.service.ByteService;

public class Run {
	public static void main(String[] args) {
		/*
		 * // 불변성(Immutable)의 String // 1. new 연산자 String str1 = new String("Hello");
		 * String str2 = new String("Hello");
		 * 
		 * System.out.println(System.identityHashCode(str1));
		 * System.out.println(System.identityHashCode(str2)); // str1, str2는 값이 다름 -> 다른
		 * 객체라는 의미
		 * 
		 * System.out.println("==========================");
		 * 
		 * str1 = str1 + "world";
		 * 
		 * System.out.println(System.identityHashCode(str1));
		 * System.out.println(System.identityHashCode(str2));
		 * 
		 * // str1, str2의 값은 다르다. str1에서 새로운 객체를 생성하게 되면서 // 값이 달라짐 // 연산이 들어가면 아예 새로운
		 * 값이 들어가게된다. // => 불변성
		 * 
		 * System.out.println("==========================");
		 * 
		 * // 2. 리터럴 표기법 String str3 = "Hello"; String str4 = "Hello";
		 * 
		 * System.out.println(System.identityHashCode(str3));
		 * System.out.println(System.identityHashCode(str4));
		 * 
		 * System.out.println("==========================="); str3 = str3 + "world";
		 * 
		 * System.out.println(System.identityHashCode(str3));
		 * System.out.println(System.identityHashCode(str4));
		 * 
		 * // str1, str2는 값이 같음 -> 같은 객체라는 의미 // String pool에 의해서 같은 객체를 가리키고 있기 때문
		 * 
		 * System.out.println("===========================");
		 * 
		 * // 가변성(Mutable)의 StringBuilder(비동기:빠르지만 불안전), StringBuffer(동기 : 느리지만 안전)
		 * StringBuilder sb = new StringBuilder();
		 * System.out.println(System.identityHashCode(sb)); sb.append("Hello World!");
		 * sb.append("12345"); System.out.println(sb);
		 * 
		 * System.out.println(System.identityHashCode(sb));
		 * System.out.println("===========================");
		 * 
		 * System.out.println("===========================");
		 */
		ByteService byteService = new ByteService();
//		byteService.fileByteOutput();
		byteService.bufferedFileByteoutPut();
		
	}
}
