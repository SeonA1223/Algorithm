package Day210424;

import java.util.Arrays;

public class 순열조합부분집합기본 {
	static int[] input = { 1, 3, 4, 6 };
	static int N = input.length;
	static int R = N - 1;

	public static void main(String[] args) {
		// 중복순열
//		perm2(0, new int[N]);
		// 순열
//		perm(0, new int[N], new boolean[N]);

		// 조합
//		comb(0,0,new int[R]);
		// 조합2
//		comb2(0,0, new int[R]);

		// 부분집합
//		subset3(0, 0, new int[N]);
		subset(0, 0, new int[N]);
		
//		subset2(0,new boolean[N]);
	}

	private static void subset3(int index, int start, int[] arr) {
		if(index==N) {
			return;
		}
		if(start==N) {
			
			return;
		}
		for(int i:arr) {
			System.out.print(i);
		}
		System.out.println();
		arr[index] = input[start];
		subset3(index+1, start+1, arr);
		subset3(index, start+1, arr);

		
	}

	private static void subset2(int index, boolean[] visited) {
		if(index == N) {
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		visited[index] = true;
		subset2(index+1, visited);
		visited[index] = false;
		subset2(index+1, visited);
		
	}

	private static void subset(int start, int index, int[] arr) {
		for (int x : arr) {
			System.out.print(x);
		}
		System.out.println();

		for (int i = start; i < N; i++) {
			arr[index] = input[i];
			subset(i + 1, index + 1, arr);
			arr[index] = 0;
		}
	}

	private static void comb2(int start, int index, int[] arr) {
		if (index == R) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		if (start == N)
			return;
		arr[index] = input[start];
		comb2(start + 1, index + 1, arr);
		comb2(start + 1, index, arr);

	}

	private static void comb(int start, int index, int[] arr) {
		if (index == R) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = start; i < N; i++) {
			arr[index] = input[i];
			comb(i + 1, index + 1, arr);
		}

	}

	private static void perm2(int index, int[] arr) {
		if (index == N) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = 0; i < N; i++) {

			arr[index] = input[i];
			perm2(index + 1, arr);

		}

	}

	private static void perm(int index, int[] arr, boolean[] visited) {
		if (index == N) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			arr[index] = input[i];
			perm(index + 1, arr, visited);
			visited[i] = false;
		}

	}
}
