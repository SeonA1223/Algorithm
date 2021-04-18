package Day210418;

import java.util.Arrays;

public class 순열부분집합_비트마스킹 {
	static int[] input = new int[] { 1, 6, 5 };
	static int N = input.length;
	
	public static void main(String[] args) {
//		int[] arr = new int[N];
//		perm(0,0, arr);
		
		
		
		int allCase = 1 << N;
		subset(allCase);
	}

	private static void subset(int allCase) {
		for (int i = 0; i < allCase; i++) {
			for (int j = 0; j < N; j++) {
				if((i & 1 << j) != 0) {
					System.out.print(input[j] + " ");
				}
			}
			System.out.println();
		}
		
	}

	private static void perm(int index, int bit, int[] arr) {
		if(index == N) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = 0; i < N; i++) {
			if((bit & 1 << i) != 0) continue;
			arr[index] = input[i];
			perm(index+1, bit | 1 << i, arr);
		}
		
	}

}
