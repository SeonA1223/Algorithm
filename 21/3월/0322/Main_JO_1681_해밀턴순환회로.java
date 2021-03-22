package problem210322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1681_해밀턴순환회로 {
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

		int start = 0; // 회사 시작
		int count = 0;
		boolean[] visited = new boolean[N]; // 방문체크
		int[] distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[start] = 0;
		int min = 0, current = 0;
		for (int i = 0; i < N; i++) {
			min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if (!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
					count++;
				}
			}
			visited[current] = true;
			if (count == N) {
				visited[start] = false;
				distance[start] = Integer.MAX_VALUE;
			}

			for (int c = 0; c < N; c++) {
				if (!visited[c] && arr[current][c] != 0 && distance[c] > min + arr[current][c]) {
					distance[c] = min + arr[current][c];
				}
			}
		}

		System.out.println(distance[start]);

	}

}
