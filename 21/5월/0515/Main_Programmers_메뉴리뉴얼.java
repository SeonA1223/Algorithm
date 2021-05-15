package Day210515;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main_Programmers_메뉴리뉴얼 {
	static Map<String, Integer> map;
	static Set<String> set;
	static int m;

	static public String[] solution(String[] orders, int[] course) {
		Queue<String> pq = new PriorityQueue<>();

		for (int j = 0; j < course.length; j++) {
			map = new HashMap<>();
			m = 0;
			for (int i = 0; i < orders.length; i++) {
				comb(0, 0, "", orders[i], course[j]);
			}
			
			for(String s : map.keySet()) {
				if(m>1&&map.get(s)==m)
					pq.offer(s);
			}
		}
		
		String[] arr = new String[pq.size()];
		int k=0;
		while(!pq.isEmpty()) {
			arr[k++] = pq.poll();
		}
		return arr;
	}

	static public void comb(int start, int cnt, String ns, String s, int len) {

		if (cnt == len) {
			char[] arr = ns.toCharArray();
			Arrays.sort(arr);
			String ss = "";
			for (int i = 0; i < arr.length; i++)
				ss += arr[i];
			if (map.containsKey(ss))
				map.put(ss, map.get(ss) + 1);
			else
				map.put(ss, 1);
			m = Math.max(m, map.get(ss));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			char c = s.charAt(i);
			comb(i + 1, cnt + 1, ns + c, s, len);
		}
	}

}
