//package problem210626;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main_BOJ_인성문제있어_19952_bfs {
//	static int H, W, O, F, sx, sy, ex, ey;
//	static int arr[][];
//	static int dx[] = { -1, 1, 0, 0 };
//	static int dy[] = { 0, 0, 1, -1 };
//	static String success = "잘했어!!";
//	static String fail = "인성 문제있어??";
//
//	static class Node implements Comparable<Node>{
//		int x, y;
//		int f;
//
//		public Node(int x, int y, int f) {
//			super();
//			this.x = x;
//			this.y = y;
//			this.f = f;
//		}
//
//		@Override
//		public int compareTo(Node o) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//
//	}
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		Map<Integer, Integer> map = new HashMap<>();
//		map.
//
//		int tc = Integer.parseInt(br.readLine());
//
//		while (--tc >= 0) {
//			st = new StringTokenizer(br.readLine());
//			H = Integer.parseInt(st.nextToken());
//			W = Integer.parseInt(st.nextToken());
//			O = Integer.parseInt(st.nextToken());
//			F = Integer.parseInt(st.nextToken());
//			sy = Integer.parseInt(st.nextToken());
//			sx = Integer.parseInt(st.nextToken());
//			ey = Integer.parseInt(st.nextToken());
//			ex = Integer.parseInt(st.nextToken());
//
//			arr = new int[W + 1][H + 1];
//
//			for (int i = 0; i < O; i++) {
//				st = new StringTokenizer(br.readLine());
//				int y = Integer.parseInt(st.nextToken());
//				int x = Integer.parseInt(st.nextToken());
//				int h = Integer.parseInt(st.nextToken());
//				arr[x][y] = h;
//			}
//
//			boolean isArrival = bfs();
//			System.out.println(isArrival ? success : fail);
//			
//		}
//	}
//
//	private static boolean bfs() {
//		Queue<Node> q = new LinkedList<>();
//		boolean visited[][] = new boolean[W + 1][H + 1];
//		q.offer(new Node(sx, sy, F));
//		visited[sx][sy] = true;
//		
//		Node temp = null;
//		while(!q.isEmpty()) {
//			temp = q.poll();
//			int x = temp.x;
//			int y = temp.y;
//			int height = arr[x][y];
//			
//			if(x == ex && y == ey) {
//				return true;
//			}
//			
//			if(temp.f <= 0) return false;
//			
//			for (int i = 0; i <4; i++) {
//				int nx = x + dx[i];
//				int ny = y + dy[i];
//				
//				if(isValid(nx, ny) && !visited[nx][ny]) {
//					int nheight = arr[nx][ny];
//					if (height > nheight) {
//						visited[nx][ny] = true;
//						q.offer(new Node(nx, ny, temp.f-1));
//					} else {
//						int jump = nheight - height;
//						if (jump <= temp.f) {
//							visited[nx][ny] = true;
//							q.offer(new Node(nx, ny, temp.f-1));
//						}
//
//					}
//				}
//			}
//		}
//		return false;
//	}
//	
//	private static boolean isValid(int x, int y) {
//		if (x <= 0 || x > W || y <= 0 || y > H)
//			return false;
//		else
//			return true;
//	}
//}
