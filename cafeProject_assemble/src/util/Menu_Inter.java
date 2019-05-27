package util;

public interface Menu_Inter {
	
	void showPrint();
	
    // 메인 메뉴 선택창
	public int MEMBERS=1, JOIN=2, MENU=3,QUIT=4;
	
	
	//메뉴 선택 시 쓰는 것들 
	// 음료 & 푸드
	public int AMERICANO = 1, CAPPUCHINO =2, SPARKLING =3, LEMONADE=4
	,CHEEZE = 5, CHOCO = 6, COOCKIES = 7, SANDWITCHES =8, SCONE =9, HONEY_BREAD=10; 
	
	
	//음료인가 푸드인가
	public int BEVERAGE = 1, FOOD = 2;

	//음식은 1=안뎁힌거 음료1=차가운음료
	int FOOD_COLD = 1,FOOD_HOT = 2, BEV_COLD = 1, BEV_HOT=2;

}