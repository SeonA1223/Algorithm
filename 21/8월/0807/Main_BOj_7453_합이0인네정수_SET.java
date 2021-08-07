package problem210807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOj_7453_합이0인네정수_SET {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];
		int[] D = new int[N];
		long cnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B);
		Arrays.sort(C);
		Arrays.sort(D);

		// A + B 모든 합
		long[] sumAB = new long[N * N];
		long[] sumCD = new long[N * N];
		for (int i = 0; i < N; i++) {
			int numA = A[i];
			int numC = C[i];
			for (int j = 0; j < N; j++) {
				int numB = B[j];
				int numD = D[j];

				sumAB[i * N + j] = (long) numA + numB;
				sumCD[i * N + j] = (long) numC + numD;
			}
		}

		Arrays.sort(sumAB);
		Arrays.sort(sumCD);

		int start = 0;
		int end = N * N - 1;

		while (start < N * N && end >= 0) {
			long res = sumAB[start] + sumCD[end];
			if (res == 0) {
				long tempAB = sumAB[start];
				long tempCD = sumCD[end];
				long abCnt = 0;
				long cdCnt = 0;
				while (start < N * N && sumAB[start] == tempAB) {
					start++;
					abCnt++;
				}
				while (end >= 0 && sumCD[end] == tempCD) {
					end--;
					cdCnt++;
				}
				cnt += abCnt * cdCnt;
			} else if (res > 0) {
				end--;
			} else {
				start++;
			}
		}

		System.out.println(cnt);
	}
}
