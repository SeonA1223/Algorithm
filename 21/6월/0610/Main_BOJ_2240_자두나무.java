package Day210610;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2240_자두나무 {
	static int T, W;
	static int[] fallPlumLoc;
	static int[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		fallPlumLoc = new int[T + 1];

		for (int i = 1; i <= T; i++) {
			fallPlumLoc[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[T + 1][W+1][3];
		for (int i = 0; i <= T; i++) {
			for (int j = 0; j <=W; j++) {
				for (int k = 0; k < 3; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		System.out.println(Math.max(getMaxPlum(T, W, 1), getMaxPlum(T, W-1, 2)));
		
	}

	private static int getMaxPlum(int time, int mv, int plumLoc) {
		if(dp[time][mv][plumLoc] != -1) return dp[time][mv][plumLoc];
		if(time == 0){
			return 0;
		}

		int loc = fallPlumLoc[time];
		if(loc == plumLoc) {
			dp[time][mv][loc] = getMaxPlum(time-1, mv, plumLoc)+ 1;
			if(mv-1>=0) dp[time][mv][loc] = Math.max(dp[time][mv][loc], getMaxPlum(time-1, mv-1, plumLoc == 1 ? 2 : 1));
		}else {
			if(loc == 1) {
				dp[time][mv][loc] = getMaxPlum(time-1,  mv, plumLoc);
				if(mv-1>=0)
				dp[time][mv][loc] = Math.max(dp[time][mv][loc], getMaxPlum(time-1, mv-1, 1)+1);
			}else {
				dp[time][mv][loc] = getMaxPlum(time-1,  mv, plumLoc);
				if(mv-1>=0)
				dp[time][mv][loc] = Math.max(dp[time][mv][loc], getMaxPlum(time-1, mv-1, 2)+1);
				
			}
				
			
		}
		return dp[time][mv][loc];
		
	}

}
