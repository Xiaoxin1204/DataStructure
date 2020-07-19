package com.xiaoxin.tools;

public class Asserts {
	public static void test(boolean value) {
		try {
			if (!value) throw new Exception("测试未通过");
			else System.out.println("测试通过");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
