package problem210320;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();

		System.out.println(Arrays.toString(solution(a, b)));
	}

	public static int[] solution(int brown, int yellow) {
		int size = brown + yellow;
		int ans[] = null;
		for (int i = 3; i <= size / 2; i++) {
			if (size % i == 0) {
				int width = i;
				int height = size / i;
				
				int brownCount = width + width + height + height - 4;
				if (brownCount == brown) {
					ans = new int[] { width, height };
				}
			}

		}
		return ans;

	}
}