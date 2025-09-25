package edu.kh.oarr.model.service;

import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;

public class MemberService {
	// 비즈니스 로직 작성
	// 속성
	private Scanner sc = new Scanner(System.in);

	// 회원가입한 사람의 정보를 저장해둘 참조 변수
	// Member 5칸짜리 객체배열 선언 및 할당
	private Member[] memberArr = new Member[5]; // 회원가입 한 사람

	// 현재 로그인한 회원의 정보를 저장할 참조 변수 선언 -> 로그인은 1명
	private Member loginMember = null;

	// 기능
	public MemberService() { // 기본생성자
		// memberArr 배열 0, 1, 2 인덱스 초기화
		memberArr[0] = new Member("user01", "pass01", "홍길동", 30, "서울");
		memberArr[1] = new Member("user02", "pass02", "계보린", 25, "경기");
		memberArr[2] = new Member("user03", "pass03", "고길동", 45, "강원");
	}

	// 메뉴 출력용 메서드
	public void displayMenu() {
		int menuNum = 0; // 메뉴 선택용 변수

		// 무조건 한번은 반복
		do {
			System.out.println("==회원 관리 프로그램 v2==");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 검색(지역)");
			System.out.println("0. 프로그램 종료");

			System.out.print("메뉴 입력 : ");
			menuNum = sc.nextInt();

			// 입력 버퍼에 남은 개행문자 제거
			sc.nextLine();

			switch (menuNum) {
			case 1: /* signUp() */
				System.out.println(signUp());
				break;
			case 2: /* login() */
				System.out.println(login());
				break;
			case 3: /* selectMember() */
				System.out.println(selectMember());
				break;
			case 4: /* updateMember() */
				int result = updateMember();

				if (result == -1) { // 로그인 x
					System.out.println("로그인 후 이용바람");
				} else if (result == 0) { // 비밀번호 다름
					System.out.println("회원 정보 수정 실패(비밀번호 불일치)");
				} else { // 수정 완료
					System.out.println("회원 정보가 수정되었습니다:)");
				}
				break;
			case 5: /* searchRegion() */
				searchRegion();
				break;
			case 0:
				System.out.println("프로그램 종료..");
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 메뉴에 있는 번호만 선택하세요!!");
			}
		} while (menuNum != 0); // menuNum이 0이 되면 반복 종료
	}

	// 사이드 메서드 : 메인 기능은 아니나, 다른 메서드에 도움이 되는 메서드
	// memberArr의 비어있는 인덱스 번호를 반환하는 역할
	// 단, 비어있는 인덱스가 없다면 -1 반환
	public int emptyIndex() {
		for (int i = 0; i < memberArr.length; i++) {
			// 현재 인덱스에 있는 요소가 참조하는 값이
			// null 인 경우의 인덱스를 반환
			if (memberArr[i] == null) {
				return i;
				// 현재 메서드를 종료하고 호출한 곳으로
				// i 값을 가지고 되돌아감
			}
		}
		// for문을 수행했지만 인덱스값이 return되지 않은 경우
		// 해당 위치 코드가 수행된다!
		// -> for문에서 return 되지 않았다 == 배열에 빈칸이 없다.
		return -1;
	}

	// 회원가입 메서드
	public String signUp() {
		// 회원 가입
		System.out.println("\n=======회원 가입=======");

		// 객체 배열 memberArr에 새로 가입할 회원 정보를 저장할 예정
		// -> memberArr 배열에 빈자리가 있는지 확인
		// -> 빈자리가 있을 때 : 빈 공간의 인덱스 번호를 얻어오기
		// -> 없을 때 : -1 반환

		int index = emptyIndex();

		if (index == -1) { // 비어있는 공간 없음 -> 회원가입 불가!
			return "회원가입 불가능(인원 수 초과)";
		}

		// 회원 가입 가능일 때
		System.out.println("아이디 : ");
		String memberId = sc.next();

		System.out.println("비밀번호 : ");
		String memberPw = sc.next();

		System.out.println("비밀번호 확인 : ");
		String memberPwCheck = sc.next();

		System.out.println("이름 : ");
		String memberName = sc.next();

		System.out.println("나이 : ");
		int memberAge = sc.nextInt();

		System.out.println("지역 : ");
		String memberRegion = sc.next();

		// 비밀번호, 비밀번호 확인이 일치하면 회원가입 진햏ㅇ
		// 일치하지 않으면 회원가입 실패

		if (memberPw.equals(memberPwCheck)) { // 일치하는 경우
			memberArr[index] = new Member(memberId, memberPw, memberName, memberAge, memberRegion);
			return "회원가입 완료!";
		} else { // 불일치
			return "회원 가입 실패!! (비밀번호 불일치)";
		}

	}

