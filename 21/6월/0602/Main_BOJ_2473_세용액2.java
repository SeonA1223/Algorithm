package Day210602;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2473_세용액2 {
	static int N;
	static long res;
	static int[] arr;
	static long ans[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		res = Long.MAX_VALUE;
		ans = new long[3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int start = 0;
		int mid = 1;
		int end = N - 1;
		long temp = 0;

		int a = 0, b = 0, c = 0;
		while (start < N) {
				temp = arr[start] + arr[mid] + arr[end];
				if (Math.abs(temp) < Math.abs(res)) {
					res = temp;
					a = start;
					b = mid;
					c = end;
				}

				if (temp < 0)
					mid++;
				else if(temp > 0)
					end--;
				else break;

				if (mid >= end) {
					start++;
					mid = start + 1;
					end = N - 1;
					if(mid >= end) break; 
			}
		}

		ans[0] = arr[a];
		ans[1] = arr[b];
		ans[2] = arr[c];

		Arrays.sort(ans);
		for (int i = 0; i < 3; i++) {
			System.out.print(ans[i] + " ");
		}

	}
}
