//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main {
//	static int[][] room;
//	static int N, M, res;
//	static Map<String, List<int[]>> map;
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		res = 0;
//		room = new int[N + 1][N + 1];
//		map = new HashMap<>();
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			String s = "" + x + y;
//			if (map.containsKey(s)) {
//				map.get(s).add(new int[] { a, b });
//			} else {
//				map.put(s, new ArrayList<>());
//				map.get(s).add(new int[] { a, b });
//			}
//		}
//
//		Queue<int[]> q = new LinkedList<>();
//		boolean[][] turnon = new boolean[N + 1][N + 1];
//		boolean[][] visited = new boolean[N + 1][N + 1];
//		q.add(new int[] { 1, 1 });
//		visited[1][1] = true;
//		turnon[1][1] = true;
//
//		int dx[] = { 0, 0, -1, 1 };
//		int dy[] = { 1, -1, 0, 0 };
//
//		int[] temp;
//		while (!q.isEmpty()) {
//			temp = q.poll();
//			int x = temp[0];
//			int y = temp[1];
//
//			String s = "" + x + y;
//			if (map.containsKey(s)) {
//				List<int[]> tList = map.get(s);
//				for (int[] loc : tList) {
//					int tx = loc[0];
//					int ty = loc[1];
//					turnon[tx][ty] = true;
//					
//				}
//			}
//
//			for (int d = 0; d < 4; d++) {
//				int nx = x + dx[d];
//				int ny = y + dy[d];
//
//				if (nx <= 0 || nx > N || ny <= 0 || ny > N)
//					continue;
//				if (!turnon[nx][ny])
//					continue;
//				if (visited[nx][ny])
//					continue;
//
//				visited[nx][ny] = true;
//				q.add(new int[] { nx, ny });
//			}
//		}
//
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				if (turnon[i][j])
//					res++;
//			}
//		}
//		
//		System.out.println(res);
//
//	}
//
//}
