package problem210714;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_16916_부분문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();

		if (S.length() == P.length()) {
			if (S.equals(P)) {
				System.out.println(1);
				return;
			} else {
				System.out.println(0);
				return;
			}
		}
		char[] Schar = S.toCharArray();
		char[] Pchar = P.toCharArray();
		int[] fail = new int[P.length()];

		for (int i = 1, j = 0; i < P.length(); i++) {
			while (j > 0 && Pchar[i] != Pchar[j]) {
				j = fail[j - 1];
			}
			if (Pchar[i] == Pchar[j])
				fail[i] = ++j;
		}

		int j = 0;
		int result = 0;
		for (int i = 0; i < Schar.length; i++) {
			while (j > 0 && Schar[i] != Pchar[j]) {
				j = fail[j - 1];
			}
			if (Schar[i] == Pchar[j]) {
				if (j == Pchar.length - 1) {
					result = 1;
					break;
				} else
					++j;
			}
		}
		System.out.println(result);
	}
}
