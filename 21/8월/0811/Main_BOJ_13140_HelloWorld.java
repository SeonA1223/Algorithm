package problem210811;

import java.util.Scanner;

public class Main_BOJ_13140_HelloWorld {
	static String res;
	static int resInt;
	static boolean[] number;
	static boolean find;
	static int[] random;
	static int hello;
	static int world;
//	{h, e, l, o, w, r, d} => 0, 4번은 0일 수 없음

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		res = sc.next();
		resInt = Integer.parseInt(res);
		find = false;
		hello = 0;
		world = 0;
		number = new boolean[10];
		random = new int[7];
//		int maxRes = 99999 + 99999;
		String noAnswer = "No Answer";
//		if (resInt >= maxRes) {
//			System.out.println(noAnswer);
//			return;
//		}

		perm(0);
		if (find) {
			StringBuilder sb = new StringBuilder();
			sb.append("  ").append(hello).append("\n");
			sb.append("+ ").append(world).append("\n");
			sb.append("-------").append("\n");
			if (res.length() <= 5) {
				sb.append("  ").append(res);
			} else {
				sb.append(" ").append(res);
			}
			System.out.println(sb.toString());
		} else {
			System.out.println(noAnswer);
		}

	}

	private static void perm(int cnt) {
		if (find)
			return;
		if (cnt >= 7) {
			calculate();
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (number[i])
				continue;
			if (cnt == 0 || cnt == 4) {
				if (i == 0)
					continue;
			}
			number[i] = true;
			random[cnt] = i;
			perm(cnt + 1);
			number[i] = false;
		}
	}

	private static boolean calculate() {
//		helloString.append(random[0]).append(random[1]).append(random[2]).append(random[2]).append(random[3]);
//		worldString.append(random[4]).append(random[3]).append(random[5]).append(random[2]).append(random[6]);
		int temp1 = 10000 * random[0] + 1000 * random[1] + 100 * random[2] + 10 * random[2] + random[3];
		int temp2 = 10000 * random[4] + 1000 * random[3] + 100 * random[5] + 10 * random[2] + random[6];

		int sum = temp1 + temp2;
		if (sum == resInt) {
			hello = temp1;
			world = temp2;
			find = true;
			return true;
		}

		return false;

	}

}
