package Day210416;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17471_게리멘더링 {
	static Node[] arr;
	static int[] zone, pNum;
	static int N, MinValue;

	static class Node {
		int vertex;
		Node next;

		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());  
		st = new StringTokenizer(br.readLine(), " ");
		pNum = new int[N + 1];
		zone = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			pNum[i] = Integer.parseInt(st.nextToken());
		}

		arr = new Node[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {
				arr[i] = new Node(Integer.parseInt(st.nextToken()), arr[i]);
			}
		}

		MinValue = 987654321;
		comb(0);
		System.out.println(MinValue == 987654321 ? -1 : MinValue);

	}

	private static void comb(int index) {
		if (index == N + 1) {
			if (check(0) && check(1)) {
				int res = getCount();
				MinValue = Math.min(res, MinValue);
			}
			return;
		}

		zone[index] = 1;
		comb(index + 1);
		zone[index] = 0;
		comb(index + 1);

	}

	private static boolean check(int value) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (zone[i] == value) {
				q.offer(i); // 연결된 걸 찾고 싶은 것이기 때문에 하나만 넣고 break로 나온다
				visited[i] = true;
				break;
			}
		}

		if (q.size() == 0)
			return false;

		int c;
		while (!q.isEmpty()) {
			c = q.poll();

			for (Node temp = arr[c]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex]) {
					if(zone[temp.vertex] == value) {
						visited[temp.vertex] = true;
						q.offer(temp.vertex);						
					}

				}

			}
		}
		for (int i = 1; i <= N; i++) {
			if (zone[i] == value) {
				if (!visited[i])
					return false;
			}
		}
		return true;

	}

	private static int getCount() {
		int A, B;
		A = B = 0;

		for (int i = 1; i <= N; i++) {
			if (zone[i] == 1) {
				A += pNum[i];
			} else {
				B += pNum[i];
			}
		}
		return Math.abs(A - B);
	}

}
