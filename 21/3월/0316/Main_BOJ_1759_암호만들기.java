package problem210316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1759_암호만들기 {

	static StringBuilder sb;
	static int L, C;
	static String vowel = "aeiou";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		String[] s = new String[C];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			s[i] = st.nextToken();
		}

		Arrays.sort(s);

		sb = new StringBuilder();
		comb(s, 0, 0);

	}

	private static void comb(String[] s, int count, int start) {
		if (count == L) {
			if (judge()) {
				System.out.println(sb.toString());
			}
			return;
		}
		for (int i = start; i < C; i++) {
			sb.append(s[i]);
			comb(s, count + 1, i + 1);
			sb.setLength(sb.length() - 1);

		}

	}

	private static boolean judge() {
		int vowelCount = 0;
		for (int i = 0; i < L; i++) {
			if (vowel.contains(sb.substring(i, i+1))) {

				vowelCount++;
			}
		}
		if (vowelCount >= 1 && L - vowelCount >= 2)
			return true;
		else
			return false;
	}

}
