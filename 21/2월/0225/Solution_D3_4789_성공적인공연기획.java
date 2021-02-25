package problem210225;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_4789_성공적인공연기획 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			char s[] = br.readLine().toCharArray();
			int people = 0; // 박수치고 있는 사람들 합
			int hire = 0; // 기립박수를 치기 위해 고용해야하는 사람들

			for (int i = 0; i < s.length; i++) {
				if (people < i) {
					int value = i - people;
					hire += value;
					people += value; // 고용한 사람들도 추가해주기
				}
				people += s[i] - '0';

			}
			sb.append(hire).append("\n");
		}
		System.out.println(sb.toString());
	}

}
