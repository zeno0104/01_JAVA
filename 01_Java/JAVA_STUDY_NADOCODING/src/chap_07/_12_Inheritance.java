package chap_07;

import chap_07.camera.Camera;
import chap_07.camera.FactoryCam;
import chap_07.camera.SpeedCam;

public class _12_Inheritance {

	public static void main(String[] args) {
		// 상속
		// 부모 클래스의 기본적인 기능을 모두 사용하고, 추가로 뭔가를 할 때,
		// 추가적인 기능만 추가하면 확장해서 사용할 수 있다.
		// 코드의 중복을 줄일 수 있다.

		Camera camera = new Camera();
		FactoryCam factoryCam = new FactoryCam();
		SpeedCam speedCam = new SpeedCam();

		System.out.println(camera.name);
		System.out.println(factoryCam.name);
		System.out.println(speedCam.name);

		camera.takePicture();
		factoryCam.recordVideo();
		speedCam.takePicture();

		factoryCam.detectFire();
		speedCam.checkSpeed();
		speedCam.recognizeLicensePlate();
	}

}
