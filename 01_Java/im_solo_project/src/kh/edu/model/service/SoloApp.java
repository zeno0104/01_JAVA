package kh.edu.model.service;

import java.util.*;

import kh.edu.model.dto.Member;

public class SoloApp extends Member {

	private Scanner sc = new Scanner(System.in);
	List<Member> memberList = new ArrayList<Member>();

	Map<String, Map<String, Integer>> pointList = new LinkedHashMap<String, Map<String, Integer>>();

	public List<String> makeFavorite(String... favorite) {
		List<String> favoriteList = new ArrayList<String>();

		for (String item : favorite) {
			favoriteList.add(item);
		}

		return favoriteList;
	}

	public Map<String, Integer> makePointList(String... nameList) {
		Map<String, Integer> pointMap = new LinkedHashMap<String, Integer>();
		for (String name : nameList) {
			pointMap.put(name, 0);
		}

		return pointMap;
	}

	public SoloApp() {
		memberList.add(new Member("광수", 30, "마케터", "인천", 'M', makeFavorite("농구"), false));
		memberList.add(new Member("상철", 33, "디자이너", "서울", 'M', makeFavorite("사진", "전시회"), false));
		memberList.add(new Member("순자", 28, "바이올리니스트", "대전", 'F', makeFavorite("클래식", "산책"), false));
		memberList.add(new Member("영수", 31, "회계사", "부산", 'M', makeFavorite("러닝", "보드게임"), false));
		memberList.add(new Member("영숙", 33, "연구원", "수원", 'F', makeFavorite("요가", "카페투어"), false));
		memberList.add(new Member("영철", 34, "개발자", "서울", 'M', makeFavorite("등산", "볼링"), false));
		memberList.add(new Member("정숙", 30, "교사", "부산", 'F', makeFavorite("독서", "요리"), false));
		memberList.add(new Member("현숙", 34, "개발자", "서울", 'F', makeFavorite("코딩", "러닝"), false));

		pointList.put("광수", makePointList("순자", "영숙", "정숙", "현숙"));
		pointList.put("상철", makePointList("순자", "영숙", "정숙", "현숙"));
		pointList.put("순자", makePointList("광수", "상철", "영수", "영철"));
		pointList.put("영수", makePointList("순자", "영숙", "정숙", "현숙"));
		pointList.put("영숙", makePointList("광수", "상철", "영수", "영철"));
		pointList.put("영철", makePointList("순자", "영숙", "정숙", "현숙"));
		pointList.put("정숙", makePointList("광수", "상철", "영수", "영철"));
		pointList.put("현숙", makePointList("광수", "상철", "영수", "영철"));
	}

	public SoloApp(String name, int age, String job, String address, char gender, List<String> favorite,
			List<Member> memberList, boolean isVoted) {
		super(name, age, job, address, gender, favorite, isVoted);
		this.memberList = memberList;
	}

	public void displayMenu() {
		int input = 0;
		do {
			System.out.println("===== 나는 SOLO 미니 =====");
			System.out.println("1. 전체 참가자 조회");
			System.out.println("2. 첫인상 투표");
			System.out.println("3. 데이트 신청");
			System.out.println("4. 모든 참가자별 호감도 조회");
			System.out.println("5. 마지막 선택");
			System.out.println("0. 종료");

			System.out.print(">>");
			input = sc.nextInt();

			switch (input) {
			case 1: /* printAllMember() */
				printAllMember();
				break;
			case 2:/* voteFirstImpression() */
				voteFirstImpression();
				break;
			case 3:/* requestDate() */
				System.out.println(requestDate());
				break;
			case 4:/* showAffectionScores() */
				showAffectionScores();
				break;
			case 5:/* finalChoice() */
				break;
			case 0:/**/
				System.out.println("프로그램을 종료합니다..");
				break;
			}
		} while (input != 0);

	}

	/**
	 * 1. 전체 참가자 조회
	 */
	public void printAllMember() {
		for (Member member : memberList) {
			System.out.println(member.toString());
		}
	}

