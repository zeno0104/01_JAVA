package chap_07.camera;

public class SlowActionCam {

	public String name;

	public SlowActionCam() {
		this.name = "슬로우 액션 카메라";
	}

	public void makeVideo() {
		System.out.println("자체 개발한 비디오 제작 기능");
	}

	// 오버라이딩이 불가해짐 -> final 설정을 했기 때문
//	public void makeVideo() {
//		System.out.println(this.name + " : " + this.lens + "로 촬영한 영상을 통해 멋진 슬로우모드 비디오를 제작합니다.");
//	}

}
