package edu.kr.network.client.model.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientService {
	public void clientStart() {
		// 1.서버의 IP주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
		// String serverIP = InetAddress.getLocalHost().getHostAddress();

		Scanner sc = new Scanner(System.in);
		// 1. 현재 컴퓨터의 로컬 IP 주소를 얻어오는 방법
		String serverIP = "127.0.0.1";

		// 2. 127.0.0.1 - loop back IP (현재 컴퓨터의 IP를 나타냄)
		// ex) 서버 컴퓨터 IP 주소 : 198.50.212.22
		// String serverIP = "198.50.212.22";
		// -> 서버가 다른 컴퓨터일때는
		// 그 컴퓨터의 IP주소를 작성해야 한다!!
		// 지금은 한대의 컴퓨터로 서버/클라이언트 둘다 사용중이라 ip가 같은 것일 뿐

		int port = 8500;

		Socket clientSocket = null;

		InputStream is = null;
		OutputStream os = null;

		BufferedReader br = null;
		PrintWriter pw = null;

		try {
			clientSocket = new Socket(serverIP, port);
			// 서버의 IP, Port를 통해 클라이언트 소켓 생성시
			// 해당 서버에 접속 요청 함.
			
			if(clientSocket != null) {
				// 2.서버와의 입출력 스트림 오픈
				is = clientSocket.getInputStream();
				os = clientSocket.getOutputStream();
				// 서버와 연결에 성공한 경우
				
				// 3.보조 스트림을 통해 성능 개선
				br = new BufferedReader(new InputStreamReader(is));
				pw = new PrintWriter(os);
				
				// 4.스트림을 통해 읽고 쓰기
				// 서버 -> 클라이언트에게 보낸 날짜메시지 한줄을 읽어와 콘솔창에 출력
				// 읽기! (입력)
				String serverMsg = br.readLine();
				System.out.println(serverMsg);
				
				System.out.print("서버로 전달할 메시지 : ");
				String str = sc.nextLine();
				
				pw.println(str);
				pw.flush();
			
			}
			// 5.통신 종료
			
		} catch (Exception e) {

		} finally {
			try {
				if (clientSocket != null)
					clientSocket.close();
				if (br != null)
					br.close();
				if (pw != null)
					pw.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
	}

}
