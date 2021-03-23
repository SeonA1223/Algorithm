package problem210323;

import java.util.Scanner;

public class Main_BOJ_1463_1로만들기 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();
		int[] table = new int[N + 1];
		int min;

		for (int i = 2; i <= N; i++) {
			table[i] = table[i - 1] + 1;
			if (i % 2 == 0)
				table[i] = Math.min(table[i], table[i / 2] + 1);
			if (i % 3 == 0)
				table[i] = Math.min(table[i], table[i / 3] + 1);

		}
		
		System.out.println(table[N]);
	}
}
