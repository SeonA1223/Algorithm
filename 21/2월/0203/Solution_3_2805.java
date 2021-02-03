package problem210203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_3_2805 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());

		for (int i = 1; i <= testcase; i++) {
			int N = Integer.parseInt(br.readLine()); // 농작 크기
			int farm[][] = new int[N][N];

			for (int j = 0; j < N; j++) { // 농작물 가치 입력
				String str = br.readLine();
				for (int k = 0; k < N; k++) {
					farm[j][k] = str.charAt(k) - '0';
				}
			}
			
			for (int j = 0; j < N; j++) {
				System.out.println(Arrays.toString(farm[j]));
			}
			int profit = 0;
			for (int j = 0; j < N; j++) {
				for (int k = Math.abs(N/2-j); k < N-Math.abs(N/2-j); k++) {
					System.out.println("k = " + k);
					profit += farm[j][k];
				}

			}
			System.out.println("#" + i + " " + profit);
		}
	}

}
