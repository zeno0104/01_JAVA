package edu.kh.collection.pack1.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.pack1.model.dto.Student;

public class StudentService {

	// java.util.List => 인터페이스 : List에 반드시 필요한 필수 기능을 모아둔 인터페이스
	// * 인터페이스 객체 생성 불가, 부모 참조변수로써의 역할은 가능!

	// java.util.ArrayList : 배열 형태 List (가장 대표적인 List 자식 클래스)
	// -> 검색(조회) 효율적
	// java.util.Vector : 동기화를 제공하여 List중 성능이 가장 좋지 않음
	// java.util.LinkedList : 값을 추가, 수정, 삭제에서 효율적

	// <E> : 제네릭
	// 타입을 제한하는 문법
	// 제네릭은 객체(Reference Type)만 허용
	// => 즉, wrapper class를 넣으면 됌
	// Java 7 이상에서는 우변 제네릭 타입을 생략 가능
	// 다이아몬드 연산자 : 컴파일러가 좌변 부분을 보고 우변의 타입을 추론

	private List<Object> testList = new ArrayList<>();

	// 학생 정보를 저장할 List 생성
	private List<Student> studentList = new ArrayList<>();

	private Scanner sc = new Scanner(System.in);

	// private List<Student> studentList; or private List<Student> studentList =
	// null;
	// stack에 null, heap에는 아무것도 생성 x
	// 따라서, add, remove와 같은 메서드를 사용할 수 없다.
	// 빈 상자만 만들어 놓은 것

	// new ArrayList() : 기본생성자 -> 기본 크기 10짜리 리스트 생성
	// 하지만 리스트의 크기는 늘었다 줄었다 하기 때문에 큰 의미는 없음

	public StudentService() { // 기본 생성자
		studentList.add(new Student("홍길동", 23, "서울시 중구", 'M', 100));
		studentList.add(new Student("이수지", 20, "경기도 안산", 'F', 100));
		studentList.add(new Student("강하늘", 25, "서울시 강남구", 'M', 80));
		studentList.add(new Student("오미나", 24, "충북 청주시", 'F', 90));
		studentList.add(new Student(" 박주희", 24, "서울시 서대문구", 'F', 70));
	}

	public void ex() { // List 테스트용 메서드
		// List.add(Object e) : 리스트에 객체를 추가
		// 매개변수 타입 Object == 모든 객체 타입을 매개변수로 전달할 수 있음
		testList.add("문자열");
		testList.add(new Scanner(System.in));
		testList.add(100); // AutoBoxing (자동으로 기본자료형을 객체형태로 변환함)
		testList.add(new Object());
		// 컬렉션 특징 : 여러 타입의 데이터를 저장할 수 있다.

		// Object List.get(int index) : 리스트에서 index번째에 있는 객체를 반환해주는 메서드
		// 반환형이 Object == 모든 객체를 반환할 수 있다.

		for (Object e : testList) {
			System.out.println(e);
		}
	}

