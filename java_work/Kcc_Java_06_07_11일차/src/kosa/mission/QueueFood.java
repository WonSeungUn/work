package kosa.mission;

import java.util.LinkedList;
import java.util.Scanner;

public class QueueFood {
	private String foodName;
	private int price;
	private Scanner sc;
	private LinkedList<QueueFood> list;
	private int totalPrice;

	public QueueFood() {
		sc = new Scanner(System.in);
		list = new LinkedList<QueueFood>();
	}

	public QueueFood(String foodName, int price) {
		this.foodName = foodName;
		this.price = price;
	}

	// 주문요청
	public void addFood() {
		System.out.println("주문요리 > 1.파스타(15000원) 2. 감바스(16000원) 3. 피자(20000원)");
		System.out.print("메뉴선택 : ");
		String menu = sc.nextLine();
		switch (menu) {
		case "1":
			QueueFood food1 = new QueueFood("파스타", 15000);
			list.offer(food1);
			break;
		case "2":
			QueueFood food2 = new QueueFood("감바스", 16000);
			list.offer(food2);
			break;
		case "3":
			QueueFood food3 = new QueueFood("피자", 20000);
			list.offer(food3);
			break;

		}
		System.out.println("주문 요청이 완료되었습니다.");
	}

	// QueueFood 안의 내용 보여주기
	public void show() {
		System.out.println(this.foodName + "\t" + this.price + " 원");
	}

	// 주문요청 목록 출력
	public void listFood() {
		for (QueueFood q : list) {
			System.out.println("----------------");
			q.show();
			System.out.println("----------------");

		}
	}

	// 주문처리
	public void finishOrder() {
		System.out.println("맨 처음에 주문받으신 음식을 주문처리완료하시겠습니까?");
		System.out.print("1. YES 2. No");
		String menu = sc.nextLine();
		switch (menu) {
		case "1":
			if (!list.isEmpty()) {
				total(list.poll());
			}else {
				total(null);
			}
			System.out.println(" 주문처리완료하였습니다.");
			break;
		case "2":
			System.out.println("처음으로 돌아가겠습니다.");
			break;
		}
	}

	// 매출액 총액
	public void total(QueueFood f) {
		try {
			this.totalPrice += f.price;
		} catch (Exception e) {
			System.out.println("아무것도 없어요오오오!!!");
		}
	}
	
	public void totalprint(QueueFood f) {
		total(f);
		System.out.println(this.totalPrice + " 원 입니다.");
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
