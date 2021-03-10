package Day210310;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_17070_파이프옮기기 {
	static int N, cases;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int[][] newHouse = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				newHouse[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 가장 처음에 위치한 파이프는 가로, (1,1),(1,2)
		cases = 0;
		findLine(newHouse, 1, 2, 3);
		System.out.println(cases);

	}

	private static void findLine(int[][] newHouse, int x, int y, int pipeShape) {
		if (1 > x || x > N || 1 > y || y > N)
			return;

		if (pipeShape == 5) {
			if (newHouse[x - 1][y] == 1 || newHouse[x][y - 1] == 1)
				return;
		}
		

		if (newHouse[x][y] == 1)
			return;

		if (x == N && y == N) {
			cases++;
			return;
		}

		switch (pipeShape) {
		case 3:// 가로
				// 가로
			findLine(newHouse, x, y + 1, 3);
			findLine(newHouse, x + 1, y + 1, 5);
			break;
		case 4:
			// 세로
			findLine(newHouse, x + 1, y, 4);
			// 대각선
			findLine(newHouse, x + 1, y + 1, 5);
			break;
		case 5:
			// 가로
			findLine(newHouse, x, y + 1, 3);
			// 세로
			findLine(newHouse, x + 1, y, 4);
			// 대각선
			findLine(newHouse, x + 1, y + 1, 5);
			break;
		}
	}

}
