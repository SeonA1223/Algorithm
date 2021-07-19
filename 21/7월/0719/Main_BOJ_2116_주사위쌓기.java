package problem210719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2116_주사위쌓기 {
	static int N;
	static int arr[][][];
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][3][2];
		res = 0;

//		0, 5 / 1, 3 / 2, 4 => 한 쌍
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (j == 0) {
					arr[i][0][0] = num;
				} else if (j == 1) {
					arr[i][1][0] = num;
				} else if (j == 2) {
					arr[i][2][0] = num;
				} else if (j == 3) {
					arr[i][1][1] = num;
				} else if (j == 4) {
					arr[i][2][1] = num;
				} else {
					arr[i][0][1] = num;
				}
			}

		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				int num = arr[0][i][j];
				int max = 0;
				for (int k = 0; k < 3; k++) {
					if (i == k)
						continue;
					int one = arr[0][k][0];
					int two = arr[0][k][1];
					max = Math.max(max, Math.max(one, two));
				}
				dfs(1, num, i, max);
			}
		}
		
		System.out.println(res);

	}

	private static void dfs(int diceNum, int downNum, int side, int sum) {
		if (diceNum == N) {
			if (res < sum) {
				res = sum;
			}
			return;
		}
		
		int index = 0;
		int p = 0;
		loop:for(int i=0; i<3; i++) {
			for(int j=0; j<2; j++) {
				if(arr[diceNum][i][j] == downNum) {
					index = i;
					p = j == 1? 0 : 1;
					break loop;
				}
			}
		}
		

		int max = 0;
		for (int i = 0; i < 3; i++) {
			if (i == index)
				continue;
			max = Math.max(max, Math.max(arr[diceNum][i][0], arr[diceNum][i][1]));
		}
		dfs(diceNum+1, arr[diceNum][index][p], index, sum + max);

	}
}
