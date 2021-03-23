package problem210323;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14501_퇴사 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] schedule = new int[N][2];
		int[] table = new int[N+1];
		int maxValue = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = N-1; i >= 0; i--) {
			if(i + schedule[i][0] > N) table[i] = maxValue;
			
			
			
			
			
			else {
				maxValue = Math.max(maxValue, table[i+schedule[i][0]] + schedule[i][1]);
				table[i] = maxValue;
				
			}
		}
		
		System.out.println(maxValue);
	}
}
