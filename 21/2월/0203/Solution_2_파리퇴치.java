package problem210203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2_파리퇴치 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int max = 0;

			int[][] flies = new int[N][N];

			for (int j = 0; j < N; j++) {
				StringTokenizer nums = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					flies[j][k] = Integer.parseInt(nums.nextToken());
				}
			}

			int numFlies = 0;
			for (int j = 0; j < N-M+1; j++) {
				for (int k = 0; k < N-M+1; k++) {
					for (int x = 0; x < M; x++) {
						for (int y = 0; y < M; y++) {
							numFlies += flies[x + j][y + k];
						}
					}
					max = Math.max(max, numFlies);
					numFlies = 0;
				}

			}
			System.out.println("#"+i+" "+max);

		}
	}
}
