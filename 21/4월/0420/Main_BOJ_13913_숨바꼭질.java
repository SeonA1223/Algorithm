package Day210420;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main_BOJ_13913_숨바꼭질 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // 수빈
		int k = scan.nextInt(); // 동생

		if (k < n) { // 동생이 수빈이보다 뒤에 있을 경우
			System.out.println(n - k); // 시간
			for (int i = n; i >= k; i--) {
				System.out.print(i + " "); // 이동방법 출력
			}
		} else if (k == n) { // 수빈이와 동생이 같은 위치에 있을 경우
			System.out.println(0);
			System.out.println(n);
		} else { // 동생이 수빈이보다 앞에 있을 경우
			boolean visited[] = new boolean[100001];
			int parent[] = new int[100001];
			Queue<Integer> q = new LinkedList<>();
			Stack<Integer> s = new Stack<>();

			parent[n] = n;
			visited[n] = true;

			q.offer(n);

			int count = 0;
			int x, size;
			loop: while (!q.isEmpty()) {
				size = q.size();

				while (--size >= 0) {
					x = q.poll();

					if (x == k) {
						int index = k;
						s.push(index);
						while (index != n) {
							index = parent[index];
							s.push(index);
						}

						System.out.println(count);
						while(!s.isEmpty()) {
							System.out.print(s.pop() + " ");
						}
						break loop;
					}

					for (int nx : new int[] { x - 1, x + 1, x * 2 }) {
						if (isRange(nx)) {
							if (!visited[nx]) {
								visited[nx] = true;
								parent[nx] = x;
								q.offer(nx);
							}
						}
					}
				}
				count++;
			}

		}
	}

	private static boolean isRange(int nx) {
		if (0 <= nx && nx <= 100000)
			return true;
		return false;
	}
}
