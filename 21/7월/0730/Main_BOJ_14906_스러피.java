package problem210730;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_14906_스러피 {
	static int num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		System.out.println("SLUPPYS OUTPUT");
		while (--tc >= 0) {
			char[] c = br.readLine().toCharArray();
			num = 0;
			int len = slimp(c, 0);
			if (len == -1 || len >= c.length) {
				System.out.println("NO");
				continue;
			}

			if (slump(c, len)) {
				if (num >= c.length) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			} else {
				System.out.println("NO");
			}
		}
		System.out.println("END OF OUTPUT");
	}

	private static int slimp(char[] c, int i) {
		int len = -1;
		if (i >= c.length - 1)
			return -1;
		if (c[i] == 'A') {
			if (c[i + 1] == 'B') {
				len = slimp(c, i + 2);
			} else if (c[i + 1] == 'H') {
				return i + 2;
			} else {
				if (slump(c, i + 1))
					len = num;
			}
			if (len == -1)
				return -1;
			else {
				if (c[len] == 'C')
					return len + 1;
			}
		}
		return -1;
	}

	private static boolean slump(char[] c, int i) {
		if (i >= c.length)
			return false;
		if (c[i] == 'D' || c[i] == 'E') {
			int cnt = 0;
			int index = i + 1;
			while (true) {
				if (index >= c.length)
					break;
				if (c[index] == 'F')
					cnt++;
				if (cnt >= 1 && c[index] == 'G') {
						break;
				}
				if (c[index] == 'E' || c[index] == 'D') {
					if (slump(c, index))
						return true;
					else
						return false;
				}

				if (c[index] != 'E' && c[index] != 'F' && c[index] != 'G' && c[index] != 'D')
					return false;
				index++;
			}
			num = index + 1;
		} else {
			return false;
		}
		return true;
	}

}

