package problem210217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_쿼드트리_1992 {
	static StringBuffer sb;
	static BufferedReader br;
	static int[][] data;

	private static void divideFourParts(int x, int y, int n) {
		if (n == 2) {
			makeQuadCode(x, y);
			return;
		} else {
			int result = isAllSameNum(x, y, n);

			if (result == -1) {// 값이 다르다면 다시 나눠...
				sb.append("(");
				for (int i = x; i < n+x; i += n / 2) {
					for (int j = y; j < n+y; j += n / 2) {
						divideFourParts(i, j, n / 2);
					}
				}
				sb.append(")");
			} else { // 값이 다 같다면,
				sb.append(result);
				return;
			}
		}

	}

	private static int isAllSameNum(int x, int y, int n) {
		boolean flag = true; // 모두 같은 숫자라고 확신
		int value = data[x][y];
		loop:
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if (value != data[i][j]) {
					flag = false;
					break loop;
				}
			}
		}
		if (flag)
			return value;
		else
			return -1;

	}

	private static void makeQuadCode(int x, int y) {
		StringBuffer s = new StringBuffer();
		int value = data[x][y];

		boolean flag = true; // 모두 같을거라 확신
		s.append("(");

		for (int i = x; i < x + 2; i++) {
			for (int j = y; j < y + 2; j++) {
				if (value != data[i][j])
					flag = false;
				s.append(data[i][j]);

			}
		}
		if (flag == true) { // 모두 같음
			s.delete(0, s.length());
			s.append(value);
			sb.append(s);
		} else {
			s.append(")");
			sb.append(s);
		}

	}

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		data = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				data[i][j] = str.charAt(j) - '0';
			}
		}

		divideFourParts(0, 0, N);// 시작점 x, y, 크기
		System.out.println(sb.toString());

	}
}
