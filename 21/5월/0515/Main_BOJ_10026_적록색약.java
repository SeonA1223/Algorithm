package Day210515;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_10026_적록색약 {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][n];
		boolean[][] normal = new boolean[n][n];
		boolean[][] abnormal = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		int a = 0;
		int b = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!normal[i][j]) {
					dfs1(i, j, arr, normal);
					a++;
				}
				if (!abnormal[i][j]) {
					dfs2(i, j, arr, abnormal);
					b++;
				}
			}

		}

		System.out.println(a + " " + b);

	}

	private static void dfs2(int i, int j, char[][] arr, boolean[][] abnormal) {
		Queue<int[]> queue = new LinkedList<>();
		abnormal[i][j] = true;
		queue.offer(new int[] {i,j});
		
		int[] temp;
		while(!queue.isEmpty()) {
			temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx <0 || nx >= n || ny < 0 || ny >= n || abnormal[nx][ny] == true) continue;
				
				switch(arr[x][y]) {
				case 'R': 
				case 'G': 
					if(arr[nx][ny] == 'R' || arr[nx][ny] == 'G') {
						abnormal[nx][ny] = true;
						queue.offer(new int[] {nx, ny});
					}
					break;
				case 'B': 
					if(arr[nx][ny] == 'B') {
						abnormal[nx][ny] = true;
						queue.offer(new int[] {nx, ny});
					}
					break;
				}
				
			}
		}

	}

	private static void dfs1(int i, int j, char[][] arr, boolean[][] normal) {
		Queue<int[]> queue = new LinkedList<>();
		normal[i][j] = true;
		queue.offer(new int[] { i, j });

		int[] temp;
		while (!queue.isEmpty()) {
			temp = queue.poll();
			int x = temp[0];
			int y = temp[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n || normal[nx][ny] == true)
					continue;

				if (arr[x][y] == arr[nx][ny]) {
					normal[nx][ny] = true;
					queue.offer(new int[] { nx, ny });
				}
			}
		}

	}

}
