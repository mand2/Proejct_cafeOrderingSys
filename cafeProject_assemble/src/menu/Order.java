package menu;

import java.util.ArrayList;

import bitloco.Menu;

public class Order {

	ArrayList<Menu> orderMenu;
	int sum = 0;

	public Order() {
		orderMenu = new ArrayList();
	}

	void orderLine() {

		for (int i = 0; i < orderMenu.size(); i++) {
			if (orderMenu.get(i).getCnt() < 1) {
				continue;
			} else {
				sum += orderMenu.get(i).getPrice() * orderMenu.get(i).getCnt();
			} // else문 종료
		} // for문 종료
	} // 메서드 종료

	void orderPirnt() {
		System.out.println("============ B I T L O C O ============");
		System.out.println("---------------------------------------");
		System.out.println("    품명           |    단가      | 수량  |   총 금액       ");
		cafe: for (int i = 0; i < orderMenu.size(); i++) {
			if (orderMenu.get(i).getCnt() < 1) {
				continue cafe;
			} else {

				System.out.println(orderMenu.get(i).getName() + orderMenu.get(i).getPrice() + orderMenu.get(i).getCnt()
						+ (orderMenu.get(i).getPrice() * orderMenu.get(i).getCnt()));
			}
			System.out.println(" T O T A L : " + sum + "원입니다.");
			System.out.println("---------------------------------------");
			System.out.println("=======================================");
		}
	}

}
