package chap_07.camera;

public final class ActionCam extends Camera {
// class에도 final을 써주면 상속이 불가능
	public final String lens; // = "광각렌즈"; // 값을 초기화 한 이후에는 값 변경x

	public ActionCam() {
		super("액션 카메라");
		lens = "광각렌즈";
	}

	public final void makeVideo() {
		System.out.println(this.name + " : " + this.lens + "로 촬영한 영상을 통해 " + "멋진 비디오를 제작합니다.");
	}
}
