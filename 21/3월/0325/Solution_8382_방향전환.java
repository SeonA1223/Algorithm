package problem210325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8382_방향전환 {
	static class Node {
		int x, y, count, dir;

		public Node(int x, int y, int count, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.dir = dir;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = 0, x2 = 0, y1 = 0, y2 = 0;

			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;

			boolean[][][] visited = new boolean[201][201][2];
			int[] dx = { 1, -1, 0, 0 }; // 0,1 세로 2, 3 가로
			int[] dy = { 0, 0, -1, 1 };

			Queue<Node> q = new LinkedList<>();
			q.add(new Node(x1, y1, 0, 0));
			q.add(new Node(x1, y1, 0, 1));
			visited[x1][y1][0] = true;// 0은 가로
			visited[x1][y1][1] = true; // 1은 세로

			Node node = null;
			while (!q.isEmpty()) {
				node = q.poll();

				if (node.x == x2 && node.y == y2) {
					sb.append(node.count).append("\n");
					break;
				}

				if (node.dir == 0) { // 가로니까, 세로로 가기
					for (int i = 0; i < 2; i++) {
						int nx = node.x + dx[i];
						int ny = node.y + dy[i];

						if (0 <= nx && nx <= 200 && 0 <= ny && ny <= 200) {
							if (!visited[nx][ny][1]) {
								visited[nx][ny][1] = true;
								q.add(new Node(nx, ny, node.count + 1, 1));
							}
						}
					}

				} else {
					for (int i = 2; i < 4; i++) {
						int nx = node.x + dx[i];
						int ny = node.y + dy[i];

						if (0 <= nx && nx <= 200 && 0 <= ny && ny <= 200) {
							if (!visited[nx][ny][0]) {
								visited[nx][ny][0] = true;
								q.add(new Node(nx, ny, node.count + 1, 0));
							}
						}
					}

				}
			}
		}
		System.out.println(sb.toString());
	}
}
