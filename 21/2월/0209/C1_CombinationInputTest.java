package problem210209;

import java.util.Arrays;
import java.util.Scanner;

// nCr 
public class C1_CombinationInputTest {

	// 1,2,3
	// 3C2 = 3!/1!2! = 3
	static int N = 4, R = 2;
	static int[] numbers;
	static int[] input = { 1, 2, 3, 4 };

	public static void main(String[] args) {
		numbers = new int[R]; // r개의 크기 배열

		combination(0, 0);

	}

//cnt: 현재까지 뽑은 조합원소 개수, start: 시작 인덱스 
	private static void combination(int cnt, int start) {
		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		numbers[cnt] = input[start];
		combination(cnt, start + 1);
		combination(cnt + 1, start + 1);
	}
}
