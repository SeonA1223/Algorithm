package Day210418;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 순열조합부분집합_BASIC {
	static int[] input = new int[] { 1, 6, 5 };
	static int N = input.length;

	public static void main(String[] args) {
		// 순열
//		int[] arr = new int[N];
//		boolean[] visited = new boolean[N];
//		perm(0, arr, visited);
		
		//조합
//		int R = 2;
//		int[] arr1 = new int[R];
//		comb(0,0, arr1);
		
		//조합을 사용한 부분집합
//		List<Integer> arr2 = new ArrayList<>();
//		subset1(0,arr2);

		//기본부분집합
		boolean[] visited1 = new boolean[N];
		subset2(0,visited1);
	}

	private static void subset2(int index, boolean[] visited1) {
		if(index==N) {
			for (int i = 0; i < N; i++) {
				if(visited1[i])
					System.out.print(input[i] + " ");
			}
			System.out.println();
			return;
		}
		visited1[index] = true;
		subset2(index+1, visited1);
		visited1[index] = false;
		subset2(index+1, visited1);
		
	}

	private static void subset1(int start, List<Integer> arr2) {
		for(int i : arr2) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (int i = start; i < N; i++) {
			arr2.add(input[i]);
			subset1(i+1, arr2);
			arr2.remove(arr2.size() -1);
		}
		
	}

	private static void comb(int index, int start, int[] arr1) {
		if(index == arr1.length) {
			System.out.println(Arrays.toString(arr1));
			return;
		}
		for (int i = start; i < N; i++) {
			arr1[index] = input[i];
			comb(index+1, i+1, arr1);
			
		}
		
	}

	private static void perm(int count, int[] arr, boolean[] visited) {
		if (count == N) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			arr[count] = input[i];
			perm(count+1, arr, visited);
			visited[i] = false;
		}
	}

}
