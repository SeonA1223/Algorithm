package Day210526;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라
public class Main_BOJ_4485_녹색옷1 {
	static int N;
	static int cave[][];
	static boolean visited[][];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int rupee;

		public Node(int x, int y, int rupee) {
			super();
			this.x = x;
			this.y = y;
			this.rupee = rupee;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.rupee - o.rupee;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = 0;
		while (true) {
			tc++;
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			cave = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0, 0, cave[0][0]));
			
			Node temp;
			while (!pq.isEmpty()) {
				temp = pq.poll();
				if (visited[temp.x][temp.y])
					continue;

				visited[temp.x][temp.y] = true;
				
				if (temp.x == N - 1 && temp.y == N - 1) {
					sb.append("Problem ").append(tc).append(": ").append(temp.rupee).append("\n");
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nx = temp.x + dx[i];
					int ny = temp.y + dy[i];
					
					if(nx < 0 || nx >= N || ny <0 || ny >= N) continue;
					if(visited[nx][ny]) continue;
					
					pq.offer(new Node(nx, ny, temp.rupee + cave[nx][ny]));
				}

			}

		}
		System.out.println(sb.toString());
	}
}
