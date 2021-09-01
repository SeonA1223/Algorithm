import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_16637_괄호추가하기 {
	static int N;
	static int maxRes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		maxRes = Integer.MIN_VALUE;
		char[] express = br.readLine().toCharArray();

		// 가능한 괄호 갯수
		int bracketNum = (N / 2) / 2;

		for (int i = 0; i <= bracketNum; i++) {
			setBracket(express, 0, 0, i, new boolean[N]);
		}
		
		System.out.println(maxRes);

	}

	private static void setBracket(char[] express, int start, int cnt, int bracket, boolean[] checked) {
		if (cnt == bracket) {
			calc(express, checked, bracket);
			return;
		}
		for (int i = start; i <= N-2; i += 2) {
			if (checked[i])
				continue;
			for (int j = i; j <= i + 2; j++) {
				checked[j] = true;
			}
			setBracket(express, start + 2, cnt + 1, bracket, checked);
			for (int j = i; j <= i + 2; j++) {
				checked[j] = false;
			}
		}

	}

	private static void calc(char[] express, boolean[] checked, int bracket) {
		int[] temp = new int[N];
		Arrays.fill(temp, Integer.MAX_VALUE);

		for (int i = 0; i < N-2; i++) {
			if (checked[i]) {
				int before = express[i] - '0';
				char exp = express[i + 1];
				int after = express[i + 2] - '0';

				if (exp == '+') {
					temp[i] = before + after;
				} else if (exp == '*') {
					temp[i] = before - after;
				} else if (exp == '-') {
					temp[i] = before * after;
				}

				i += 2;
			}
		}

		if (temp[1] != Integer.MAX_VALUE) {
			dfs(express, 3, temp[1], temp);
		} else {
			dfs(express, 1, express[0] - '0', temp);
		}
	}

	private static void dfs(char[] express, int index, int res, int[] temp) {
		if (index >= N) {
			maxRes = Math.max(maxRes, res);
			return;
		} else {
			char exp = express[index];
			boolean flag = false;
			int after;
			if (temp[index + 1] != Integer.MAX_VALUE) {
				flag = true;
				after = temp[index + 1];
			} else {
				after = express[index + 1] - '0';
			}
			if (flag)
				index += 2;
			switch (exp) {
			case '+':
				dfs(express, index + 2, res + after, temp);
				break;
			case '-':
				dfs(express, index + 2, res - after, temp);
				break;
			case '*':
				dfs(express, index + 2, res * after, temp);
				break;
			}
		}

	}
}
