package problem210212_보충;

import java.util.Arrays;

public class 순열복습 {
	/*
	 * 순열 특정 N개를 순서대로 나열한 경우의 수 n!
	 */
	public static void main(String[] args) {
		cases = 0;
		perm(0);
		System.out.println("cases = " + cases);

	}

	static int N = 3, cases;
	static String foods[] = { "떡볶이", "녹차갸또쇼콜라", "커리" };
	static boolean isChecked[] = new boolean[N];
	static String ans[] = new String[N];

	static void perm(int count) {
		if (count == N) {
			cases++;
			System.out.println(Arrays.toString(ans));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isChecked[i] == true) //중복방지
				continue;
			isChecked[i] = true;
			ans[count] = foods[i];
			perm(count + 1);
			isChecked[i] = false;
		}
	}

}
