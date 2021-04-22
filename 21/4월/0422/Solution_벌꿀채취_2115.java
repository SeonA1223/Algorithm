package Day210422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_벌꿀채취_2115 {
	static int N, M, C;
	static int[][] honey;
	static int MAX_PROFIT, MaxA, MaxB, sumAll;
	static List<int[]> listA, listB;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 전체크기
			M = Integer.parseInt(st.nextToken()); // 얻을 수 있는 꿀통갯수
			C = Integer.parseInt(st.nextToken());

			honey = new int[N][N];
			MAX_PROFIT = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					honey[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					sumAll =0;
					subset(i, j, 0, 0, 0);
					MaxA = sumAll;

					for (int k = j + M; k <= N - M; k++) {
						sumAll = 0;
						subset(i, k, 0, 0, 0);
						MaxB = sumAll;
						MAX_PROFIT = Math.max(MAX_PROFIT, MaxA + MaxB);
					}
					for (int i2 = i + 1; i2 < N; i2++) {
						for (int j2 = 0; j2 <= N - M; j2++) {
							sumAll=0;
							subset(i2, j2, 0, 0, 0);
							MaxB = sumAll;
							MAX_PROFIT = Math.max(MAX_PROFIT, MaxA + MaxB);
						}
					}
				}
			}
			sb.append(MAX_PROFIT).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void subset(int row, int col, int index, int sum, int pow) {
		if (sum > C)
			return;
		
		if (index == M) {
			sumAll = Math.max(sumAll, pow);
			return;
		}

		//합일 때는 이 거 사용, 현재 값 선택했을 때
		subset(row, col + 1, index + 1, sum + honey[row][col], pow + honey[row][col] * honey[row][col]);
		//현재값 선택안할 때
		subset(row, col + 1, index + 1, sum, pow);

	}
}
