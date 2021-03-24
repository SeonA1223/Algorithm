package problem210324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1600_말이되코픈원숭이 {
	static class Node {
		int x, y;
		int count;
		int k;

		public Node(int x, int y, int count, int k) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.k = k;
		}

	}

	private static boolean isValid(int x, int y, int W, int H) {
		if (0 <= x && x < W && 0 <= y && y < H)
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][] arr = new int[H][W];
		int[][] alldir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		int[][] knight = { { -2, -1 }, { -1, -2 }, { -2, 1 }, { -1, 2 }, { 1, -2 }, { 2, -1 }, { 1, 2 }, { 2, 1 } };
		boolean[][][] visited = new boolean[K+1][H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int min = Integer.MAX_VALUE;

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0, 0));

		while (!q.isEmpty()) {

			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			int count = node.count;
			int k = node.k;

			if (x == H - 1 && y == W - 1) {
				System.out.println(count);
				return;

			}

			if (k + 1 <= K) {
				for (int i = 0; i < knight.length; i++) {
					int nx = x + knight[i][0];
					int ny = y + knight[i][1];

					if (isValid(nx, ny, H, W) && !visited[k + 1][nx][ny] && arr[nx][ny] != 1) {
						visited[k + 1][nx][ny] = true;
						q.add(new Node(nx, ny, count + 1, k + 1));
					}

				}
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + alldir[i][0];
				int ny = y + alldir[i][1];

				if (isValid(nx, ny, H, W) && !visited[k][nx][ny] && arr[nx][ny] != 1) {
					visited[k][nx][ny] = true;
					q.add(new Node(nx, ny, count + 1, k));
				}
			}

		}
		System.out.println("-1");
	}
}
