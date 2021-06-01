package Day210602;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_2473_세용액 {
	static int N, res;
	static Integer[] arr;
	static int ans[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new Integer[N];
		res = Integer.MAX_VALUE;
		ans = new int[3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int start = 0;
		int mid = 1;
		int end = 2;
		int temp = 0;

		int a = 0, b = 0, c = 0;
		while (start + 3 <= N) {
			temp = arr[start] + arr[mid] + arr[end];
			if (Math.abs(temp) < Math.abs(res)) {
				res = temp;
				a = start;
				b = mid;
				c = end;
			}else {
				end = N;
			}

			if (end < N) {
				end++;
			}

			if (end >= N && mid + 1 < N) {
				mid++;
				end = mid + 1;

			}

			if (end >= N && mid+1 >= N) {
				start++;
				mid = start + 1;
				end = mid + 1;
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
