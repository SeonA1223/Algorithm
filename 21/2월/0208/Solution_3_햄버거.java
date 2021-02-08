package problem210208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_3_햄버거 {
	static int N, L;
	static boolean[] isSelected;
	static ArrayList<int[]> score;
	static int result = 0;

	private static void generateSubset(int count) {
		if (count == N) {
			int sum = 0; // 칼로리
			int favorite = 0; // 재료 맛 점수
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sum += score.get(i)[1];
					favorite += score.get(i)[0];
				}
			}
			if (sum <= L) {
				if (result < favorite) {
					result = favorite;
				}
			}
			return;
		}
		isSelected[count] = true;
		generateSubset(count + 1);
		isSelected[count] = false;
		generateSubset(count + 1);
	}

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 재료 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			score = new ArrayList<>();
			isSelected = new boolean[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer sts = new StringTokenizer(br.readLine(), " ");
				score.add(new int[] { Integer.parseInt(sts.nextToken()), Integer.parseInt(sts.nextToken()) });
			}
			generateSubset(0);
			System.out.println("#" + tc + " " + result);
			result = 0;

		}
	}

}
