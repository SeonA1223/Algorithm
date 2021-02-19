package problem210219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_요리사 {
	static int half;
	static int N;
	static int ingredient[][], A[], B[];
	static boolean visit[];
	static int  res;
	static int synergy;

	private static void comb(int index, int start) {
		if (index == half) {
			int j = 0;
			for (int i = 0; i < N; i++) {
				if (!visit[i]) {
					B[j] = i;
					j++;
				}
			}
			synergy = 0;
			getFoodTasteComb(0, 0, new int[2], A);
			int a = synergy;
			synergy = 0;
			
			getFoodTasteComb(0, 0, new int[2], B);
			int b = synergy;
			res = Math.min(res, Math.abs(a-b));
			
			return;
		}
		for (int i = start; i < N; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			A[index] = i;
			comb(index + 1, i + 1);
			visit[i] = false;
		}
	}

	private static void getFoodTasteComb(int index, int start, int[] arr, int[] foods) { // 2개씩의 조합을 만들기
		if (index == 2) {
			synergy += ingredient[arr[0]][arr[1]];
			synergy += ingredient[arr[1]][arr[0]];
			return;

		}
		for (int i = start; i < foods.length; i++) {
			arr[index] = foods[i];
			getFoodTasteComb(index + 1, i + 1, arr, foods);

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			half = N / 2;

			ingredient = new int[N][N];
			visit = new boolean[N];
			A = new int[half];
			B = new int[half];
			synergy = 0;
			res = 987654321;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					ingredient[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			comb(0, 0);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());

	}

}
