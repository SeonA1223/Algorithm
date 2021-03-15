package problem210315;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의A형_등산로조성 {
	static int hikingTrailDis;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		boolean visited[][];

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int maxHeight = 0;
			hikingTrailDis = 0;
			visited = new boolean[N][N];
			int[][] geography = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int height = Integer.parseInt(st.nextToken());
					geography[i][j] = height;
					maxHeight = Math.max(maxHeight, height);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (geography[i][j] == maxHeight) {
						visited[i][j] = true;
						dfs(geography, visited, i, j, 1, K);
						visited[i][j] = false;
					}
				}
			}
			sb.append(hikingTrailDis).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int[][] geography, boolean[][] bs, int x, int y, int dis, int k) {
		if (hikingTrailDis < dis)
			hikingTrailDis = dis;
		// 방문을 했거나, 해당위치의 높이보다 지형이 높은 곳으로 사분면이 막혀있을 경우 return
		for (int i = 0; i < 4; i++) {
			int value = 0;
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < N && 0 <= ny && ny < N && !bs[nx][ny]) {
				if (geography[nx][ny] < geography[x][y]) {
					bs[nx][ny] = true;
					dfs(geography, bs, nx, ny, dis + 1, k);
					bs[nx][ny] = false;
				} else if ((value = geography[nx][ny] - geography[x][y] + 1) <= k) {
					if (k > 0) {
						bs[nx][ny] = true;
						geography[nx][ny] -= value;
						dfs(geography, bs, nx, ny, dis + 1, 0);
						geography[nx][ny] += value;
						bs[nx][ny] = false;
					}
				}
			}

		}
		return;
	}

}
