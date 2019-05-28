package bitloco;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import util.Menu_Inter;
import util.Util;

public class LocoManager {

	/*
	 * 변수설명
	 * 
	 * @bit : 해쉬맵, 회원들 정보 저장
	 */

	public Map<String, String> bit = new HashMap<String, String>();
	private int select;
	private boolean findN = false;
	public MemberManager manager;

	MenuSelect plate;

	private LocoManager() {

		plate = new MenuSelect();
	}

	private static LocoManager loco = new LocoManager();

	static LocoManager getInstance() {
		if (loco == null) {
			loco = new LocoManager();
		}
		return loco;
	}

	public Map<String, String> getBit() {
		return this.bit;
	}

	// 로그인 메서드
	public void login() {
		System.out.println("1. H O M E\n2. L O G I N");
		System.out.print("Select Number:");
		select = Util.keyboard.nextInt();
		Util.keyboard.nextLine();
		if (select == 1) {
			System.out.println("초기화면으로 돌아갑니다.");
			return;
		} else {

			choice: while (true) {

				System.out.println("■■■■■  L  O  G  I  N  ■■■■■");

				System.out.print("I  D:");

				String id = Util.keyboard.nextLine();

				System.out.print("P  W:");
				String pw = Util.keyboard.nextLine();
				System.out.println("***** 접속시간을 체크합니다 ******");

				if (bit.containsKey(id)) {
					if (bit.get(id).equals(pw)) {
						System.out.println(getTime() + "접속!");
						System.out.println("[ " + id + ", Signed in! ]");
						System.out.println("===========================");
						System.out.println();
						while (true) {
							System.out.println("---------------------------");
							System.out.println("1.M Y I N F O\n2.O R D E R\n3.A C C O U T\n4.E V E N T \n5.H O M E");
							System.out.println("---------------------------");
							System.out.print("Select Number:");
							select = Util.keyboard.nextInt();
							Util.keyboard.nextLine();
							cafe: switch (select) {
							case 1:
								manager.first();
								if (select < 1 || select > 4) {
									System.out.println("잘못 선택하셨습니다.다시 선택해주세요.");
								} else if (select == 1) {
									manager.showAllData();
								} else if (select == 2) {
									manager.editInfo();
								} else if (select == 3) {
									manager.deleteInfo();
								} else if (select == 4) {
									System.out.println("[Back to the Menu.]");
								}
								break;

							case 2:
								plate.showMenu(id);
								break;

							case 3:
								System.out.println("영수증을 볼 수 있습니다.");
								break;
							case 4:
//									TODO eventMenu();
								break;
							case 5:
								System.out.println("초기화면으로 돌아갑니다.");
								return;
							}
						} // while 문

//					return;
					} else {
						System.out.println("[Password do not match]");
						return;
					} // else문 종료 (비밀번호가 일치하지 않는 회원)
				} else {
					System.out.println("[존재하지 않는 회원입니다.다시 확인해주세요.]");
					System.out.println("회원가입하시겠습니까?");
					System.out.println("1. J O I N \n2. H O M E ");
					System.out.print("Select Number:");
					select = Util.keyboard.nextInt();
					switch (select) {
					case 1:
						manager.joinMember();
					case 2:
						System.out.println("초기화면으로 돌아갑니다.");
						return;
					}

				} // else문 종료 (존재하지 않는 회원)
			} // while문 종료
		} // else문 종료 (맨위)

	}

	public static String getTime() {

		SimpleDateFormat format = new SimpleDateFormat(" hh시 mm분 ss초 ");

		return format.format(new Date());

	}

}