package Day210422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_도영이가만든요리 {
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
		subset(0, 1, 0, 0);
		System.out.println(ans);
	}

	private static void subset(int index, int sour, int bitter, int flag) {
		if (flag != 0) {
			int abs = Math.abs(sour - bitter);

			if (ans > abs)
				ans = abs;
		}
		if (index == N)
			return;
		
		subset(index + 1, sour * arr[index][0], bitter + arr[index][1], flag | (1 << index));
		subset(index + 1, sour, bitter, flag);
	}

}
