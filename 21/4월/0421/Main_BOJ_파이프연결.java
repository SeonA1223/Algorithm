package Day210421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_파이프연결 {
	static int N;

	public static class Node {
		int x, y;
		int dir;
		int[][] map;

		public Node(int x, int y, int dir, int[][] map) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.map = map;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 가로면 가로랑 대각선으로 갈 수 있다.
		// 대각선이면 가로,세로, 대각선 갈 수있다.
		// 세로면 세로랑 대각선

		// 가기전에 주변을 살펴야한다.
		// 특히 대가선인경우 가고 나서도, (nx-1, ny), (nx, ny-1)를 체크해주기
		int[][] move = { { 0, 1 }, { 0, 1, 2 }, { 1, 2 } }; // 0 : 가로 1: 대각선 2: 세로
		int[][] dir = { { 0, 1 }, { 1, 1 }, { 1, 0 } };
		N = Integer.parseInt(br.readLine());
		int[][] pipeMap = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pipeMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pipeMap[0][0] = 1;
		pipeMap[0][1] = 1;
		int cases = 0;

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 1, 0, pipeMap));

		Node node;
		int[][] temp = null;
		while (!q.isEmpty()) {
			node = q.poll();
			int x = node.x;
			int y = node.y;
			int fw = node.dir;
			temp = node.map;

			for (int i = 0; i < move[fw].length; i++) {
				int d = move[fw][i];
				int nx = x + dir[d][0];
				int ny = y + dir[d][1];

				if (nx == N - 1 && ny == N - 1) {
					cases++;
					continue;
				}

				if (isRange(nx, ny)) {
					if (temp[nx][ny] != 1) {
						if(d == 1) {
							if(temp[nx-1][ny] == 1 && temp[nx][ny-1] == 1)
								temp[nx][ny] = 1;
						}else {
							temp[nx][ny] = 1;
						}
						q.offer(new Node(nx, ny, d, temp));
					}
				}
			}

		}
		System.out.println(cases);
	}

	private static boolean isRange(int nx, int ny) {
		if (0 <= nx && nx < N && 0 <= ny && ny < N)
			return true;
		return false;
	}

}
