package problem210620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main_BOJ_10775_공항_시간초과 {
	static int Gate, Plane, res;
	static Integer planeDock[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Gate = Integer.parseInt(br.readLine());
		Plane = Integer.parseInt(br.readLine());
		res = 0;
		planeDock = new Integer[Plane];
		for (int i = 0; i < Plane; i++) {
			planeDock[i] = Integer.parseInt(br.readLine());
		}

		dfs(0, new boolean[Gate + 1], 0);
		System.out.println(res);

	}

	private static boolean dfs(int depth, boolean[] visited, int cnt) {
		// 모든 비행기가 도킹됐으면
		if (depth == Plane) {
			res = Plane;
			return true;
		}

		for (int i = planeDock[depth]; i > 0; i--) {
			if (visited[i]) continue;
			visited[i] = true;
			if(dfs(depth + 1, visited, cnt + 1)) return true;
		}
		res = cnt;
		return true;
	}
}
