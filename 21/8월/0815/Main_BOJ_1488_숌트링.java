package problem210815;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1488_숌트링 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long countA = Long.parseLong(st.nextToken());
		long countB = Long.parseLong(st.nextToken());
		long maxA = Long.parseLong(st.nextToken());
		long maxB = Long.parseLong(st.nextToken());

		if (maxA > 0 && maxB > 0) {
			if (countA == countB) {
				System.out.println(countA + countB);
			} else if (countA - countB < 0) {
				// countB가 클 경우, A는 다 쓴 경우
				long useB = countA + 1;
				long leftB = countB - useB;
				if ((long) useB * (maxB - 1) >= leftB) {
					System.out.println(countA + countB);
				} else {
					System.out.println(countA + useB * maxB);
				}

			} else {
				// countA가 클 경우
				long useA = countB + 1;
				long leftA = countA - useA;
				if ((long) useA * (maxA - 1) >= leftA) {
					System.out.println(countA + countB);
				} else {
					System.out.println(useA * maxA + countB);
				}

			}

		} else {
			if (maxA == 0) {
				System.out.println(Math.min(countB,maxB));
			} else if (maxB == 0) {
				System.out.println(Math.min(countA, maxA));
			} else {
				System.out.println(0);
			}
		}
	}
}
