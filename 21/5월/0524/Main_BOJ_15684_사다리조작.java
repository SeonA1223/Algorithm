package Day210524;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_15684_사다리조작 {
	static int N, H, M;
	static int ladder[][];
	static int line;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로(열)
		H = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 가로(행)
		ladder = new int[M + 1][N + 1];
		line = 0;

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladder[a][b] = 1;
			ladder[a][b + 1] = 2;
		}

		// 선놓기
		boolean flag = true;
		for (int i = 0; i <= 3; i++) {
			line = i;
			if (putLine(1, 0)) {
				System.out.println(i);
				flag = false;
				break;
			}
		}

		if(flag) System.out.println(-1);
	}

	private static boolean putLine(int x, int lineNum) {
		
		if(line == lineNum) {
			if (check()) {
				return true;
			}
			return false;
		}

		for (int i = x; i <= M; i++) {
			for (int j = 1; j < N; j++) {
				if (ladder[i][j] == 0 && ladder[i][j + 1] == 0) {
					ladder[i][j] = 1;
					ladder[i][j + 1] = 2;
					if(putLine(i, lineNum+1)) return true;
					ladder[i][j] = ladder[i][j + 1] = 0;
				}
			}
		}
		return false;
	}

	private static boolean check() {

		for (int i = 1; i <= N; i++) { // 사다리 각 영역
			int w = i;
			int h = 1;
			while (h <= M) {
				if (ladder[h][w] == 1)
					w++;
				else if (ladder[h][w] == 2)
					w--;
				h++;
			}
			if (w != i)
				return false;

		}
		return true;
	}

}
