package Day210503;

import java.util.Scanner;

public class Main_JO_2078_13일의금요일 {
	static int month[] = { 0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
	static int day[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		day = new int[7];
		int start = 0;
		boolean flag;
		int mod;
		for (int n = 1; n <= N; n++) {
			// 윤년인지 아닌지 구하기
			int y = 1900 + n - 1;
			mod = 0;
			flag = false;
			if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
				flag = true;
			}

			for (int m = 1; m <= 12; m++) {
				if (flag) {
					if (m > 2) {
						mod = (month[m] + 13) % 7;
						day[(mod + start) % 7]++;

					} else {
						mod = (month[m] + 12) % 7;
						day[(mod + start) % 7]++;
					}
				} else {
					mod = (month[m] + 12) % 7;
					day[(mod + start) % 7]++;
				}
			}

			if (flag)
				start = (start + 2) % 7;
			else
				start = (start + 1) % 7;

		}
		for (int i = 0; i < 7; i++) {
			System.out.print(day[i] + " ");
		}
	}
}
