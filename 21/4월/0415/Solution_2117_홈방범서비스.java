package Day210415;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2117_홈방범서비스 {
	static int N, M, ans;
	static int[][] city;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException, FileNotFoundException {
//		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 도시의 크기
			M = Integer.parseInt(st.nextToken()); // 집이 지불할 수 있는 비용

			city = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					city[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			print(city);
			// "마름모"는 BFS의 depth만큼 검색되어지는 것이기 때문에 이 문제는 BFS!
			// 각각의 좌표마다 BFS를 돌려가면서 최대한 많은 집의 갯수를 찾는 것이 포인트!

			ans = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j, new boolean[N][N]);
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void bfs(int i, int j, boolean visited[][]) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		visited[i][j] = true;

		int house = city[i][j] == 1 ? 1 : 0;
		int k = 1;
		if(getOperationFee(k) <= house * M)
			ans = k > ans ? k : ans;

		int[] temp;
		while (!q.isEmpty()) {
			int size = q.size();
			k++;

			while (--size >= 0) {
				temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (isOver(nx, ny)) {
						if (!visited[nx][ny]) {
							if (city[nx][ny] == 1)
								house++;
							q.offer(new int[] { nx, ny });
							visited[nx][ny] = true;
						}
					}

				}
			}
			if (getOperationFee(k) <= house * M) {
				ans = Math.max(ans, house);
			}

		}

	}

	private static int getOperationFee(int k) {
		return k * k + (k - 1) * (k - 1);
	}

	private static boolean isOver(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N)
			return true;
		else
			return false;
	}

}
