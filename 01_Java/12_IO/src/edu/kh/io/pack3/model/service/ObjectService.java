package edu.kh.io.pack3.model.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import edu.kh.io.pack3.model.dto.Member;

public class ObjectService {
	/*
	 * ObjectInputstream / ObjectOutputStream
	 * 
	 * - Java 객체를 입/출력 할 때 사용하는 바이트 "보조" 스트림 (보조스트림은 단독 사용 불가!) *** 직렬화 - 객체를 직렬 형태로
	 * 변환 - 직렬화란 객체의 상태(필드..)를 바이트 스트림으로 변환하는 과정. 이를 통해 객체는 메모리에서만 존재하는 것이 아니라, 파일로
	 * 저장되거나 네트워크를 통해 전송될 수 있음 => 즉, 파일로 영구적으로 저장하는 방법 ex) 프로그램을 실행하면 데이터를 저장이 안되서
	 * 생긴 방법 -> 원래 프로그램에서는 DB에 저장됨
	 * 
	 * 
	 * - 역직렬화는 바이트 스트림을 다시 객체로 복원하는 과정. 즉, 저장되거나 전송된 데이터를 원래의 객체 형태로 되돌리는 작업.
	 * 
	 */
	/**
	 * 객체를 외부 파일로 출력
	 */
	public void objectOutput() {
		// 스트림 참조 변수 선언
		FileOutputStream fos = null; // 기반 스트림
		ObjectOutputStream oos = null; // 객체 출력용 보조 스트림

		try {
			// .dat 확장자 : data를 담고 있는 파일을 나타내는 확장자
			fos = new FileOutputStream("/io_test/20251014/Member.dat");
			oos = new ObjectOutputStream(fos);

			// Member 객체 생성
			Member member = new Member("member01", "pass01", "김회원", 30);
			// java.io.NotSerializableException: edu.kh.io.pack3.model.dto.Member
			// 직렬화를 하지 않았을 때 발생하는 에러
			// -> 직렬화 되지 않음
			// -> Member 클래스를 직렬화하기 위해 Member 클래스에 implements Serializable 해줘야 함!

			oos.writeObject(member); // 객체를 내보낸다.
			oos.flush();
			System.out.println("회원 데이터 출력 완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
				if (oos != null)
					oos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 외부 파일로부터 자바프로그램 내부로 객체 입력 받기
	 */
	public void objectInput() {
		// 스트림 참조 변수 선언
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream("/io_test/20251014/Member.dat");
			ois = new ObjectInputStream(fis);

			// 스트림을 이용해서 파일에 작성된
			// 직렬화된 Member 객체를 읽어와
			// 역직렬화를 수행하여 정상적인 Member 객체로 변경

			// Object ois.readObject() : 직렬화된 객체를 읽어와 역직렬화
			// + Member 객체로 변경(다운캐스팅)
			Member member = (Member) ois.readObject(); // 다운캐스팅
			System.out.println(member);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
