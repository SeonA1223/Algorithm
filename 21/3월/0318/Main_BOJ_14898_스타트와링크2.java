package problem210318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_14898_스타트와링크2 {
	static int[][] ability;
	static int cntA, cntB;
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

			cntA = 0;
			cntB = 0;
			for (int i = 0; i < teamSize - 1; i++) {
				for (int j = i+1; j < teamSize; j++) {
					cntA += ability[startTeam[i]][startTeam[j]];
					cntA += ability[startTeam[j]][startTeam[i]];
					cntB += ability[linkTeam[i]][linkTeam[j]];
					cntB += ability[linkTeam[j]][linkTeam[i]];

				}
			}

			minValue = Math.min(minValue, Math.abs(cntA - cntB));
			return;
		}

		for (int i = start; i < bs.length; i++) {
			bs[i] = true;
			combTeamSplit(count + 1, i + 1, teamSize, bs);
			bs[i] = false;

		}

	}

}
