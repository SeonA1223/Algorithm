package problem210319;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {

	static int find(int[] arr, int a) {
		if (arr[a] == a)
			return a;
		return arr[a] = find(arr, arr[a]);
	}

	static void union(int[] arr, int a, int b) {
		int aRoot = find(arr, a);
		int bRoot = find(arr, b);
		if (aRoot == bRoot)
			return;

		arr[bRoot] = aRoot;
	}

	static int union2(int[] arr, int a, int b) {
		int aRoot = find(arr, a);
		int bRoot = find(arr, b);
		if (aRoot == bRoot)
			return 1;

		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int parents[] = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				parents[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				switch (a) {
				case 0:
					union(parents, b, c);
					break;
				case 1:
					int result = union2(parents, b, c);
					sb.append(result);
					break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}
