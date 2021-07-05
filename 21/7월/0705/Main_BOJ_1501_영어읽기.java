package Day210705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_BOJ_1501_영어읽기 {
	static int N, M;
	static Map<String, Map<Character, Integer>> map;
	static List<String> dic;

	static Map<Character, Integer> getAlphabet(String s, Map<Character, Integer> temp) {
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			if (temp.containsKey(c)) {
				temp.put(c, temp.get(c) + 1);
			} else {
				temp.put(c, 1);
			}
		}
		return temp;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		map = new HashMap<>();
		dic = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			dic.add(word);
			map.put(word, new HashMap<>());
			Map<Character, Integer> temp = map.get(word);
			map.put(word, getAlphabet(word, temp));
		}

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String sentence = br.readLine();
			String[] words = sentence.split(" ");
			int ans = 1;

			for (int j = 0; j < words.length; j++) {
				String word = words[j];
				Map<Character, Integer> temp = new HashMap<>();
				temp = getAlphabet(word, temp);

				int cnt = 0;

				for (int k = 0; k < N; k++) {
					String dWord = dic.get(k);
					boolean flag = false;
					if (word.length() == 1 && dWord.length() == 1 && word.equals(dWord)) {
						flag = true;
					}
					if (word.length() > 1 && dWord.length() > 1 && word.length() == dWord.length()
							&& word.charAt(0) == dWord.charAt(0)
							&& word.charAt(word.length() - 1) == dWord.charAt(dWord.length() - 1)) {

						flag = true;
						Map<Character, Integer> temp2 = map.get(dWord);

						for (char c : temp2.keySet()) {
							int value2 = temp2.get(c);
							if (temp.get(c) == null) {
								flag = false;
								break;
							} else {
								if (temp.get(c) != value2) {
									flag = false;
									break;
								}
							}
						}
					}
					if (flag)
						cnt++;
				}
				ans *= cnt;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());

	}
}


