package problem210616;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BOj_4195_친구네트워크 {
	static Map<String, String> map;
	static Map<String, Integer> cnt;

	static void union(String first, String second) {
		if (!map.containsKey(first)) {
			map.put(first, "-1");
			cnt.put(first, 1);
		}
		if (!map.containsKey(second)) {
			map.put(second, "-1");
			cnt.put(second, 1);
		}

		String pA = findParent(first);
		String pB = findParent(second);
		if (pA == pB)
			return;

		map.put(pA, pB);
		cnt.put(pB, cnt.get(pB) + cnt.get(pA));
	}

	static String findParent(String node) {
		if (map.get(node).equals("-1"))
			return node;

		map.put(node, findParent(map.get(node)));
		return map.get(node);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		while (--T >= 0) {
			int conCnt = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			cnt = new HashMap<>();
			for (int i = 0; i < conCnt; i++) {
				st = new StringTokenizer(br.readLine());
				String first = st.nextToken();
				String second = st.nextToken();
				union(first, second);
				System.out.println(cnt.get(findParent(first)));

			}
		}
	}
}
