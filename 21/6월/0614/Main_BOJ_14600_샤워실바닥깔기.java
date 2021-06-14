package problem210614;

import java.util.Scanner;

public class Main_BOJ_14600_샤워실바닥깔기 {
	static int K, cnt;
	static int tile[][];
	static int[][] putTile = { {}, { 1, 1 }, { 1, 0 }, { 0, 1 }, { 0, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		int holeX = sc.nextInt();
		int holeY = sc.nextInt();

		int leng = 1 << K;
		tile = new int[leng + 1][leng + 1];// 1부터 시작

		int revHoleY = leng + 1 - holeY;
		tile[revHoleY][holeX] = -1;

		cnt = 0;
		makeTile(1, 1, leng, 1);
		cnt++;
		for (int i = 1; i <= leng; i++) {
			for (int j = 1; j <= leng; j++) {
				if (tile[i][j] == 0)
					tile[i][j] = cnt;
				System.out.print(tile[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void makeTile(int x, int y, int leng, int loc) {
		if (leng == 2) {
			cnt++;
			boolean findhole = false;
			for (int i = x; i < x + leng; i++) {
				for (int j = y; j < y + leng; j++) {
					if (tile[i][j] == -1) {
						findhole = true;
						break;
					}
				}
			}
			if (findhole) {
				for (int i = x; i < x + leng; i++) {
					for (int j = y; j < y + leng; j++) {
						if (tile[i][j] != -1) {
							tile[i][j] = cnt;
						}
					}
				}
			} else {
				for (int k = 1; k <= 4; k++) {
					if (k == loc)
						continue;
					int nx = x + putTile[k][0];
					int ny = y + putTile[k][1];
					tile[nx][ny] = cnt;
				}
			}
			return;
		}

		int divide = leng / 2;

		// 1사분면
		makeTile(x, y, divide, 1);
		// 2사분면
		makeTile(x, y + divide, divide, 2);
		// 3사분면
		makeTile(x + divide, y, leng / 2, 3);
		// 4사분면
		makeTile(x + divide, y + divide, leng / 2, 4);

	}
}
