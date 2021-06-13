package problem210613;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_JO_16438_극장좌석 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		long theaterSeat[] = new long[N+1];
		boolean fixSeat[] = new boolean[N+1];
		long res = 1;
		
		for (int i = 0; i < M; i++) {
			fixSeat[Integer.parseInt(br.readLine())] = true;
		}
		
		long start=1;
		for (int i = 1; i <= N; i++) {
			if(fixSeat[i]) {
				res *= start;
				start = 1;
				continue;
			}
			if(i-1 <= 0 || fixSeat[i-1]== true) {
				theaterSeat[i] = 1;
				
			}
			if(i-1> 0 && theaterSeat[i-1] == 1) {
				theaterSeat[i] = 2;
			}
			
			if(i-2>0 && fixSeat[i-1] == false && fixSeat[i-2] == false) {
				theaterSeat[i] = theaterSeat[i-1] + theaterSeat[i-2];
			}
			start = theaterSeat[i];
		}

		System.out.println(res* start);
	}
	
/*
 * 1
 * 12 21
 * 123 213 132
 * 1234 2134 1324 1243 2143
 * 
 * 자기자신이 고정자석이거나, 이 전친구가 고정자석이면 dp 그대로
 * */
}
