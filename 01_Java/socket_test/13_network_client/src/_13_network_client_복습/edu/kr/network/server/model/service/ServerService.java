package _13_network_client_복습.edu.kr.network.server.model.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerService {
	// TCP Socket 프로그래밍
	// - TCP는 신뢰성 있는 연결을 보장하며
	// 소켓은 이 연결의 끝점 역할을 하며, 데이터 송수신 통로가 됨
	// 즉, TCP 통신 = 소켓 간 연결 + 데이터 주고받기
	/*
	 * TCP
	 * - 서버, 클라이언트간 1:1 소켓통신 (연결 지향적 프로토콜)
	 * - 서버가 먼저 실행되어 있는 상태에서
	 *   클라이언트가 연결해야 함.
	 *  
	 *  
	 * - 데이터 전송 순서가 보장되고,
	 *   수신 여부를 판단하여 오류 발생 시 재전송함.
	 *  
	 *  
	 * * java.net 패키지에서 제공하는
	 *   Socket, ServerSocket 클래스를 사용해야함.
	 *  
	 *   Socket
	 * - 프로세스의 양 끝단(프로세스간의 통신을 담당)
	 * - Input/OutputStream 보유하고 있음.
	 *
	 *
	 *   ServerSocket
	 * - 포트와 연결되어 외부 요청을 기다리는 객체
	 * - 클라이언트의 연결 요청이 들어오면
	 *   클라이언트의 소켓을 얻어와 연결하게 된다.
	 *
	 * - 하나의 포트에는 하나의 ServerSocket만 연결 가능
	 * */
	public void serverStart() {
		// 1. 서버의 포트번호 정함
		int port = 8500;
		// 포트는 0 ~ 65535 사이를 지정 가능
		// 단, 1023번 이하는 이미 사용중인 경우가 많으니 피하는게 좋음
		
		// 소켓용 참조변수 선언
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		// 클라이언트가 서버쪽으로 연결 요청을 하면 서버쪽에서 client용 소켓을 같이 받음
		// 담아줄 변수 선언한 것
		
		// 입/출력용 참조변수 선언
		// 바이트 기반 스트림 최상위 부모 클래스
		// 뭐가 넘어올지, 어떤 자식 객체가 넘어올지 모르기 때문에 선언한 것
		InputStream is = null;
		OutputStream os = null;
		
		// 보조스트림 참조변수 선언
		BufferedReader br = null; // 키보드 입력
		
		PrintWriter pw = null;
		// PrintWriter : 
		
		// 2. 서버용 소켓 객체 생성
		
		
		// 3. 클라이언트 쪽에서 접속 요청이 오길 기다림
		// 4. 접속 요청이 오면 요청 수락 후 해당 클라이언트에 대한 소켓 객체 생성
		// 5. 연결된 클라이언트와 입출력 스트림 생성
		// 6. 보조 스트림을 통해 성능 개선
		// 7. 스트림을 통해 읽고 쓰기
		// 8. 통신 종료
		
		// 192.168.50.244
		
		// 18분10초~ 
		
	}

}














