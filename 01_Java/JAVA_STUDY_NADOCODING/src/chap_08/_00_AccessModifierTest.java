package chap_08;

import chap_07.BlackBoxRefurbish;

public class _00_AccessModifierTest {
	public static void main(String[] args) {
		BlackBoxRefurbish b1 = new BlackBoxRefurbish();
		b1.modelName = "까망이"; // public
		// b1.resolution = "FHD"; // default : 같은 패키지 내에서 접근 가능
		// b1.price = 200000; // private : 해당 클래스에서만 접근이 가능
		// b1.color = "블랙"; // protected : 같은 패키지 or 다른 패키지에서는 자식 클래스에서 사용 가능
		
	}
}
