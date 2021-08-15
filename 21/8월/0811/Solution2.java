package problem210811;

import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		String input = "2 3\nSHOW\nSHOW\nNEXT\nSHOW\nSHOW\nNEXT\nSHOW\nNEXT\nSHOW\nSHOW\nNEXT\nSHOW\nEXIT";
		String[] ins = input.split("\n");

		String s = ins[0];
		int M = s.charAt(0) - '0';
		int N = s.charAt(s.length() - 1) - '0';

		int index = 1;
		int day = 1;
		int addDay = 0;
		int expose = 0;
		boolean flag = true;
		StringBuilder sb = new StringBuilder();
		sb.append(s).append("\n");
		while (!ins[index].equals("EXIT")) {
			String temp = ins[index++];

			if (temp.equals("SHOW")) {
				expose++;
			} else if (temp.equals("NEGATIVE")) {
				flag = false;
				day = 0;
				expose = 0;
				sb.append("0").append("\n");
				continue;
			} else if (temp.equals("NEXT")) {
				day++;
				sb.append("-").append("\n");
				if (M+1 == day) {
					flag = true;
					day = 0;
					expose = 0;
				}
				continue;
			}

			if (flag) {
				sb.append("1").append("\n");
				if (M == day && N == expose) {
					flag = false;
					day = 0;
					expose = 0;
				}
			} else {
				sb.append("0").append("\n");

			}

		}
		sb.append("BYE").append("\n");
		System.out.println(sb.toString());

	}
}
