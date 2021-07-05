package Day210705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_BOJ_1501_영어읽기2 {
	static Map<String, Integer> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			if (temp.length > 1)
				Arrays.sort(temp, 1, temp.length - 1);

			StringBuilder c = new StringBuilder();
			for (int j = 0; j < temp.length; j++) {
				c.append(temp[j]);
			}

			String cs = c.toString();
			if (map.containsKey(cs)) {
				map.put(cs, map.get(cs) + 1);
			} else {
				map.put(cs, 1);
			}
		}

		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			int res = 1;
			String sentence = br.readLine();
			String[] words = sentence.split(" ");
			for (int j = 0; j < words.length; j++) {
				char[] temp = words[j].toCharArray();
				if (temp.length > 1)
					Arrays.sort(temp, 1, temp.length - 1);

				int cnt=0;
				StringBuilder c = new StringBuilder();
				for (int k = 0; k < temp.length; k++) {
					c.append(temp[k]);
				}

				String s = c.toString();

				if (map.get(s) != null) {
					cnt = map.get(s);
				}
				res *= cnt;
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}
}
