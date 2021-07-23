package problem210723;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_7682_틱택토 {
	static char[] tictactoe;
	static int sucX, sucO;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = null;
		while (!(s = br.readLine()).equals("end")) {
			tictactoe = s.toCharArray();
			int Xcnt = 0;
			int Ocnt = 0;
			sucX = 0;
			sucO = 0;

			for (int i = 0; i < 9; i++) {
				if (tictactoe[i] == 'X')
					Xcnt++;
				else if (tictactoe[i] == 'O')
					Ocnt++;
			}

			int diff = Xcnt - Ocnt;
			boolean flag = false;
			if (diff == 0 || diff == 1) {
				// 가로 탐색
				findHorizon();
				// 세로 탐색
				findVertical();
				// 대각선 탐색
				findDiagonal();

				if (diff == 1) {
					if (sucO == 0 && sucX > 0) {
							flag = true;
					} else if (sucO == 0 && sucX == 0) {
						if (Xcnt + Ocnt == 9)
							flag = true;
					}
				} else {
					if (sucO > 0 && sucX == 0) {
							flag = true;
					}
				}
			}

			if (flag) {
				System.out.println("valid");
			} else {
				System.out.println("invalid");
			}
		}
	}

	private static void findDiagonal() {
		if (tictactoe[0] == tictactoe[4] && tictactoe[4] == tictactoe[8] && tictactoe[0] == tictactoe[8]) {
			if (tictactoe[0] == 'X')
				sucX++;
			else
				sucO++;
		}

		if (tictactoe[2] == tictactoe[4] && tictactoe[4] == tictactoe[6] && tictactoe[2] == tictactoe[6]) {
			if (tictactoe[2] == 'X')
				sucX++;
			else 
				sucO++;
		}

	}

	private static void findVertical() {
		for (int i = 0; i < 9; i += 3) {
			char before = ' ';
			boolean flag = true;
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					before = tictactoe[i + j];
					if (before == '.') {
						flag = false;
						break;
					}
				} else {
					if (before != tictactoe[i + j]) {
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				if (before == 'X')
					sucX++;
				else if(before == 'O')
					sucO++;
			}
		}

	}

	private static void findHorizon() {
		for (int i = 0; i < 3; i++) {
			char before = ' ';
			boolean flag = true;
			for (int j = 0; j < 9; j += 3) {
				if (j == 0) {
					before = tictactoe[i + j];
					if (before == '.') {
						flag = false;
						break;
					}
				} else {
					if (before != tictactoe[i + j]) {
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				if (before == 'X')
					sucX++;
				else if(before == 'O')
					sucO++;
			}
		}

	}

}
