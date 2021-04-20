package Day210420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_17135_캐슬디펜스 {
	static int N, M, D, KillMAX;
	static int[][] map;
	static final int SOL_NUM = 3;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 궁수 3명은 M칸 중 3개의 칸에 위치가능하다.
		KillMAX = 0;
		comb(0, 0, new int[3]);
		System.out.println(KillMAX);

	}

	private static void comb(int start, int index, int[] soldier) {
		if (index == SOL_NUM) {
			int cnt = simulation(soldier);
			KillMAX = Math.max(KillMAX, cnt);
			return;
		}
		for (int i = start; i < M; i++) {
			soldier[index] = i;
			comb(i + 1, index + 1, soldier);
		}
	}

	private static int simulation(int[] soldier) {
		int[][] temp = copyMap(map);
		ArrayList<int[]> enemies = new ArrayList<>();
		int cnt = 0;
		while (isEnemies(temp)) {
			for (int i = 0; i < SOL_NUM; i++) {
				int x = N;
				int y = soldier[i];

				int d = 0;
				int minDistance = Integer.MAX_VALUE;
				int ex = -1;
				int ey = -1;
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < M; k++) {
						if (temp[j][k] == 1) {
							d = getDistance(x, y, j, k);
							if (d <= D && minDistance >= d) {
								if (minDistance == d) {
									if (ey > k) {
										ex = j;
										ey = k;
									}
								} else {
									ex = j;
									ey = k;
									minDistance = d;
								}
							}
						}
					}
				}
				if (ex != -1 && ey != -1) {
					enemies.add(new int[] { ex, ey });
				}
			}

			cnt += killEnemies(temp, enemies);
			moveEnemies(temp);
			enemies.clear();
		}

		return cnt;

	}

//	private static void moveEnemies(int[][] temp) {
//		for (int i = N - 1; i > 0; i--) {
//			for (int j = 0; j < M; j++) {
//				temp[i][j] = temp[i - 1][j];
//			}
//		}
//
//		for (int j = 0; j < M; j++) {
//			temp[0][j] = 0;
//		}
//
//	}

	private static void moveEnemies(int[][] temp) {
		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				if (temp[i][j] == 1) {
					if (i + 1 == N) {
						temp[i][j] = 0;
						continue;
					}
					temp[i][j] = 0;
					temp[i + 1][j] = 1;
				}
			}
		}

	}

	private static boolean isEnemies(int[][] temp) {
		boolean flag = false;
		loop: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 1) {
					flag = true;
					break loop;
				}
			}
		}
		return flag;
	}

	private static int killEnemies(int[][] temp, ArrayList<int[]> enemies) {
		int cnt = 0;
		for (int[] xy : enemies) {
			int x = xy[0];
			int y = xy[1];

			if (temp[x][y] == 1) {
				cnt++;
				temp[x][y] = 0;
			}
		}
		return cnt;

	}

	private static int[][] copyMap(int[][] map) {
		int temp[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}

	private static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
