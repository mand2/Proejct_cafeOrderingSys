package bitloco;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import util.*;
import bitloco.Menu;

public class Event extends MenuSelect {
	MenuSelect m = new MenuSelect();
	String id;

	public void randomCoffee() throws IOException {
		System.out.println("오늘의 음료를 추천하고 있는 중입니다.");

		int choice = (int) (Math.random() * 4 + 1);
		custum(choice);
		showCurOrder();
		checkOrder(choice);
		showBill(id);
	}

	public void randomFood() throws IOException {
		System.out.println("오늘의 FOOD를 추천하고 있는 중입니다.");

		int choice = (int) (Math.random() * 6 + 5);
		custum(choice);
		showCurOrder();
		checkOrder(choice);
		showBill(id);
	}

	@Override
	void custum(int choice) {
		// TODO Auto-generated method stub
		super.custum(choice);
	}

	@Override
	void customBev(ArrayList<Beverage> b) {
		// TODO Auto-generated method stub

		// @index: 지금 커스텀하고있는 메뉴의 인덱스값
		int index = orderBev.size() - 1;

		System.out.println("오늘의 추천 음료 - " + orderBev.get(index).getName());

		// coffee 류면 hot/iced 선택
		if (b.get(b.size() - 1) instanceof Americano || b.get(b.size() - 1) instanceof Cappuchino) {
			System.out.printf("%d.차갑게 %d.따뜻하게\n", Menu_Inter.BEV_COLD, Menu_Inter.BEV_HOT);

			int answer = Util.keyboard.nextInt();

			while (answer < Menu_Inter.BEV_COLD || answer > Menu_Inter.BEV_HOT) {
				System.out.println("!!다시 입력!!");
				answer = Util.keyboard.nextInt();
			}

			if (answer == Menu_Inter.BEV_HOT) {
				orderBev.get(index).noCold();
			}
		} // hot<>iced change

		System.out.println("사이즈업하시겠습니까? 1.예 2.아니오");
		int sizeUp = Util.keyboard.nextInt();

		if (sizeUp == 1) {
			orderBev.get(index).sizeUP();
		}

		while (sizeUp > 2) {
			System.out.println("다시 입력해주세요.");
			sizeUp = Util.keyboard.nextInt();
		}
		order.add(orderBev.get(index));
	}

	@Override
	void customFood(ArrayList<Food> f) {
		// TODO Auto-generated method stub
		int index = orderFood.size() - 1;

		System.out.println("오늘의 추천 FOOD - " + orderFood.get(index).getName());

		// 샌드위치/쿠키만
		if (f.get(f.size() - 1) instanceof Cookies || f.get(f.size() - 1) instanceof Sandwiches) {
			System.out.printf("%d.기본 %d.따뜻하게\n", Menu_Inter.FOOD_COLD, Menu_Inter.FOOD_HOT);

			int answer = Util.keyboard.nextInt();

			while (answer < Menu_Inter.FOOD_COLD || answer > Menu_Inter.FOOD_HOT) {
				System.out.println("!!다시 입력!!");
				answer = Util.keyboard.nextInt();

			}

			if (answer == Menu_Inter.FOOD_HOT) {
				orderFood.get(index).noCold();
			}
		}
		order.add(orderFood.get(index));
	}

	public void checkOrder(int select) throws IOException {
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
			order.remove(order.size() - 1);
			System.out.println("메뉴창으로 다시 돌아갑니다.");
			return;
			
		} else if (choice == 1) {

			int curCnt = menu.get(select - 1).getCnt();
			menu.get(select - 1).setCnt(--curCnt);
			m.billFormat(id);
			m.getOrderTime();
		}
		
	}

	void showEvent() throws IOException {
		System.out.println("이벤트 창입니다.");

		while (true) {
			System.out.printf("어떤 이벤트를 원하십니까? \n%d.랜덤커피\t %d.랜덤FOOD\t %d.지난 내역보기\t %d. 나가기\n", 1, 2, 3, 4);

			int choice = Util.keyboard.nextInt();
			switch (choice) {
			case 1:
				randomCoffee();
				break;

			case 2:
				randomFood();
				break;
			case 3:
				// last.lastOrder();
				break;

			case 4:
				return;
			}

		}
	}
}