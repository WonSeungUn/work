package kosa.thread;

public class SumMain {
	public static void main(String[] args) {
		// t1: 1 ~ 50 합을 구하는 쓰레드
		// t2: 51 ~ 100 합을 구하는 쓰레드
		// main : t1 + t2 => 합: 5050 => 문제 : join()
		SumThread t1 = new SumThread(1, 50);
		SumThread t2 = new SumThread(51, 100);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
		}
		System.out.println("합계 : " + ((t1.getTotal()) + (t2.getTotal())));

	}
}
