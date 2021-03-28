package problem210328;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1261_알고스팟 {

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

//		@Override
//		public int compareTo(Node o) {
//			return this.count > o.count ? 1 : this.count == o.count ? 0 : -1;
//		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken()); // 가로크기
		int N = Integer.parseInt(st.nextToken()); // 세로크기
		int res = 987654321;
		Queue<Node> q = new LinkedList<>();

		int arr[][] = new int[N][M];
		int visited[][] = new int[N][M];

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
				visited[i][j] = -1;
			}
		}

		q.offer(new Node(0, 0));
		visited[0][0] = 0;

		Node node = null;
		while (!q.isEmpty()) {
			node = q.poll();
			int x = node.x;
			int y = node.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 > nx || nx >= N || 0 > ny || ny >= M)
					continue;

				if (arr[nx][ny] == 1) {
					if (visited[nx][ny] == -1 || visited[nx][ny] > visited[x][y] + 1) {
						visited[nx][ny] = visited[x][y] + 1;
						q.offer(new Node(nx, ny));
					}
				} else {
					if (visited[nx][ny] == -1 || visited[nx][ny] > visited[x][y]) {
						visited[nx][ny] = visited[x][y];
						q.offer(new Node(nx, ny));
					}
				}
			}

		}

		System.out.println(visited[N-1][M-1]);

	}

}
