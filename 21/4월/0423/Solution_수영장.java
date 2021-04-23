package Day210423;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_수영장 {
	static int fee[], plan[];
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			
			fee = new int[4];
			plan = new int[12];
			ans =  Integer.MAX_VALUE;
			for (int i = 0; i < 4; i++) {
				fee[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void dfs(int month, int sum) {
		if(month >= 12) {
			if(sum > fee[3]) sum = fee[3];
			ans = Math.min(ans, sum);
			return;
		}
		//일로 끊을 경우
		int a = plan[month] * fee[0];
		//월로 끊을 경우
		int b = fee[1];
		//한달 또는 일권으로 끊을 경우, 둘 중 최솟값
		dfs(month+1, sum + Math.min(a, b)); 
		//해당 월부터 3개월 끊을경우
		dfs(month+3, sum + fee[2]);
	}
}
