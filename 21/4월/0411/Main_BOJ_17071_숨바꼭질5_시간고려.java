package Day210411;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_17071_숨바꼭질5_시간고려 {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();

		if (n == k) {
			System.out.println("0");
			return;
		}

		final int MAX_NUM = 500000;
		boolean visited[][] = new boolean[2][MAX_NUM + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(n);

		int time = 0;
		int x;
		int y = k;
		int size;
		int mod = 0;
		while (!q.isEmpty()) {
			size = q.size();

			for (int i = 0; i < size; i++) {
				x = q.poll();
				mod = time % 2;

				if (x == y) {
					System.out.println(time);
					return;
				}
				for (int nx : new int[] { x + 1, x - 1, x * 2 }) {
					if (0 <= nx && nx <= MAX_NUM && !visited[mod][nx]) {
						visited[mod][nx] = true;
						q.add(nx);
					}
				}
			}
			y += ++time;
			if (y > MAX_NUM) {
				System.out.println("-1");
				return;
			}
			if (visited[mod][y]) {
				System.out.println(time);
				return;
			}
		}

	}

}
