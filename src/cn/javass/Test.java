package cn.javass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Test {

	public static void main(String[] args) {
		
		//测试StringTokenizer
//		testTtringTokenizer();
		//测试List  
		testList();
		
		
	}

	private static void testList() {
		String[] ss = {"s1","s2","1"};  
		List<String> ssList = Arrays.asList(ss);
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("3");
		list.add("5");
//		list.addAll(ssList);
//		list.addAll(1, ssList);
		
//		System.out.println(list);
//		
//		boolean flag = list.retainAll(ssList);
//		System.out.println(list + " flag = " + flag);
		
		list.removeAll(ssList);
		System.out.println(list );
		
	}

	private static void testTtringTokenizer() {
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
