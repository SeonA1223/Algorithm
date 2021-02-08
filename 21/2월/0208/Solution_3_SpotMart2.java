package problem210208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_3_SpotMart2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 과자 봉지 갯수
			int M = Integer.parseInt(st.nextToken()); // 무게 합 제한
			int snacks[] = new int[N];
			int result = 0;
			int maxWeight = 0;
			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(st2.nextToken());
			}

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					result = snacks[i] + snacks[j];
					if (result <= M)
						maxWeight = Math.max(maxWeight, result);
				}
			}
			maxWeight = maxWeight == 0 ? -1 : maxWeight;
			sb.append("#").append(tc).append(" ").append(maxWeight).append("\n");
		}

		System.out.println(sb.toString());
	}
}
