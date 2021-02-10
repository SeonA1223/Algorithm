package problem210210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int count = Math.min(N, M) / 2;

		int arr[][] = new int[N][M];
		int result[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < count; c++) {
				//왼
				for (int i = M-1-c; i >1; i--) {
					result[i+1][c] = arr[i][c];
				}
				//오
				for (int i = 0+c; i <M-1 ; i++) {
					result[N-1-c][i+1] = arr[N-1-c][i];
				}
				//아래
				for (int i = 0+c; i < N-1; i++) {
					result[i+1][M-1-c] = arr[i][M-1-c];
				}
				//위
				for (int i = N-1; i < result.length; i++) {
//					result[]
				}

			}

		}

	}

}
