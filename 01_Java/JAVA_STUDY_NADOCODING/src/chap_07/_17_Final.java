package chap_07;

import chap_07.camera.ActionCam;
import chap_07.camera.SlowActionCam;

public class _17_Final {
	public static void main(String[] args) {
		// Final
		// 오버라이딩, 값 바꾸기, 클래스 상속을 할 수 없도록 막음

		// public (final) class ...
		// public (final) void ...
		// public > abstract > static > final > ...

		ActionCam actionCam = new ActionCam();
//		actionCam.lens = "표준렌즈";
		actionCam.recordVideo();
		actionCam.makeVideo();

		System.out.println("------------------------");

		SlowActionCam slowActionCam = new SlowActionCam();
		slowActionCam.makeVideo();
	}
}
