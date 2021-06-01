package Day210602;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2470_두용액 {
	static int N;
	static long res;
	static long[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		res = Long.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int start = 0;
		int end = N-1;
		long temp = 0;
		int a = 0;
		int b = 0;
		while(start < end) {
			temp = arr[start] + arr[end];
			if(Math.abs(temp) < Math.abs(res)) {
				a = start;
				b = end;
				res = temp;
			}
			
			if(temp < 0) start++;
			else if(temp > 0) end--;
			else break;
		}
		
		System.out.println(arr[a] + " " + arr[b]);
	}
}
