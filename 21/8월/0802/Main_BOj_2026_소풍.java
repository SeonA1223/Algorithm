//package problem210802;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main_BOj_2026_소풍 {
//	static int K, N, F;
//	static List<Integer>[] friends;
//	static boolean[] visited;
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		st = new StringTokenizer(br.readLine());
//		K = Integer.parseInt(st.nextToken());
//		N = Integer.parseInt(st.nextToken());
//		F = Integer.parseInt(st.nextToken());
//
//		friends = new ArrayList[N + 1];
//		visited = new boolean[N + 1];
//
//		for (int i = 0; i <= N; i++) {
//			friends[i] = new ArrayList<>();
//		}
//
//		for (int i = 0; i < F; i++) {
//			st = new StringTokenizer(br.readLine());
//			int n = Integer.parseInt(st.nextToken());
//			int m = Integer.parseInt(st.nextToken());
//
//			friends[n].add(m);
//			friends[m].add(n);
//		}
//
//		for (int i = 1; i <= N; i++) {
//			Collections.sort(friends[i]);
//		}
//
//		boolean flag = false;
//		visited = new boolean[N + 1];
//		Queue<Integer> queue = new LinkedList<>();
//		for (int i = 1; i <= N; i++) {
//			queue.isEmpty();
//			if (dfs(i, queue)) {
//				for(int j=1; j<=N; j++) {
//					if(visited[j]) {
//						System.out.println(j);
//					}
//				}
//				flag = true;
//				break;
//			}
//
//		}
//		if (!flag) {
//			System.out.println(-1);
//		}
//	}
//
//	private static boolean dfs(int current, Queue<Integer> queue) {
//		if(friends[current].size() < K-1) return false;
//		for (int i = 1; i <= N; i++) {
//			if (!visited[i])
//				continue;
//
//			boolean flag = false;
//			for (int temp : friends[i]) {
//				if (temp == current) {
//					flag = true;
//					break;
//				}
//			}
//			if (!flag) {
//				return false;
//			}
//
//		}
//
//		visited[current] = true;
//		if (index == K)
//			return true;
//
//		for (int friend : friends[current]) {
//			if (!visited[friend]) {
//				if (dfs(friend, index+1))
//					return true;
//				visited[friend] = false;
//			}
//		}
//		return false;
//	}
//}
//
//
//
