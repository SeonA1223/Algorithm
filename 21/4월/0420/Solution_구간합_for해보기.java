package Day210420;

import java.util.Scanner;

public class Solution_구간합_for해보기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			long A = sc.nextLong();
			long B = sc.nextLong();

			long p = 1;
			long[] data = new long[10];

			while (A <= B) {
				while (A <= B && B % 10 != 9) {
					cal(B, p, data);
					B--;
				}

				if (A > B)
					break;

				while (A <= B && A % 10 != 0) {
					cal(A, p, data);
					A++;
				}

				A /= 10;
				B /= 10;

				for (int i = 0; i < 10; i++) {
					data[i] += (B - A + 1) * p;
				}

				p *= 10;

			}

			long ans = 0;
			for (int i = 0; i < 10; i++) {
				ans += (data[i] * i);
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
		sc.close();
	}

	private static void cal(long b, long p, long[] data) {
		while (b > 0) {
			String s = String.valueOf(b);
			int x = s.charAt(s.length() - 1) - '0';
			data[x] += p;
			b /= 10;
		}

	}
}
