package problem210224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6485_삼성시의버스노선 {
	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = stoi(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int busStop[] = new int[5001];
			int busRouteCount = stoi(br.readLine().trim());
			for (int i = 0; i < busRouteCount; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = stoi(st.nextToken());
				int end = stoi(st.nextToken());
				for (int j = start; j <= end; j++) {
					busStop[j]++;
				}
			}
			int busStopCount = stoi(br.readLine().trim());
			for (int i = 0; i < busStopCount; i++) {
				int number = stoi(br.readLine());
				sb.append(busStop[number]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
