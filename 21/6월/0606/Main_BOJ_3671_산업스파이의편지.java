package Day210606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main_BOJ_3671_산업스파이의편지 {
	static final int LAST_NUM = 10000000;
	static boolean[] primeNumber = new boolean[LAST_NUM];
	static Set<Integer> set;
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		getPrimeNumber();
		int tc = Integer.parseInt(br.readLine());

		while (--tc >= 0) {
			char[] num = br.readLine().toCharArray();
			res = 0;
			set = new HashSet<>();
			// 부분집합 후 순열로 판단
			int allCase = 1 << num.length;
			subset(allCase, num);
			System.out.println(res);
		}

	}

	private static void subset(int allCase, char[] num) {
		List<Character> list = new ArrayList<>();
		for (int i = 1; i < allCase; i++) {
			list.clear();
			for (int j = 0; j < num.length; j++) {
				if ((i & 1 << j) != 0) {
					list.add(num[j]);
				}
			}
			perm(list, new StringBuilder(), new boolean[list.size()]);
		}

	}

	private static void perm(List<Character> list, StringBuilder sb, boolean[] visited) {
		if (sb.length() == list.size()) {
			int index = Integer.parseInt(sb.toString());
			if (!set.contains(index)) {
				set.add(index);
				if (!primeNumber[index])
					res++;
			}
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			sb.append(list.get(i));
			perm(list, sb, visited);
			sb.deleteCharAt(sb.length() - 1);
			visited[i] = false;
		}

	}

	private static void getPrimeNumber() {
		// 소수는 false
		primeNumber[0] = primeNumber[1] = true;

		for (int i = 2; i * i < LAST_NUM; i++) {
			if (!primeNumber[i]) {
				for (int j = i * i; j < LAST_NUM; j += i)
					primeNumber[j] = true;
			}
		}
	}
}
