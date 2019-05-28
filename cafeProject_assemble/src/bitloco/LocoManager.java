package bitloco;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import menu.MenuSelect;
import menu.Event;
import menu.Order;
import util.Menu_Inter;
import util.Util;

public class LocoManager {

	/*
	 * 변수설명
	 * 
	 * @bit : 해쉬맵, 회원들 정보 저장
	 */

	final MemberInfo[] mem;
	private Map<String, String> bit = new HashMap<String, String>();
	private int select;
	private boolean findN = false;
	private MemberInfo m;
	int cnt;
	MenuSelect plate;
	Event event= new Event();

	private LocoManager() {
		mem = new MemberInfo[10000];
		cnt = 0;
		plate = new MenuSelect();
	}

	private static LocoManager loco = new LocoManager();

	static LocoManager getInstance() {
		if (loco == null) {
			loco = new LocoManager();
		}
		return loco;
	}

	public void joinMember() {

//		m = null;
		Util.keyboard.nextLine();
		System.out.println("PLEASE COMPLETE A FORM!");
		System.out.print("ID:");
		String id = Util.keyboard.nextLine();

		int index = searchIndex(id);

		cafe: if (index < 0) {
			System.out.print("PASSWORD:");
			String pw = Util.keyboard.nextLine();
			System.out.print("Name:");
			String name = Util.keyboard.nextLine();
			System.out.print("Phone Number:");
			String pNum = Util.keyboard.nextLine();

			m = new MemberInfo(id, pw, name, pNum);
			mem[cnt++] = m;
			System.out.println("THANKS FOR JOINING US.");
			bit.put(id, pw);

		} else {
			System.out.println("사용중인 ID입니다.다시 입력바랍니다.");

			System.out.print("ID:");
			id = Util.keyboard.nextLine();

			System.out.print("PASSWORD:");
			String pw = Util.keyboard.nextLine();

			System.out.print("Name:");
			String name = Util.keyboard.nextLine();

			System.out.print("Phone Number:");
			String pNum = Util.keyboard.nextLine();

			m = new MemberInfo(id, pw, name, pNum);
			mem[cnt++] = m;
			System.out.println("THANKS FOR JOINING US.");
			bit.put(id, pw);

		}
	}

	public void editInfo() {
		System.out.println("insert ID ");
		String id = Util.keyboard.nextLine();
		int index = searchIndex(id);
		if (index < 0) {
			System.out.println("wrong ID!");
		} else {
			System.out.println("edit" + mem[index].getId() + "'s Information");
			System.out.println("password");
			String pw = Util.keyboard.nextLine();
			System.out.println("name");
			String name = Util.keyboard.nextLine();
			System.out.println("phone number");
			String pNum = Util.keyboard.nextLine();

			mem[index] = new MemberInfo(id, pw, name, pNum);
			bit.put(id, pw);
		}

	}

	public void deleteInfo() {
		System.out.println("insert ID ");
		String id = Util.keyboard.nextLine();
		int index = searchIndex(id);
		if (index < 0) {
			System.out.println("wrong ID!");
		} else {
			for (int i = index; i < cnt; i++) {
				mem[i] = mem[i + 1];
			}
			bit.remove(id);
			cnt--;
			System.out.println("Your ID has been successfully deleted!");
		}
	}

	private int searchIndex(String id) {
		int index = -1;
		for (int i = 0; i < cnt; i++) {
			if (mem[i].getId().equals(id))
				index = i;
			break;
		}
		return index;
	}

	public void showAllData() {
//		 int index = searchIndex(id);
		String id = null;
		if (cnt > 0) {
			for (int i = 0; i < cnt; i++) {
				mem[i].showData();
				System.out.println("------------------------");
				break;
			}
		} else {
			System.out.println("등록된 회원정보가 없습니다.");
			System.out.println("------------------------");
		}

	}

	// Members 안에 선택창
	public int first() {
		System.out.println("=======================");
		System.out.println("please select number :)");
		System.out.println("1. I N F O\n2. E D I T\n3. D E L E T E\n4. H O M E");
		System.out.println("=======================");
		System.out.print("Select Number:");
		select = Util.keyboard.nextInt();
		Util.keyboard.nextLine();
		return select;
	}

