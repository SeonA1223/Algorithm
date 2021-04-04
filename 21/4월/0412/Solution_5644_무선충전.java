//package Day210412;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Solution_5644_무선충전 {
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
//
//		int T = Integer.parseInt(br.readLine());
//
//		int dx[] = new int[] { 0, -1, 0, 1, 0 }; // 이동X, 상, 우, 하, 좌
//		int dy[] = new int[] { 0, 0, 1, 0, -1 };
//
//		for (int tc = 1; tc <= T; tc++) {
//			sb.append("#").append(tc).append(" ");
//
//			st = new StringTokenizer(br.readLine(), " ");
//			int time = Integer.parseInt(st.nextToken());
//			int bc = Integer.parseInt(st.nextToken());
//
//			int result = 0;
//			int max = 0;
//
//			st = new StringTokenizer(br.readLine(), " ");
//			int[] adis = new int[time+1];
//
//			for (int i = 1; i <= time; i++) {
//				adis[i] = Integer.parseInt(st.nextToken());
//			}
//
//			st = new StringTokenizer(br.readLine(), " ");
//			int[] bdis = new int[time+1];
//
//			for (int i = 1; i <= time; i++) {
//				bdis[i] = Integer.parseInt(st.nextToken());
//			}
//
//			int[][] bcs = new int[bc][4];
//			for (int i = 0; i <bc; i++) {
//				st = new StringTokenizer(br.readLine(), " ");
//				for (int j = 0; j < 4; j++) {
//					bcs[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//
//			boolean[][] visited = new boolean[2][bc];
//			int[] A = new int[] { 1, 1 };
//			int[] B = new int[] { 10, 10 };
//			
//			for (int i = 0; i <= time; i++) {
//				int nay = A[0] + dx[adis[i]];
//				int nax = A[1] + dy[adis[i]];
//
//				int nby = B[0] + dx[bdis[i]];
//				int nbx = B[1] + dy[bdis[i]];
//
//				
//				for (int j = 0; j < bc; j++) {
//					if (getDistance(nax, nay, bcs[j][0], bcs[j][1]) <= bcs[j][2]) {
//						visited[0][j] = true;
//					}
//
//					if (getDistance(nbx, nby, bcs[j][0], bcs[j][1]) <= bcs[j][2]) {
//						visited[1][j] = true;
//					}
//				}
//
//				max = 0;
//				for (int j = 0; j < bc; j++) {
//					for (int k = 0; k < bc; k++) {
//						if(visited[0][j]) {
//							if(visited[1][k]) {
//								if(j==k) {
//									max = Math.max(max, Math.max(bcs[j][3], bcs[k][3]));
//								}else {
//									max = Math.max(max, bcs[j][3] + bcs[k][3]);
//								}
//							}else {
//								max = Math.max(max, bcs[j][3]);
//							}
//						}else {
//							if(visited[1][k])
//								max = Math.max(max, bcs[k][3]);
//						}
//					}
//						
//				}
//
//				result += max;
//				A[1] = nax;
//				A[0] = nay;
//				B[1] = nbx;
//				B[0] = nby;
//				Arrays.fill(visited[0], false);
//				Arrays.fill(visited[1], false);
//			}
//			sb.append(result).append("\n");
//		}
//		System.out.println(sb.toString());
//
//	}
//
//	private static int getDistance(int nax, int nay, int x, int y) {
//		return Math.abs(nax - x) + Math.abs(nay - y);
//
//	}
//
//}
