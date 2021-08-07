package problem210807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3495_아스키도형 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] polygon = new char[N][M];

		int dCnt = 0;
		int dotCnt = 0;
		for (int i = 0; i < N; i++) {
			polygon[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (polygon[i][j] != '.')
					dCnt++;
			}
		}

		for (int i = 0; i < N; i++) {
			boolean start = false;
			for (int j = 0; j < M; j++) {
				if (polygon[i][j] == '/' || polygon[i][j] == '\\') {
					start = !start;
				}
				else if (start && polygon[i][j] == '.') {
					dotCnt++;
				}


			}
		}
		System.out.println(dCnt/2 + dotCnt);
	}
}
