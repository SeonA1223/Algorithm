package Day210706;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs 사용법
public class Main_BOJ_9177_단어섞기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("Data set ").append(tc).append(": ");
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();
			
			boolean[][] dp = new boolean[a.length()+1][b.length()+1];
			
			if(bfs(dp, a, b, c)){
				sb.append("yes");
			}else {
				sb.append("no");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean bfs(boolean[][] dp, String a, String b, String c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,0});
		dp[0][0] = true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			if(temp[0] == a.length() && temp[1] == b.length() && temp[2] == c.length()) {
				return true;
			}
			
			if(temp[0] < a.length() && a.charAt(temp[0]) == c.charAt(temp[2]) && !dp[temp[0] + 1][temp[1]]) {
				dp[temp[0] + 1][temp[1]] = true;
				q.offer(new int[] {temp[0] + 1, temp[1], temp[2]+1});
			}
			
			if(temp[1] < b.length() && b.charAt(temp[1]) == c.charAt(temp[2]) && !dp[temp[0]][temp[1] + 1]) {
				dp[temp[0]][temp[1] + 1] = true;
				q.offer(new int[] {temp[0], temp[1]+1, temp[2]+1});
			}
		}
		
		return false;
		
	}
}
