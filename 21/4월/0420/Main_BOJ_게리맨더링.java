package Day210420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_게리맨더링 {
	static int N;
	static int p[];
	static Node nodes[];
	static int ans;

	static public class Node {
		int x;
		Node next;

		public Node(int x, Node next) {
			super();
			this.x = x;
			this.next = next;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		p = new int[N + 1];
		nodes = new Node[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {
				int connect = Integer.parseInt(st.nextToken());
				nodes[i] = new Node(connect, nodes[i]);
			}

		}

		ans = Integer.MAX_VALUE;
		subset(1, new int[N + 1]);
		System.out.println(ans == Integer.MAX_VALUE ? "-1" : ans);

	}

	private static void subset(int index, int[] value) {
		if (index == N + 1) {
			if (connect(1, value) && connect(0, value)) {
				ans = Math.min(ans, calc(value));
			}
			return;

		}
		value[index] = 1;
		subset(index + 1, value);
		value[index] = 0;
		subset(index + 1, value);

	}

	private static int calc(int[] value) {
		int a = 0;
		int b = 0;
		for (int i = 1; i < N + 1; i++) {
			if (value[i] == 1) {
				a += p[i];
			} else {
				b += p[i];
			}
		}
		return Math.abs(a - b);
	}

	private static boolean connect(int i, int[] value) {
		boolean visited[] = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();

		for (int j = 1; j < N + 1; j++) {
			if (value[j] == i) {
				q.offer(j);
				visited[j] = true;
				break;
			}
		}

		if (q.isEmpty())
			return false;

		while (!q.isEmpty()) {
			int x = q.poll();

			for (Node node = nodes[x]; node != null; node = node.next) {
				if (!visited[node.x]) {
					if (value[node.x] == i) {
						visited[node.x] = true;
						q.offer(node.x);
					}
				}
			}
		}

		for (int j = 1; j < N + 1; j++) {
			if (value[j] == i) {
				if (!visited[j])
					return false;
			}
		}

		return true;
	}
}
