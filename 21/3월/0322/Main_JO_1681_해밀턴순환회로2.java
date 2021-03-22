package problem210322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1681_해밀턴순환회로2 {
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim());
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				arr[i][j] = value;
			}
		}

		int start = 0;
		min = Integer.MAX_VALUE;
		boolean[] visited = new boolean[N]; // 방문체크

		visited[start] = true;
		dfs(0, 0, 1, arr, visited);

		System.out.println(min);
	}

	private static void dfs(int index, int sum, int count, int[][] arr, boolean[] visited) {
		if (sum > min)
			return;

		if (count == visited.length) {
			if (arr[index][0] == 0)
				return;
			
			sum += arr[index][0];
			if (sum < min)
				min = sum;
			return;
		}

		for (int i = 1; i < visited.length; i++) {
			if (!visited[i] && arr[index][i] != 0) {
				visited[i] = true;
				dfs(i, sum + arr[index][i], count + 1, arr, visited);
				visited[i] = false;
			}
		}

	}
}