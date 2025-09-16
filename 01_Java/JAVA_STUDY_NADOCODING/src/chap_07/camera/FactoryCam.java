package chap_07.camera;

// FactoryCam is a Camera. (IS-A)
public class FactoryCam extends Camera { // 자식 클래스

	public FactoryCam() {
		// this.name = "공장 카메라";
		super("공장 카메라");
	}

	public void recordVideo() {
		// 동영상 녹화
		super.recordVideo(); // 부모 클래스에 있는 record 메서드를 수행 및 추가적인 내용 수행
		detectFire();
	}

	public void detectFire() {
		// 화재 감지
		System.out.println("화재를 감지합니다.");
	}

	// 메소드 재정의 -> 부모 클래스에 있는 메서드를 덮음
	public void showMainFeature() {
		System.out.println(this.name + "의 주요 기능 : 화재 감지");
	}

}