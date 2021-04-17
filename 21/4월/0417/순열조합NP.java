package Day210417;

import java.util.Arrays;

//NextPermutaton은 외우기
public class 순열조합NP { 
	static int[] input = new int[] {2, 1, 3};
	static int N = input.length;
	
	public static void main(String[] args) {
		
		//순열
//		Arrays.sort(input);
//		
//		do {
//			System.out.println(Arrays.toString(input));
//		}while(np(input));
		
		//조합
		int[] p = new int[N];
		int R = 2;
		
		int cnt = 0;
		while(++cnt <= R) {
			p[N-cnt] = 1;
		}
		
		do {
			for (int i = 0; i < N; i++) {
				if(p[i] == 1) {
					System.out.print(input[i] + " ");
				}
			}
			System.out.println();
		}while(np(p));
	}

	private static boolean np(int[] numbers) {
		
		int i = N-1;
		while(i>0 && numbers[i-1] >= numbers[i]) i--;
		
		if(i==0) return false;
		
		int j = N-1;
		while(numbers[i-1] >= numbers[j]) j--;
		swap(numbers, i-1,j);
		
		int k = N-1;
		while(i<k) {
			swap(numbers, i++, k--);
		}
		return true;
	}

	private static void swap(int[] numbers, int i, int j) {
		int temp =numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
		
	}

}
