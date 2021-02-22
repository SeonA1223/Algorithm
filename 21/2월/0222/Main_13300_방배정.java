package problem210222;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13300_방배정 {

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = stoi(st.nextToken());
		int K = stoi(st.nextToken());
		int roomNum = 0;

		int students[][] = new int[7][2];

		for (int num = 0; num < N; num++) {
			st = new StringTokenizer(br.readLine(), " ");
			int sex = stoi(st.nextToken());
			int grade = stoi(st.nextToken());
			students[grade][sex] += 1;
		}

		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < 2; j++) {
				if (students[i][j] > 0) {
					roomNum += Math.ceil(((double) students[i][j] / K));

				}
			}


		}
		System.out.println(roomNum);

	}
}
