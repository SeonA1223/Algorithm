package problem210619;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOj_1939_중량제한2 {
	static int N, M, A, B, result;
	static List<Node>[] list;
	static class Node {
		int connect;
		int price;

		public Node(int connect, int price) {
			super();
			this.connect = connect;
			this.price = price;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		result = 0;
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int maxLimit = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
			maxLimit = Math.max(maxLimit, c);
			//양방향이기 때문에
		}
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B =  Integer.parseInt(st.nextToken());
		
		int start = 0;
		int end = maxLimit;
		int mid = 0;
		while(start<=end) {
			mid = (start+end)/2;
			boolean[] visited = new boolean[N+1];
			if(dfs(mid, A, B, visited)) { //true면 연결됐다는 것이기 때문에, 백트래킹인데 이거
				result = mid;
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		System.out.println(result);
	}

	private static boolean dfs(int mid, int start, int end, boolean[] visited) {
		visited[start] = true;
		if(start == end) return true;
		
		for (Node node : list[start]) {
			if(!visited[node.connect] && node.price >= mid) {
				visited[node.connect] = true;
				if(dfs(mid, node.connect, end, visited)) return true;
			}
		}
		return false;
	}
}
