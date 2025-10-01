package com.hw3.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.hw3.model.dto.Book;

public class BookService extends Book {
	private Scanner sc = new Scanner(System.in);
	private List<Book> bookList = new ArrayList<Book>(); // 도서 관련 객체 배열
	private List<Book> favoriteList = new ArrayList<Book>(); // 즐겨찾기 도서 관련 객체 배열

	public BookService() {
		bookList.add(new Book(1111, "세이노의 가르침", "세이노", 6480, "데이원"));
		bookList.add(new Book(2222, "문과남자의 과학공부", "유시민", 15750, "돌베개"));
		bookList.add(new Book(3333, "역행자", "자청", 17550, "웅진지식하우스"));
		bookList.add(new Book(4444, "꿀벌의 예언", "베르나르 베르베르", 15120, "열린책들"));
		bookList.add(new Book(5555, "도둑맞은 집중력", "요한 하리", 16920, "어크로스"));
	}

	public BookService(int bookNumber, String title, String author, int price, String publisher) {
		super(bookNumber, title, author, price, publisher);
	}

	public void displayMenu() {
		int selectMenu = 0;

		do {
			System.out.println("===도서 목록 프로그램===");
			System.out.println("1. 도서 등록");
			System.out.println("2. 도서 조회");
			System.out.println("3. 도서 수정");
			System.out.println("4. 도서 삭제");
			System.out.println("5. 즐겨찾기 추가");
			System.out.println("6. 즐겨찾기 삭제");
			System.out.println("7. 즐겨찾기 조회");
			System.out.println("8. 추천도서 뽑기");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴를 입력하세요 : ");
			selectMenu = sc.nextInt();

			switch (selectMenu) {
			case 1: /* addBook(); */
				addBook();
				break;
			case 2: /* searchBook() */
				searchBook();
				break;
			case 3:/* editBook() */
				editBook();
				break;
			case 4:/* removeBook() */
				removeBook();
				break;
			case 5:/* addFavoriteBook() */
				addFavoriteBook();
				break;
			case 6:/* removeFavoriteBook() */
				removeFavoriteBook();
				break;
			case 7:/* searchFavoriteBook() */
				searchFavoriteBook();
				break;
			case 8:/* recommendBook() */
				recommendBook();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다...");
				break;
			default:
				System.out.println("올바른 번호를 입력해주세요.");
			}
		} while (selectMenu != 0);
	}

	/**
	 * 2. 도서 등록
	 */
	public void addBook() {
		System.out.println("======도서 등록======");

		System.out.print("도서 번호 : ");
		int number = sc.nextInt();
		sc.nextLine();

		System.out.print("도서 제목 : ");
		String title = sc.nextLine();

		System.out.print("도서 저자 : ");
		String author = sc.nextLine();

		System.out.print("도서 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();

		System.out.print("도서 출판사 : ");
		String publisher = sc.next();

		bookList.add(new Book(number, title, author, price, publisher));
		System.out.println("등록 완료");
	}

	/**
	 * 2. 도서 조회
	 */
	public void searchBook() {
		System.out.println("======도서 조회======");

		Collections.sort(bookList);

		for (Book book : bookList) {
			System.out.println(book);
		}
	}

	/**
	 * 3. 도서 수정
	 * 
	 */
	public void editBook() {
		int selectNum = 0;

		boolean flag = false;

		System.out.println("========도서 수정========");
		System.out.print("수정할 도서 번호를 입력하세요:");
		int bookNum = sc.nextInt();
		int bookIndex = 0;

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBookNumber() == bookNum) {
				flag = true;
				bookIndex = i;
				break;
			}
		}
		if (!flag) {
			System.out.println("수정할 도서가 존재하지 않습니다.");
			return;
		}

		System.out.println("1. 도서명");
		System.out.println("2. 도서 저자");
		System.out.println("3. 도서 가격");
		System.out.println("4. 도서 출판사");
		System.out.println("0. 수정 완료");

		System.out.print("어떤 정보를 수정하시겠습니까?");
		selectNum = sc.nextInt();
		sc.nextLine();

