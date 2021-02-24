package problem210224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1037_오류교정 {

	private static int toInt(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = toInt(br.readLine().trim());
		int[][] message = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				message[i][j] = toInt(st.nextToken());
			}
		}

		// 가로로 읽기
		int oddHorizontalCount = 0;
		int row = 0;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += message[i][j];
			}
			if (sum % 2 != 0) {
				row = i;
				oddHorizontalCount++;
			}
		}
		// 세로로 읽기
		int oddVerticalCount = 0;
		int column = 0;
		for (int j = 0; j < N; j++) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += message[i][j];
			}
			if (sum % 2 != 0) {
				column = j;
				oddVerticalCount++;
			}
		}
		
		if(oddHorizontalCount == 0 && oddVerticalCount == 0) {
			System.out.println("OK");
		}else if(oddHorizontalCount > 1 || oddVerticalCount > 1) {
			System.out.println("Corrupt");
		}else {
			System.out.printf("Change bit (%d,%d)\n", row+1, column+1);
		}

	}

}
