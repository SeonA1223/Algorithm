package problem210319;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1486_장훈이의높은선반 {
	static int N, B;
	static int[] staff;
	static int minHeight;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 직원의 수
			B = Integer.parseInt(st.nextToken()); // 선반의 높이

			staff = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				staff[i] = Integer.parseInt(st.nextToken());
			}

			minHeight = Integer.MAX_VALUE;
			comb(0, 0);
			sb.append(minHeight-B).append("\n");
		}
		System.out.println(sb);
	}

	private static void comb(int index, int sum) {
		if (sum >= B) {
			minHeight = Math.min(minHeight, sum);
			return;
		}
		if (index >= N)
			return;
		
		comb(index+1, sum+staff[index]);
		comb(index+1, sum);

	}

}
