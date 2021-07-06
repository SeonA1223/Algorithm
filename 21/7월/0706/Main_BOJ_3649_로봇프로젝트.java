package Day210706;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_3649_로봇프로젝트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null) {
			int x = Integer.parseInt(s);
			int n = Integer.parseInt(br.readLine());
			int[] lego = new int[n];
			for (int i = 0; i < n; i++) {
				lego[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(lego);
			x *= 10000000;

			int start = 0;
			int end = n - 1;
			int temp = 0;
			int l1 = 0;
			int l2 = 0;
			boolean flag = false;
			while (start < end) {
				temp = lego[start] + lego[end];
				if (temp == x) {
					flag = true;
					l1 = lego[start];
					l2 = lego[end];
					break;
				}

				if (temp < x) {
					start++;
				}
				if (temp > x) {
					end--;
				}
			}

			if (flag) {
				System.out.println("yes " + l1 + " " + l2);
			} else {
				System.out.println("danger");
			}

		}
	}
}
