package Day210801;

import java.util.*;

public class Solution {
	static int dx[] = { 0, 0, 1, 1 };
	static int dy[] = { 0, 1, 0, 1 };
	static int res;
	static char blocks[][];

	public static void main(String[] args) {
		String[] temp = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		System.out.println(solution(4, 5, temp));
	}

	public static int solution(int m, int n, String[] board) {
		blocks = new char[m][n];
		res = 0;
		for (int i = 0; i < m; i++) {
			blocks[i] = board[i].toCharArray();
		}

		while (true) {
			if (checkTwoByTwo(m, n))
				break;
		}

		return res;
	}

	public static boolean checkTwoByTwo(int m, int n) {
		boolean[][] isDelete = new boolean[m][n];

		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				char c = blocks[i][j];
				boolean flag = true;
				if(c == ' ') continue;
				for (int d = 1; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];

					if (c != blocks[nx][ny]) {
						flag = false;
						break;
					}
				}

				if (flag) {
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];

						isDelete[nx][ny] = true;
					}
				}
			}
		}
		if (deleteBlocks(isDelete, m, n))
			return true;
		return false;
	}

	public static boolean deleteBlocks(boolean[][] delete, int m, int n) {
		int temp = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (delete[i][j]) {
					blocks[i][j] = ' ';
					temp++;
				}
			}
		}
		if (temp == 0)
			return true;
		else {
			res += temp;
			downBlocks(m, n);
			return false;
		}
	}

	public static void downBlocks(int m, int n) {
		Queue<Character> q = new LinkedList<>();
		for (int j = 0; j < n; j++) {
			for (int i = m - 1; i >= 0; i--) {
				if ('A' <= blocks[i][j] && blocks[i][j] <= 'Z') {
					q.add(blocks[i][j]);
				}
				blocks[i][j] = ' ';
			}
			int index = m - 1;
			while (!q.isEmpty()) {
				blocks[index--][j] = q.poll();
			}
		}
	}
}