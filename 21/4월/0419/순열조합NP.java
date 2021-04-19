package Day210419;

import java.util.Arrays;

public class 순열조합NP {
	static int[] input = new int[] { 4, 6, 2};
	static int N = input.length;
	static int R = N-1;
	
	public static void main(String[] args) {
		
		//순열
//		Arrays.sort(input);
		
//		do {
//			System.out.println(Arrays.toString(input));
//		}while(np(input));
		
		System.out.println("---------------");
		
		int[] arr = new int[N];
		int cnt = 0;
		while(++cnt <= R) {
			arr[N-cnt] = 1;
		}
		
		do {
			for (int i = 0; i < N; i++) {
				if(arr[i] == 1) {
					System.out.print(input[i]);
				}
			}
			System.out.println();
		}while(np(arr));
	}
	
	public static boolean np(int[] arr) {
		int i = N-1;
		while(i>0 && arr[i-1] >= arr[i]) i--;
		if(i==0) return false;
		
		int j = N-1;
		while(arr[i-1] >= arr[j]) j--;
		swap(arr, i-1, j);
		
		int k = N-1;
		while(i<k) {
			swap(arr, i++, k--);
		}
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