	/**
	 * 메뉴 출력용 메서드
	 * 
	 * alt + shift + j : 메서드 설명용 주석
	 * 
	 * @author 안재훈(jaehun0104@gmail.com)
	 * 
	 */
	public void displayMenu() {
		int menuNum = 0; // 메뉴 선택용 변수
		do {
			try {
				System.out.println("================학생 관리 프로그램================");
				System.out.println("1. 학생 정보 추가");
				System.out.println("2. 학생 정보 전체조회");
				System.out.println("3. 학생 정보 수정");
				System.out.println("4. 학생 정보 제거");
				System.out.println("5. 이름으로 검색(완전일치)");
				System.out.println("6. 이름으로 검색(포함)");
				System.out.println("7. 나이 순으로 정렬"); // Comparable 사용
				System.out.println("8. 이름 순으로 정렬"); // Comparator 사용
				System.out.println("0. 프로그램 종료");

				System.out.print("메뉴 번호 선택 : ");
				menuNum = sc.nextInt();
				sc.nextLine(); // 입력버퍼 개행문자 제거용

				switch (menuNum) {
				case 1: /* addStudent(); */
					System.out.println(addStudent());
					break;
				case 2: /* selectAll(); */
					selectAll();
					break;
				case 3: /* updateStudent(); */
					System.out.println(updateStudent());
					break;
				case 4: /* removeStudent(); */
					System.out.println(removeStudent());
					break;
				case 5: /* searchName1(); */
					searchName1();
					break;
				case 6: /* searchName2(); */
					searchName2();
					break;
				case 7: /* sortByAge(); */
					sortByAge();
					break;
				case 8: /* sortByName(); */
					sortByName(); 
					break;
				case 0:
					System.out.println("프로그램 종료...");
					break;
				default:
					System.out.println("메뉴에 작성된 번호만 입력하세요!");
				}

			} catch (InputMismatchException e) {
				System.out.println("\nerror: 입력형식이 유효하지 않습니다." + "다시 시도해주세요.");
				sc.nextLine(); // 입력버퍼 남아있는 잘못된 코드 + 개행문자 제거
				menuNum = -1; // 첫 반복 시 잘못 입력하는 경우
				// menuNum이 초기값인 0을 가지고 있어 반복문이 종료
				// 이를 방지하기 위해서 임의의 값 -1 대입
			}
		} while (menuNum != 0);

	}

	/**
	 * 1. 학생 정보 추가 메서드
	 * 
	 * @return 삽입 성공 시 "성공" 실패 시 "실패" 문자열 반환
	 */
	public String addStudent() {
		// checkedException : 반드시 throws 구문이나 try-catch 처리 강제
		// IOException, SQLException..

		// InputMismatchException -> 예외 전파
		// UncheckedException : 강제 처리 x, 예외 발생하면
		// 자동으로 상위 호출 메서드로 예외가 전파된다.
		// InputMismatchException, NullPointerException, ...
		// throws를 던지지 않아도 알아서 전파가 되어서 예외가 처리된다.

		System.out.println("============학생 정보 추가============");
		System.out.print("이름 : ");
		String name = sc.next();

		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 개행문자 제거

		System.out.print("사는 곳 : ");
		String region = sc.nextLine();

		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);

		System.out.print("점수 : ");
		int score = sc.nextInt();

//		Student std = new Student(name, age, region, gender, score);
//		boolean result = studentList.add(std); // -> 여기서 add를 하게되면 boolean값을 return하게 됌
//		if(result) {
//			
//		} else {
//			
//		}

