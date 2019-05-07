package heapbuster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	
	private static Random random = new Random();

	public static String randomWords(int limitStart, int limitEnd) {    	
		if (limitEnd > limitStart && limitStart > 0) {    	
			StringBuilder sb = new StringBuilder();
			int i=0;
			int l=limitStart + Math.abs(random.nextInt())%(limitEnd - limitStart);
			for (i=0;i<l;i++) {
				sb.append(randomString(12) + " ");
			}
			return sb.toString();
		} else {
			return "";
		}
	}

	public static String randomString(final int LENGTH) {       
		char[] universe = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
		int i;
		char[] randomString = new char[LENGTH];

		for (i=0;i<LENGTH;i++) {
			randomString[i] = universe[Math.abs(random.nextInt())%universe.length];
		}

		return new String(randomString);
	}

	public static void main(String[] args) {
		new Main().run(
				Integer.parseInt(args[0]),
				Integer.parseInt(args[1]),
				Integer.parseInt(args[2]));
	}
	
	private void run(int size, int total, int time) {
		List<String> holdList = new ArrayList<String>();
		int i = 0;
		String s;
		for (i=0;i<total;i++) {
			s = randomString(size * 1024 * 1024);
			holdList.add(s);
		}
	}
	
}
