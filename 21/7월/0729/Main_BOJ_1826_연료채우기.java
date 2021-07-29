package problem210729;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1826_연료채우기 {
	static int N, des, fuel, cnt, start;
	static int before;
	static Node[] gasStation;
	static PriorityQueue<Node> pq;

	static class Node implements Comparable<Node> {
		int dis;
		int amount;

		public Node(int dis, int amount) {
			super();
			this.dis = dis;
			this.amount = amount;
		}

		@Override
		public int compareTo(Node o) {
			return this.dis - o.dis;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		gasStation = new Node[N];
		before = 0;
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int dis = Integer.parseInt(st.nextToken());
			int amount = Integer.parseInt(st.nextToken());
			gasStation[i] = new Node(dis, amount);
			pq.add(gasStation[i]);
		}
		Arrays.sort(gasStation);

		st = new StringTokenizer(br.readLine());
		des = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		cnt = 0;
		start = 0;

		while (true) {
			Node node = isLessThanFuel(start);
			if (node ==  null) {
				System.out.println(-1);
				break;
			}
			cnt++;
			fuel = fuel - node.dis + node.amount;
			before = node.dis;
			if (before >= des) {
				System.out.println(cnt);
				break;
			}
		}
	}

	private static Node isLessThanFuel(int index) {
		double temp = 0;
		Node node;
		Node best = null;
		while (!pq.isEmpty()) {
			node = pq.peek();
			if (node.dis < fuel) {
				int dis = node.dis - before;
				int amount = node.amount;
				double efficiency = (double) amount / (dis - before);
				pq.poll();
				if (temp < efficiency) {
					temp = amount / (dis - before);
					best = node;
				} else
					break;
			}
		}
		return best;
	}
}
