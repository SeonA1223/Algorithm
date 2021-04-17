package Day210417;

import java.util.Arrays;

public class 비트마스킹순열부분조합 {
	static int[] input = new int[] { 4, 6, 2};
	static int N = input.length;

	public static void main(String[] args) {

		// 값을 담을 배열
		int[] res = new int[N];

		// 순열
		// i & 1 << j => check
		// i | 1 << j => visite check
//		perm(0, 0, res);
		
		//부분집합
		int allCase = 1 << N;
		subset(allCase);
	}

	private static void subset(int allCase) {
		for (int i = 0; i < allCase; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print((i&1<<j) != 0 ? input[j]+" " : "");
			}
			System.out.println();
		}
		
	}

	private static void perm(int cnt, int visited, int[] res) {
		if(cnt == N) {
			System.out.println(Arrays.toString(res));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((visited & 1 << i) != 0) continue;
			res[cnt] = input[i];
			perm(cnt+1, visited | 1 << i, res);
		}
		
	}
}
