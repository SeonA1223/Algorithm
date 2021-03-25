package problem210325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_9205_맥주마시면서걷기 {

	private static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	private static boolean getDistance(int x1, int y1, int x2, int y2) {
		int value = Math.abs(x1 - x2) + Math.abs(y1 - y2);
		if( value / 50 <= 20) {
			if(value == 20) {
				if(value % 50 == 0)
					return true;
				else return false;
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Node> q;
		final int beerDis = 50;
		final int beerNum = 20;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int storeNum = Integer.parseInt(br.readLine());

			int[][] storeXY = new int[storeNum + 2][2];
			boolean[] visited = new boolean[storeNum + 2];

			for (int i = 0; i < storeNum + 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					storeXY[i][j] = Integer.parseInt(st.nextToken()) + 32768;
				}
			}

			int sx = storeXY[0][0], sy = storeXY[0][1];
			int ex = storeXY[storeNum + 1][0], ey = storeXY[storeNum + 1][1];

			q = new LinkedList<>();
			q.offer(new Node(sx, sy));

			Node node = null;
			boolean flag = true;
			while (!q.isEmpty()) {
				node = q.poll();

				if (getDistance(node.x, node.y, ex, ey)) {
					System.out.println("happy");
					flag = false;
					break;
				}

				for (int i = 1; i < storeNum + 2; i++) {
					if (!visited[i] && getDistance(node.x, node.y, storeXY[i][0], storeXY[i][1])) {
						visited[i] = true;
						q.offer(new Node(storeXY[i][0], storeXY[i][1]));
					}
				}

			}
			if (flag) {
				System.out.println("sad");
			}

		}
	}
}
