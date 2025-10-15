package edu.kh.io.pack2.model.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteService {
	/*
	 * 스트림(Stream) : 데이터가 이동하는 통로 기본적으로 한 방향으로 흐름
	 * 
	 * 바이트(Byte) 기반 스트림 - 1byte 단위로 데이터를 입/출력하는 스트림 - 최상위 클래스 : InputStream,
	 * OutputStream - 최상위 클래스 : InputStream, OutputStream - 문자열, 이미지, 영상, 오디오, pdf 등
	 * 모든것을 입/출력 할 수 있음 (단, 통로가 좁다보니 속도가 좀 느림, 1byte 초과인 문자같은 경우 깨질 우려가 있음)
	 * 
	 * 
	 */

	/**
	 * 바이트 기반 스트림을 이용한 파일 출력 + 데이터 출력
	 * 
	 */
	public void fileByteOutput() {
		// FileOutPutStream 참조 변수 선언 (OutPutStream 상속받은 자식 클래스)
		FileOutputStream fos = null;

		try {
			// FileNotFoundException : 경로 상 파일을 찾을 수 없음

			// new FileOutPutStream("경로");
			// -> 경로에 작성된 파일과 연결된 파일 출력 스트림 객체 생성
			// -> 출력 스트림에 연결된 파일이 존재하지 않으면 자동 생성
			// 단, 폴더는 자동생성해주지 않음
			// 기존 파일이 존재하면 내용을 덮어쓰기함

			// fos = new FileOutputStream("/io_test/20251014/folder");
			// -> 해당 코드에서 folder는 자동 생성이 되지 않음.

			fos = new FileOutputStream("/io_test/20251014/바이트기반_테스트.txt");

			// String의 불변성 문제를 해결한 객체
			// StringBuilder(비동기) / StringBuffer(동기)
			StringBuilder sb = new StringBuilder(); // 빈문자열
			sb.append("Hello World\n");
			sb.append("1234567890\n");
			sb.append("~!@#$%^&*()_-+<>?\n");
			// 위 문자는 1바이트라 깨지지않음
			sb.append("가나다라마바사\n");
			sb.append("와 자바 너무 재밌다\n");
			sb.append("선생님 저 공부 정말 열심히 할게요~\n");
			sb.append("진짜로!!! 정말로 !! 화이팅!!!\n");

			// 출력 방법 1 : 한 글자(2byte)씩 파일로 출력
			// StringBuilder -> String 변환 -> charAt() -> char변환
			String content = sb.toString(); // String 변환
			/*
			 * for (int i = 0; i < content.length(); i++) { char ch = content.charAt(i);
			 * fos.write(ch); // fos는 1, ch는 1~2바이트가 들어가있어서 깨짐 }
			 */

			// 출력 방법 2 : String을 byte[] 변환 후 출력 => 한글 안깨지게함

			// 이전
			// 수행 시간 확인
			long startTime = System.nanoTime();
			// System.nanoTime() : 1970.01.01 오전 9:00:00 부터
			// 현재 시간까지의 차이를 ns(nano second)로 반환
			// 1ms (밀리) == 1/1000초
			// 1us (마이크로) == 1/1000ms
			// 1ms (나노) == 1/1000us

			fos.write(content.getBytes()); // byte[]로 만들어 반환하고
			// 내부적으로 문자 인코딩을 적용하여 한글도 깨지지 않고 출력됨.

			// 이후
			long endTime = System.nanoTime();

			System.out.println("[수행시간] : " + (endTime - startTime) + "ns");
			// ⭐⭐
			fos.flush(); // FileOutPutStream에서는 선택사항 -> 남은 것들을 다 내보내준다는 것
			// flush : 스트림 안에 남아있는 모든 데이터를 외부로 모두 밀어냄

			System.out.println("출력 완료!");

		} catch (IOException e) {
			e.printStackTrace();
		} finally { // try 예외 발생 여부 관계 없이 무조건 수행 구간
			// 사용 완료한 스트림을 제거(닫기, 메모리 반환)
			// -> 메모리 누수 방지

			// 스트림이 정상 생성된 경우
			// 스트림을 닫는다.
			if (fos != null) {
				try {
					fos.close();
					// close() 메서드도 IOExcepetion을 발생시키기 떄문에
					// try-catch 이용하여 예외 처리 필수!
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 버퍼를 이용한 파일 출력 + BufferedOutputStream 보조 스트림 이용
	 *
	 *
	 *
	 */
	public void bufferedFileByteoutPut() {
		/*
		 * 버퍼(Buffer)란? - 데이터를 모아두는 공간, 마치 바구니 같은 메모리 공간
		 * 
		 * BufferedOutputStream / BufferedInputStream 출력용 보조 스트림(바이트) / 입력용 보조 스트림(바이트)
		 * - FileOutputStream은 1바이트씩 데이터를 입출력 -> 통로가 좁아서 데이터 입출력 시 속도가 느림 -> 보조스트림 이용 시
		 * 버퍼에 입출력 할 내용을 모아서 한번에 입출력! -> 기반 스트림(FileOutputStream)을 이ㅛㅇ하는 횟수, 시간이 줄어듬 ->
		 * 성능, 시간 효율 향상
		 * 
		 */
		FileOutputStream fos = null; // 기반 스트림 참조변수 선언
		BufferedOutputStream bos = null; // 보조 스트림 참조변수 선언

		try {
			fos = new FileOutputStream("/io_test/20251014/바이트기반_테스트_buffered.txt");

			// 기반스트림 fos를 이용해 보조스트림 bos를 생성
			bos = new BufferedOutputStream(fos);

			StringBuilder sb = new StringBuilder();
			sb.append("Hello World\n");
			sb.append("1234567890\n");
			sb.append("~!@#$%^&*()_-+<>?\n");

			sb.append("가나다라마바사\n");
			sb.append("와 자바 너무 재밌다\n");
			sb.append("선생님 저 공부 정말 열심히 할게요~\n");
			sb.append("진짜로!!! 정말로 !! 화이팅!!!\n");

			String content = sb.toString();
			long startTime = System.nanoTime();

			bos.write(content.getBytes());
			// 버퍼에 저장(파일에 즉시 기록 X)

			long endTime = System.nanoTime();

			System.out.println("[수행시간] : " + (endTime - startTime) + "ns");

			bos.flush(); // 스트림안에 남아있는 모든 데이터를 밀어냄 -> 꼭 작성
			// 안하면 메모장에 값이 안들어감
			// ** BufferedOutputStream 사용시 flush() 꼭 작성할 것!! **
			// 단, close()시 버퍼에 있는 내용 모두 밀어내고 close 하기 때문에
			// close() 있을 때는 flush() 선택 사항

			System.out.println("출력 완료!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// close() 시 버퍼에 남아있는 내용 모두 flush()함.
				// 조건문을 쓰는 이유는 NullPointerException을 처리하기 위함
				// bos가 null일 수 있기 때문
				// if문 작성 시 null이 아닐 때를 따지는 이유
				// 스트림 객체 미 생성시 close() 구간에서
				// NullPointerException 발생 우려가 있음
				// -> 예외 처리
				if (bos != null)
					bos.close();
				// 보조스트림(bos) close()시
				// 보조스트림 생서에 사용된 기반스트림(fos)도 같이 close()됨
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 바이트 기반 파일 입력 - 외부 파일의 내용을 자바프로그램 내부로 읽어오기
	 */
	public void fileByteInput() {
		// 파일 입력용 바이트 기반 스트림 선언
		FileInputStream fis = null; // 상자만 만든것
		// java.io -> IOException 일을킬 확률 높아서 예외처리 해줘야 함.
		try {
			fis = new FileInputStream("/io_test/20251014/노래가사.txt"); // 경로 전달, 데이터를 읽어서 가져옴

			// 연결통로를 만든 것
			// InputStream은 파일이 존재해야만 가져올 수 있음.
			// FileInputStream 이용 시 해당 경로에 반드시
			// 실제 파일이 존재해야함!
			// -> java.io.FileNotFoundException: \io_test\20251014\노래가사.txt (지정된 파일을 찾을 수
			// 없습니다)
			// FileOutputStream은 자동 생성해줌

			// 방법1. 파일 내부 내용을 1byte씩 끊어서 가져오기 -> 한글이면 다 깨짐;
			// -> 2바이트 범주의 글자들은 꺠지는 문제 발생함

			// byte -> 자바에서 정수형
			// 다루기 힘들기 때문에 정수형 기본형인 int로 변환해서 사용

			/*
			 * int value = 0; // 읽어온 바이트값을 저장할 변수
			 * 
			 * StringBuilder sb = new StringBuilder(); // 가변성을 띄는 문자열을 작성하는 것
			 * 
			 * while (true) { value = fis.read(); // 1byte씩 읽어오기 // 단, 더이상 읽어올 값이 없으면 -1 반환
			 * 
			 * if (value == -1) { // 다 읽어왔으면 반복 멈춤 break; }
			 * 
			 * sb.append((char) value); // char로 강제형변환해서 문자 형태로 sb에 추가 // String, char 타입을
			 * 받을 수 있음 } System.out.println(sb.toString()); // 읽어온 내용 콘솔에 출력
			 */

			// 방법 2. 파일에 저장된 모든 byte값을 다 읽어와서
			// byte[] 형태로 반환 받기 -> byte로 받으면 안깨짐
			// -> byte[] 배열을 이용해서 String 객체 생성

			byte[] bytes = fis.readAllBytes(); // 모든내용을 가져와서 배열로 만들어줌.
			String content = new String(bytes); // String 클래스는 byte 배열을 문자열로 만들어주는 기능이 존재

			System.out.println(content);

			// 입력은 flush가 없음. 출력은 flush -> 즉, 자바프로그램에서 외부로 보낼 때만 해주면 됌(FileOutputStream)
			// flush()는 출력 스트림에만 관련된 동작

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// stream => 메모리 닫아줘야함.
				if (fis != null) { // NullPointerException 방지하기 위함.
					fis.close(); // 사용완료된 Stream 메모리 반환
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * BufferedInputStream 보조 스트림을 이용한 성능 향상
	 * 
	 * InputStream의 경우 외부 파일의 데이터를 읽어올 때 사용 -> 읽어오는 파일 내부의 데이터 크기가 작으면 보조스트림의 성능 이점이
	 * 크게 눈에 띄지 않음.
	 */
	public void bufferedFileByteInput() {
		// 파일 입력용 바이트 기반 스트림 선언
		FileInputStream fis = null;
		// 파일 입력용 바이트 보조 스트림 선언
		BufferedInputStream bis = null;

		try {
			// 기반 스트림 생성
			fis = new FileInputStream("/io_test/20251014/노래가사.txt");
			// 보조 스트림 생성
			bis = new BufferedInputStream(fis);

			byte[] bytes = bis.readAllBytes();

			String content = new String(bytes);

			System.out.println(content);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (bis != null) {
					// 보조 스트림만 close() 해도 기반 스트림도 같이 close() 됨
					bis.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 */
	public void fileCopy() {
		/**
		 * 파일 복사
		 *
		 * 파일 경로를 입력받아 지정된 파일과 같은 경로에 복사된 파일 출력하기
		 *
		 * [실행화면] 파일 경로 입력 : /io_test/20251014/노래가사.txt 복사 완료 :
		 * /io_test/20251014/노래가사_copy.txt
		 *
		 * 1) 입력된 경로에 파일이 있는지 검사 2) 있으면 파일 내용을 모두 읽어오기 : FileInputStream +
		 * BufferedInputStream 3) 읽어온 내용을 같은 경로 위치에 "파일명_copy.확장자" 이름으로 출력 :
		 * FileOutputStream + BufferedOutputStream
		 * 
		 * + Scanner 대신 BufferedReader(문자열 입력용 스트림) 이용 -> BufferedReader는 보조스트림으로 단독사용
		 * 불가능! -> BufferedReader 생성 시 보조스트림인 InputStreamReader -> InputStream가 기반
		 *
		 */

		// 스트림 참조변수들 선언
		BufferedReader br = null; // 입력용 스트림(Scanner 대신 사용)

		FileInputStream fis = null; // 파일 입력 기반 스트림
		BufferedInputStream bis = null; // 파일 입력 보조 스트림

		FileOutputStream fos = null; // 파일 출력 기반 스트림
		BufferedOutputStream bos = null; // 파일 출력 보조 스트림

		try {
			// 키보드 입력을 받기 위한 스트림 객체 생성 -> Scanner 대신 만든 것
			br = new BufferedReader(new InputStreamReader(System.in));

			// 경로 입력 받기
			System.out.print("파일 경로 입력 : ");
			String target = br.readLine();

			// 해당 경로에 파일이 존재하는지 확인
			File file = new File(target);

			if (!file.exists()) { // 해당 경로에 파일이 존재하지 않으면
				System.out.println("[해당 경로에 파일이 존재하지 않습니다.");
				return; // 파일이 존재하지 않으면 해당 메서드 바로 종료
			}

			// 해당 경로에 파일이 존재하면
			// target이 가리키는 파일을 입력받을 수 있돌고
			// 입력용 스트림 생성

			fis = new FileInputStream(target);
			bis = new BufferedInputStream(fis);

			// 입력용 스트림을 이용해서 target 파일의 내용 입력받기
			byte[] bytes = bis.readAllBytes();

			// ---------------------------------------------------------
			// 출력할 파일의 경로 + _copy가 붙은 파일 이름
			// target : /io_test/20251014/노래가사.txt
			// copy : /io_test/20251014/노래가사_copy.txt

			StringBuilder sb = new StringBuilder();
			sb.append(target); // io_test/20251014/노래가사.txt

			// int String.lastIndexOf("문자열");
			// - 전달인자 문자열이 마지막으로 등장하는 인덱스를 찾아
			// int 값으로 반환. 찾지 못하면 -1 반환
			int insertPoint = target.lastIndexOf(".");

			sb.insert(insertPoint, "_copy");

			// 출력용 스트림 생성
			// 출력용 스트림은 없으면 자동 생성, 입력용 스트림은 자동생성 x -> 파일
			fos = new FileOutputStream(sb.toString());
			bos = new BufferedOutputStream(fos);

			// 원본에서 읽어온 내용 bytes를 bos를 이용해서 출력(쓰기)

			bos.write(bytes);
			bos.flush(); // 스트림에 잇는 데이터 모두 밀어내기!(출력용에서는 flush를 꼭 써줘야 한다)

			System.out.println("복사완료 : " + sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
