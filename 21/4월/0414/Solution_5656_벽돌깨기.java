package Day210414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {
	static int N, W, H;
	static int[][] arr;
	static int count;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken()); // 구술 n번
			W = Integer.parseInt(st.nextToken()); // 열
			H = Integer.parseInt(st.nextToken()); // 행

			arr = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 중복순열
			count = W * H;
			perm(new int[N], 0);
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void perm(int[] order, int cnt) {
		if (cnt == N) {
			simulation(order);
			return;
		}
		for (int i = 0; i < W; i++) {
			order[cnt] = i;
			perm(order, cnt + 1);
		}

	}

	private static int[][] copymap(int[][] arr) {
		int temp[][] = new int[H][W];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}

	private static void simulation(int[] order) {
		int[][] temp = copymap(arr);

		for (int i = 0; i < N; i++) { // 구슬 부수기
			// 특정위치에서 맨위에 있는 구슬 부시기
			int x = 0;
			int y = order[i];

			while (x < H) {
				if (temp[x][y] > 1) {
					temp = breakBrick(x, y, temp);
					break;
				} else if (temp[x][y] == 1) {
					temp[x][y] = 0;
					break;
				} else
					x += 1;
			}
		}

		// 다 부시고 나서 벽돌 갯수 세기
		count = Math.min(count, countBrick(temp));
	}

	private static int countBrick(int[][] temp) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (temp[i][j] > 0)
					count++;
			}
		}
		return count;

	}

	private static int[][] breakBrick(int sx, int sy, int[][] arr) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sx, sy });

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];

			int c = arr[x][y];
			arr[x][y] = 0;
			for (int i = 0; i < 4; i++) {
				int nx = x;
				int ny = y;
				for (int j = 0; j < c - 1; j++) {
					nx += dx[i];
					ny += dy[i];

					if (nx < 0 || nx >= H || ny < 0 || ny >= W)
						break;

					if (arr[nx][ny] == 1)
						arr[nx][ny] = 0;
					else if (arr[nx][ny] > 1) {
						q.offer(new int[] { nx, ny });
					}

				}
			}

		}

		// 빈공간이 있을 경우 벽돌 밑으로 떨어트리기
		checkEmptySpace(arr);
		return arr;

	}

	private static void checkEmptySpace(int[][] arr) {
		// 열중심으로 행 W -> 0 으로 하나씩 보기
		for (int j = 0; j < W; j++) {
			int i = H - 1;
			while (i > 0) {
				if (arr[i][j] == 0) {
					int ni = i - 1;
					while (ni > 0 && arr[ni][j] == 0)
						ni--;
					arr[i][j] = arr[ni][j];
					arr[ni][j] = 0;
				}
				i--;
			}
		}

	}
}
