package Day210706;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1561_놀이공원 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int time[] = new int[M+1];
		st = new StringTokenizer(br.readLine());
		int start = Integer.MAX_VALUE;
		int end = 0;
		for(int i=1; i<=M; i++) {
			time[i] = Integer.parseInt(st.nextToken());
			end += time[i];
			start = Math.min(start, time[i]);
		}
	}
}
