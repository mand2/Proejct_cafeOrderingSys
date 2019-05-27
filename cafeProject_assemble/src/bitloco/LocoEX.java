package bitloco;



import java.util.ArrayList;
import menu.MenuSelect;
import util.*;



public class LocoEX {


	public static void main(String[] args) {
    
	 LocoManager bitloco = LocoManager.getInstance();
	 MenuSelect m = new MenuSelect();	
//		member m = new member (null, null); 
//		Set <LoginMember> login = new HashSet ();
    
    	System.out.println("B   I   T   L   O   C   O");
    	System.out.println("-------------------------");
		System.out.println("최상의 서비스를 위해 항상 노력하겠습니다.");
		System.out.println("--------------------------");
		
		
     while(true) {
		System.out.printf("%d. M E M B E R S \n%d. J O I N \n%d. M E N U \n%d. Q U I T\n",Menu_Inter.MEMBERS,Menu_Inter.JOIN,
				Menu_Inter.MENU,Menu_Inter.QUIT);
	    System.out.println("===========================");
	    System.out.print("Select Number:");
		int select = Util.keyboard.nextInt();

		switch (select) {
		case Menu_Inter.MEMBERS:
			bitloco.login();
			break;
			
		case Menu_Inter.JOIN:
			bitloco.joinMember();
			break;
			
		case Menu_Inter.MENU:
			m.showMenuPlate();
			break;
			
		case Menu_Inter.QUIT:
			System.out.println("프로그램을 종료합니다.\n이용해주셔서 감사합니다.\n       _BITLOCO");
			return;
			
		default:
			System.out.println("Please, re-select!");
			break;
		
		}
		
		
		//	기존아리님이 쓴 코드	
//		if(select<1||select>4) {
//			System.out.println("Please, re-select!");
//			continue;
//		}else if(select==Menu_Inter.MEMERS) {
//			switch(select) {
//			case 1:
//			bitloco.login();
//			
////			System.out.println("회원전용 메뉴창입니다.");
////			System.out.println("회원메뉴에는 1.MyInfo 2.ORDER 3.ACOOUNT 4.EVENT 5.HOME(초기화면)");
//			}
//		}else if(select==Menu_Inter.JOIN) {
//			
//			bitloco.joinMember();
//
//		}else if (select==Menu_Inter.MENU) {
//			//bitloco.foodMenu();
//			m.main(args);
//			bitloco.login();
//		}else if(select==Menu_Inter.QUIT) {
//			System.out.println("프로그램을 종료합니다.\n이용해주셔서 감사합니다.\n       _BITLOCO");
//			return;
//		}
//		
//		
//		
		}
	}
}