package kh.edu.model.service;

import java.util.*;
import java.util.Map.Entry;


import kh.edu.model.dto.Toy;

public class ToyFactory extends Toy {

	private Scanner sc = new Scanner(System.in);
	private Map<Integer, String> ingredientMap = new HashMap<Integer, String>();
	private Set<Toy> toys = new LinkedHashSet<>();

	public Set<String> useIngredient(int... ingredient) {

		Set<String> ingredientList = new LinkedHashSet<String>();

		for (int item : ingredient) {
			if (ingredientMap.containsKey(item)) {
				ingredientList.add(ingredientMap.get(item));
			}
		}
		return ingredientList;
	}

	public ToyFactory() {
		ingredientMap.put(1, "면직물");
		ingredientMap.put(2, "플라스틱");
		ingredientMap.put(3, "유리");
		ingredientMap.put(4, "고무");

		toys.add(new Toy("마미롱레그", 8, 36000, "분홍색", 19950805, useIngredient(1, 4)));
		toys.add(new Toy("허기워기", 5, 12000, "파란색", 19940312, useIngredient(1, 2)));
		toys.add(new Toy("키시미시", 5, 15000, "분홍색", 19940505, useIngredient(1, 2)));
		toys.add(new Toy("캣냅", 8, 27000, "보라색", 19960128, useIngredient(1, 2)));
		toys.add(new Toy("파피", 12, 57000, "빨간색", 19931225, useIngredient(1, 2, 4)));
	}

