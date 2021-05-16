package Day210516;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_4991_로봇청소기2 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static List<int[]> dirty;
	static int cnt;
	static int[][] dis;
	static char arr[][];
	static int N, M;

	public static class Node {
		int x;
		int y;
		int move;

		public Node(int x, int y, int move) {
			super();
			this.x = x;
			this.y = y;
			this.move = move;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0)
				break;

			dirty = new ArrayList<>();
			arr = new char[N][M];
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == '*') {
						dirty.add(new int[] { i, j });
					} else if (arr[i][j] == 'o') {
						dirty.add(0, new int[] { i, j });
					}
				}
			}

			cnt = dirty.size();
			// 각각 거리 계산하기
			dis = new int[cnt][cnt];
			if (!getDistance()) {
				System.out.println("-1");
			} else {

				System.out.println(res());

			}

		}
	}

	private static int res() {

		boolean visited[] = new boolean[cnt];
		int cur = 0;
		visited[cur] = true;

		int res = 0;

		for (int i = 0; i < cnt; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int j = 0; j < cnt; j++) {
				if (!visited[j] && min > dis[cur][j]) {
					min = dis[cur][j];
					minIndex = j;
				}
			}
			if(min == Integer.MAX_VALUE) break;
			res += min;
			visited[minIndex] = true;
			cur = minIndex;

		}
		return res;
	}

	private static boolean getDistance() {
		for (int i = 0; i < cnt; i++) {
			for (int j = i + 1; j < cnt; j++) {
				int distance = bfs(dirty.get(i), dirty.get(j));
				if (distance == -1) {
					return false;
				}
				dis[i][j] = dis[j][i] = distance;
			}
		}
		return true;

	}

	private static int bfs(int[] start, int[] end) {
		Queue<Node> q = new LinkedList<>();
		boolean visited[][] = new boolean[N][M];
		q.offer(new Node(start[0], start[1], 0));
		visited[start[0]][start[1]] = true;

		Node temp;
		int res = -1;
		while (!q.isEmpty()) {
			temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			int move = temp.move;

			if (x == end[0] && y == end[1]) {
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

				if (!visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny, move + 1));
				}

			}
		}
		return res;
	}
}
