package kosa.thread;

public class PrintThread extends Thread {
	SharedArea sharedArea;

	PrintThread() {

	}

	public PrintThread(SharedArea sharedArea) {
		this.sharedArea = sharedArea;
	}

	// critical section : 사용중인 쓰레드에서 다른 쓰레드가 방해하는 것
	// critial section을 방지하기 위해 동기화를 하자!!
	public void run() {
		for (int cnt = 0; cnt < 3; cnt++) {
			synchronized (sharedArea) {
				int sum = sharedArea.account1.getBalance() + sharedArea.account2.getBalance();
				System.out.println("계좌 잔액 합계 : " + sum);
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

}
