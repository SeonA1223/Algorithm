package Day210418;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Krusckal복습_RANK사용O {
	static int N;
	static int[] parent;
	static int[] rank;
	static Node[] list;
	// unionFind하기

	static private int find(int x) { // 부모 찾기
		if (parent[x] == -1)
			return x;
		return parent[x] = find(parent[x]);

	}

	private static boolean union(int x, int y) { // x가 y에 부모
		int px = find(x);
		int py = find(y);
		if (px == py)
			return false;
		
		if(rank[px] > rank[py]) {
			parent[py] = px;			
		}else {
			parent[px] = py;
			if(rank[px] == rank[py])
				rank[py]++;
		}
		return true;
	}
	
	public static class Node implements Comparable<Node>{
		int start;
		int end;
		int weight;
		public Node(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight; //오름차순
		}
		
		
	}
	
	public static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;	
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //정점 수
		int M = Integer.parseInt(st.nextToken()); //간선 수
		list = new Node[M];
		parent = new int[N+1]; //1부터 시작하므로
		rank = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[i] = new Node(start, end, weight);
	
		}
		
		Arrays.fill(parent, -1);
		Arrays.sort(list); //간선수 작은 것부터 시작해야한다. 
		
	}

	public static void main(String[] args) throws Exception {
		init();
		int con = 0;
		int res = 0;
		for (Node node: list) {
			if(union(node.start, node.end)) {
				res += node.weight;
				if(++con == N-1) break;
			}
		}
		
		System.out.println(res);
	}

}
