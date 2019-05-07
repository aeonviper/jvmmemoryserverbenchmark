package stacksize;

public class Worker extends Thread {
	private Integer id;
	private Integer depth;
	
	public Worker(Integer id, Integer depth) {
		this.id = id;
		this.depth = depth;
	}
	
	public void run() {
		stackBuster("x", 0, depth);
		Main.sleep(5);
	}
	
	private String stackBuster(String s, Integer level, Integer depth) {
		String o = s;
		String p = s;
		if (level.intValue() >= depth.intValue()) {
			return "o";
		}
		return stackBuster(s, level.intValue() + 1, depth);
	}
}
