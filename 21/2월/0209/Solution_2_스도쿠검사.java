package problem210209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2_스도쿠검사 {
	static int ans;
	static boolean[] checked;
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0, 0};
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1, 0 };

	private static boolean rowCheck(int[][] sudoku) {
		for (int i=0; i < 9; i++) {
			for (int j = 0; j <9; j++) {
				checked[sudoku[i][j]] = true;
			}
			if (!checkTrue(checked)) {
				return false;
			} else {
				Arrays.fill(checked, false);
			}
		}
		return true;
	}

	private static boolean colCheck(int[][] sudoku) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j <9; j++) {
				checked[sudoku[j][i]] = true;
			}
			if (!checkTrue(checked)) {
				return false;
			} else {
				Arrays.fill(checked, false);
			}
		}
		return true;
	}

	private static boolean smallBoxCheck(int[][] sudoku) {
		for (int i = 1; i < 9; i += 3) {
			for (int j = 1; j < 9; j += 3) {
				for (int k = 0; k < 9; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					checked[sudoku[nx][ny]] = true;
				}
				if (!checkTrue(checked)) {
					return false;
				} else {
					Arrays.fill(checked, false);
				}
			}
		}
		return true;
	}

	private static boolean checkTrue(boolean[] check) {
		boolean flag = true;
		for (int i=1; i<=9; i++) {
			if (check[i] == false)
				flag = false;
		}
		return flag;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		checked = new boolean[10];

		for (int tc = 1; tc <= T; tc++) {
			int[][] sudoku = new int[9][9];

			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (rowCheck(sudoku) && colCheck(sudoku) && smallBoxCheck(sudoku)) {
				ans = 1;
			} else
				ans = 0;

			sb.append("#").append(tc).append(" ").append(ans).append("\n");

		}
		System.out.println(sb.toString());
	}

}
