package Day210422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울 {
	static int N, cases;
	static int arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			cases = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 순열
			perm(0, new int[N], new boolean[N]);
			sb.append(cases).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void perm(int index, int[] order, boolean[] visited) {
		if (index == N) {
			subset(0, 0, 0, order);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			order[index] = i;
			perm(index + 1, order, visited);
			visited[i] = false;
		}

	}

	private static void subset(int index, int left, int right, int[] order) {
		if (left < right)
			return;

		if (index == N) {
			cases++;
			return;
		}

		subset(index + 1, left + arr[order[index]], right, order);
		subset(index + 1, left, right + arr[order[index]], order);

	}
}
