package problem210612;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//35분
public class Main_BOJ_14621_나만안되는연예 {
	static int N, M;
	static char university[];
	static int connect[];
	static int rank[];
	static Node[] list;

	static class Node implements Comparable<Node> {
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
			return this.weight - o.weight;
		}

	}

	static int find(int x) {
		if (connect[x] == -1)
			return x;
		return connect[x] = find(connect[x]);
	}

	static boolean union(int x, int y) { // x가 y에 부모
		int cx = find(x);
		int cy = find(y);
		if (cx == cy)
			return false; // 이미 연결됐다는 뜻

		if (rank[cx] > rank[cy]) {// 랭크 사용
			connect[cy] = cx;
		} else {
			connect[cx] = cy;
			if (rank[cx] == rank[cy])
				rank[cy]++;
		}
		return true;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학교 수
		M = Integer.parseInt(st.nextToken()); // 도로의 갯수

		university = new char[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			university[i] = st.nextToken().charAt(0);
		}

		list = new Node[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[i] = new Node(start, end, weight);
		}

		connect = new int[N + 1];
		rank = new int[N + 1];
		Arrays.fill(connect, -1);
		Arrays.sort(list);

		int routeLen = 0;
		int conCnt = 0;
		for(Node node : list) {
			if(university[node.start] == university[node.end]) continue;
			if(union(node.start, node.end)) {
				routeLen += node.weight;
				if(++conCnt == N-1) break;
			}
		}
		
		if(conCnt < N-1) System.out.println(-1);
		else System.out.println(routeLen);
	}
}
