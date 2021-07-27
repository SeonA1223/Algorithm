package problem210727;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_1043_거짓말 {
	static int N, M, T;
	static boolean[] tellTruthPerson, alreadyTellTruth;
	static List<Integer> parties[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tellTruthPerson = new boolean[N + 1];
		alreadyTellTruth = new boolean[M];
		parties = new ArrayList[M];

		for (int i = 0; i < M; i++) {
			parties[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			int p = Integer.parseInt(st.nextToken());
			tellTruthPerson[p] = true;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int p = Integer.parseInt(st.nextToken());
				parties[i].add(p);

			}
		}

		while (true) {
			boolean flag = false;
			flag = check(flag);
			if (!flag)
				break;
		}

		int res = 0;
		for (int i = 0; i < M; i++) {
			if (!alreadyTellTruth[i])
				res++;
		}

		System.out.println(res);
	}

	private static boolean check(boolean flag) {
		boolean tellTrue;
		for (int i = 0; i < M; i++) {
			if (alreadyTellTruth[i])
				continue;
			tellTrue = false;
			for (int p : parties[i]) {
				if (tellTruthPerson[p]) {
					tellTrue = true;
					break;
				}
			}
			if (tellTrue) {
				for (int p : parties[i]) {
					if (!tellTruthPerson[p]) {
						flag = true;
						tellTruthPerson[p] = true;
					}
				}
			}
		}
		return flag;
	}
}
