package problem210618;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16234_인구이동 {
	static int N, L, R, res;
	static int[][] arr;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		res = 0;
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			boolean[][] visited = new boolean[N][N];
			// 이중포문이 한번에 인구이동
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						if (bfs(i, j, visited))
							flag = true;
					}
				}
			}
			if (flag)
				res++;
			else
				break;

		}

		System.out.println(res);
	}

	private static boolean bfs(int i, int j, boolean[][] visited) {
		Queue<int[]> checked = new LinkedList<>();
//		boolean checked[][] = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		checked.offer(new int[] { i, j });
		visited[i][j] = true;
//		checked[i][j] = true;

		int[] temp;
		int add = 0;
		while (!q.isEmpty()) {
			temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			int pop = arr[x][y];
			add += pop;

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
					continue;
				int diff = Math.abs(pop - arr[nx][ny]);
				if (L <= diff && diff <= R) {
					visited[nx][ny] = true;
//					checked[nx][ny] = true;
					checked.offer(new int[] { nx, ny });
					q.offer(new int[] { nx, ny });

				}

			}
		}

		if (checked.size() > 1) {
			int absadd = add / checked.size();
//			for (int k = 0; k < N; k++) {
//				for (int k2 = 0; k2 < N; k2++) {
//					if (checked[k][k2]) {
//						arr[k][k2] = absadd;
//					}
//				}
//			}

			while (!checked.isEmpty()) {
				int[] loc = checked.poll();
				arr[loc[0]][loc[1]] = absadd;

			}

			return true;
		}
		return false;

	}
}
