package Day210419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8458_원점으로집합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
	
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			int max = 0;
			int p = 0; //합이 홀인지 짝인지 찾아내기
			boolean flag = false;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				
				int sum = Math.abs(x1) + Math.abs(y1);
				if(i==0) {
					p = sum % 2;
				}else {
					if(p != sum % 2) flag = true;
				}
				max = Math.max(max, sum);
			}
			
			if(flag) {
				sb.append("-1").append("\n");
				continue;
			}
			
			//모두 홀수 또는 모두 짝수
			int sum = 0;
			int i = 0;
			
			while(true) {
				if(max == sum) break;
				if(max < sum && (sum - max) % 2 == 0) break;
				
				sum += i;
				i++;
			}
			sb.append(max).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
