package Day210418;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_최적경로 {
	static Node company, home, nodes[];
	static int N;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			company = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			nodes = new Node[N]; // 0 : 회사 1 : 집
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				nodes[i] = new Node(x, y);
			}
			
			perm(0, 0,company.x, company.y, new boolean[N]);
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static void perm(int depth, int sum, int x, int y, boolean[] visited) {
		if(depth == N) {
			sum += getDistance(x, y, home.x, home.y);
			ans = Math.min(ans, sum);
			return;
		}
		
		if(sum > ans) return;
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			perm(depth+1, sum + getDistance(x,y, nodes[i].x, nodes[i].y), nodes[i].x, nodes[i].y, visited);
			visited[i] = false;
		}
		
	}

	private static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	private static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
