package problem210225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2578_빙고 {
	static int bingo[][];

	private static int CheckHorizontal(int count) {
		boolean flag;

		for (int i = 0; i < 5; i++) {
			flag = true;
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] != 0) {
					flag = false;
					break;
				}
			}
			if (flag == true) { // 열이 다 0이라면
				count += 1;
			} 
		}
		return count;
	}

	private static int CheckVertical(int count) {
		boolean flag;

		for (int j = 0; j < 5; j++) {
			flag = true;
			for (int i = 0; i < 5; i++) {
				if (bingo[i][j] != 0) {
					flag = false;
					break;
				}
			}
			if (flag == true) { // 열이 다 0이라면
				count += 1;
			} 
		}
		return count;

	}

	private static int CheckDiagonal(int count) {
		boolean flag = true;

		for (int i = 0; i < 5; i++) {
			if (bingo[i][i] != 0) {
				flag = false;
				break;
			}
		}
		if (flag == true) { // 열이 다 0이라면
			count += 1;
		}

		flag = true;

		for (int i = 0; i < 5; i++) {
			if (bingo[i][bingo.length - 1 - i] != 0) {
				flag = false;
				break;
			}
		}
		if (flag == true) {
			count += 1;
		}

		return count;

	}

	private static void find(int value) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j] == value) {
					bingo[i][j] = 0;
				}
			}
		}

	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		bingo = new int[5][5];

		int cCall = 0;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				int value = Integer.parseInt(st.nextToken());
				cCall++;
				find(value);

				int count = 0;

				count = CheckHorizontal(count);
				count = CheckVertical(count);
				count = CheckDiagonal(count);

				if (count >= 3) {
					System.out.println(cCall);
					return;

				}

			}

		}

	}

}
