package problem210714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_BOJ_15927_회문은회문이아니야 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();

		int start = 0;
		int end = s.length() - 1;
		boolean flag = true;
		char before = ' ';

		while (start <= end) {
			char a = s.charAt(start);
			char b = s.charAt(end);

			if (a != b) {
				System.out.println(s.length());
				return;
			} else {
				if (before != ' ' && flag) {
					if (before != a)
						flag = false;
				}
				if (flag) {
					before = a;
				}
				start++;
				end--;

			}
		}
		
		if(flag) {
			System.out.println(-1);
		}else {
			System.out.println(s.length()-1);
		}
	}
}
