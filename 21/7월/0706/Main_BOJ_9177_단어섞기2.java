package Day210706;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BOJ_9177_단어섞기2 {

	static void getAlphabet(Map<Character, Integer> map, String s) {
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Map<Character, Integer> map;
		Map<Character, Integer> total;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("Data set ").append(tc).append(": ");
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();
			boolean flag = true;
			map = new HashMap<>();
			total = new HashMap<>();
			getAlphabet(map, a);
			getAlphabet(map, b);
			getAlphabet(total, c);

			if(map.size() == total.size()) {
				for(char temp : map.keySet()) {
					if(total.get(temp) == null) {
						flag = false;
						break;
					}else {
						if(total.get(temp) != map.get(temp)) {
							flag = false;
							break;
						}
					}
				}
			}

			if (flag) {
				StringBuilder temp = new StringBuilder();
				if (dfs(0, 0, 0, temp, a, b, c)) {
					sb.append("yes");
				} else {
					sb.append("no");
				}

			} else {
				sb.append("no");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static boolean dfs(int aIndex, int bIndex, int cIndex, StringBuilder temp, String a, String b, String c) {
		if (temp.toString().equals(c)) {
			return true;

		}

		if (aIndex < a.length() && a.charAt(aIndex) == c.charAt(cIndex)) {
			if (dfs(aIndex + 1, bIndex, cIndex + 1, temp.append(a.charAt(aIndex)), a, b, c))
				return true;
			else {
				temp.deleteCharAt(aIndex);
			}
		}

		if (bIndex < b.length() && b.charAt(bIndex) == c.charAt(cIndex)) {
			if (dfs(aIndex, bIndex + 1, cIndex + 1, temp.append(b.charAt(bIndex)), a, b, c))
				return true;
			else {
				temp.deleteCharAt(bIndex);
			}
		}

		return false;
	}
}
