package Day210415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] pipe = { {}, { 0, 1, 2, 3 }, { 1, 3 }, { 0, 2 }, { 0, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append(bfs()).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { R, C });
		visited[R][C] = true;

		int count = 1;
		int size;
		int time = 1;
		int[] temp;

		while (!q.isEmpty()) {
			if (time == L)
				break;
			size = q.size();
			for (int i = 0; i < size; i++) {
				temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				int n = map[x][y];

				for (int j = 0; j < pipe[n].length; j++) {
					int d = pipe[n][j];
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (0 > nx || nx >= N || 0 > ny || ny >= M || map[nx][ny] == 0 || visited[nx][ny] == true) // 범위
																												// 벗어나거나,
																												// 터널이
						// 없을 경우
						continue;

					// 다음 위치에 있는 터널 구조물 타입과 연결이 되야함
					// 우 -> 좌가 있는지 check 0, 2
					// 좌 -> 우 2,0
					// 상 -> 하 3, 1
					// 하 -> 상 1, 3

					int l = (d + 2) % 4;
					for (int k = 0; k < pipe[map[nx][ny]].length; k++) {
						if (pipe[map[nx][ny]][k] == l) {
							q.offer(new int[] { nx, ny });
							visited[nx][ny] = true;
							count++;
						}
					}

				}

			}
			++time;

		}
		return count;

	}
}
