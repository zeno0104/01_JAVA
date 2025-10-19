package _12_IO_복습.edu.kh.io.pack2.model.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteService {
	/*
	 * 스트림(Stream) : 데이터가 이동하는 통로
	 * 				  기본적으로 한 방향으로 흐름
	 * 바이트(Byte)기반 스트림 
	 * - 1byte 단위로 데이터를 입/출력하는 스트림
	 * - 최상위 클래스 : InputStream, OutputStream
	 * - 문자열, 이미지, 영상, 오디오, pdf 등
	 * 모든것을 입/출력 할 수 있음
	 * (단, 통로가 좁다보니 속도가 좀 느림, 1byte 초과인 문자같은 경우
	 * 깨질 우려가 있음)
	 * 
	 * */
	
	/**
	 * 바이트 기반 스트림을 이용한 파일 출력
	 * + 데이터 출력
	 */
	// 1. 객체 생성하지 않아서 close할 때 에러
	// 2. flush 하지 않아서 발생
	// 3. 한글 깨지는거
	// 4. 파일 경로
	public void fileByteOutPut() {
		// FileOutputStream 참조 변수 선언 (OutputStream 상속받은 자식클래스)
		FileOutputStream fos = null;
		// Unhandled exception type FileNotFoundException
		// 위에서 new를 하게되면 위와같은 에러가 나오게 됌, 즉, 경로 상 파일을 찾을 수 없음 에러
		try {
			// new FileOutputStream("경로");
			// -> 경로에 작성된 파일과 연결된 파일 출력 스트림 객체 생성
			// 데이터를 내보내기위한 출력 스트림, 통로를 뚫어놓은 것
			// -> 출력스트림에 연결된 파일이 존재하지 않으면 자동 생성
			// 단, 폴더는 자동생성 해주지 않음.
			// 기존 파일이 존재하면 내용을 덮어쓰기함
			fos = new FileOutputStream("/io_test/20251014/바이트기반_테스트.txt");
			// -> 파일이기 때문에 없으면 자동생성해줌
			StringBuilder sb = new StringBuilder();
			
			// String의 불변성 문제를 해결한 객체
			// StringBuilder(비동기) / StringBuffer(동기)
			sb.append("Hello World!\n");
			sb.append("1234567890\n");
			sb.append("~!@#$%^&*()-+<>?\n");
			sb.append("가나다라마바사\n");
			sb.append("와 자바 너무 재밌다\n");
			sb.append("선생님 저 공부 정말 열심히 할게요~!\n");
			sb.append("진짜로!!! 정말로!! 화이팅!!!\n");
			
			// 출력 방법 1 : 한 글자(2byte -> char(2byte))씩 파일로 출력
			// StringBuilder -> String 변환 -> charAt() -> char 변환
			String content = sb.toString();

			/*
			for(int i = 0; i < content.length(); i++) {
				char ch = content.charAt(i);
				fos.write(ch); // 해당 파일에 글을 쓰는 것
				// fos는 1바이트 통로, ch는 1~2바이트 들어가있음(한글, 영어, 특수문자 등)
				// => 한글은 깨짐 
			}
			*/
			
			// 이전 
			// 수행 시간 확인
			long startTime = System.nanoTime();
			// System.nanoTime() : 1970.01.01 오전 9:00:00 부터
			// 현재 시간까지의 차이를 ns(nano second)로 반환
			// 1ms (밀리) == 1/1000초
			// 1us (마이크로) == 1/1000ms
			// 1ns (나노) == 1/1000us
			
			// 출력 방법 2 : String을 byte[] 변환 후 출력 -> 한글 안깨짐
			fos.write(content.getBytes("UTF-8")); // byte[]로 만들어 반환하고
			// 내부적으로 문자 인코딩을 적용하여 한글도 꺠지지 않고 출력됨.
			// 즉, 글자들을 byte[]안에 있는 데이터들을 1바이트 변환해서 fos로 내보내는 것
			
			// 이후
			long endTime = System.nanoTime();
			
			System.out.println("[수행시간] : " + (endTime - startTime) + "ns");
			
			
			fos.flush(); // FileOutputStream에서는 flush()는 선택사항
			// ⭐ flush : 스트림 안에 남아있는 모든 데이터를 외부로 모두 밀어냄
			System.out.println("출력 완료.");
			// fos는 한글은 깨짐!
				
		} catch (IOException e) {
			// FileOutputStream의 부모가 IOException임.
		} finally {
			// try 예외 여부 관계 없이 무조건 수행 구간
			// 사용 완료한 스트림을 제거(닫기, 메모리 반환)하는 코드
			// -> 메모리 누수 방지
			try {
				// 스트림이 정상 생성된 경우
				// 스트림을 닫는다.
				if(fos != null) {
					fos.close();
					// IOException을 발생시키는 메소드이기 때문에 try-catch 안에 넣어줌
					// close() 메소드도 IOException을 발생시키기 때문에
					// try-catch 이용하여 예외 처리 필수!
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void bufferedFileByteOutput() {
		/* 버퍼(Buffer)란?
		 * - 데이터를 모아두는 공간, 마치 바구니 같은 메모리 공간
		 * 
		 * BufferedOutputStream / BufferedInputStream
		 * 출력용 보조 스트림(바이트) / 입력용 보조 스트림(바이트)
		 * 
		 * - FileOutputStream은 1바이트씩 데이터를 입출력하기 때문에
		 * -> 통로가 좁아서 데이터 입출력 시 속도가 느림
		 * -> 보조스트림 이용 시 버퍼에 입출력할 내용을 모아서 한번에 입출력!
		 * -> 기반 스트림(FileOutputStream)을 이용하는 횟수, 시간이 줄어듬
		 * -> 성능, 시간 효율 향상
		 * 
		 * */
		// 기반스트림을 썼을 때보다 보조스트림을 썼을 때 속도차이가 있다.
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("/io_test/20251014/바이트기반_테스트_buffered.txt");
			
			// 기반스트림 fos를 이용해 보조스트림 bos를 생성
			bos = new BufferedOutputStream(fos);
			
			StringBuilder sb = new StringBuilder();
			
			// String의 불변성 문제를 해결한 객체
			// StringBuilder(비동기) / StringBuffer(동기)
			sb.append("Hello World!\n");
			sb.append("1234567890\n");
			sb.append("~!@#$%^&*()-+<>?\n");
			sb.append("가나다라마바사\n");
			sb.append("와 자바 너무 재밌다\n");
			sb.append("선생님 저 공부 정말 열심히 할게요~!\n");
			sb.append("진짜로!!! 정말로!! 화이팅!!!\n");
			
			String content = sb.toString();
			long startTime = System.nanoTime();
			
			bos.write(content.getBytes("UTF-8")); 
			// 버퍼에 저장(파일에 즉시 기록 X)
			long endTime = System.nanoTime();
			System.out.println("[수행시간] : " + (endTime - startTime) + "ns");
			
			bos.flush(); // 스트림안에 남아있는 모든 데이터를 밀어냄 => 즉, 버퍼에 있는 것을 다 넘김
			// ** BufferedOutputStream 사용시 flush() 꼭 작성할 것!!! **
			// flush를 작성안해도 한번에 flush된 것처럼 나가는 경우
			// close할 때 자동으로 flush됌
			// 하지만, 명시적으로 쓰는게 좋음 
			// 단, close()시 버퍼에 있는 내용 모두 밀어내고 close하기 때문에
			// close() 있을 때는 flush() 선택 사항
			// 즉, close 안했을 때, 파일안에 데이터가 들어가지 않음
			System.out.println("출력 완료.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 만약 bos가 null이고, if문을 안써주면 NullPointerException 발생
				// 즉, NullPointerException을 제거해주기 위함
				// if문 작성 시 null이 아닐 때를 따지는 이유는
				// 스트림 객체 미 생성시 close() 구간에서
				// NullPointerException 발생 우려가 잇음
				// -> 예외 처리
				if(bos != null) {
					bos.close();
				}
				// 보조스트림(bos) close()시
				// 보조스트림 생성에 사용된 기반스트림(fos)도 같이 close()됨
				// close() 시 버퍼에 남아있는 내용 모두 flush()함.
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 바이트 기반 파일 입력
	 * - 외부 파이르이 내용을 자바프로그램 내부로 읽어오기
	 */
	public void fileByteInput() {
		// 파일 입력용 바이트 기반 스트림 선언
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("/io_test/20251014/노래가사.txt");
			// FileInputStream 이용 시 해당 경로에 반드시
			// 실제 파일이 존재해야함!
			// -> FileNotFoundException 발생시킴
			// :\io_test\20251014\노래가사.txt (지정된 파일을 찾을 수 없습니다)
			
			// 방법1. 파일 내부 내용을 1byte씩 끊어서 가져오기
			// -> 2byte 범주의 글자들은 깨지는 문제 발생함
			
			// byte -> 자바에서 정수형
			// 다루기 힘들기 때문에 정수형 기본형인 int로 변환해서 사용
			
			/* -> 여기선 텍스트 다 깨짐 1바이트씩 읽어와서 한글이라 다 깨지는 거임
			int value = 0; // 읽어온 바이트 값을 저장할 변수
			
			// 가변성의 특징을 가짐, 자주 String이 바뀔 때 사용
			StringBuilder sb = new StringBuilder();
			
			while(true) {
				// 1byte씩 읽어오기
				value = fis.read();
				if(value == -1) 
					break;
				// 단, 더이상 읽어올 값이 없으면 -1 반환
				sb.append((char) value);
				// char로 강제형변환해서 문자 형태로 sb에 추가
			}
			System.out.println(sb.toString());
			*/
			
			// 방법 2. 파일에 저장된 모든 byte 값을 다 읽어와
			// byte[] 형태로 반환 받기
			// -> byte[] 배열을 이용해서 String 객체 생성
			
			byte[] bytes = fis.readAllBytes();
			
			String content = new String(bytes); // String에는 byte를 String으로 바꾸는게 있음
			System.out.println(content);
			
			// InputStream은 flush 없음
			// flush() 는 출력 스트림에만 관련된 동작
			
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용완료된 Stream 메모리 반환
			try {
				if(fis != null) {
					fis.close();
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * BufferedInputStream 보조 스트림을 이용한 성능 향상
	 * InputStream의 경우 외부 파일의 데이터를 읽어올 때 사용
	 * -> 읽어오는 파일 내부의 데이터 크기가 작으면
	 * 보조스트림의 성능 이점이 크게 눈에 띄지 않음.
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
				// 보조 스트림만 close()해도 기반 스트림도 같이 close() 됨
				if(bis != null) {
					bis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/** 파일 복사
	 *
	 * 파일 경로를 입력받아
	 * 지정된 파일과 같은 경로에 복사된 파일 출력하기
	 *
	 * [실행화면]
	 * 파일 경로 입력 : /io_test/20251014/노래가사.txt
	 * 복사 완료 : /io_test/20251014/노래가사_copy.txt
	 *
	 * 1) 입력된 경로에 파일이 있는지 검사
	 * 2) 있으면 파일 내용을 모두 읽어오기 : FileInputStream + BufferedInputStream
	 * 3) 읽어온 내용을 같은 경로 위치에 "파일명_copy.확장자" 이름으로 출력
	 *    : FileOutputStream + BufferedOutputStream
	 *   
	 * + Scanner 대신 BufferedReader(문자열 입력용 스트림) 이용
	 * -> BufferedReader는 보조스트림으로 단독사용 불가능!
	 * -> BufferedReader 생성 시 보조스트림인 InputStreamReader -> InputStream가 기반
	 *
	 */
	

	public void fileCopy() {
		
	}
}








