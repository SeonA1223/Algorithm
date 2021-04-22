package Day210422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_도영이가만든요리2 {
	static int N;
	static int ans;
	static int arr[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		ans = Integer.MAX_VALUE;
		// 부분집합 사용이지만 조합
		subset(0, new boolean[N]);
		System.out.println(ans);
	}

	private static void subset(int index, boolean[] visited) {
		if (index == N) {
			int sour = 1;
			int bitter = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					sour *= arr[i][0];
					bitter += arr[i][1];
					flag = true;
				}
			}
			if (flag) {
				ans = Math.min(ans, Math.abs(sour - bitter));
			}
			return;
		}

		visited[index] = true;
		subset(index + 1, visited);
		visited[index] = false;
		subset(index + 1, visited);
	}

}
