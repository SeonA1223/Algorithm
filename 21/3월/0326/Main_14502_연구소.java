package problem210326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int N, M;
	static ArrayList<int[]> viruses;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int maxSafeArea = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] lab = new int[N][M];
//		boolean[][] visited = new boolean[N][M];
		viruses = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 2)
					viruses.add(new int[] { i, j });
				lab[i][j] = value;
			}
		}

		setWall(lab, 0);
		System.out.println(maxSafeArea);

	}

//	private static int[][] copyMap(int[][] map) {
//		int[][] copy = new int[map.length][map[0].length];
//
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[0].length; j++) {
//				copy[i][j] = map[i][j];
//			}
//		}
//
//		return copy;
//	}

	private static void setWall(int[][] lab, int count) {

		if (count == 3) {

//			bfs(copyMap(lab));
			bfs(lab);
			return;
		}

			for (int i = 0; i < N*M; i++) {
				int x = i / M;
				int y = i % M;
				if (lab[x][y] == 0) {
					lab[x][y] = 1;
					setWall(lab, count + 1);
					lab[x][y] = 0;
				}
			}
			
		

	}

	/*
	 * 모든 맵이 바이러스로 가득차면 실패 상하좌우가 1이거나 범위를 벗어나게 되면 안전영역의 크기를 계산
	 */
	private static void bfs(int[][] lab) {
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < viruses.size(); i++) {
			q.offer(viruses.get(i));
		}

		int[] temp = null;
		while (!q.isEmpty()) {
			temp = q.poll();
			int x = temp[0];
			int y = temp[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 > nx || nx >= N || 0 > ny || ny >= M)
					continue;

				if (lab[nx][ny] == 2 || lab[nx][ny] == 1)
					continue;

				
				if(lab[nx][ny] == 0) {
					lab[nx][ny] = 3;
					q.offer(new int[] { nx, ny });					
				}
			}

		}
		maxSafeArea = Math.max(maxSafeArea, getSafeAreaNum(lab));

	}

	private static int getSafeAreaNum(int[][] area) {
		int count = 0;
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[0].length; j++) {
				if (area[i][j] == 0)
					count++;
				else if(area[i][j] == 3)
					area[i][j] = 0;
			}
		}
		return count;
	}
}
