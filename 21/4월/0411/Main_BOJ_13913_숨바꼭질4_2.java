package Day210411;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main_BOJ_13913_숨바꼭질4_2 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();

		if (n > k) {
			System.out.println(n - k);
			for (int i = n; i >= k; i--) {
				System.out.print(i + " ");
			}
		} else if (n == k) {
			System.out.println("0");
			System.out.println(n);
		} else {
			boolean time[] = new boolean[100001];
			int parent[] = new int[100001];
			Queue<Integer> q = new LinkedList<>();
			Stack<Integer> s = new Stack<>();

			parent[n] = n;
			q.add(n);

			int x;
			int index;
			int count = 0;
			int size;
			loop:
			while (!q.isEmpty()) {
				size = q.size();
				for (int i = 0; i < size; i++) {

					x = q.poll();

					if (x == k) {
						s.push(k);
						index = k;

						while (index != n) {
							s.push(parent[index]);
							index = parent[index];
						}

						System.out.println(count);
						while (!s.isEmpty()) {
							System.out.print(s.pop() + " ");
						}
						break loop;
					}

					if (x + 1 >= 0 && x + 1 <= 100000 && !time[x + 1]) {
						time[x + 1] = true;
						parent[x + 1] = x;
						q.add(x + 1);
					}

					if (x - 1 >= 0 && x - 1 <= 100000 && !time[x - 1]) {
						time[x - 1] = true;
						parent[x - 1] = x;
						q.add(x - 1);
					}
					if (x * 2 >= 0 && x * 2 <= 100000 && !time[2 * x]) {
						time[x * 2] = true;
						parent[x * 2] = x;
						q.add(x * 2);
					}

				}
				count++;
			}
		}
	}

}
