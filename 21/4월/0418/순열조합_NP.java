package Day210418;

import java.util.Arrays;

public class 순열조합_NP {
	static int[] input = new int[] { 1, 6, 5 };
	static int N = input.length;
	public static void main(String[] args) {
		//순열
//		Arrays.sort(input);
//		do {
//			System.out.println(Arrays.toString(input));
//		}while(np(input));
		
		//조합
		int R = 2;
		int arr[] = new int[N];
		int cnt = 0;
		
		while(++cnt <= R) {
			arr[N-cnt] = 1;
		}
		
		do {
			for (int i=0; i<N; i++) {
				if(arr[i] == 1){
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
		}while(np(arr));
		
	}
	
	private static boolean np(int[] arr) {
		int i = N-1;
		while(i>0 && arr[i-1] >= arr[i]) i--;
		if(i==0) return false;
		
		int j = N-1;
		while(arr[i-1]>= arr[j]) j--;
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
