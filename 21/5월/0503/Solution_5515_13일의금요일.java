package Day210503;

import java.util.Scanner;

public class Solution_5515_13일의금요일 {
	static int month[] = { 0, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = scan.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int m = scan.nextInt();
			int d = scan.nextInt();

			int res = month[m] + d;
			int mod = (res + 3) % 7;
			sb.append(mod % 7).append("\n");
		}
		System.out.println(sb.toString());
	}

}
