package problem210623;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_6087_레이저통신 {
	static int W, H;
	static char[][] map;
	static int[][] lazer;
	static int minMirror;

	static class Node implements Comparable<Node> {
		int x, y;
		int mirrorCnt;
		int dir;

		public Node(int x, int y, int mirrorCnt, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.mirrorCnt = mirrorCnt;
			this.dir = dir;
		}

		@Override
		public int compareTo(Node o) {
			return this.mirrorCnt - o.mirrorCnt;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		map = new char[W][H];
		lazer = new int[2][2];
		int lazerCnt = 0;

		for (int i = 0; i < W; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < H; j++) {
				if (map[i][j] == 'C') {
					lazer[lazerCnt][0] = i;
					lazer[lazerCnt][1] = j;
					lazerCnt++;
				}
			}
		}
		minMirror = Integer.MAX_VALUE;
		bfs();
		System.out.println(minMirror);
	}

	private static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[W][H];
		int dx[] = new int[] { -1, 1, 0, 0 };
		int dy[] = new int[] { 0, 0, 1, -1 };
		pq.add(new Node(lazer[0][0], lazer[0][1], 0, -1));
//		visited[lazer[0][0]][lazer[0][1]] = true;

		Node temp = null;
		while (!pq.isEmpty()) {
			temp = pq.poll();
			if (visited[temp.x][temp.y])
				continue;
			visited[temp.x][temp.y] = true;
			if(map[temp.x][temp.y] == '*') continue;

			if (temp.x == lazer[1][0] && temp.y == lazer[1][1]) {
				minMirror = Math.min(minMirror, temp.mirrorCnt);
			}

			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if (nx < 0 || nx >= W || ny < 0 || ny >= H)
					continue;
				if (map[nx][ny] == '*')
					continue;
				if (visited[nx][ny])
					continue;
				if (temp.dir == -1) {
					pq.offer(new Node(nx, ny, 0, i));
				} else {
					if (temp.dir == i) {
						pq.offer(new Node(nx, ny, temp.mirrorCnt, i));
					}else {
						pq.offer(new Node(nx, ny, temp.mirrorCnt+1, i));
					}
				}
			}
		}

	}
}
