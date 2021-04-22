package Day210422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_2930_힙 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> Integer.compare(y, x));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			pq.clear();
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				
				switch(num) {
				case 1:
					int value = Integer.parseInt(st.nextToken());
					pq.add(value);
					break;
				case 2:
					if(pq.isEmpty()) sb.append("-1").append(" ");
					else sb.append(pq.poll()).append(" ");
					break;
				}
				
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
