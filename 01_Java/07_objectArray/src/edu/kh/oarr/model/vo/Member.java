package edu.kh.oarr.model.vo;

public class Member {
	// 멤버 정의

	// 속성 (필드 == 멤버변수)
	// 인스턴스 변수 -> 그냥 일반 변수
	// 클래스 변수 -> static으로 정의한 변수

	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String region; // 지역 (서울, 경기)
	// 추상화를 통해 필드 정의

	// private으로 한 이유
	// -> class 외부에서 필드들의 직접접근 제한하기 위해서
	// -> 캡슐화 원칙

	// 기능 (메서드, 생성자)
	// 생성자 (기본생성자, 매개변수 생성자)
	// 생성자 작성 규칙
	// 1. 생성자명은 클래스명과 같다
	// 2. 반환형이 없다.

	// 기본 생성자
	// 매개변수 생성자가 없을 때, 컴파일러가 기본 생성자를 만들어 준다.

	// 오버로딩 : 같은 클래스 내 동일한 생성자명/메서드명 등을 이용할 수 있는 기법
	// 타입, 개수, 순서
	public Member() {

	}

	// 모든 필드초기화용 매개변수 생성자
	public Member(String memberId, String memberPw, String memberName, int memberAge, String region) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.region = region;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
}
