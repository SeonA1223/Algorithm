package problem210319;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1863_종교 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 학생수
		int m = Integer.parseInt(st.nextToken()); // 쌍의 수
		int faithCount = n;
		int parent[] = new int[n + 1];

		// make
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (union(parent, a, b))
				--faithCount;
		}
		System.out.println(faithCount);

	}

	private static boolean union(int[] parent, int a, int b) {
		int parentA = find(parent, a);
		int parentB = find(parent, b);
		if (parentA == parentB)
			return false;
		parent[parentB] = parentA;
		return true;
	}

	private static int find(int[] parent, int a) {
		if (parent[a] == a)
			return a;
		else
			return parent[a] = find(parent, parent[a]);
	}

}
