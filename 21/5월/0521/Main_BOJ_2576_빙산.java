package Day210521;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2576_빙산 {
	static int N, M, t;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		t = 0;
		while(true) {
			t++;
			meltIce();
			
			if(divideMass()) break;
		}
		System.out.println(t);
	}

	private static boolean divideMass() {
		boolean visited[][] = new boolean[N][M];
		int cnt = 0;
		loop: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] != 0) {
					dfs(i, j, visited);
					break loop;
				}
			}
		}
		
		int v = calculate(visited);
		int c = calculate();

		if(v==c) {
			if(c==0) {
				t=0;
				return true;
			}
			return false;
		}
		return true;
	}

	private static int calculate() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] != 0) cnt++;
			}
		}
		return cnt;
	}

	private static int calculate(boolean[][] visited) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j]) cnt++;
			}
		}
		return cnt;
	}

	private static void dfs(int i, int j, boolean[][] visited) {
		visited[i][j] = true;
		
		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if(0 > nx || nx >= N || 0> ny || ny >= M) continue;
			if(arr[nx][ny] == 0 ) continue;
			if(!visited[nx][ny]) dfs(nx, ny, visited);
		}
		
	}

	private static void meltIce() {
		int temp[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] != 0) {
					int c = 0;
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(0 > nx || nx >= N || 0> ny || ny >= M) continue;
						if(arr[nx][ny] == 0) c++;
					}
					temp[i][j] = c;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] -= temp[i][j];
				if(arr[i][j] < 0) arr[i][j] = 0;
			}
		}
		
		
	}
}
