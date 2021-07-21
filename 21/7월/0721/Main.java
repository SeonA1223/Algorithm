package Day210721;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K, R, res;
	static boolean[][][][] roads;
	static Node[] nodes;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		res = 0;
		roads = new boolean[N + 1][N + 1][N + 1][N + 1];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			roads[a][b][c][d] = true;
			roads[c][d][a][b] = true;
		}

		nodes = new Node[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(x, y);
		}

		comb(0, 0, new int[2]);
		System.out.println(res);

	}

	private static void comb(int index, int cnt, int[] twoCows) {
		if (cnt == 2) {
			if (canCrossNotRoad(twoCows))
				res++;
			return;
		}

		for (int i = index; i < K; i++) {
			twoCows[cnt] = i;
			comb(i + 1, cnt + 1, twoCows);

		}
	}

	private static boolean canCrossNotRoad(int[] twoCows) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[N + 1][N + 1];
		int sIndex = twoCows[0];
		int eIndex = twoCows[1];
		int sx = nodes[sIndex].x;
		int sy = nodes[sIndex].y;
		visited[sx][sy] = true;

		q.add(new Node(sx, sy));

		Node node;
		while (!q.isEmpty()) {
			node = q.poll();
			int x = node.x;
			int y = node.y;

			if (x == nodes[eIndex].x && y == nodes[eIndex].y) {
				return false;
			}

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx <= 0 || nx > N || ny <= 0 || ny > N)
					continue;
				if (visited[nx][ny])
					continue;
				if (roads[x][y][nx][ny])
					continue;

				visited[nx][ny] = true;
				q.add(new Node(nx, ny));
			}

		}
		return true;

	}
}
