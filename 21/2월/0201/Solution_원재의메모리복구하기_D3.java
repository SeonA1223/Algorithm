package problem210201;

import java.util.Scanner;

public class Solution_원재의메모리복구하기_D3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String originalValue = sc.next();

			int count = 0;

			if (originalValue.charAt(0) == '1') {
				count += 1;
			}

			for (int i = 0; i < originalValue.length()-1; i++) {
				if (originalValue.charAt(i) != originalValue.charAt(i + 1))
					count += 1;
			}
			System.out.println("#" + test_case + " " + count);
		}

	}

}
