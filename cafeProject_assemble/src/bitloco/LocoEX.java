package bitloco;

import util.Menu_Inter;
import util.Util;

public class LocoEX {

	public static void main(String[] args) {
		LocoManager bitloco = LocoManager.getInstance();
		MenuSelect m = new MenuSelect();
		MemberManager mm = new MemberManager();

//		member m = new member (null, null); 
//		Set <LoginMember> login = new HashSet ();

		System.out.println("B   I   T   L   O   C   O");
		System.out.println("-------------------------");
		System.out.println("최상의 서비스를 위해 항상 노력하겠습니다.");
		System.out.println("--------------------------");

		while (true) {
			System.out.printf("%d. M E M B E R S \n%d. J O I N \n%d. M E N U \n%d. Q U I T\n", Menu_Inter.MEMBERS,
					Menu_Inter.JOIN, Menu_Inter.MENU, Menu_Inter.QUIT);
			System.out.println("===========================");
			System.out.print("Select Number:");
			int select = Util.keyboard.nextInt();

			switch (select) {
			case Menu_Inter.MEMBERS:
				bitloco.login();
				break;

			case Menu_Inter.JOIN:
				mm.joinMember();
				break;

			case Menu_Inter.MENU:
				m.showMenuPlate();
				break;

			case Menu_Inter.QUIT:
				System.out.println();
				System.out.println("  " + bitloco.getTime() + "종료!");
				System.out.println("Thank you for using. \nPlease come again next time.\n             \t _ BITLOCO");
				return;

			default:
				System.out.println("Please, re-select!");
				break;

			}
		}
	}

}