	public boolean checkParticipant(String name) {
		boolean flag = false;
		for (Member member : memberList) {
			if (member.getName().equals(name)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public boolean checkGender(String myName, String diffName) {
		char firstGenderInfo = 0;
		char secondGenderInfo = 0;

		for (Member member : memberList) {
			if (member.getName().equals(myName)) {
				firstGenderInfo = member.getGender();
			}
			if (member.getName().equals(diffName)) {
				secondGenderInfo = member.getGender();
			}

		}

		if (firstGenderInfo == secondGenderInfo) {
			return false;
		} else {
			return true;
		}
	}

	public boolean getMember(String name) {

		for (Member member : memberList) {
			if (member.getName().equals(name)) {
				return member.getIsVoted();
			}
		}
		return false;
	}

	public void plusPoint(String myName, String diffName, int point) {
		Map<String, Integer> map = pointList.get(myName);

		for (Map.Entry<String, Integer> list : map.entrySet()) {
			if (list.getKey().equals(diffName)) {
				list.setValue(list.getValue() + point);
			}
		}

		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getName().equals(myName)) {
				memberList.get(i).setIsVoted(true);
			}
		}

	}

	/**
	 * 2. 첫인상 투표
	 */
	public void voteFirstImpression() {
		while (true) {
			System.out.print("내 이름: ");
			String myName = sc.next();
			boolean myNameResult = getMember(myName);

			if (myNameResult) {
				System.out.println("이미 첫인상 투표를 했습니다. (1회만 가능)");
				continue;
			}

			boolean myNameCheck = checkParticipant(myName);

			if (!myNameCheck) {
				System.out.println("존재하지 않는 참가자입니다: " + myName);
				continue;
			}
			System.out.print("투표할 이성 이름: ");
			String diffName = sc.next();

			boolean diffNameCheck = checkParticipant(diffName);

			if (!diffNameCheck) {
				System.out.println("존재하지 않는 참가자입니다: " + diffName);
			}

			if (myName.equals(diffName)) {
				System.out.println("동일인입니다. 다시 입력해주세요.");
				continue;
			}
			if (!checkGender(myName, diffName)) {
				System.out.println("동성을 선택하셨습니다. 다시 입력해주세요.");
				continue;
			}
			plusPoint(myName, diffName, 1);
			System.out.println("<첫인상 투표 완료: " + myName + " -> " + diffName + " (+1점)");
			break;
		}
	}

	/**
	 * 3. 데이트 신청
	 */
	public String requestDate() {
		System.out.print("내 이름: ");
		String myName = sc.next();

		boolean checkMyName = checkParticipant(myName);

		if (!checkMyName) {
			return "존재하지 않는 참가자입니다: " + myName;
		}

		System.out.print("신청할 이성 이름: ");
		String diffName = sc.next();

		boolean checkDiffName = checkParticipant(myName);

		if (!checkDiffName) {
			return "존재하지 않는 참가자입니다: " + myName;
		}
		if (myName.equals(diffName)) {
			return "자기 자신에게는 신청할 수 없습니다.";
		}
		Member firstInfo = null;
		Member secondInfo = null;

		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getName().equals(myName)) {
				firstInfo = memberList.get(i);
			}
			if (memberList.get(i).getName().equals(diffName)) {
				secondInfo = memberList.get(i);
			}
		}

		if (firstInfo.getGender() == secondInfo.getGender()) {
			return "데이트 신청은 이성에게만 가능합니다.";
		}

		System.out.print("날짜(YYYYMMDD): ");
		String date = sc.next();

		if (date.length() < 8 || date.length() > 8) {
			return "날짜 형식이 올바르지 않습니다. 예: 20241013";
		}

		plusPoint(myName, diffName, 2);
		return "<데이트 신청 완료: " + myName + " -> " + diffName + " " + date + "+2점";

	}

	/**
	 * 4. 모든 참가자별 호감도 조회
	 */
	public void showAffectionScores() {
		for (Map.Entry<String, Map<String, Integer>> memberPointList : pointList.entrySet()) {
			System.out.println(memberPointList.getKey() + " " + memberPointList.getValue());
		}
	}
}