	public void login() {
		System.out.println("---------------------------");
		System.out.println("1.Home\n2.Login");
		System.out.print("Select Number:");
		select = Util.keyboard.nextInt();
		Util.keyboard.nextLine();
		if (select == 1) {
			System.out.println("초기화면으로 돌아갑니다.");
			return;
		} else {

			choice: while (true) {

				System.out.println("=====  L  O  G  I  N  =====");
				System.out.print("ID: ");
				String id = Util.keyboard.nextLine();

				System.out.print("Password: ");
				String pw = Util.keyboard.nextLine();

				if (bit.containsKey(id)) {
					if (bit.get(id).equals(pw)) {
						System.out.println(id + "님,로그인 되었습니다.");
						System.out.println("---------------------------");

						while (true) {
							System.out.println("---------------------------");
							System.out.println("1.M Y I N F O\n2.O R D E R\n3.A C C O U T\n4.E V E N T \n5.H O M E");
							System.out.println("---------------------------");
							System.out.print("Select Number:");
							select = Util.keyboard.nextInt();
							Util.keyboard.nextLine();
							cafe: switch (select) {
							case 1:
								first();
								if (select < 1 || select > 4) {
									System.out.println("잘못 선택하셨습니다.다시 선택해주세요.");
								} else if (select == 1) {
									showAllData();
								} else if (select == 2) {
									editInfo();
								} else if (select == 3) {
									deleteInfo();
								} else if (select == 4) {
									System.out.println("초기화면으로 돌아갑니다.");
								}
								break;

							case 2:
								plate.showMenu();
								break;

							case 3:
								System.out.println("계산을 하는 공간입니다 / 영수증을 볼 수 있습니다.");
								break;
							case 4:
								eventMenu();
								break;
							case 5:
								System.out.println("초기화면으로 돌아갑니다.");
								return;
							}
						} // while 문

//					return;
					} else {
						System.out.println("비밀번호가 일치하지 않습니다.");
						return;
					} // else문 종료 (비밀번호가 일치하지 않는 회원)
				} else {
					System.out.println("존재하지 않는 회원입니다.다시 확인해주세요.");
					System.out.println("회원가입하시겠습니까?");
					System.out.println("1.회원가입\n2.초기화면");
					System.out.print("Select Number:");
					select = Util.keyboard.nextInt();
					switch (select) {
					case 1:
						joinMember();
					case 2:
						System.out.println("초기화면으로 돌아갑니다.");
						return;
					}

				} // else문 종료 (존재하지 않는 회원)
			} // while문 종료
		} // else문 종료 (맨위)

	}

	public void foodMenu() {

		System.out.println("=======================================");
		System.out.printf("%d. 치즈케익\n%d. 초코케익\n%d. 쿠키\n%d. 샌드위치\n", Menu_Inter.CHEEZE, Menu_Inter.CHOCO,
				Menu_Inter.COOCKIES, Menu_Inter.SANDWITCHES);
		System.out.println("=======================================");

	}

	public void eventMenu() {
		showEvent();
	}

	void howareyou() {
		int good = 10;
		int soso = 5;
		int bad = 1;
		// 그냥 친구 기분에 따라 어떤거 마실건지 물어서 임의로 정했습니다.!
		// 하고 싶은건 로그인하고 오늘의 기분 이벤트로 들어온 후 메뉴를 고를 수 있고 시킨 음료를 그 기분에 맞게 저장해서 넣고 싶어요 그래서
		// 다음 번엔 기분에 따라 시킨 음료가 카운트 된 만큼 많은 카운트 수를 받은 음료를 추천할 수 있게?
		System.out.printf("오늘의 기분을 숫자로 입력해주세요\n좋아요.(%d)\t보통이에요(%d)\t별로에요(%d)\n", good, soso, bad);
		int feel = Util.keyboard.nextInt();

		if (feel == good) {
			System.out.println("카푸치노 어떠세요?");

		} else if (feel == soso) {
			System.out.println("레몬에이드 한 잔 어떠세요?");

		} else {
			System.out.println("아메리카노 어떠세요?");

		}

	}

	void showEvent() {
		System.out.println("이벤트 창입니다.");

		while (true) {
			System.out.printf("어떤 이벤트를 원하십니까? \n%d.랜덤커피\t %d.랜덤FOOD\t %d.오늘의 기분\t %d. 나가기\n", 1, 2, 3, 4);
			// menu.MenuSelect menuselect = new MenuSelect();

			int choice = Util.keyboard.nextInt();
			switch (choice) {
			case 1:
				event.randomCoffee();
				break;

			case 2:
				event.randomFood();
				break;
			case 3:
				howareyou();
				break;

			case 4:
				return;
			}
		}
	}

	void cafeOrder() {
		Order o;

	}

}