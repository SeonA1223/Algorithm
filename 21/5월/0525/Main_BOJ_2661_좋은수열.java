package Day210525;

import java.util.Scanner;

public class Main_BOJ_2661_좋은수열 {
	static int N;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		if (dfs(new StringBuilder("1")))
			return;
		if (dfs(new StringBuilder("2")))
			return;
		if (dfs(new StringBuilder("3")))
			return;

	}

	private static boolean dfs(StringBuilder sb) {
		if (sb.length() > N)
			return false;
		if (sb.length() == N) {
			if (check(sb)) {
				System.out.println(sb.toString());
				return true;
			}
			return false;
		}

			if (check(sb)) {
				char c = sb.charAt(sb.length() - 1);
				for (int i = 1; i <= 3; i++) {
					if (i != (c - '0')) {
						if (dfs(sb.append(i)))
							return true;
						sb.deleteCharAt(sb.length() - 1);
					}
				}
			} else {
				return false;
			}
		

		return false;

	}

	private static boolean check(StringBuilder sb) {
		int leng = sb.length();
		for(int c=leng/2; c>1; c--) {
			String s1 = sb.substring(sb.length()-c-c, sb.length()-c);
			String s2 = sb.substring(sb.length()-c, sb.length());
			
			if (s1.equals(s2))
				return false;
		}

		return true;
	}
}
