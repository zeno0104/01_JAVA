package edu.kh.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import edu.kh.model.dto.Toy;

public class ToyFactory extends Toy {

	private Scanner sc = new Scanner(System.in);
	private Set<Toy> setToyList = new LinkedHashSet<Toy>();
	private Map<Integer, String> mapIngredientList = new HashMap<Integer, String>();

	public Set<String> makeMap(int... ingredient) {

		Set<String> ingredientSetList = new HashSet<String>();

		for (int item : ingredient) {
			if (mapIngredientList.containsKey(item)) {
				String value = mapIngredientList.get(item);
				ingredientSetList.add(value);
			}
		}
		return ingredientSetList;
	}

	public boolean checkIngredient(String ingredient) {
		for (int i = 1; i <= mapIngredientList.size(); i++) {
			if (mapIngredientList.get(i).equals(ingredient)) {
				return true;
			}
		}
		return false;
	}

	public ToyFactory() {

		mapIngredientList.put(1, "면직물");
		mapIngredientList.put(2, "플라스틱");
		mapIngredientList.put(3, "유리");
		mapIngredientList.put(4, "고무");

		setToyList.add(new Toy("마미롱레그", 8, 36000, "분홍색", 19950805, makeMap(1, 4)));
		setToyList.add(new Toy("허기워기", 5, 12000, "파란색", 19940312, makeMap(1, 2)));
		setToyList.add(new Toy("키시미시", 5, 15000, "분홍색", 19940505, makeMap(1, 2)));
		setToyList.add(new Toy("캣냅", 8, 27000, "보라색", 19960128, makeMap(1, 2)));
		setToyList.add(new Toy("파피", 12, 57000, "빨간색", 19931225, makeMap(1, 2, 4)));
	}

