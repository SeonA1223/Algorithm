package Day210419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1708_블록껍질 {
	static int sx, sy;

	private static class Node implements Comparable<Node> {
		int x;
		int y;
		double degree;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			if (this.degree == o.degree) {
				if (this.x == o.x)
					return this.y - o.y;
				return this.x - o.x;
			} else {
				return (int) (this.degree - o.degree);
			}
		}

	}
	
	private static double CalDegree(int x1, int y1) {
		double radian = Math.atan(y1 - sy / x1 - sx);
		return Math.toDegrees(radian);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 점의 갯수
		Node[] nodes = new Node[N];
		int sx = Integer.MAX_VALUE;
		int sy = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (sy > y) {
				sx = x;
				sy = y;
			} else if (sy == y) {
				if (sx > x) {
					sx = x;
					sy = y;
				}
			}
			nodes[i] = new Node(x, y);
		}
		
		System.out.println(sx);
		for (int i = 0; i < N; i++) {
			nodes[i].degree = CalDegree(nodes[i].x, nodes[i].y);
		}
		
		Arrays.sort(nodes);
		for (int i = 0; i < N; i++) {
			System.out.println(nodes[i].x + " " + nodes[i].y + " " + nodes[i].degree);
		}
	}
}
