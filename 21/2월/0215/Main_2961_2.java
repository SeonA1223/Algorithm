package problem210215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_2 {
	static int[][] foods;
	static boolean[] isSelect;
	static int N;
	static int minNum = Integer.MAX_VALUE;

	private static void makeFoods(int start, int bitter, int sour) {
			int diff = Math.abs(bitter - sour);

			for (int i = start; i < N; i++) {
				makeFoods(start + 1, bitter + foods[i][1], sour * foods[i][0]);
			}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		foods = new int[N][2];
		isSelect = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				foods[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		makeFoods(0, 0, 1);
		System.out.println(minNum);

	}

}
