package Day210421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_15683_감시 {
	static int ans = Integer.MAX_VALUE;
	static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N, M;
	static int[][][] watch = { 
			{}, 
			{ { 0 }, { 1 }, { 2 }, { 3 } }, 
			{ { 0, 1 }, { 2, 3 } },
			{ { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } }, 
			{ { 0, 1, 2 }, { 0, 1, 3 }, { 1, 2, 3 }, { 0, 2, 3 } },
			{ { 0, 1, 2, 3 } } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int map[][] = new int[N][M];

		List<int[]> camera = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (0 < value && value < 6) {
					camera.add(new int[] { i, j, value});
				}
				map[i][j] = value;
			}
		}

		int size = camera.size();
		dfs(0, camera, map, size);
		System.out.println(ans);

	}

	private static int[][] copyMap(int[][] map) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}

	private static void dfs(int index, List<int[]> camera, int[][] map, int size) {
		if (index == size) {
			int count = blindSpot(map);
			ans = Math.min(ans, count);
			return;
		}

		int[] xy = camera.get(index);
		int x = xy[0];
		int y = xy[1];
		int cameraNum = xy[2];
		int copy[][];
		for (int i = 0; i < watch[cameraNum].length; i++) {	
			copy = copyMap(map);
			watchRange(watch[cameraNum][i], copy, x, y, -1);
			dfs(index + 1, camera, copy, size);
		}

	}

	private static int blindSpot(int[][] map) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					count++;
			}
		}
		return count;
	}

	private static void watchRange(int[] i, int[][] map, int x, int y, int num) {
		for (int j = 0; j < i.length; j++) {
			int sx = x;
			int sy = y;
			while (true) {
				sx += dir[i[j]][0];
				sy += dir[i[j]][1];

				if (0 > sx || sx >= N || 0 > sy || sy >= M)
					break;

				if(0< map[sx][sy] && map[sx][sy] < 6) continue;
				if (map[sx][sy] != 6)
					map[sx][sy] = num;
				if (map[sx][sy] == 6)
					break;
				;

			}
		}
	}
}
