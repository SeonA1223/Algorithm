package Day210521;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//2시간반
public class Main_BOJ_17779_게리멘더링2 {
	static int N, totalPeople;
	static int[][] arr;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		totalPeople = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				totalPeople += arr[i][j];
			}
		}

		ans = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int dx = 1; dx < N; dx++) {
					for (int dy = 1; dy < N; dy++) {
						if (i + dx + dy <= N && 1 <= j - dx && j + dy <= N) {
							getFiveDistrict(i, j, dx, dy);
						}

					}
				}

			}
		}
		System.out.println(ans);

	}

	private static void getFiveDistrict(int i, int j, int dx, int dy) {
		boolean visited[][] = new boolean[N + 1][N + 1];
		int min = Integer.MAX_VALUE;
		int max = 0;
		// 경계선만 체크
		for (int x = 0; x <= dx; x++) {
			visited[i + x][j - x] = true;
			visited[i + dy + x][j + dy - x] = true;
		}

		for (int y = 0; y <= dy; y++) {
			visited[i + dx + y][j - dx + y] = true;
			visited[i + y][j + y] = true;
		}

		for (int x = i + 1; x < i + dx + dy; x++) {
			for (int y = 1; y <= N; y++) {
				if (visited[x][y]) {
					while (++y <= N && !visited[x][y])
						visited[x][y] = true;
				}
			}
		}

		// 1번 선거구 인구 계산

		int cnt2 = 0;
		for (int x = 1; x < i + dx; x++) {
			for (int y = 1; y <= j; y++) {
				if (visited[x][y])
					continue;
				cnt2 += arr[x][y];
			}
		}
		min = Math.min(min, cnt2);
		max = Math.max(max, cnt2);
		// 2번 선거구 인구 계산
		int cnt3 = 0;
		for (int x = 1; x <= i + dy; x++) {
			for (int y = j + 1; y <= N; y++) {
				if (visited[x][y])
					continue;
				cnt3 += arr[x][y];
			}
		}
		min = Math.min(min, cnt3);
		max = Math.max(max, cnt3);
		// 3번 선거구 인구 계산
		int cnt4 = 0;
		for (int x = i + dx; x <= N; x++) {
			for (int y = 1; y < j - dx + dy; y++) {
				if (visited[x][y])
					continue;
				cnt4 += arr[x][y];
			}
		}
		min = Math.min(min, cnt4);
		max = Math.max(max, cnt4);
		// 4번 선거구 인구 계산
		int cnt5 = 0;
		for (int x = i + dy + 1; x <= N; x++) {
			for (int y = j - dx + dy; y <= N; y++) {
				if (visited[x][y])
					continue;
				cnt5 += arr[x][y];
			}
		}
		min = Math.min(min, cnt5);
		max = Math.max(max, cnt5);

		int cnt = totalPeople - cnt2 - cnt3 - cnt4 - cnt5;
		min = Math.min(min, cnt);
		max = Math.max(max, cnt);
		ans = Math.min(ans, max - min);

	}

}
