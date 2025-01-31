package kosa.oop;

public class Account {
	// 1. 필드  2. 생성자  3. 메소드
	// 계좌객체 생성하기 위해서
	// 객체로부터 공통된 데이터 구조와 기능을 추출
	// 상태(데이터) : 계좌번호, 계좌주, 잔액 => 멤버변수 역할.
	// 행동(기능) : 입금한다. 출금한다. => 멤버 메서드 역할.
	private String accountNo; // 계좌번호 역할
	private String ownerName; // 계좌주
	private int balance; 	  // 잔액
	
	// 생성자는 return 형이 아예없다 void 조차도 없다
	// 생성자
	// 생성자의 장점 : 객체의 초기화 용이함.
	// 디폴트 생성자
	// 디폴트 생성자가 없어도 JVM이 자동으로 만들어준다.
	// 그러나 파라미터가 1개라도 있는 다른 생성자가 존재할 경우 디폴트 생성자를 생성하던 JVM에서 만들지 않는다.
	// 확장성을 위해서 클래스를 만드면 무조건 디폴트 생성자 만들자!
	public Account() {
		
	}
	
	// 매개변수인 accountNo 와 객체 Account 의 accountNo는 다르다
	// 매개변수는 생성자가 끝나면 사라지지만 객체의 accountNo는 객체가 사라질 때까지 존재한다.
	// 오버로딩 : 파라미터의 개수나 데이터의 타입이 다르면 메서드명이 같거나 같은 생성자처럼 보여도 서로 다른 생성자이면서 메서드이다.
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	
	// 객체를 초기화하고자 하는 생성자의 형태를 자신이 원하는 형태로 바꿔주면 된다
//	public Account(String string, String string2, double d) {
//		// TODO Auto-generated constructor stub
//	}

	// 입금하다
	public void deposit(int amount) {
		balance += amount;
	}
	
	// 출금하다
	// withdraw 메서드를 호출하는 곳에서 예외를 try catch로 처리해야된다.
	public int withdraw(int amount) throws Exception {
		if(balance <amount) {
			throw new Exception("잔액부족");
		} else {
			balance -= amount;
		}
		return amount;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}
	
	
}
