package Day210420;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_숨바꼭질2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(); // 수빈
		int k = scan.nextInt(); // 동생

		if (k < n) { // 동생이 수빈이보다 뒤에 있을 경우
			System.out.println(n - k);
			System.out.println(1);
		} else if (k == n) { // 수빈이와 동생이 같은 위치에 있을 경우
			System.out.println(0);
			System.out.println(1);
		} else { // 동생이 수빈이보다 앞에 있을 경우
			Queue<Integer> q = new LinkedList<>();
			int visited[] = new int[1000001];
			// 해당 위치에 오는 시간을 저장하기 not 해당 위치에 몇번 오는지는 중요하지 않음.
			// 첫 방문이거나, 동일한 시간에 또 방문한다면 가능성이 있기 때문

			q.offer(n);
			visited[n] = 1;

			int x;
			int size = 0;
			int cases = 0;
			int count = 0;
			boolean flag = false;
			while (!q.isEmpty()) {
				size = q.size();

				while (--size >= 0) {
					x = q.poll();

					for (int nx : new int[] { x + 1, x - 1, x * 2 }) {
						if (isRange(nx)) {
							if (nx == k) {
								count++;
								visited[nx] = visited[x] + 1;
								flag = true;
							} else if (visited[nx] == 0 || visited[nx] == visited[x] + 1) {
								q.offer(nx);
								visited[nx] = visited[x] + 1;
							}
						}
					}

				}
				if(flag) break;
			}
			System.out.println(visited[k] - 1);
			System.out.println(count);
		}
	}

	private static boolean isRange(int nx) {
		if (0 <= nx && nx <= 100000)
			return true;
		else
			return false;
	}
}
