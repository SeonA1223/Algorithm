package Day210609;

import java.util.Scanner;

public class Solution_4355_무인도탈출 {
	static int[][][] arr;
	static int boxNum, maxHeight;
	static final int maxLength = 10_000;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int T = 1; T <= tc; T++) {
			boxNum = sc.nextInt();
			arr = new int[boxNum][3][3];
			maxHeight = 0;

			for (int j = 0; j < boxNum; j++) {
				int width = sc.nextInt();
				int length = sc.nextInt();
				int height = sc.nextInt();

				arr[j][0][0] = width;
				arr[j][0][1] = length;
				arr[j][0][2] = height;

				arr[j][1][0] = height;
				arr[j][1][1] = width;
				arr[j][1][2] = length;

				arr[j][2][0] = length;
				arr[j][2][1] = height;
				arr[j][2][2] = width;

			}
			// 부분집합 후 순열
			makeTop(1 << boxNum, 0, maxLength, maxLength);
			System.out.println("#" + T + " " + maxHeight);
		}

	}

	private static void makeTop(int visited, int curHeight, int curWidth, int curLength) {
		if (curHeight > maxHeight) {
			maxHeight = curHeight;
		}

		for (int i = 0; i < boxNum; i++) {
			if ((visited & 1 << i) != 0)
				continue;
			for (int j = 0; j < 3; j++) {
				if (curWidth * curLength >= arr[i][j][1] * arr[i][j][2]
						&& (curWidth >= arr[i][j][1] && curLength >= arr[i][j][2])
						|| (curWidth >= arr[i][j][2] && curLength >= arr[i][j][1])) {
					makeTop(visited | 1 << i, curHeight + arr[i][j][0], arr[i][j][1], arr[i][j][2]);
				}
			}

		}

	}

}
//685 375 8 113

//375
