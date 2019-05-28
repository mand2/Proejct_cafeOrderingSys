package menu;
//TODO 레모네이드클래스만 sizeUP변경됨/ 그리고 cafe클래스에 사이즈업자체를 돈 넣어버림.확인용으로 시도해볼것.

import bitloco.Menu;

//음료 클래스. coffee & Non-C 클래스의 부모.
abstract class Beverage extends Menu {

	/*
	 * 변수선언
	 * 
	 * @size: 1 (small이 기본, 2가 되면 LARGE)
	 * 
	 * @cold: 1 (cold가 기본, 2가 되면 hot)
	 */
	private String size;
	private String cold;

	// 변수 선언 (과일쥬스 fruit과 설탕당도 sugar)
	// @fruit : 1.바나나 2.딸기 3.딸바를 위한 변수
	// @sugar : 1( sugar free, 2가되면 sugar = 기본(original)

	private String fruit;
	private String sugar;

	/* 생성자 */
	public Beverage() {
		super();
		this.size = "small";
		this.cold = "iced";
		this.sugar = "";
		this.fruit = "";
	}

	// 사이즈업하는 메서드
	public void sizeUP() {
		size = "large";
		setPrice(getPrice() + 1000);
	}

	// hot으로 바꿔주는 메서드
	public void noCold() {
		cold = "hot";
	}

	// sugar free 메소드
	public void sugarFree() {
		sugar = "(sugar free)";
	}

	// 바나나를 위한 메소드
	public void banana() {
		fruit = "바나나 ";
	}

	// 딸기를 위한 메소드
	public void strawberry() {
		fruit = "딸기 ";
	}

	// 딸바를 위한 메소드
	public void banaberry() {
		fruit = "딸바 ";
	}

	public String getSize() {
		return this.size;
	}

	public String getCold() {
		return this.cold;
	}

	public String getSugar() {
		return this.sugar;
	}

	public String getfruit() {
		return this.fruit;
	}

	public abstract void showPrint();

	@Override
	public void showProduct() {
		System.out.println(getSugar() + " " + getCold() + " " + getfruit() + " " + getName() + " " + getSize() + " | "
				+ getPrice() + " 원");
	}

}

//아메리카노 클래스 AMERICANO = 1
class Americano extends Beverage {

	// 생성자
	public Americano() {
		super();
		setPrice(4000); // 상품의 가격 정해줌.
		setName("아메리카노"); // 상품의 이름 정해줌(오버라이드)
	}

	@Override
	public void showPrint() {
		System.out.println(getName() + " | " + getPrice() + " 원");
	}
}

//카푸치노 클래스 CAPPUCHINO =2, SPARKLING =3, LEMONADE=4;
class Cappuchino extends Beverage {

	// 생성자
	public Cappuchino() {
		super();
		setPrice(5000); // 상품의 가격 정해줌.
		setName("카푸치노"); // 상품의 이름 정해줌(오버라이드)
	}

	@Override
	public void showPrint() {
		System.out.println(getName() + "   | " + getPrice() + " 원");
	}

}

//탄산수 클래스
class Sparkling extends Beverage {

	// 생성자
	public Sparkling() {
		super();
		setPrice(3000); // 상품의 가격 정해줌.
		setName("탄산수"); // 상품의 이름 정해줌(오버라이드)
	}

	@Override
	public void showPrint() {
		System.out.println(getName() + "     | " + getPrice() + " 원");
	}

}

//레몬에이드 클래스
class Lemonade extends Beverage {

	// 생성자
	public Lemonade() {
		super();
		setPrice(4000); // 상품의 가격 정해줌.
		setName("레몬에이드"); // 상품의 이름 정해줌(오버라이드)
	}

	@Override
	public void showPrint() {
		System.out.println(getName() + " | " + getPrice() + " 원");
	}
}

//과일쥬스 클래스
class FruitJuice extends Beverage {

	// 생성자
	public FruitJuice() {
		super();
		setPrice(4000);
		setName("생과일 쥬스");
	}

	@Override
	public void showPrint() {
		System.out.println(getName() + "| " + getPrice() + " 원 (바나나,딸기,딸바)");
	}
}