package Day210608;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2146_다리만들기 {
	static int N, bridge;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1. 지도에서 섬 위치 파악하기
		int islandsCnt = 0;
		boolean visited[][] = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1)
					setIslands(++islandsCnt, i, j, visited);
			}
		}

		// 2. 각 섬을 연결하면서 최단거리 다리 길이 구하기
		bridge = N;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					makeBridge(i, j);
				}
			}
		}

		System.out.println(bridge);

	}

	private static void makeBridge(int i, int j) {

		int islandNum = map[i][j];
		for (int k = 0; k < 4; k++) {
			int nx = i;
			int ny = j;
			int connect = 0;
			while (true) {
				nx += dx[k];
				ny += dy[k];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					connect = -1;
					break;
				}
				if (map[nx][ny] == islandNum) {
					connect = -1;
					break;
				} else if (map[nx][ny] == 0) {
					connect++;
					if (connect > bridge)
						break;
				} else
					break;
			}
			if (connect != -1 && connect < bridge)
				bridge = connect;
		}

	}

	private static void setIslands(int islandsCnt, int i, int j, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		visited[i][j] = true;
		map[i][j] = islandsCnt;
		q.offer(new int[] { i, j });

		int[] temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			int x = temp[0];
			int y = temp[1];

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
					continue;
				if (map[nx][ny] == 1) {
					map[nx][ny] = islandsCnt;
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}
}