		if (studentList.add(new Student(name, age, region, gender, score))) {
			return "성공";
		} else {
			return "실패";
		}
	}

	/**
	 * 2. 학생 전체 조회 메서드 - List가 비어있는 경우 "학생 정보가 없습니다" 출력 - 있는 경우 전체 학생 출력
	 * 
	 */
	public void selectAll() {
		System.out.println("===========학생 전체 조회===========");

		// studentList가 비어있는지 확인하는 방법 2가지
		// List에 저장된 데이터의 개수를 얻어오는 방법 : int형을 반환하는 List.size()

		// 1. boolean List.isEmpty() : 컬렉션이 비어있다면 true 반환
		// 2. if(studentList.size() == 0)

		if (studentList.isEmpty()) {
			System.out.println("학생 정보가 없습니다.");
			return; // 현재 메서드를 종료하고 호출한 곳으로 돌아감.
		}

		// 일반 for문
		// for (int i = 0; i < studentList.size(); i++) { // length (X)
		// System.out.println(studentList.get(i));
		// }

		// 향상된 for문
		int index = 0;
		for (Student student : studentList) {
			System.out.println(index++ + "번 : " + student.toString());
		}
	}

	/**
	 * 3. 학생 정보 수정 메서드
	 * 
	 * - 학생 정보가 studentList에 하나라도 있는지 검사, 없다면 "입력된 학생정보가 없습니다" 문자열 반환
	 * 
	 * - 인덱스 번호로 선택하여 학생을 수정 입력된 숫자가 0보다 작은지 검사, 작다면 "음수는 입력할 수 없습니다" 반환
	 * 
	 * - studentList 범위 내 인덱스 번호인지 검사, 이상이라면 "범위를 넘어선 값을 입력할 수 없습니다" 반환
	 * 
	 * - 수정할 때 1. index 번째에 저장된 학생정보 수정 전에 한번 출력
	 * 
	 * 2. 이름, 나이, 사는 곳, 성별, 점수 수정할 값 입력받기
	 * 
	 * 3. 수정이 완료되었다면, "ooo의 정보가 변경되었습니다." 반환
	 * 
	 * 
	 * @return
	 * 
	 */
	public String updateStudent() {
		System.out.println("=============학생 정보 수정=============");

		if (studentList.isEmpty()) {
			return "입력된 학생정보가 없습니다.";
		}
		System.out.println("인덱스 번호 : ");
		int index = sc.nextInt();

		// 1) 입력된 숫자가 0보다 작은지
		if (index < 0) {
			return "음수는 입력할 수 없습니다.";

		}

		// 2) studentLsit 범위 내 인덱스번호인지 검사
		if (index > studentList.size()) {
			return "범위를 넘어선 값을 입력할 수 없습니다.";
		}

		// 수정 코드 작성
		// 1. index 번째에 저장된 학생정보 출력
		System.out.println(index + "번째에 저장된 학생 정보");
		System.out.println(studentList.get(index));

		// 2. 수정할 내용 입력받기
		System.out.print("이름 : ");
		String name = sc.next();

		System.out.println("나이 : ");
		int age = sc.nextInt();
		sc.nextLine(); // 입력버퍼 개행문자 제거

		System.out.println("사는 곳 : ");
		String region = sc.nextLine();

		System.out.println("성별(M/F) : ");
		char gender = sc.next().charAt(0);

		System.out.println("점수 : ");
		int score = sc.nextInt();

		// 입력받은 index 번째에 수정할 학생정보를 세팅 -> 수정

		// set은 기존 객체를 반환해줌
		// E List.set(int index, E e)
		// : 주어진 index번째에 주어진 객체로 덮어쓰기(수정함)
		// 기존의 객체를 반환함
		Student temp = studentList.set(index, new Student(name, age, region, gender, score));

		System.out.println(temp.getName() + "의 정보가 변경되었습니다.");

		return studentList.get(index).toString();
	}

	/**
	 * 4. 학생 정보 제거 메소드
	 * 
	 * 수정과 같은 검사 후 삭제 시 "정말 삭제하시겠습니까? (Y/N) : " Y를 입력했다면 해당 인덱스에 있는 객체 삭제 후 "000님의
	 * 정보가 제거되었습니다" 문자열 반환(리턴) N을 입력했다면 "취소" 리턴
	 * 
	 * 
	 * @return
	 */
	public String removeStudent() {
		System.out.println("=========학생 정보 제거=========");

		if (studentList.isEmpty()) {
			return "입력된 학생정보가 없습니다.";
		}
		System.out.println("인덱스 번호 : ");
		int index = sc.nextInt();

		// 1) 입력된 숫자가 0보다 작은지
		if (index < 0) {
			return "음수는 입력할 수 없습니다.";

		}

		// 2) studentLsit 범위 내 인덱스번호인지 검사
		if (index > studentList.size()) {
			return "범위를 넘어선 값을 입력할 수 없습니다.";
		}

		// 삭제
		System.out.println("정말 삭제 하시겠습니까? (Y/N) : ");
		char ch = sc.next().toUpperCase().charAt(0);
		// "y" -> "Y" -> 'Y'

		// E List.remove(int index)
		// : 리스트에서 index번째 요소를 제거
		// 이 때 제거된 요소가 반환됨.
		// * List 중간에 비어있는 인덱스가 없게 하기 위해서
		// remove() 동작 시 뒤쪽 요소를 한칸씩
		// 자동으로 당겨오는 행위하고 있음

		if (ch == 'Y') {
			Student temp = studentList.remove(index);
			return temp.getName() + "의 정보가 제거되었습니다.";
		}
		return "취소";
	}

	/**
	 * 5. 이름이 일치하는 학생을 찾아 조회하는 메서드(완전 일치)
	 * 
	 * - 검색할 이름을 입력받아 studentList에서 꺼내온 Student 객체의 name값이 같은지 비교
	 * 
	 * - 일치하는 경우 Student 객체 출력 - 일치하는게 없다면 "검색 결과가 없습니다" 출력
	 * 
	 * 
	 */
	public void searchName1() {
		//
		System.out.println("==========학생 검색(이름 완전 일치)==========");

		System.out.print("검색할 이름 입력 : ");
		String input = sc.next();

		boolean flag = true;

		// 향상된 for문
		for (Student std : studentList) {
			if (input.equals(std.getName())) {
				System.out.println(std);
				flag = false;
			}
		}
		if (flag) {
			System.out.println("검색 결과가 없습니다.");
		}
	}

	/**
	 * 6. 이름에 특정 문자열이 포함되는 학생을 찾아서 조회하는 메서드
	 * 
	 * 
	 */
	public void searchName2() {
		System.out.println("==========학생 검색(이름 부분 포함)==========");

		System.out.print("이름에 포함되는 문자열 입력 : ");
		String input = sc.next();

		boolean flag = true;

		// 향상된 for문
		
		for (Student std : studentList) {
			// 순서 유의!!!!
				//		대상			검색할 대상
			// boolean String.contains(문자열)
			// String에 문자열이 포함되어 있으면 true, 아니면 false
			if (std.getName().contains(input)) {
				// std.getNAme()에 input이 포함되어 있느냐?
				
				System.out.println(std);
				flag = false;
			}
		}
		if (flag) {
			System.out.println("검색 결과가 없습니다.");
		}
	}
	/* List를 정렬하는 방법
	*
	* 방법 1: Comparable 인터페이스 상속받아 compareTo() 메서드 재정의
	* Student에 Comparable 인터페이스를 상속받아
	* 오버라이딩한 compareTo()에 정의한 대로 정렬됨 (나이 오름차순, 내림차순..)
	*
	* 방법 2: Comparator 클래스에 의한 정렬 compare() 사용 (익명 내부 클래스 이용)
	*
	* 익명 내부 클래스란?
	* 이름이 없는 클래스를 즉석에서 선언해서 한 번만 사용할 목적으로
	* 작성 객체를 생성하면서 바로 구현 내용을 정의할 수 있음
	*
	* <익명 내부클래스 장점>
	* 코드 간결화(별도로 클래스를 만들지 않아도 될 때 사용)
	* 즉시 사용(한 번만 사용할 Comparator 등을 정의할 때 유용함)
	* 지역화(특정 메서드 안에서만 필요할 때)
	*/
	
	/**
	 * 7. 나이에 따라 오름차순 정렬(Comparable 인터페이스 사용)
	 * 
	 */
	public void sortByAge() {
		Collections.sort(studentList);
		for(Student std : studentList) {
			System.out.println(std);
		}
	}
	
	/**
	 * 8. 이름으로 정렬 (가나다순)
	 * 
	 * 
	 */
	public void sortByName() {
		Collections.sort(studentList, new Comparator<Student>() {
			// 익명 클래스
			// Comparator는 인터페이스, 근데 객체 생성을 하고 있음
			// 
			@Override
			public int compare(Student o1, Student o2) {
				// 이름 비교
				// name은 String 형이라 compareTo()로 비교
				// String.compareTo(); : 자바에서 객체를 비교하는 메소드.
				// String이 Comparable을 상속받아 재정의해둔 
				// compareTo() 메서드를 이용하는 것
				// -> 두 객체를 비교하고 문자열의 순서 결정함.
				return o1.getName().compareTo(o2.getName());
			}
			
		});
		for(Student std : studentList) {
			System.out.println(std);
		}
	}
	
	
}






















