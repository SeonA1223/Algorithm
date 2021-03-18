package problem210318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_14898_스타트와링크 {
	static int[][] ability;
	static int res;
	static int minValue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		ability = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minValue = 987654321;
		res = 0;
		combTeamSplit(0, 0, N / 2, new boolean[N]);
		System.out.println(minValue);

	}

	private static void combTeamSplit(int count, int start, int teamSize, boolean[] bs) {
		if (start == teamSize)
			return;
		
		if (count == teamSize) {
			int startI = 0, linkI = 0;
			int startTeam[] = new int[teamSize];
			int linkTeam[] = new int[teamSize];
			for (int i = 0; i < bs.length; i++) {
				if (bs[i]) {
					startTeam[startI] = i;
					startI++;
				} else {
					linkTeam[linkI] = i;
					linkI++;
				}
			}
			
			System.out.println("startTeam : " + Arrays.toString(startTeam));
			System.out.println("linkTeam : " + Arrays.toString(linkTeam));
			res = 0;
			comb(startTeam, new int[2], 0, 0);
			int a = res;

			res = 0;
			comb(linkTeam, new int[2], 0, 0);
			int b = res;

			minValue = Math.min(minValue, Math.abs(a - b));
			return;
		}

		for (int i = start; i < bs.length; i++) {
			bs[i] = true;
			combTeamSplit(count + 1, i + 1, teamSize, bs);
			bs[i] = false;

		}

	}

	private static void comb(int[] Team, int[] ans, int index, int start) {
		if (index == 2) {
			res += ability[ans[0]][ans[1]] + ability[ans[1]][ans[0]];
			return;

		}
		for (int i = start; i < Team.length; i++) {
			ans[index] = Team[i];
			comb(Team, ans, index + 1, i + 1);
		}

	}

}
