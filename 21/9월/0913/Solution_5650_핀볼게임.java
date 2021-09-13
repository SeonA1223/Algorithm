package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5650_핀볼게임 {
	static int[] dx = { -1, 1, 0, 0 }; // 위, 아래, 왼, 오
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] moveDirection;
	static int[][] warmHoles;
	static int[][] board;
	static int N;
	static int maxMove;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		moveDirection = new int[6][4];

		moveDirection[1][0] = 1;
		moveDirection[1][1] = 3;
		moveDirection[1][2] = 0;
		moveDirection[1][3] = 2;
		moveDirection[2][0] = 3;
		moveDirection[2][1] = 0;
		moveDirection[2][2] = 1;
		moveDirection[2][3] = 2;
		moveDirection[3][0] = 2;
		moveDirection[3][1] = 0;
		moveDirection[3][2] = 3;
		moveDirection[3][3] = 1;
		moveDirection[4][0] = 1;
		moveDirection[4][1] = 2;
		moveDirection[4][2] = 3;
		moveDirection[4][3] = 0;
		moveDirection[5][0] = 1;
		moveDirection[5][1] = 0;
		moveDirection[5][2] = 3;
		moveDirection[5][3] = 2;

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			maxMove = 0;
			warmHoles = new int[5][4];

			for (int i = 0; i < 5; i++) {
				Arrays.fill(warmHoles[i], -1);
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] > 5) {
						int num = board[i][j] - 6;
						if (warmHoles[num][0] != -1) {
							warmHoles[num][2] = i;
							warmHoles[num][3] = j;
						} else {
							warmHoles[num][0] = i;
							warmHoles[num][1] = j;
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int d = 0; d < 4; d++) {
						if (board[i][j] == 0) {
							runPinballGame(i, j, d);
						}
					}
				}
			}

			sb.append(maxMove).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void runPinballGame(int sx, int sy, int dir) {
		int d = dir;
		int nx = sx;
		int ny = sy;
		int cnt = 0;
		while (true) {
			nx += dx[d];
			ny += dy[d];
			
			if (0 > nx || nx >= N || 0 > ny || ny >= N) {
				d = moveDirection[5][d];
				cnt++;
				continue;
			}

			if (board[nx][ny] == -1 || nx == sx && ny == sy) {
				maxMove = Math.max(maxMove, cnt);
				break;
			}


			
			if (1 <= board[nx][ny] && board[nx][ny] <= 5) {
				cnt++;
				d = moveDirection[board[nx][ny]][d];
			} else if (board[nx][ny] > 5) {
				int number = board[nx][ny] - 6;
				int x1 = warmHoles[number][0];
				int y1 = warmHoles[number][1];
				int x2 = warmHoles[number][2];
				int y2 = warmHoles[number][3];
				if (nx == x1 && ny == y1) {
					nx = x2;
					ny = y2;
				} else {
					nx = x1;
					ny = y1;
				}
			}
		}
	}
}
