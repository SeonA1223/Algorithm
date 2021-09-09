import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_14923_미로탈출 {
	static int N, M;
	static int sx, sy, ex, ey;
	static int[][] maze;
	static boolean[][][] visited;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int dir;
		int flag;

		public Node(int x, int y, int dir, int flag) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.flag = flag;
		}

		@Override
		public int compareTo(Node o) {
			return this.dir - o.dir;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken()) - 1;
		ey = Integer.parseInt(st.nextToken()) - 1;

		maze = new int[N][M];
		visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		0이 빈칸, 1이 벽
		if (!bfs()) {
			System.out.println(-1);
		}

	}

	private static boolean bfs() {
//		PriorityQueue<Node> pq = new PriorityQueue<>();
		Queue<Node> pq = new LinkedList<>();
		pq.add(new Node(sx, sy, 0, 0));

		Node temp;
		while (!pq.isEmpty()) {
			temp = pq.poll();
			int x = temp.x;
			int y = temp.y;
			if (visited[x][y][temp.flag])
				continue;
			visited[x][y][temp.flag] = true;
			if (x == ex && y == ey) {
				System.out.println(temp.dir);
				return true;
			}

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (0 > nx || nx >= N || 0 > ny || ny >= M)
					continue;
				if (temp.flag == 0 && maze[nx][ny] == 1) {
					pq.add(new Node(nx, ny, temp.dir + 1, 1));
				}
				if (maze[nx][ny] == 0) {
					pq.add(new Node(nx, ny, temp.dir + 1, temp.flag));
				}

			}

		}
		return false;

	}
}