		switch (selectNum) {
		case 1:
			System.out.println("=====도서명 수정=====");
			System.out.print("수정할 도서명을 입력하세요: ");
			String name = sc.nextLine();
			bookList.get(bookIndex).setTitle(name);
			System.out.println("수정 완료");
			break;
		case 2:
			System.out.println("=====도서 저자 수정=====");
			System.out.print("수정할 도서 저자를 입력하세요: ");
			String author = sc.nextLine();
			bookList.get(bookIndex).setAuthor(author);
			System.out.println("수정 완료");

			break;
		case 3:
			System.out.println("=====도서 가격 수정=====");
			System.out.print("수정할 도서 가격을 입력하세요: ");
			int price = sc.nextInt();
			bookList.get(bookIndex).setPrice(price);
			;
			System.out.println("수정 완료");
			break;
		case 4:
			System.out.println("=====도서 출판사 수정=====");
			System.out.print("수정할 도서 출판사를 입력하세요: ");
			String publisher = sc.nextLine();
			bookList.get(bookIndex).setPublisher(publisher);
			;
			System.out.println("수정 완료");
			break;
		case 0:
			System.out.println("수정 종료");
			break;
		}
	}

	/**
	 * 4. 도서 삭제
	 */
	public void removeBook() {
		System.out.println("=====도서 삭제=====");
		System.out.print("삭제할 도서 번호 입력 : ");
		int bookNumber = sc.nextInt();

		int index = 0;
		boolean flag = false;

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBookNumber() == bookNumber) {
				index = i;
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("도서가 존재하지 않습니다.");
			return;
		}

		System.out.print("정말 삭제하시겠습니까? (Y/N): ");
		String yesOrNo = sc.next();

		if (yesOrNo.equalsIgnoreCase("Y")) {
			bookList.remove(index);
			System.out.println("도서를 삭제했습니다.");
		} else if (yesOrNo.equalsIgnoreCase("N")) {
			System.out.println("도서를 삭제하지 않습니다.");
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	/**
	 * 5. 즐겨찾기 추가
	 */
	public void addFavoriteBook() {
		System.out.println("======즐겨찾기 추가======");

		System.out.print("도서 번호 : ");
		int number = sc.nextInt();
		sc.nextLine();

		boolean flag = false;
		int index = 0;

		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBookNumber() == number) {
				index = i;
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("도서 번호가 존재하지 않습니다.");
			return;
		}
		// 중복 체크
		for (int i = 0; i < favoriteList.size(); i++) {
			if (favoriteList.get(i).getBookNumber() == bookList.get(index).getBookNumber()) {
				System.out.println("이미 즐겨찾기 목록에 존재합니다.");
				return;
			}
		}

		favoriteList.add(bookList.get(index));
		System.out.println("즐겨찾기에 도서가 추가되었습니다.");

	}

	/**
	 * 6. 즐겨찾기 삭제
	 */
	public void removeFavoriteBook() {
		System.out.println("=====도서 삭제=====");
		System.out.print("삭제할 도서 번호 입력 : ");
		int bookNumber = sc.nextInt();

		int index = 0;
		boolean flag = false;

		for (int i = 0; i < favoriteList.size(); i++) {
			if (favoriteList.get(i).getBookNumber() == bookNumber) {
				index = i;
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("도서가 존재하지 않습니다.");
			return;
		}

		System.out.print("정말 삭제하시겠습니까? (Y/N): ");
		String yesOrNo = sc.next();

		if (yesOrNo.equalsIgnoreCase("Y")) {
			favoriteList.remove(index);
			System.out.println("도서를 삭제했습니다.");
		}
	}

	/**
	 * 7. 즐겨찾기 조회
	 */
	public void searchFavoriteBook() {
		System.out.println("======즐겨찾기 조회======");
		Collections.sort(favoriteList);
		for (Book favoriteBook : favoriteList) {
			System.out.println(favoriteBook);
		}
	}

	/**
	 * 8. 도서 추천
	 */
	public void recommendBook() {
		System.out.println("======즐겨찾기 도서 목록 추천======");
		int recommendBookNumber = (int) (Math.random() * favoriteList.size());
		if (favoriteList.size() == 0) {
			System.out.println("즐겨찾기에 등록된 도서가 존재하지 않습니다.");
			return;
		}
		System.out.println(favoriteList.get(recommendBookNumber));
	}
}
