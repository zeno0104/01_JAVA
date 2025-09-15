package chap_07;

public class BlackBox {
	String modelName; // 모델명
	String resolution; // 해상도
	int price; // 가격
	String color; // 색상
	int serialNumber; // 시리얼 넘버

	static int counter = 0; // 시리얼 번호를 생성해주는 역할 (처음엔 0이었다가 ++ 연산을 통해서 값을 증가)

	static boolean canAutoReport = false; // 자동 신고 기능
	// 클래스 변수, 클래스 내 변수
	// static을 붙이면 이 클래스로부터 만들어지는 모든 객체에 똑같이 적용되는 것
	// 클래스명.canAutoReport와 같이 클래스 변수는 클래스명으로 접근하는 것을 권장

	// 생성자도 오버로딩이 가능하다
	BlackBox() {
		// 생성자
		// 객체가 생성될 때 자동으로 호출되는 메소드

		System.out.println("기본 생성자 호출");
		this.serialNumber = ++counter;
		System.out.println("새로운 시리얼 너버를 발급받았습니다 : " + this.serialNumber);
	}

	BlackBox(String modelName, String resolution, int price, String color) {
		// this()는 기본 생성자를 접근.
		// 해당 생성자를 수행하고 나서 밑에 코드가 수행된다.
		// 지금은 serialNumber를 발급받기 위해서 기본 생성자 수행을 하는 것
//		this(); // 기본 생성자 호출
//
//		System.out.println("사용자 정의 생성자 호출");
//		this.modelName = modelName;
//		this.resolution = resolution;
//		this.price = price;
//		this.color = color;
	}

	void autoReport() {
		if (canAutoReport) {
			System.out.println("충돌이 감지되어 자동으로 신고합니다.");
		} else {
			System.out.println("자동 신고기능이 지원되지 않습니다.");
		}
	}

	void insertMemoryCard(int capacity) {
		System.out.println("메모리 카드가 삽입되었습니다.");
		System.out.println("용량은 " + capacity + "GB 입니다.");
	}

	int getVideoFileCount(int type) {
		if (type == 1) {
			// 일반 영상
			return 9;
		} else if (type == 2) {
			// 이벤트 영상
			return 1;
		}
		return 10;
	}

	void record(boolean showDateTime, boolean showSpeed, int min) {
		System.out.println("녹화를 시작합니다");
		if (showDateTime) {
			System.out.println("영상의 날짜정보가 표시됩니다.");
		}
		if (showSpeed) {
			System.out.println("영상의 속도정보가 표시됩니다.");
		}
		System.out.println("영상은 " + min + "분 단위로 기록됩니다.");
	}

	void record() {
		record(true, true, 5);
	}

	// class 메소드, 모든 객체에서 실행할 수 있음
	static void callServiceCenter() {
		System.out.println("서비스 센터(1588-0000) 로 연결합니다.");

		// modelName = "test";

		// 클래스 변수는 클래스 메서드에서 사용 가능
		// 인스턴스 변수는 객체가 만들어져야 만들어지기 때문에, 직접 접근 불가
		canAutoReport = false;
	}

	void appendModelName(String modelName) {
		// 클래스가 가지는 인스턴스 변수의 modelName을 명시하기 위해 this를 붙여주면 됌
		// 클래스의 인스턴스 변수에 직접 접근할 수 있음.
		this.modelName += modelName;
	}

	// Getter & Setter
	String getModelName() {
		return modelName;
	}

	void setModelName(String modelName) {
		this.modelName = modelName;
	}

	String getResolution() {
		if (resolution == null || resolution.isEmpty()) {
			// isEmpty(): 빈 문자열인지 확인
			return "판매자에게 문의하세요.";
		}
		return resolution;
	}

	void setResolution(String resolution) {
		this.resolution = resolution;
	}

	int getPrice() {
		return price;
	}

	void setPrice(int price) {
		if (price < 100000) {
			this.price = 100000;
		} else {
			this.price = price;
		}
	}

	String getColor() {
		return color;
	}

	void setColor(String color) {
		this.color = color;
	}

}