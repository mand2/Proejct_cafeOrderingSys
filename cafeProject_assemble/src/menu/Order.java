package menu;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

import bitloco.Menu;

public class Order {
	
	ArrayList<Menu> orderMenu;
	int sum = 0;

	public Order() {
		orderMenu = new ArrayList();
	}

	void getTotal(MenuSelect m) { // 총합계 계산하는 메서드
		
		for (int i = 0; i < orderMenu.size(); i++) {
			if (orderMenu.get(i).getCnt() < 1) {
				continue;
			} else {
				sum += orderMenu.get(i).getPrice() * orderMenu.get(i).getCnt();
			} // else문 종료
		} // for문 종료
	} // 메서드 종료

	void billPirnt() { // 영수증 프린트~(결제한 내용만!)
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

	
	void billFormat(MenuSelect m) {
		System.out.println("■■■■■■■■■■■■ B I T L O C O ■■■■■■■■■■■■■ ");
		System.out.println("대표자: 최아리");
		System.out.print("주문시각: ");
		System.out.println(getOrderTime());
		System.out.println("---------------------------------------");
		
		System.out.println("================= 메뉴 ================= ");
		System.out.println("   상  품  명         |    가   격 ");
		System.out.println("---------------------------------------");
		for(Menu e : m.order) {
			orderMenu.add(e);
			e.showProduct();
			System.out.println("---------------------------------------");
		}
		
		
	}
	
	//주문시간 프린트.
	public String getOrderTime() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String result = format.format(new Date());
		
		return result;
	}
}