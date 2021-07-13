package Day210711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_1956_운동 {
	static int V, E;
	static int dp[][];

	static class Node {
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	static List<Node>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		list = new ArrayList[V + 1];

		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list[a].add(new Node(b, c));
		}
		
		dp = new int[V+1][V+1];
		for(int i=0; i<=V; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		//플로이샬 워드 알고리즘 사용
		for(int k=1; k<=V; k++) { 	//경유지
			for(int i=1; i<=V; i++) { //출발
				for(int j=1; j<=V; j++) { //도착
					
				}
			}
		}
	}
}
