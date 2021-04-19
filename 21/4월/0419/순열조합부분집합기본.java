package Day210419;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 순열조합부분집합기본 {
	static int[] input = {1, 3, 5};
	static int N = input.length;
	static int R = N-1;
	public static void main(String[] args) {
		//순열
//		perm(0, new int[N], new boolean[N]);
		
		//조합
//		comb(0,0, new int[R]);
//		comb2(0,0, new int[R]);
		
		//부분집합
		//1. 조합을 사용한 부분집합
		List<Integer> list = new ArrayList<>();
		subset(0, list);
		
		//2. 기본
//		subset2(0, new boolean[N]);
		
		//3, 기본심화
//		subset3(0, new int[N]);
	}
	private static void subset3(int cnt, int[] visited) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				if(visited[i] == 1) {
					System.out.print(input[i]);
				}
			}
			System.out.println();
			return;
		}
		
		visited[cnt] = 0;
		subset3(cnt+1, visited);
		visited[cnt] = 1;
		subset3(cnt+1, visited);
		
		
	}
	private static void subset2(int cnt, boolean[] visited) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				if(visited[i])
					System.out.print(input[i]);
			}
			System.out.println();
			return;
		}
		visited[cnt] = true;
		subset2(cnt+1, visited);
		visited[cnt] = false;
		subset2(cnt+1, visited);
		
		
	}
	private static void subset(int start, List<Integer> list) {
		for(int i : list) {
			System.out.print(i);
		}
		System.out.println();
		
		for (int i = start; i < N; i++) {
			list.add(input[i]);
			subset(i+1, list);
			list.remove(list.size()-1);
		}
		
	}
	private static void comb2(int start, int cnt, int[] arr) {
		if(cnt == R) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		if(start == N) return;
		arr[cnt] = input[start];
		comb2(start+1, cnt+1, arr);
		comb2(start+1, cnt, arr);
		
		
	}
	private static void comb(int start, int cnt, int[] arr) {
		if(cnt == R) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for (int i = start; i < N; i++) {
			arr[cnt] = input[i];
			comb(i+1, cnt+1, arr);
		}
		
	}
	private static void perm(int cnt, int[] arr, boolean[] visited) {
		if(cnt == N) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			arr[cnt] = input[i];
			perm(cnt+1, arr, visited);
			visited[i] = false;
		}
		
	}
}
