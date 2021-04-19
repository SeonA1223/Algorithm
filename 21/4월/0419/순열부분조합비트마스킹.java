package Day210419;

import java.util.Arrays;

public class 순열부분조합비트마스킹 {
	static int[] input = {1, 3, 5};
	static int N = input.length;
	static int R = N-1;
	
	public static void main(String[] args) {
		//순열
//		perm(0, 0, new int[N]);
		
		//조합
		int allCase = 1 << N;
		subset(allCase);
		
	}

	private static void subset(int allCase) {
		for (int i = 0; i < allCase; i++) {
			for (int j = 0; j < N; j++) {
				if((i & 1 << j) != 0) {
					System.out.print(input[j]);
				}
			}
			System.out.println();
		}
		
	}

	private static void perm(int cnt, int bit, int[] arr) {
		if(cnt == N) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = 0; i < N; i++) {
			if((bit & 1 << i) != 0) continue;
			arr[cnt] = input[i];
			perm(cnt+1, bit | 1 << i, arr);
		}
		
	}

}
