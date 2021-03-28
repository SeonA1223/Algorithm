package problem210328;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11650_좌표정렬하기_comparator {
	static class Node implements Comparator<Node> {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compare(Node o1, Node o2) {
			if (o1.x == o2.x)
				return Integer.compare(o1.y, o2.y);
			return Integer.compare(o1.x, o2.x);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Node[] nodes;

		int N = Integer.parseInt(br.readLine());
		nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

//		Arrays.sort(nodes, new Node(N, N));
//		Arrays.sort(nodes, (o1, o2) -> {
//			if (o1.x == o2.x)
//				return Integer.compare(o2.y, o1.y);
//			return Integer.compare(o2.x, o1.x);
//		});

//		Arrays.sort(nodes, Comparator.reverseOrder()); => comparable일때만 가능하다

		Arrays.sort(nodes, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return 0;
			}

		});

		
		PriorityQueue<Node> pq = new PriorityQueue<>((s1, s2) -> Integer.compare(s1.x, s2.x));
		for (Node node : nodes) {
			System.out.println(node.x + " " + node.y);
		}
	}

}
