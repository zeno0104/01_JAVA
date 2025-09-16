package chap_07;

import chap_07.camera.Camera;
import chap_07.camera.FactoryCam;
import chap_07.camera.SpeedCam;

public class _14_Polymorphism {
	public static void main(String[] args) {
		// 다형성

		// class Person: 사람
		// class Student extends Person: 학생 (Student is a Person)
		// class Teacher extends Person: 선생님 (Teacher is a person)
		// -> 역은 성립 x

		Camera camera = new Camera();
		Camera factoryCam = new FactoryCam();
		Camera speedCam = new SpeedCam();
		// -> 부모 클래스로 작성해줄 수 있음

		camera.showMainFeature();
		factoryCam.showMainFeature();
		speedCam.showMainFeature();

		System.out.println("--------------------------------------------------");
		Camera[] cameras = new Camera[3];
		cameras[0] = new Camera();
		cameras[1] = new FactoryCam();
		cameras[2] = new SpeedCam();

		for (Camera cam : cameras) {
			cam.showMainFeature();
		}
		System.out.println("--------------------------------------------------");

		// factoryCam.detectFire();
		// speedCam.checkSpeed();
		// speedCam.recognizeLicensePlate();
		// 자식 클래스에 있는 메서드에는 접근 불가, 부모 클래스인 Camera로 타입이 되어있기 때문에 사용할 수 없음.
		// 따라서, 부모가 갖고있는 메서드만 사용할 수 있음.

		// instanceof
		if (camera instanceof Camera) {
			System.out.println("카메라입니다.");
		}
		if (factoryCam instanceof FactoryCam) {
			((FactoryCam) factoryCam).detectFire();
		}

		if (speedCam instanceof SpeedCam) {
			((SpeedCam) speedCam).checkSpeed();
		}

		// Java는 기본적으로 Object를 상속받고 있다.
		Object[] objs = new Object[3];
		objs[0] = new Camera();
		objs[1] = new FactoryCam();
		objs[2] = new SpeedCam();
	}
}