package problem210621;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_4991_로봇청소기 {
	static int W, H, ALL;
	static char[][] room;
	static int[][] temp;
	static int[] robot;
	static boolean[][][] visited;

	static class Node {
		int x, y;
		int cnt;
		int clean;

		public Node(int x, int y, int cnt, int clean) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.clean = clean;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			if (H == 0 && W == 0)
				return;
			room = new char[W][H];
			temp = new int[W][H];

			int dirtyCnt = 0;
			for (int i = 0; i < W; i++) {
				room[i] = br.readLine().toCharArray();
				for (int j = 0; j < H; j++) {
					temp[i][j] = 0;
					if (room[i][j] == 'o') {
						robot = new int[] { i, j };
					} else if (room[i][j] == '*') {
						temp[i][j] = ++dirtyCnt;

					} else if (room[i][j] == 'x') {
						temp[i][j] = -1;
					}

				}
			}
			
			
			visited = new boolean[W][H][1 << dirtyCnt + 1];
			ALL = (1 << dirtyCnt + 1) - 1;

			System.out.println(bfs());
		}
	}

	private static int bfs() {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(robot[0], robot[1], 0, 1));
		visited[robot[0]][robot[1]][0] = true;

		Node node;
		while (!q.isEmpty()) {
			node = q.poll();
			if (node.clean == ALL) {
				return node.cnt;
			}
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];

				if (nx < 0 || nx >= W || ny < 0 || ny >= H)
					continue;
				if (temp[nx][ny] == -1)
					continue;
				if (temp[nx][ny] > 0) { // 더러운 부분이라면
					int check = node.clean | (1 << temp[nx][ny]);
					if(visited[nx][ny][check]) continue;
					visited[nx][ny][check] = true;
					q.add(new Node(nx, ny, node.cnt + 1, check));
				}
				if (temp[nx][ny] == 0) {
					if(visited[nx][ny][node.clean]) continue;
					visited[nx][ny][node.clean] = true;
					q.add(new Node(nx, ny, node.cnt + 1, node.clean));
				}
			}
		}
		return -1;

	}
}
