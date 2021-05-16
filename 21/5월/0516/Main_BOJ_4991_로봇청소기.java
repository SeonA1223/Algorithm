package Day210516;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_4991_로봇청소기 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static class Node implements Comparable<Node> {
		int x;
		int y;
		int move;
		int clean;

		public Node(int x, int y, int move, int clean) {
			super();
			this.x = x;
			this.y = y;
			this.move = move;
			this.clean = clean;
		}

		@Override
		public int compareTo(Node o) {
			return this.move - o.move;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0)
				break;
			
			Map<Integer, Integer> map = new HashMap<>();

			int dirty = 0;
			int sx = 0;
			int sy = 0;
			char arr[][] = new char[N][M];
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == '*') {
						map.put(i * M + j, dirty++);
					} else if (arr[i][j] == 'o') {
						sx = i;
						sy = j;
					}
				}
			}

			boolean visited[][][] = new boolean[1<<dirty][N][M];

			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(sx, sy, 0, 0));

			Node temp;
			int res = -1;
			while (!pq.isEmpty()) {
				temp = pq.poll();

				int x = temp.x;
				int y = temp.y;
				int move = temp.move;
				int clean = temp.clean;

				if (clean == (1 << dirty)-1) {
					res = move;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;
					if (arr[nx][ny] == 'x')
						continue;

					if (arr[nx][ny] == '.') {
						if (!visited[clean][nx][ny]) {
							visited[clean][nx][ny] = true;
							pq.offer(new Node(nx, ny, move + 1, clean));
						}
					}

					if (arr[nx][ny] == '*') {
						int index = nx * M + ny;
						int num = map.get(index);
						if ((clean & (1 << num)) == 0) {
							visited[clean][nx][ny] = true;
							clean |= (1 << num);
							pq.offer(new Node(nx, ny, move + 1, clean));
						}
					}
				}
			}
			System.out.println(res);
		}
	}
}
