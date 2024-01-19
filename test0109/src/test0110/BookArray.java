package test0110;

import java.util.Scanner;

class Book {
	String title, author;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
}

public class BookArray {
	
	public static void main(String[] args) {
		Book[] book = new Book[2]; // Book 배열선언
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < book.length; i++) {
			System.out.print("제목>>");
			String title = scanner.nextLine();
			System.out.print("저자>>");
			String author = scanner.nextLine();
			book[i] = new Book(title, author); // 배열원소객체생성
			System.out.println(book);
		}
		for (int i = 0; i < book.length; i++)
			System.out.print("(" + book[i].title + ", " + book[i].author + ")");
		
		scanner.close();
	}
}
