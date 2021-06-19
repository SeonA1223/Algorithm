package problem210619;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BOj_4195_친구네트워크2 {
	static Map<String, Integer> map;
	static int[] parent, count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (--T >= 0) {
			int F = Integer.parseInt(br.readLine());
			parent = new int[F * 2 + 1];
			count = new int[F * 2 + 1];
			Arrays.fill(count, 1);
			map = new HashMap<>();
			int index = 0;
			for (int i = 0; i < F; i++) {

				st = new StringTokenizer(br.readLine());
				String fa = st.nextToken();
				String fb = st.nextToken();

				if (!map.containsKey(fa)) {
					parent[index] = -1;
					map.put(fa, index++);
				}
				if (!map.containsKey(fb)) {
					parent[index] = -1;
					map.put(fb, index++);
				}

				union(map.get(fa), map.get(fb));
				System.out.println(count[find(map.get(fa))]);
			}
		}
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb) return; //이미 친구 관계
		parent[pa] = pb; //pa의 부모 pb
		count[pb] += count[pa]; //pb의 친구 + pa의 친구

	}
	
	private static int find(int a) {
		if(parent[a] == -1) return a;
		return parent[a] = find(parent[a]);
	}
}
