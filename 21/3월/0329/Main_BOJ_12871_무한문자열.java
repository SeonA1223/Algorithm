package problem210329;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_12871_무한문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String t = br.readLine();

		int sLen = s.length();
		int tLen = t.length();

		if (sLen == tLen) {
			if (s.equals(t))
				System.out.println("1");
			else
				System.out.println("0");
		} else {
			StringBuilder ss = new StringBuilder();
			StringBuilder tt = new StringBuilder();
			int diff = lcm(sLen, tLen);

			for (int i = 0; i < diff / sLen; i++) {
				ss.append(s);
			}
			for (int i = 0; i < diff / tLen; i++) {
				tt.append(t);
			}
			
			if(ss.toString().equals(tt.toString()))
				System.out.println("1");
			else
				System.out.println("0");

		}

	}

	static int lcm(int a, int b) { // 최소 공배수
		// 0이 아닌 두 수의 곱 / 두 수의 최대공약수
		return a * b / gcd(a, b);
	}

	static int gcd(int a, int b) { // 최대 공약수
		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);
	}
}
