package menu;

import bitloco.Menu;

abstract class Food extends Menu {


	/*
	 * 변수선언
	 * @hot: 기본이 따뜻X, 1로 초기화 (따뜻하면 2로) // 베이커리류만 오버라이딩하면 됨.
	 * @honey: 기본이 정량, 2가 생크림 추가
	 */
	private String hot;

	// 생성자
	public Food() {
		super();
		this.hot = "기본";
	}

	public void setHot(String hot) {
		this.hot = "따뜻한";
	}

	public String getHot() {
		return this.hot;
	}

	public void noCold() {
		this.hot = "따뜻한";
	}

	@Override
	public void showProduct() {
		System.out.println(getHot() + " " + getName() + " | " + getPrice() + " 원");
	}
}

//int CHEEZE = 5, CHOCO = 6, COOCKIES = 7, SANDWITCHES =8;
class Cheeze extends Food {

	public Cheeze() {

		super();
		this.setPrice(5500);
		this.setName("치즈케익");
	}

	@Override
	public void showPrint() {
		System.out.println(this.getName() + " | " + this.getPrice() + " 원");

	}

}

class Choco extends Food {

	public Choco() {

		super();
		setPrice(6000);
		setName("초코케이크");
	}

	@Override
	public void showPrint() {
		System.out.println(getName() + " | " + getPrice() + " 원");
	}

}

class Cookies extends Food {

	public Cookies() {

		super();
		setPrice(2800);
		setName("쿠    키");
	}
	
	void hotCookies() {
		
		setPrice(3300);
		setName("따뜻한 쿠키");
	}
	
	void Cookies() {
		
		setPrice(3300);
		setName("쿠    키");
	}

	@Override
	public void showPrint() {
		System.out.println(getName() + " | " + getPrice() + " 원");
	}

}

class Sandwiches extends Food {

	public Sandwiches() {

		super();
		setPrice(5600);
		setName("샌드위치");
	}
	
	void hotScone() {
		
		setPrice(3300);
		setName("따뜻한 샌드위치");
	}
	
	void Scone() {
	
		setPrice(3300);
		setName("샌드위치");
	}

	@Override
	public void showPrint() {
			System.out.println(getName() + " | " + getPrice() + " 원");
	}
}

class Scone extends Food {
	
	public Scone() {
		super();
		setPrice(3300);
		setName("스    콘");
	}
	
	void hotScone() {
		
		setPrice(3300);
		setName("따뜻한 스콘");
	}
	
	void Scone() {
	
		setPrice(3300);
		setName("스    콘");
	}
	
	@Override
	public void showPrint() {
		System.out.println(getName() + " | " + getPrice() + " 원");
	}
}

class Honeybread extends Food {
	public Honeybread() {
		super();
		setPrice(6000);
		setName("허니브레드");
	}
	
	void Honeybread() {
	
		setPrice(6000);
		setName("허니브레드");
	}
	
	void moreHoneybread() {
	
		setPrice(7000);
		setName("생크림 허니브레드");
	}
	
	@Override
	public void showPrint() {
		System.out.println(getName() + " | " + getPrice() + " 원");
	}

}
