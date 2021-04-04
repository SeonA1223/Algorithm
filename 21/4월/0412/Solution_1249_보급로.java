//package Day210412;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Solution_1249_보급로 {
////	private static class Node implements Comparable<Node> {
////		int x, y;
////		int s;
////
////		public Node(int x, int y, int s) {
////			super();
////			this.x = x;
////			this.y = y;
////			this.s = s;
////		}
////
////		@Override
////		public int compareTo(Node o) {
////			return this.s - o.s;
////		}
////
////	}
//	
//	private static class Node  {
//		int x, y;
//		int s;
//
//		public Node(int x, int y, int s) {
//			super();
//			this.x = x;
//			this.y = y;
//			this.s = s;
//		}
//
//	}
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//
//		int T = Integer.parseInt(br.readLine());
//
//		for (int tc = 1; tc <= T; tc++) {
//			sb.append("#").append(tc).append(" ");
//
//			int n = Integer.parseInt(br.readLine());
//
//			int map[][] = new int[n][n];
//			int visited[][] = new int[n][n];
//			int dx[] = { 0, 0, 1, -1 };
//			int dy[] = { 1, -1, 0, 0 };
//
//			String s;
//			for (int i = 0; i < n; i++) {
//				s = br.readLine();
//				for (int j = 0; j < n; j++) {
//					map[i][j] = s.charAt(j) - '0';
//				}
//			}
//
////			PriorityQueue<Node> q = new PriorityQueue<>();
//			int min = Integer.MAX_VALUE;
//			Queue<Node> q = new LinkedList<>();
//			q.add(new Node(0, 0, 0));
//
//			Node temp;
//			while (!q.isEmpty()) {
//				temp = q.poll();
//				int x = temp.x;
//				int y = temp.y;
//
//				if (x == n - 1 && y == n - 1) {
//					min = Math.min(min, temp.s);
//					continue;
//				}
//
//				for (int i = 0; i < 4; i++) {
//					int nx = x + dx[i];
//					int ny = y + dy[i];
//
//					if (0 > nx || nx >= n || 0 > ny || ny >= n)
//						continue;
//
//					if (!visited[nx][ny]) {
//						visited[nx][ny] = true;
//						q.add(new Node(nx, ny, temp.s + map[nx][ny]));
//					}
//
//				}
//			}
//			sb.append(min).append("\n");
//
//		}
//		System.out.println(sb.toString());
//	}
//}
