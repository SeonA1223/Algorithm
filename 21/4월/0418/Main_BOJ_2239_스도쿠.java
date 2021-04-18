package Day210418;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_BOJ_2239_스도쿠 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] sudoku = new int[9][9];

		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < sudoku.length; j++) {
				int value = s.charAt(j) - '0';
				sudoku[i][j] = value;
			}
		}

		dfs(sudoku);
		print(sudoku);

	}

	private static void print(int[][] ans) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean dfs(int[][] sudoku) {
		Point point = finishSudoku(sudoku);
		if (point == null) {
			return true;
		}

		boolean[] visited = new boolean[10];
		// rowcheck
		rowCheck(point.x, point.y, sudoku, visited);
		// colcheck
		colCheck(point.x, point.y, sudoku, visited);
		// boxcheck
		boxCheck(point.x, point.y, sudoku, visited);
		
		if(checkAllTrue(visited)) return false;

		for (int k = 1; k <= 9; k++) {
			if (!visited[k]) {
				sudoku[point.x][point.y] = k;

				if (dfs(sudoku))
					return true;
			}
		}
		sudoku[point.x][point.y] = 0;
		return false;

	}

	private static boolean checkAllTrue(boolean[] checked) {
		for (int i = 1; i < 10; i++) {
			if(checked[i] == false) return false;
		}
		return true;
	}
	
	
	private static void boxCheck(int x, int y, int[][] sudoku, boolean[] visited) {
		for (int i = x/3 * 3; i < x/3*3 + 3; i++) {
			for (int j = y/3 * 3; j < y/3 * 3 + 3; j++) {
				visited[sudoku[i][j]] = true;
			}
		}
	}

//	private static void boxCheck(int i, int j, int[][] sudoku, boolean[] visited) {
//		if (0 <= i && i < 3) {
//			if (0 <= j && j < 3) {
//				for (int x = 0; x < 3; x++) {
//					for (int y = 0; y < 3; y++) {
//						visited[sudoku[x][y]] = true;
//					}
//				}
//			} else if (3 <= j && j < 6) {
//				for (int x = 0; x < 3; x++) {
//					for (int y = 3; y < 6; y++) {
//						visited[sudoku[x][y]] = true;
//					}
//				}
//			} else if (6 <= j && j < 9) {
//				for (int x = 0; x < 3; x++) {
//					for (int y = 6; y < 9; y++) {
//						visited[sudoku[x][y]] = true;
//					}
//				}
//			}
//		} else if (3 <= i && i < 6) {
//			if (0 <= j && j < 3) {
//				for (int x = 3; x < 6; x++) {
//					for (int y = 0; y < 3; y++) {
//						visited[sudoku[x][y]] = true;
//					}
//				}
//			} else if (3 <= j && j < 6) {
//				for (int x = 3; x < 6; x++) {
//					for (int y = 3; y < 6; y++) {
//						visited[sudoku[x][y]] = true;
//					}
//				}
//			} else if (6 <= j && j < 9) {
//				for (int x = 3; x < 6; x++) {
//					for (int y = 6; y < 9; y++) {
//						visited[sudoku[x][y]] = true;
//					}
//				}
//			}
//
//		} else if (6 <= i && i < 9) {
//			if (0 <= j && j < 3) {
//				for (int x = 6; x < 9; x++) {
//					for (int y = 0; y < 3; y++) {
//						visited[sudoku[x][y]] = true;
//					}
//				}
//			} else if (3 <= j && j < 6) {
//				for (int x = 6; x < 9; x++) {
//					for (int y = 3; y < 6; y++) {
//						visited[sudoku[x][y]] = true;
//					}
//				}
//			} else if (6 <= j && j < 9) {
//				for (int x = 6; x < 9; x++) {
//					for (int y = 6; y < 9; y++) {
//						visited[sudoku[x][y]] = true;
//					}
//				}
//			}
//		}
//
//	}

	private static void colCheck(int i, int j, int[][] sudoku, boolean[] visited) {
		for (int k = 0; k < 9; k++) {
			visited[sudoku[k][j]] = true;
		}

	}

	private static void rowCheck(int i, int j, int[][] sudoku, boolean[] visited) {
		for (int k = 0; k < 9; k++) {
			if (!visited[sudoku[i][k]]) {
				visited[sudoku[i][k]] = true;
			}
		}

	}

	static Point finishSudoku(int[][] sudoku) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0)
					return new Point(i, j);
			}
		}
		return null;
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
