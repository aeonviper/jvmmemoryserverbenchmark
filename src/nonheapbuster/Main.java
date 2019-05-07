package nonheapbuster;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {		
		MyClassLoader loader;
		Class c;
		int i = 0;
		List<Class> classList = new ArrayList<Class>();

		pwd();

		while (true) {
			try {
				loader = new MyClassLoader();
				c = loader.findClass("nonheapbuster.Sample", "bin/nonheapbuster/Sample.class");
				classList.add(c);
				i++;
			} catch (Error e) {
				System.err.println("Died at " + i);
				e.printStackTrace();
				break;
			}
		}
	}

	private void pwd() {		  
		System.out.println(new File("dummy.txt").getAbsolutePath());
		System.out.println(System.getProperty("user.dir"));
	}

	private void sleep(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
