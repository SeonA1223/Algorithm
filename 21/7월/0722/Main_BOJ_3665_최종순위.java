package Day210722;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_3665_최종순위 {
	static boolean check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		while (--tc >= 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			Set<Integer>[] list = new HashSet[n + 1];
			check = false;
			for (int i = 0; i <= n; i++) {
				list[i] = new HashSet<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n; i++) {
				int s = arr[i];
				for (int j = i + 1; j < n; j++) {
					list[s].add(arr[j]);
				}
			}

			int c = Integer.parseInt(br.readLine());
			boolean flag = true;
			while (--c >= 0) {
				st = new StringTokenizer(br.readLine());
				int win = Integer.parseInt(st.nextToken());
				int lose = Integer.parseInt(st.nextToken());

				boolean isExist = false;

				if (list[lose].contains(win)) {
					isExist = true;
				}

				if (isExist) {
					list[lose].remove(win);
					list[win].add(lose);
					continue;
				} else {
					isExist = false;

					if (list[win].contains(lose)) {
						isExist = true;
					}
				}
				if (!isExist) {
					flag = false;
					break;
				} else {
					list[win].remove(lose);
					list[lose].add(win);
				}
			}
			if (flag) {
				PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

					@Override
					public int compare(int[] o1, int[] o2) {
						if(o1[1] == o2[1]) check = true;
						return o2[1] - o1[1];
					}

				});

				for (int i = 1; i <= n; i++) {
					pq.add(new int[] { i, list[i].size() });
				}
				if (check) {
					System.out.println("IMPOSSIBLE");
				} else {
					while (!pq.isEmpty()) {
						System.out.print(pq.poll()[0] + " ");
					}
					System.out.println();
				}
			} else {
				System.out.println("?");
			}
		}
	}
}

