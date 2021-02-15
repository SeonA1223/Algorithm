package problem210215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961 {
	static int[][] foods;
	static int N;
	static int minNum = Integer.MAX_VALUE;

	private static void makeFoods(int start, int bitter, int sour, int count) {
		if (count > 0) {
			int diff = Math.abs(bitter - sour);
			minNum = Math.min(minNum, diff);
		}
		for (int i = start; i < N; i++) {
			makeFoods(i + 1, bitter + foods[i][1], sour * foods[i][0], ++count);

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		foods = new int[N][2];
		int count = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				foods[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		makeFoods(0, 0, 1, count);
		System.out.println(minNum);

	}

}