	public ToyFactory(String name, int age, int price, String color, int year, Set<String> ingredient) {
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
			case 1: /* viewAllToys() */
				viewAllToys();
				break;
			case 2:/* createToy() */
				createToy();
				break;
			case 3:/* deleteToy() */
				System.out.println(deleteToy());
				break;
			case 4:/* viewToysByManufactureDate() */
				viewToysByManufactureDate();
				break;
			case 5:/* viewToysByAgeGroup() */
				viewToysByAgeGroup();
				break;
			case 6:/* addIngredient() */
				System.out.println(addIngredient());
				break;
			case 7:/* removeIngredient() */
				System.out.println(removeIngredient());
				break;
			case 0: /* 종료 */
				System.out.println("프로그램을 종료합니다..");
				break;
			default:
				System.out.println("0~7 사이의 숫자만 입력해주세요!!");
			}

		} while (selectNum != 0);

	}

	/**
	 * 1. 전체 장난감 조회하기
	 */
	public void viewAllToys() {
		System.out.println("<전체 장난감 목록>");

		Iterator<Toy> it = setToyList.iterator();
		int index = 1;
		while (it.hasNext()) {
			System.out.println(index++ + it.next().toString());
		}
	}

	/**
	 * 2. 새로운 장난감 만들기
	 */
	public void createToy() {
		System.out.println("<새로운 장난감 추가>");

		System.out.print("장난감 이름 : ");
		String name = sc.next();

		System.out.print("사용 가능 연령 : ");
		int age = sc.nextInt();

		System.out.print("가격 : ");
		int price = sc.nextInt();

		System.out.print("색상 : ");
		String color = sc.next();

		System.out.print("제조일 (YYYYMMDD 형식으로 입력) : ");
		int year = sc.nextInt();

		String input = "";

		Set<String> setIngredientList = new LinkedHashSet<String>();

		boolean flag = false;

		while (true) {
			System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요) : ");
			input = sc.next();

			if (input.equals("q"))
				break;

			if (checkIngredient(input)) {
				setIngredientList.add(input);
				flag = true;
			} else {
				System.out.println("해당 재료가 존재하지 않습니다.");
			}
		}
		if (flag) {
			setToyList.add(new Toy(name, age, price, color, year, setIngredientList));
			System.out.println("새로운 장난감이 추가되었습니다.");
		}
	}

	/**
	 * @param name
	 * @return
	 * subMethod : 장난감 존재하는지 이름 확인하는 메소드
	 */
	public boolean checkToyName(String name) {
		Iterator<Toy> it = setToyList.iterator();

		while (it.hasNext()) {
			if (((Toy) it.next()).getName().equals(name)) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	/**
	 * @return 3. 장난감 삭제하기
	 */
	public String deleteToy() {
		System.out.print("삭제할 장난감의 이름을 입력하세요: ");
		String name = sc.next();

		if (checkToyName(name)) {
			return "장난감이 삭제되었습니다.";
		} else {
			return "해당 장난감이 존재하지 않습니다";
		}
	}

	/**
	 * 4. 제조년월일 기준으로 오름차순 정렬
	 */
	public void viewToysByManufactureDate() {
		List<Toy> list = new ArrayList<Toy>(setToyList);

		Collections.sort(list);
		int index = 1;
		for (Toy toy : list) {
			System.out.println(index++ + toy.toString());
		}
	}

	/**
	 * 5. 연령별 사용 가능한 장난감 리스트 조회하기
	 */
	public void viewToysByAgeGroup() {
		Set<Integer> setAgeList = new LinkedHashSet<Integer>();
		
		for(Toy toy : setToyList) {
			setAgeList.add(toy.getAge());
		}
		
		
		List<Integer> ageList = new ArrayList<Integer>(setAgeList);
		
		List<Toy> toyList = new ArrayList<Toy>(setToyList);
		
		Collections.sort(ageList);
		Collections.sort(toyList, new Comparator<Toy>() {
			@Override
			public int compare(Toy o1, Toy o2) {
				// TODO Auto-generated method stub
				return o2.getYear() - o1.getYear();
			}
		});
		
		for(int ageInfo : ageList) {
			System.out.printf("[연령: %d세]\n", ageInfo);
			int index = 1;
			
			for(Toy toy : toyList) {
				if(toy.getAge() == ageInfo) {
					System.out.println(index++ + toy.toString());
				}
			}
		}
	}

	/**
	 * sub method: 재료 리스트 출력
	 */
	public void printIngredient() {
		for (Map.Entry<Integer, String> ingredient : mapIngredientList.entrySet()) {
			System.out.println(ingredient.getKey() + ":" + ingredient.getValue());
		}
		System.out.println("----------------------");
	}

	/**
	 * @return 6. 재료 추가
	 */
	public String addIngredient() {
		System.out.println("<재료 추가>");
		printIngredient();
		
		System.out.print("재료 고유번호(key) 입력: ");
		int keyNum = sc.nextInt();
		
		System.out.print("재료명 입력: ");
		String name = sc.next();
		
		if(mapIngredientList.get(keyNum) == null) {
			mapIngredientList.put(keyNum, name);
			return "새로운 재료가 성공적으로 등록되었습니다.";
		} 
		if(mapIngredientList.containsKey(keyNum)){
			System.out.println("이미 해당 키에 재료가 등록되어 있습니다.");
			System.out.print("덮어쓰시겠습니까? (Y/N): ");
			String yesOrNo = sc.next().toUpperCase();
			
			if(yesOrNo.equalsIgnoreCase("Y")) {
				mapIngredientList.put(keyNum, name);
				return "재료가 성공적으로 덮어쓰기 되었습니다.";
			} 
		}
		return "재료를 등록하지 않습니다.";
	}

	/**
	 * @return 7. 재료 제거 메소드
	 */
	public String removeIngredient() {
		System.out.println("<재료 삭제>");
		System.out.println("---현재 등록된 재료---");
		printIngredient();
		System.out.print("삭제할 재료명 입력: ");
		String name = sc.next();

		for (int index : mapIngredientList.keySet()) {
			if (mapIngredientList.get(index).equals(name)) {
				String result = "재료 '" + mapIngredientList.get(index) + "'가 성공적으로 제거되었습니다.";
				mapIngredientList.remove(index);
				return result;
			}
		}
		return "해당 이름의 재료가 존재하지 않습니다.";
	}
}
