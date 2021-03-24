package problem210324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2636_치즈2 {
	static int N, M, count;
	static int[][] cheese;
	static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cheese = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < args.length; j++) {
				if(cheese[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dir[k][0];
						int ny = j + dir[k][1];
						
						if(0<=nx && nx < N && 0<= ny && ny < M) {
							if(cheese[nx][ny] ==  0) {
								cheese[i][j] = 2;
							}
						}
					}
					break;
				}
			}
		}

	}
}
