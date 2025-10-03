package edu.kh.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import edu.kh.model.dto.Toy;

public class ToyFactory extends Toy {

	private Scanner sc = new Scanner(System.in);
	private List<Toy> toyList = new ArrayList<Toy>();
	private Map<Integer, String> ingredientList;
	
	public Set<String> makeMap(int...ingredient){
		
		Set<String> ingredientSetList = null;
		
		for(int item : ingredient) {
			if(ingredientList.containsKey(item)) {
				ingredientSetList.add(ingredientList.get(item));
			}
		}
		return ingredientSetList;
	}
	
	public ToyFactory() {
		
		ingredientList.put(1, "면직물");
		ingredientList.put(2, "플라스틱");
		ingredientList.put(3, "유리");
		ingredientList.put(4, "고무");
		
		toyList.add(new Toy("마미롱레그", 8, 36000, "분홍색", 19950805, makeMap(1, 4)));
		toyList.add(new Toy("허기워기", 5, 12000, "파란색", 19940312, makeMap(1, 2)));
		toyList.add(new Toy("키시미시", 5, 15000, "분홍색", 19940505, makeMap(1, 2)));
		toyList.add(new Toy("캣냅", 8, 27000, "보라색", 19960128, makeMap(1, 2)));
		toyList.add(new Toy("파피", 12, 57000, "빨간색", 19931225, makeMap(1, 2, 4)));
	}

	public ToyFactory(String name, int age, int price, String color, int year, Map<Integer, String> ingredient) {
		super(name, age, price, color, year, ingredient);
	}

	public void displayMenu() {
		int selectNum = 0;
		do {
			System.out.println("<< 플레이타임 공장 >>");
			System.out.println("1. 전체 장난감 조회하기");
			System.out.println("2. 새로운 장난감 만들기");
			System.out.println("3. 장난감 삭제하기");
			System.out.println("4. 장난감 제조일 순으로 조회하기");
			System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
			System.out.println("6. 재료 추가");
			System.out.println("7. 재료 제거");
			System.out.println("0. 종료");

			System.out.print("선택: ");
			selectNum = sc.nextInt();

			switch (selectNum) {
			case 1: /*viewAllToys()*/
				viewAllToys();
				break;
			case 2:/*createToy()*/
				break;
			case 3:/*deleteToy()*/
				break;
			case 4:/*viewToysByManufactureDate()*/
				break;
			case 5:/*viewToysByAgeGroup()*/
				break;
			case 6:/*addMaterial()*/
				break;
			case 7:/*removeMaterial()*/
				break;
			case 0: /* 종료 */
				 System.out.println("프로그램을 종료합니다..");
				break;
			default:
				System.out.println("0~7 사이의 숫자만 입력해주세요!!");
			}

		} while (selectNum != 0);

	}
	public void viewAllToys() {
		
	}

}
