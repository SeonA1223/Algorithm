package problem210218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {
	static int N;
	static int[][] customers;
	static int[] work, home;
	static int min;

	private static void perm(boolean[] isUsed, int index, int[] order) {
		if (index == N) {
//			System.out.println(Arrays.toString(order));
			min = Math.min(min, getAllDistance(order));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isUsed[i])
				continue;
			isUsed[i] = true;
			order[index] = i;
			perm(isUsed, index + 1, order);
			isUsed[i] = false;
		}
	}

	private static int getAllDistance(int[] order) {
		int distance = 0;
		distance += getDistance(work[0], customers[order[0]][0], work[1], customers[order[0]][1]);
		for (int i = 1; i < N; i++) {
			int before = order[i - 1];
			int current = order[i];
			distance += getDistance(customers[before][0], customers[current][0], customers[before][1],
					customers[current][1]);
		}
		distance += getDistance(customers[order[N-1]][0], home[0], customers[order[N-1]][1], home[1]);
		return distance;

	}

	private static int getDistance(int x1, int x2, int y1, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 고객의 수
			customers = new int[N][2];
			st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				work = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
				home = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
				for (int i = 0; i < N; i++) {
					customers[i][0] = Integer.parseInt(st.nextToken());
					customers[i][1] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			perm(new boolean[N], 0, new int[N]);
			System.out.println("#" + tc + " " + min);

		}
	}

}
