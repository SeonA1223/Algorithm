package Day210508;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2003_수들의합2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		int cnt = 0;
		int sum = 0;
		while(start < arr.length) {
			
			if(sum > M || end == arr.length) {
				sum -= arr[start];
				start++;
			}else {
				sum += arr[end];
				end++;
			}
			
			if(sum==M) cnt++;
			
		}
		System.out.println(cnt);
	}
}
