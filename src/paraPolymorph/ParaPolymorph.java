package paraPolymorph;

public class ParaPolymorph {

	public static void main(String[] args) {
		
		
		Buyer b = new Buyer();
		
		b.buy(new Tv1());
		b.buy(new Computer());
		
		System.out.println("잔액 " + b.money);
		System.out.println("보너스 점수 " + b.bonusPoint);
	}

}

// 자식 생성자 생성 -> 부모 기본 생성자 호출 -> 자식 기본 생성자 호출
// 자식 클래스는 인스턴스를 생성하려면 부모의 생성자가 생성되어야만 부모의 멤버를 사용할 수 있다.
class Product{
	
	int price;
	int bonusPoint;
	
	public Product(int price) {
		
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	
}

class Tv1 extends Product{
	
	public Tv1() {
		super(200);
		// 부모클래스의 기본생성자는 자동으로 호출되지만 매개변수가 있는  생성자는 자동으로 호출되지 않는다.
		// 그래서 따로 super()로 호출해야만한다.
		
	}
	public String toString() { return "tv";}
}

class Computer extends Product{
	
	public Computer() {
		super(100);
	}
	public String toString() { return "computer";}
}

class Buyer{
	
	int money = 1000;
	int bonusPoint = 0;
	
	// 부모 객체변수를 통해서 자식 클래스들을 참조할 수 있다.(자식클래스의 멤버는 참조불가)
	void buy(Product p) {
		
		if(money < p.price) {
			System.out.println("잔액이 부족");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p + "를 구입하셨습니다.");
	}
}


