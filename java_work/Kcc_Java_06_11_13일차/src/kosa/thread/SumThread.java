package kosa.thread;

public class SumThread extends Thread {
	private int start;
	private int end;
	private int total;
	
	
	public SumThread() {
	}
	
	
	public SumThread(int start, int end) {
		this.start = start;
		this.end = end;
	}


	@Override
	public void run() {
		for(int i = start ; i<=end; i++) {
			total += i;
		}
	}

	public int getTotal() {
		return total;
	}


}
