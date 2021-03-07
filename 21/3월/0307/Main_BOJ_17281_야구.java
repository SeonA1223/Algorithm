package Day210307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_17281_야구 {
	static int[][] inning;
	static int N;
	static int MaxScore;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		inning = new int[N][9];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		MaxScore = 0;

		// 순열 계산
		int[] order = new int[9];
		boolean[] bs = new boolean[9];
		bs[3] = true;
		order[3] = 0;
		perm(1, order, bs);
		System.out.println(MaxScore);
	}

	private static void perm(int index, int[] order, boolean[] bs) {
		if (index == 9) {
			simulation(order);
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (bs[i])
				continue;
			bs[i] = true;
			order[i] = index;
			perm(index + 1, order, bs);
			bs[i] = false;
		}
	}

	private static void simulation(int[] order) {
		int[] Order = order; // 순서를 저장해 놓은 배열
		int index = 0; // 그 순서에 해당하는 인덱스
		int out;
		boolean[] locate = new boolean[4];
		int result = 0;

		for (int i = 0; i < N; i++) {
			out = 0;
			Arrays.fill(locate, false);
			while (out < 3) {
				if (index >= 9) {
					index = index % 9;
				}
				int hitter_num = Order[index]; // 타자순서에 해당하는 값
				int battingCount = inning[i][hitter_num]; // 해당 이닝에 그 선수에 타율

				locate[0] = true; // 타자가 되었다는 의미

				switch (battingCount) {
				case 0: // 아웃
					locate[0] = false; // 나왔따
					out++;
					break;
				case 1:
				case 2:
				case 3:
				case 4:
					for (int j = 3; j >= 0; j--) { // 3루부터
						if (locate[j] == true) {
							int value = j + battingCount;// 3
							if (value > 3) {
								result += 1;
							} else {
								locate[value] = true;
							}
							locate[j] = false;
						}
					}
					break;
				}
				index++;
			}
		}
		MaxScore = Math.max(MaxScore, result);

	}

}
