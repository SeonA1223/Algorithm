package problem210216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1074_Z {
	static int count = 0;
	static int r, c;

	private static void divide(int x, int y, int[][] arr, int value) {
		if (value <= 2) {
			solve(x, y, arr, value);
			return;
		}
		for (int i = x; i < x + value; i += value / 2) {
			for (int j = y; j < y + value; j += value / 2) {
				divide(i, j, arr, value / 2);
			}
		}
	}

	private static void solve(int x, int y, int[][] arr, int value) {
		for (int i = x; i < x + value; i++) {
			for (int j = y; j < y + value; j++) {
				if (i == r && j == c) {
					System.out.println(count);
					System.exit(0);
				}
				count++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int value = (int) Math.pow(2, N);
		int arr[][] = new int[value][value]; //배열을 정의했을 때, 메모리 초과가 남. 배열 정의 X 해야함

		for (int i = 0; i < value; i += value / 2) {
			for (int j = 0; j < value; j += value / 2) {
				divide(i, j, arr, value / 2);
			}
		}
	}

}
