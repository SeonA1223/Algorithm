package problem210210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935 {
	static int arr[][], result[][];// 입력값이자
	static int N, M;

	private static void Left90Rotate() {
		int n = arr.length;
		int m = arr[0].length;
		int[][] result = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[m - 1 - j][i] = arr[i][j];
//				int tmp = arr[i][j];
//				arr[i][j] = arr[j][i];
//				arr[j][i] = tmp;
			}
		}
		arr = result;

	}

	private static void Right90Rotate() {
		int m= arr[0].length;
		int n = arr.length;
		int[][] result = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[j][n - 1 - i] = arr[i][j];
//				int tmp = arr[i][j];
//				arr[i][j] = arr[j][N - 1 - i];
//				arr[j][N - 1 - i] = tmp;
			}
		}
		arr = result;
	}

	private static void LeftRightReverse() {
		int n = arr.length;
		int m = arr[0].length;
		for (int j = 0; j < m / 2; j++) {
			for (int i = 0; i < n; i++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[i][m - 1 - j];
				arr[i][m - 1 - j] = tmp;

			}
		}

	}

	private static void UpDownReverse() {
		int n = arr.length;
		int m = arr[0].length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[n - 1 - i][j];
				arr[n - 1 - i][j] = temp;
			}
		}

	}

	private static void CounterClockwise() {
		int n = arr.length / 2;
		int m = arr[0].length / 2;
		int[][] result = new int[arr.length][arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (i < n && j < m) { //1
					result[i+n][j] = arr[i][j];
				}
				if (i < n && j >= m) {//2
					result[i][j-m] = arr[i][j];
				}
				if (i >= n && j >= m) {//3
					result[i-n][j] = arr[i][j];
				}
				if (i >= n && j < m) {//4
					result[i][j+m] = arr[i][j];
				}
			}
		}
		arr = result;

	}

	private static void Clockwise() {
		int n = arr.length / 2;
		int m = arr[0].length / 2;
		int[][] result = new int[arr.length][arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (i < n && j < m) {
					result[i][j + m] = arr[i][j];
				}
				if (i < n && j >= m) {
					result[i + n][j] = arr[i][j];
				}
				if (i >= n && j >= m) {
					result[i][j - m] = arr[i][j];
				}
				if (i >= n && j < m) {
					result[i - n][j] = arr[i][j];
				}
			}
		}
		arr = result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 배열의 크기 행
		M = Integer.parseInt(st.nextToken()); // 배열의 크기 열
		int R = Integer.parseInt(st.nextToken()); // 수행해야 하는 연산의 수

		arr = new int[N][M];
		int select[] = new int[R];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < R; i++) {
			select[i] = Integer.parseInt(st.nextToken());
			switch (select[i]) {
			case 1:
				UpDownReverse();
				break;
			case 2:
				LeftRightReverse();
				break;
			case 3:
				Right90Rotate();
				break;
			case 4:
				Left90Rotate();
				break;
			case 5:
				Clockwise();
				break;
			case 6:
				CounterClockwise();
				break;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