	// 로그인 메서드
	public String login() {
		System.out.println("\n=======로그인=======");

		// 1) 아이디, 비밀번호 입력받기
		System.out.print("아이디 : ");
		String memberId = sc.next();

		System.out.print("비밀번호 : ");
		String memberPw = sc.next();

		// 2) memberArr 배열 내 요소를 순서대로 접근하여
		for (int i = 0; i < memberArr.length; i++) {
			// 2-1) 현재 접근한 요소가 null이 아닌지 확인
			if (memberArr[i] != null) { // 회원 정보가 있을 경우
				// 2-2) 회원 정보가 있을 경우
				// -> 회원정보의 아이디, 비밀번호와
				// 입력받은 (로그인)아이디, 비밀번호가 같은지 비교
				if (memberArr[i].getMemberId().equals(memberId) && memberArr[i].getMemberPw().equals(memberPw)) {
					// 2-3) 아이디/비밀번호 같다면
					// 로그인 회원 정보 객체를 참조할 변수
					// loginMember에 현재 접근중인 memberArr[i] 요소에
					// 저장된 주소를 얕은복사
					loginMember = memberArr[i];
					break; // 더이상 같은 아이디, 비밀번호가
					// 없을 것이라고 예상. 효율을 위해 for문 종료
				}
			}
		}
		// 3) 로그인 성공/실패 여부에 따라 결과 값 반환
		// -> 로그인 성공 : 홍길동님 환영합니다.
		// -> 로그인 실패 : 아이디 또는 비밀번호가 일치하지 않습니다.
		if (loginMember != null) {
			return loginMember.getMemberName() + "님 환영합니다!";
		} else {
			return "아이디 또는 비밀번호가 일치하지 않습니다.";
		}
	}

	// 회원 검색(지역) 메서드
	public void searchRegion() {
		System.out.println("\n=======회원 검색(지역)=======");
		System.out.print("검색할 지역을 입력하세요 : ");
		String inputRegion = sc.next();

		boolean flag = true; // 검색 결과 신호용 변수

		for (int i = 0; i < memberArr.length; i++) {
			// 2) memberArr[i] 요소가 null인 경우 반복 종료
			if (memberArr[i] == null) {
				break;
			}
			// 3) memberArr[i] 요소가 null이 아니라면
			// memberArr[i] 요소에 저장된 지역(region)이
			// 입력받은 지역(inputRegion)과 같을 경우
			// memberARr[i] 요소에 저장된 객체의
			// 회원 아이디, 이름을 출력
			if (memberArr[i].getRegion().equals(inputRegion)) {
				System.out.printf("아이디 : %s, 이름 : %s\n", memberArr[i].getMemberId(), memberArr[i].getMemberName());
				flag = false; // 찾았다는 신호
			}
		}
		// 4) 입력한 지역과 일치하는 회원이 없다면
		// 일치하는 검색결과가 없습니다!
		if (flag) { // 찾기 못함
			System.out.println("일치하는 검색결과가 없습니다!");
		}
	}

	public String selectMember() {
		System.out.println("\n======회원 정보 조회======");
		// 1) 로그인 여부 확인
		// 필드 loginMember가 참조하고 있는 객체 있는지 확인
		if (loginMember == null) {
			return "로그인 후 이용 바람";
		}
		// 2) 로그인이 되어있는 경우
		// 현재 로그인한 회원의 정보를 출력할 문자열을
		// 만들어서 반환
		String result = "이름 : " + loginMember.getMemberName();
		result += "\n아이디 : " + loginMember.getMemberId();
		result += "\n나이 : " + loginMember.getMemberAge();
		result += "\n지역 : " + loginMember.getRegion();

		return result;
	}

	public int updateMember() {
		System.out.println("\n======회원 정보 수정======");

		// 1) 로그인 여부 판별
		if (loginMember == null) {
			return -1;
		}

		// 2) 로그인 된 경우
		// 수정할 회원 정보 이볅 받기(이름, 나이, 지역)

		System.out.println("수정할 이름 입력 : ");
		String memberName = sc.next();

		System.out.println("수정할 나이 입력 : ");
		int memberAge = sc.nextInt();

		System.out.println("수정할 지역 입력 : ");
		String memberRegion = sc.next();

		// 3) 비밀번호를 입력받아서
		// 로그인한 회원의 비밀번호와 일치하는지 확인

		System.out.println("비밀번호 입력 : ");
		String memberPw = sc.next();

		if (loginMember.getMemberPw().equals(memberPw)) {
			loginMember.setMemberName(memberName);
			loginMember.setMemberAge(memberAge);
			loginMember.setRegion(memberRegion);
			loginMember.setMemberPw(memberPw);
			return 1;
		} else {
			return 0;
		}
	}
}
