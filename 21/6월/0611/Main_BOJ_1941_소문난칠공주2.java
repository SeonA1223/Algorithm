package problem210611;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1941_소문난칠공주2 {
	static char[][] girlClass;
	static final int NUM = 5, SEVEN = 7;
	static int res;
	static int cnt;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		girlClass = new char[NUM][NUM];
		res = 0;

		for (int i = 0; i < NUM; i++) {
			girlClass[i] = br.readLine().toCharArray();
		}

		// 순열 25C7뽑기
		comb(0, 0, new int[7]);

		System.out.println(res);
	}

	private static void comb(int start, int index, int[] arr) {
		if (index == SEVEN) {
			if (checkScnt(arr)) {
				isAdjacent(arr);
			}
			return;
		}

		for (int i = start; i < NUM * NUM; i++) {
			arr[index] = i;
			comb(i + 1, index + 1, arr);
		}
	}

	private static void isAdjacent(int[] arr) {
		boolean[] visited = new boolean[SEVEN];
		visited[0] = true;
		cnt = 0;
		cnt++;
		dfs(0, visited, arr);
		return;
	}

	private static void dfs(int num, boolean[] visited, int[] arr) {
		if (cnt == SEVEN) {
			if (checked(visited))
				res++;
			return;
		}
		int row = arr[num] / NUM;
		int col = arr[num] % NUM;

		for (int i = 0; i < 4; i++) {
			int nx = row + dx[i];
			int ny = col + dy[i];

			if (nx < 0 || nx >= NUM || ny < 0 || ny >= NUM)
				continue;

			for (int j = 0; j < SEVEN; j++) {
				if (arr[j] == nx * NUM + ny) {
					if (!visited[j]) {
						visited[j] = true;
						cnt++;
						dfs(j, visited, arr);
					}

				}
			}
		}

	}

	private static boolean checked(boolean[] visited) {
		for (int i = 0; i < SEVEN; i++) {
			if (visited[i] == false)
				return false;
		}
		return true;
	}

	private static boolean checkScnt(int[] arr) {
		int cnt = 0;
		for (int i = 0; i < SEVEN; i++) {
			int num = arr[i];
			int row = num / NUM;
			int col = num % NUM;
			if (girlClass[row][col] == 'S')
				cnt++;
		}
		if (cnt >= 4)
			return true;
		return false;
	}
}
