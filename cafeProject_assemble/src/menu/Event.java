package menu;

import java.util.ArrayList;
import menu.Order;
import bitloco.Menu;
import util.Menu_Inter;
import util.Util;

public class Event extends MenuSelect {

	public void randomCoffee() {
		System.out.println("오늘의 음료를 추천하고 있는 중입니다.");
		
		int choice = (int) (Math.random() * 4 + 1);
		custum(choice);
		showCurOrder();
		checkOrder(choice);
		
	}
	public void randomFood() {
		System.out.println("오늘의 FOOD를 추천하고 있는 중입니다.");

		int choice = (int) (Math.random() * 4 + 5);
		custum(choice);
		showCurOrder();
		checkOrder(choice);
		
	}
	public void checkOrder(int select) {
		// TODO Auto-generated method stub
		System.out.println("■■■■■■■■■■■■■■ 주문 확인 ■■■■■■■■■■■■■■ ");
		System.out.print("주문상품: ");

		order.get(order.size() - 1).showProduct();

		System.out.println("선택하신 상품이 맞으신가요?");
		System.out.println("1. 예  2. 아니오");

		// 상품재확인 1.맞다. 2.아니다(== order에서 빼라.)
		int choice = Util.keyboard.nextInt();

		while (choice > 2 || choice < 1) {
			System.out.println("!!다시 입력!!");
			choice = Util.keyboard.nextInt();
		}

		if (choice == 2) {
			order.remove(order.size());
			System.out.println("메뉴창으로 다시 돌아갑니다.");

		} else if (choice == 1) {

			int curCnt = menu.get(select - 1).getCnt();
			menu.get(select - 1).setCnt(--curCnt);
		}
	}
}
