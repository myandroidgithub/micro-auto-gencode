package cn.javass;

import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {
		
		testStringTokenizer();
		
	}

	private static void testStringTokenizer() {
		String str = "www.baidu.com";
		
		StringTokenizer tokenizer = new StringTokenizer(str,".");
		
		while (tokenizer.hasMoreTokens()) {
			String nextToken = tokenizer.nextToken();
			
			System.out.println("nextToken="+nextToken);
			
			if (tokenizer.hasMoreTokens()) {
				System.out.println("...");
			}
		}
	}
}
