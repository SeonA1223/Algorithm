package Day210422;

import java.util.Arrays;

public class 순열조합부분집합베이직 {
	static int input[] = { 1, 4, 5 };
	static int N = input.length;
	static int R = N - 1;

	public static void main(String[] args) {
		//순열
//		perm(0, new int[N], new boolean[N]);
		
		//조합1
//		comb1(0,0, new int[R]);
		
		//조합2
//		comb2(0,0, new int[R]);
		
		//부분집합
		//조합이용
		subset(0,0, new int[N]);
		
		//부분집합 boolean
//		subset2(0, new boolean[N]);
		
//		subset3(0, new int[N]);
	}

	private static void subset3(int index, int[] js) {
		if(index == N) {
			for (int i = 0; i < N; i++) {
				if(js[i]==1) {
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		js[index] = 0;
		subset3(index+1, js);
		js[index] = 1;
		subset3(index+1, js);
		
		
	}

	private static void subset2(int index, boolean[] bs) {
		if(index==N) {
			for (int i = 0; i < N; i++) {
				if(bs[i]) {
					System.out.print(input[i]);
				}
			}
			System.out.println();
			return;
		}
		
		bs[index] = true;
		subset2(index+1, bs);
		bs[index] = false;
		subset2(index+1, bs);
		
	}

	private static void subset(int start, int index, int[] arr) {
		for(int x : arr) {
			System.out.print(x);
		}
		System.out.println();
		
		for(int i=start; i<N; i++) {
			arr[index] = input[i];
			subset(i+1, index+1, arr);
			arr[index] = 0;
		}
	}

	//이제 안 사실!
	//먼저 index를 증가시켜주고, 그 다음에 인덱스를 증가안시키는 순으로 꼭 해줘야한다. index가 증가하냐 안증가하냐지
	//start는 항상 증가!
	
	//실전에서는 comb1을 사용하기 comb2는 실수하기 쉬움
	private static void comb2(int index, int start, int[] ks) {
		if(index == R) {
			System.out.println(Arrays.toString(ks));
			return;
		}
		if(start == N) return;
		ks[index] = input[start];
		comb2(index+1, start+1, ks);
		comb2(index, start+1, ks);
		
	}

	private static void comb1(int start, int index, int[] ks) {
		if(index == R) {
			System.out.println(Arrays.toString(ks));
			return;
		}
		for(int i= start; i<N; i++) {
			ks[index] = input[i];
			comb1(i+1, index+1, ks);
		}
		
	}

	private static void perm(int index, int arr[], boolean[] visited) {
		if(index == R) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			arr[index] = input[i];
			perm(index+1, arr, visited);
			visited[i] = false;
		}
		
	}
}