	public void displayMenu() {
		int input = 0;
		try {
			do {
				System.out.println("<< 플레이타임 공장 >>");
				System.out.println("1. 전체 장난감 조회하기");
				System.out.println("2. 새로운 장난감 만들기");
				System.out.println("3. 장난감 삭제하기");
				System.out.println("4. 장난감 제조일 순으로 조회하기");
				System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
				System.out.println("6. 재료 추가");
				System.out.println("7. 재료 제거");
				System.out.println("0. 프로그램 종료");

				System.out.print("선택 : ");
				input = sc.nextInt();

				switch (input) {
				case 1: /* viewAllToys() */
					viewAllToys();
					break;
				case 2:/* createToy() */
					createToy();
					break;
				case 3:/* deleteToy() */
					System.out.println(deleteToy());
					;
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
					removeIngredient();
					break;
				case 0:/* 프로그램 종료 */
					System.out.println("프로그램을 종료합니다..");
					break;
				default:
					System.out.println("0~7 사이의 숫자만 입력해주세요!");
				}
			} while (input != 0);
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 1. 전체 장난감 조회하기
	 */
	public void viewAllToys() {

		int index = 1;

		Iterator<Toy> toyList = toys.iterator();

		while (toyList.hasNext()) {
			System.out.println((index++) + ". " + toyList.next());

		}

	}

	/**
	 * @param beforeCheckToy
	 * @return 2. 장난감 추가하기의 서브 메소드 장난감이 toys에 존재하는지를 판별하는 메소드
	 */
	public boolean checkToy(Toy beforeCheckToy) {
		// 중복된 장난감이 있는지 확인

		for (Toy toy : toys) {
			if (toy.equals(beforeCheckToy)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 2. 장난감 추가하기
	 */
	public void createToy() {
		System.out.println("새로운 장난감 추가");

		System.out.print("장난감 이름 : ");
		String name = sc.next();

		System.out.print("사용 가능 연령 : ");
		int age = sc.nextInt();

		System.out.print("가격 : ");
		int price = sc.nextInt();

		System.out.print("색상 : ");
		String color = sc.next();

		System.out.print("제조일(YYYYMMDD 형식으로 입력) : ");
		int year = sc.nextInt();

		String ingredient = "";
		Set<String> ingredientSet = new LinkedHashSet<String>();

		while (true) {
			System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요)");
			ingredient = sc.next();

			if (ingredient.equals("q")) {
				break;
			}
			if (!ingredientMap.containsValue(ingredient)) {
				System.out.println("존재하지 않는 재료입니다.");
			} else {
				ingredientSet.add(ingredient);
			}
		}

		Toy beforeToy = new Toy(name, age, price, color, year, ingredientSet);
		boolean result = checkToy(beforeToy);

		if (result == false) {
			System.out.println("이미 등록된 장난감입니다.");
		} else {
			toys.add(new Toy(name, age, price, color, year, ingredientSet));
			System.out.println("새로운 장난감이 추가되었습니다.");
		}
	}

	/**
	 * 3. 장난감 삭제하기
	 */
	public String deleteToy() {
		System.out.print("삭제할 장난감의 이름을 입력하세요: ");
		String name = sc.next();

		Iterator<Toy> toy = toys.iterator();

		while (toy.hasNext()) {
			if (toy.next().getName().equals(name)) {
				toy.remove();
				return "장난감이 삭제되었습니다.";
			}
		}
		return "장난감이 존재하지 않습니다.";
	}

	/**
	 * 4. 장난감 제조일 순으로 조회하기
	 */
	public void viewToysByManufactureDate() {
		System.out.println("<제조일 순으로 장난감을 정렬>");
		List<Toy> toy = new ArrayList<Toy>(toys);

		Collections.sort(toy);
		for (Toy toyItem : toy) {
			System.out.println(toyItem);
		}
	}

	/**
	 * 5. 연령별 사용 가능한 장난감 리스트 조회하기
	 */
	public void viewToysByAgeGroup() {
		Set<Integer> ageValue = new HashSet<Integer>();

		List<Toy> toyList = new ArrayList<Toy>(toys);

		for (Toy toy : toys) {
			ageValue.add(toy.getAge());
		}

		Collections.sort(toyList, new Comparator<Toy>() {
			@Override
			public int compare(Toy o1, Toy o2) {
				// TODO Auto-generated method stub
				return o2.getYear() - o1.getYear();
			}
		});
		for (int age : ageValue) {
			System.out.println("[연령: " + age + "세]");
			for (int i = 0; i < toyList.size(); i++) {
				if (toyList.get(i).getAge() == age) {
					System.out.println(toyList.get(i).toString());
				}
			}

		}
	}

	public void printIngredient() {
		System.out.println("---현재 등록된 재료---");

		for (Entry<Integer, String> item : ingredientMap.entrySet()) {
			System.out.println(item.getKey() + ": " + item.getValue());
		}
		System.out.println("-----------------");
	}

	/**
	 * 6. 재료 추가
	 */
	public String addIngredient() {
		System.out.println("< 재료 추가 >");
		printIngredient();
		System.out.print("재료 고유번호(key) 입력 : ");
		int key = sc.nextInt();

		System.out.print("재료명 입력: ");
		String name = sc.next();

		if (ingredientMap.containsKey(key)) {
			System.out.println("이미 해당 키에 재료가 등록되어 있습니다.");
			System.out.print("덮어쓰시겠습니까? (Y/N): ");
			String yesOrNo = sc.next();

			if (yesOrNo.equalsIgnoreCase("Y")) {
				ingredientMap.put(key, name);
				return "재료가 성공적으로 덮어쓰기 되었습니다.";
			} else {
				return "재료를 등록하지 않습니다.";
			}
		} else {
			ingredientMap.put(key, name);
			return "새로운 재료가 성공적으로 등록되었습니다.";
		}

	}

	/**
	 * 7. 재료 제거
	 */
	public void removeIngredient() {
		System.out.println("<재료 삭제>");
		printIngredient();

		System.out.print("삭제할 재료명 입력: ");
		String name = sc.next();

		boolean flag = false;

		for (Entry<Integer, String> item : ingredientMap.entrySet()) {
			if (item.getValue().equals(name)) {
				ingredientMap.remove(item.getKey());
				flag = true;
				System.out.println("재료 '" + item.getValue() + "'가 성공적으로 제거되었습니다.");
				break;
			}
		}
		if (!flag) {
			System.out.println("해당 이름의 재료가 존재하지 않습니다.");
		}

	}
}
