package edu.kh.io.pack4.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CharacterService {
	/* 문자 기반 스트림
	 * - 2byte 문자 단위로 입/출력 하는 스트림
	 * - Reader (입력) / Writer (출력) 최상위 클래스
	 * - 문자만 작성된 파일, 채팅, 인터넷 요청 시 데이터 전달
	 * */
	/**
	 * 문자 기반 파일 입력(파일 읽어오기)
	 * + 보조 스트림 Buffered 사용
	 */
	public void fileInput() {
		// 스트림 참조변수 선언
		FileReader fr = null; // 문자 기반 파일 입력 스트림
		BufferedReader br = null; // 문자 기반 보조 스트림
		
		try {
			fr = new FileReader("/io_test/20251014/노래가사.txt"); // 문자 기반 스트림 생성
			br = new BufferedReader(fr); // 문자 기반 보조 스트림 생성
			
			String line = null;
			
			while(true) {
				// String BufferedReader.readLine() : 한 줄씩 문자열을 읽는 역할(줄단위)
				// -> 개행문자가 나올때까지의 문자열을 읽음
				line = br.readLine();
				
				
				if(line == null) { // 더 이상 읽어올 내용이 없다면 반복 종료
					break;
				}
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) fr.close();
				if(br != null) br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	/**
	 * 문자 기반 파일 출력(파일 쓰기)
	 * + 보조 스트림 Buffered 사용
	 */
	public void fileOutput() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter("/io_test/20251014/출력테스트.txt");
			bw = new BufferedWriter(fw);
			
			StringBuilder sb = new StringBuilder();
			sb.append("아직도 수요일이라니\n");
			sb.append("를 긍정의 힘으로 !!\n");
			sb.append("벌써 수요일이라니!!\n");
			sb.append("???????????????????????\n");
			
			// /io_test/20251014/출력테스트.txt
			
			bw.write(sb.toString()); // sb에 저장된 내용을 연결된 파일에 출력(쓰기)
			bw.flush();
			
			System.out.println("출력 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) fw.close();
				if(bw != null) bw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}
}
