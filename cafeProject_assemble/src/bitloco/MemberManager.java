package bitloco;

import util.Util;

public class MemberManager {

	final MemberInfo[] mem;
	private MemberInfo m;
	LocoManager loco = LocoManager.getInstance();
	int cnt;
	int select;

	public MemberManager() {
		mem = new MemberInfo[10000];
		cnt = 0;
	}

	// 회원가입
	public void joinMember() {

//			m = null;
		Util.keyboard.nextLine();
		System.out.println("PLEASE COMPLETE A FORM!");
		System.out.print("I      D :");
		String id = Util.keyboard.nextLine();

		while (!(searchIndex(id) < 0)) {
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
		loco.bit.put(id, pw);
	}

	// 회원정보 수정
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
			loco.bit.put(id, pw);
			System.out.println("[Your edit is complete!]");
		}
	}

	// 회원정보 삭제
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
			loco.bit.remove(id);
			cnt--;
			System.out.println("[Your ID has been successfully deleted!]");
		}
	}

	// 회원정보 검색시 사용할 메서드
	int searchIndex(String id) {
		int index = -1;
		for (int i = 0; i < cnt; i++) {
			if (mem[i].getId().equals(id))
				index = i;
			break;
		}
		return index;
	}

	// 회원정보 출력
	public void showAllData() {
//			 int index = searchIndex(id);
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
}