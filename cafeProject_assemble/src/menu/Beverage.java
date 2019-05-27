package menu;
//TODO 레모네이드클래스만 sizeUP변경됨/ 그리고 cafe클래스에 사이즈업자체를 돈 넣어버림.확인용으로 시도해볼것.

import bitloco.Menu;

//음료 클래스. coffee & Non-C 클래스의 부모.
abstract class Beverage extends Menu {

	/*
	 * 변수선언
	 * @size: 1 (small이 기본, 2가 되면 LARGE)
	 * @cold: 1 (cold가 기본, 2가 되면 hot)
	 */
	private String size;
	private String cold;

	/* 생성자 */
	public Beverage() {
		super();
		this.size = "small";
		this.cold = "iced";
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

	public String getSize() {
		return this.size;
	}

	public String getCold() {
		return this.cold;
	}

	public abstract void showPrint();

	@Override
	public void showProduct() {
		System.out.println(getCold() + " " + getName() + " " + getSize() + " | " + getPrice() + " 원");
	}

}


//아메리카노 클래스 - 예시
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