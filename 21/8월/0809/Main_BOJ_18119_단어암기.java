package problem210809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_18119_단어암기 {
	static int N, M;
	static boolean[][] words;
	static int check;
	static String vowel = "aeiou";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		words = new boolean[N][26];

		for (int i = 0; i < 26; i++) {
			check |= (1 << i);
		}

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				words[i][s.charAt(j) - 'a'] = true;
			}

		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			char letter = st.nextToken().charAt(0);

			if (number == 1) {
				// 잊기 => 0으로 바꾸기
				if ((check & (1 << (letter - 'a'))) != 0) {
					check ^= (1 << (letter - 'a'));
				}
			} else if (number == 2) {
				// 기억해낸다.
				if ((check & (1 << (letter - 'a'))) == 0) {
					check |= (1 << (letter - 'a'));
				}
			}

			int cnt = isKnowTheWord();
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static int isKnowTheWord() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			boolean flag = true;
			for (int j = 0; j < 26; j++) {
				if (!words[i][j])
					continue;
				if (words[i][j] && (check & (1 << j)) == 0) {
					flag = false;
					break;
				}
			}

			if (flag)
				cnt++;
		}
		return cnt;
	}
}
