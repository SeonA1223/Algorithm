//package problem210324;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main_BOJ_2636_치즈 {
//	static int N, M, count;
//	static int[][] cheese;
//	static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
//	static boolean[][] visited;
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		st = new StringTokenizer(br.readLine(), " ");
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//
//		cheese = new int[N][M];
//		visited = new boolean[N][M];
//
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			for (int j = 0; j < M; j++) {
//				cheese[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//
//		count = 0;
//		int time = 0;
//		int before = 0;
//		visited[0][0] = true;
//
//		
//		do {
//			dfs(0,0);
//			time++;
//		}while();
////		System.out.println(time);
////		System.out.println(before);
//	}
//
//	private static boolean dfs(int x, int y) {
//		for (int i = 0; i < 4; i++) {
//			int nx = x + dir[i][0];
//			int ny = y + dir[i][1];
//
//			if (!visited[nx][ny] && 0 <= nx && nx < N && 0 <= ny && ny < M) {
//				visited[nx][ny] = true;
//				if (cheese[nx][ny] == 1) {
//					cheese[nx][ny] = 2;
//					count++;
//
//				} else {
//					dfs(nx, ny);
//
//				}
//			}
//			return false;
//
//		}
//
//	}
//
//	private static void remove(int[][] arr) {
//		int count = 0;
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				if (arr[i][j] == 2) {
//					arr[i][j] = 0;
//					count++;
//				}
//			}
//		}
//	}
//}
