package problem210222;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_7964_부먹왕국의차원관문 {
	static int N, D;
	static int[] cities;
	static int dx[] = { -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = stoi(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken()); // 부먹 왕국의 도시 수
			D = stoi(st.nextToken()); // 이동제한 거리
			int minDoor = 0;

			cities = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cities[i] = stoi(st.nextToken());
			}

			int range = 0;
			for (int i = 0; i < N; i++) {
				if (cities[i] == 0) {
					range++;
				} else if (cities[i] == 1) { // cities[i] == 1일 때
					range = 0;

				}
				if (range == D) {
					minDoor++;
					range = 0;
				}

			}
			sb.append("#").append(tc).append(" ").append(minDoor).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

	private static boolean checkRange(int nx) {
		if (0 <= nx && nx < N)
			return true;
		else
			return false;
	}

//	private static boolean findDimensionGate(int x) {
//		for (int i = 1; i <= D; i++) {
//			for (int j = 0; j < 2; j++) {
//				int nx = x + dx[j] * i;
//				if (checkRange(nx)) {
//					if (cities[nx] == 1)
//						return true; // D이내에 차원관문이 존재
//				}
//			}
//		}
//		return false; // D이내에 차원관문 존재 X
//	}
}
