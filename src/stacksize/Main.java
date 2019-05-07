package stacksize;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		int i=0;
		while (true) {
			try {
				new Worker(i, 100).start();
				i++;
			} catch (Error e) {
				System.err.println("Died at " + i); 
				e.printStackTrace();
				break;
			}

		}
	}

	public static void sleep(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
