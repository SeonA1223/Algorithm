package Day210424;

import java.util.Arrays;

public class 순열부분조합비트마스킹 {
	static int[] input = { 1, 3, 4, 6 };
	static int N = input.length;
	static int R = N - 1;

	public static void main(String[] args) {
		// 순열
//		perm(0,0, new int[N]);

		// 부분조합
		int allCases = 1 << N;// 2^n
		subset(allCases);
	}

	private static void subset(int allCases) {
		for (int i = 0; i < allCases; i++) {
			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) != 0)
					System.out.print(input[j] + " ");
			}
			System.out.println();
		}

	}

	private static void perm(int index, int visited, int[] arr) {
		if (index == N) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((visited & 1 << i) != 0)
				continue;
			arr[index] = input[i];
			perm(index + 1, visited | 1 << i, arr);
		}

	}
}
