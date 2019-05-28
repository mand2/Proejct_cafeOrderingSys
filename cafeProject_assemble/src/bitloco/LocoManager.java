package bitloco;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import menu.MenuSelect;
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

	private LocoManager() {
		mem = new MemberInfo[10000];
		cnt = 0;
		plate = new MenuSelect();
	}

	private static LocoManager loco = new LocoManager();

	public static LocoManager getInstance() {
		if (loco == null) {
			loco = new LocoManager();
		}
		return loco;
	}
	
	public Map<String, String> getBit(){
		return this.bit;
	}

	public void joinMember() {

//		m = null;
		Util.keyboard.nextLine();
		System.out.println("PLEASE COMPLETE A FORM!");
		System.out.print("I      D :");
		String id = Util.keyboard.nextLine();
		
		while( !(searchIndex(id)<0) ) {
			System.out.println("The ID is using.Please re-enter.");
			System.out.print("I      D :");
			id = Util.keyboard.nextLine();
		}
		    
			System.out.print("Password :");
			String pw = Util.keyboard.nextLine();
		
			System.out.print("N A  M E :");
			String name = Util.keyboard.nextLine();
			
			System.out.print("PhoneNum :");
			String pNum = Util.keyboard.nextLine();

			m = new MemberInfo(id, pw, name, pNum);
			mem[cnt++] = m;
			System.out.println("[THANKS FOR JOINING US. ]");
			bit.put(id, pw);
	}

	public void editInfo() {
		System.out.print("INSERT-ID: ");
		String id = Util.keyboard.nextLine();
		int index = searchIndex(id);
		if (index < 0) {
			System.out.println("wrong ID!");
		} else {
			System.out.println("[edit" + mem[index].getId() + "'s Information]");
			
			System.out.print("PASSWORD :");
			String pw = Util.keyboard.nextLine();

			System.out.print("N  A  M E:");
			String name = Util.keyboard.nextLine();

			System.out.print("Phone Num:");
			String pNum = Util.keyboard.nextLine();

			mem[index] = new MemberInfo(id, pw, name, pNum);
			bit.put(id, pw);
			System.out.println("[Your edit is complete!]");
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
			System.out.println("[Your ID has been successfully deleted!]");
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
				System.out.println("===========================");
				break;
			}
		} else {
			System.out.println("등록된 회원정보가 없습니다.");
		}

	}

	// Members 안에 선택창
	public int first() {
		System.out.println("===========================");
		System.out.println("please select number :)");
		System.out.println("1. I N F O\n2. E D I T\n3. D E L E T E\n4. H O M E");
		System.out.println("===========================");
		System.out.print("Select Number:");
		select = Util.keyboard.nextInt();
		Util.keyboard.nextLine();
		return select;
	}

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
						System.out.println(getTime()+"접속!");
						System.out.println("[ "+id + ", Signed in! ]");
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

	

	 public static String getTime() {
			
			SimpleDateFormat format  = new SimpleDateFormat (" hh시 mm분 ss초 ");
			
			return format.format(new Date());
					
		}
	
	
	
}