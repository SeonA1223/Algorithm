package Day210420;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_숨바꼭질5 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();

		if (n == k) {
			System.out.println("0");
		} else {
			final int MaxCoor = 500000;
			boolean visited[][] = new boolean[2][MaxCoor + 1];
			Queue<Integer> q = new LinkedList<>();

			q.offer(n);
			visited[0][n] = true;

			int size;
			int x;
			int y = k;
			int time = 0;
			int mod = 0;
			while (!q.isEmpty()) {
				size = q.size();
				time++;
				y += time;
				mod = time % 2;

				if (y > MaxCoor) {
					System.out.println(-1);
					break;
				}

				while (--size >= 0) {
					x = q.poll();

					for (int nx : new int[] { x + 1, x - 1, 2 * x }) {
						if (0 <= nx && nx <= MaxCoor) {
							if (!visited[mod][nx]) {
								visited[mod][nx] = true;
								q.offer(nx);
							}
						}

					}
				}
				
				if(visited[mod][y]) {
					System.out.println(time);
					break;
				}
			}

		}
	}
}
