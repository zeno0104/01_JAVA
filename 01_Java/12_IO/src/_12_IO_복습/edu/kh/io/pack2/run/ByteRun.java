package _12_IO_복습.edu.kh.io.pack2.run;

import _12_IO_복습.edu.kh.io.pack2.model.service.ByteService;

public class ByteRun {
	public static void main(String[] args) {
		// 불변성(Immutable)의 String
		// 변하지 않는다는 의미, 객체 한번 생성되면 그 내용을 변경할 수 없음
		// 어떤 문자열 연산을 수행하면 항상 새로운 String 객체가 생성됨
		// String str = "Hello"; // 124
		// str = str + "world!" // 23627
		// 즉, 값이 바뀌면 주소가 바뀜. 처음에 만들어진 str에 변경 못함
		// 연산이 일어나면 새로운 객체가 만들어짐.
		// 처음에 만들어진게 변하지 못한다는 의미

		// String str = "안녕"; => 문자열 리터럴 방식
		// String str = new String("안녕"); => new 연산자 방식

		// ex)
		// String str1 = "Hello";
		// String str2 = "Hello";
		// 다른 것 같지만, String pool로 인해서 같은 곳을 가리키고 있음
		// 즉, String pool에 같은 값이 있다면 같은 곳을 가리키게 된다는 의미

		// String str3 = "Hello";
		// Heap 영역에 새로 만들어지게됌
		// new 연산자로 생성된 String이든, 문자열 리터럴로 생성된 String이든,
		// String의 불변성은 변함이 없다.

		// 1. new 연산자
//		String str1 = new String("Hello");
//		String str2 = new String("Hello");
//		System.out.println(System.identityHashCode(str1)); // 681842940
//		System.out.println(System.identityHashCode(str2)); // 1392838282
//		str1 = str1 + " world";
//		System.out.println(System.identityHashCode(str1)); // 468121027
//		// 값이 새로 생성됌 => 기존 str1의 주소와 다름
//
//		// 2. 리터럴 표기법
//		String str3 = "Hello";
//		String str4 = "Hello";
//		System.out.println(System.identityHashCode(str3)); // 523429237
//		System.out.println(System.identityHashCode(str4)); // 523429237
//		// String 상수 풀에 들어가기 때문에 주소가 같은것
//		// 불변성의 특징은 계속 유지
//		str3 = str3 + " world";
//		System.out.println(System.identityHashCode(str3)); // 1804094807
//		// => 모든 new, 리터럴 표기법은 불변성에 대한 변화가 없다는 것
//		// 문자열의 잦은 연산이 일어날 때는 불변성의 String을 잘 사용안하는게 좋음
//		// 메모리가 계속 바뀌기 떄문에 가변성으로 써야 효율적
//
//		System.out.println("=============================");
//		// StringBuilder : 비동기(줄서지 않고 빠르지만 실수o), StringBuffer: 동기(줄섬.느리지만 안전)
//		// 가변성(Mutable)의 StringBuilder, StringBuffer
//		StringBuilder sb = new StringBuilder();
//		System.out.println(System.identityHashCode(sb)); // 951007336
//		sb.append("Hello world!"); // sb의 변화를 주는 방법
//		sb.append("12345");
//		System.out.println(sb);
//		System.out.println(System.identityHashCode(sb)); // 951007336
		// 메모리 주소 변화가 일어나지 않음
		// 즉, 원본의 값이 변할 수 있다는 의미로 가변성의 띈다고 말함

		// 비동기화: 동기화를 제공하지 않음. 따라서, 멀티스레드 환경에서는
		// 안전하지 않으나, 단일스레드 환경에서 사용하기 적합

		ByteService byteService = new ByteService();
		// byteService.fileByteOutPut();
		// byteService.bufferedFileByteOutput();
		byteService.fileByteInput();
	}
}



