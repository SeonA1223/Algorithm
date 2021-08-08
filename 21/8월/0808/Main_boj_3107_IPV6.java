package Day210808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_3107_IPV6 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
		String ipv6 = br.readLine();
		String[] basic = new String[8];
		// 1번째 ::으로 나눈다.

		if (ipv6.contains("::")) {
			String[] ipv6s = ipv6.split("::");
			if (ipv6s.length == 0) {
				for (int i = 0; i < 8; i++) {
					basic[i] = "0000";
				}
			} else {
				String[] front = ipv6s[0].split(":");
				int frontSize = 0;
				if (front[0].equals(""))
					frontSize = 0;
				else
					frontSize = front.length;

				if (ipv6s.length > 1) {
					String[] back = ipv6s[1].split(":");
					int backSize = 0;

//4개를 기준으로 해도 되나 모르겠지만 일단 해봅시다
//			int totalLength = front.length + back.length;
					addZero(front, basic, 0, frontSize);
					if (back[0].equals(""))
						backSize = 0;
					else
						backSize = back.length;

					int index = 8 - backSize;
					for (int i = frontSize; i < index; i++) {
						basic[i] = "0000";
					}

					addLastZero(back, basic, 0, index);
				} else {
					addZero(front, basic, 0, frontSize);
					for (int i = frontSize; i < 8; i++) {
						basic[i] = "0000";
					}
				}
			}
		} else {
			String[] ipv6s = ipv6.split(":");
			addZero(ipv6s, basic, 0, 8);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			sb.append(basic[i]);
			if (i != 7) {
				sb.append(":");
			}
		}
		System.out.println(sb.toString());

	}

	private static void addZero(String[] ipv6s, String[] ans, int start, int index) {
		for (int i = start; i < index; i++) {
			StringBuilder sb = new StringBuilder(ipv6s[i]);
			if (sb.length() == 1) {
				sb.insert(0, "000");
			} else if (sb.length() == 2) {
				sb.insert(0, "00");
			} else if (sb.length() == 3) {
				sb.insert(0, "0");
			}

			ans[i] = sb.toString();
		}

	}

	private static void addLastZero(String[] ipv6s, String[] ans, int start, int index) {
		for (int i = start; i < ipv6s.length; i++) {
			StringBuilder sb = new StringBuilder(ipv6s[i]);
			if (sb.length() == 1) {
				sb.insert(0, "000");
			} else if (sb.length() == 2) {
				sb.insert(0, "00");
			} else if (sb.length() == 3) {
				sb.insert(0, "0");
			}

			ans[index++] = sb.toString();
		}
	}

}

