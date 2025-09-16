package chap_07.camera;

public class Camera { // 부모 클래스
	// 상속을 이용하면 부모 클래스의 기본적인 기능을 모두 사용하고, 추가적인 기능을 만들어서 확장할 수 있다.
	// 단일 상속만 가능하다.
	public String name;

	public Camera() {
		this("카메라"); // 밑에 있는 생성자를 호출.
	}

	protected Camera(String name) {
		this.name = name;
	}

	public void takePicture() {
		// 사진 촬영
		System.out.println(this.name + " : 사진을 촬영합니다.");
	}

	public void recordVideo() {
		// 동영상 녹화
		System.out.println(this.name + " : 동영상을 녹화합니다.");
	}

	public void showMainFeature() {
		System.out.println(this.name + "의 주요 기능 : 사진 촬영, 동영상 녹화");
	}
}