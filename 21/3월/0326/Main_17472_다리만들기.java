package problem210326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472_다리만들기 {
	static int N, M, islandNum;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[] islands;
	static boolean[] visited;
	static int[][] disWithIslands;
	static final int INF = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬의 갯수 판단
		int islandSetNum = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					findIsland(map, islandSetNum, i, j);
					islandSetNum++;
				}
			}
		}

//		printMap(map);

		islandNum = islandSetNum - 2;

		// 각 섬들 사이의 거리 구하기(인접행렬 만들기)
		disWithIslands = new int[islandNum][islandNum];

		// 초기화
		for (int i = 0; i < islandNum; i++) {
			for (int j = 0; j < islandNum; j++) {
				if (i == j)
					continue;
				disWithIslands[i][j] = INF;
			}
		}
		// 인접행렬구하기
		getDisWithIsland(map);

		islands = new int[islandNum]; // 최소거리
		visited = new boolean[islandNum]; // check
		Arrays.fill(islands, INF);
//		printMap(disWithIslands);

		int result = connectAllIsalnd(islands, visited, disWithIslands);
		System.out.println(result);

	}

	
	private static void findIsland(int[][] map, int islandNum, int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		map[i][j] = islandNum;

		int[] temp = null;
		while (!q.isEmpty()) {
			temp = q.poll();
			int x = temp[0];
			int y = temp[1];

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (0 > nx || nx >= N || 0 > ny || ny >= M)
					continue;
				if (map[nx][ny] == 0 || map[nx][ny] == islandNum)
					continue;
				if (map[nx][ny] == 1) {
					map[nx][ny] = islandNum;
					q.offer(new int[] { nx, ny });
				}
			}
		}

	}
	
	//prim알고리즘
	private static int connectAllIsalnd(int[] islands, boolean[] visited, int[][] disWithIslands) {
		int minIndex, min, result = 0;
		islands[0] = 0;

		for (int i = 0; i < islandNum; i++) {
			min = INF;
			minIndex = 0;

			for (int j = 0; j < islandNum; j++) {
				if (!visited[j] && min > islands[j]) {
					min = islands[j];
					minIndex = j;
				}
			}

			result += min;
			visited[minIndex] = true;

			for (int j = 0; j < islandNum; j++) {
				if (!visited[j] && disWithIslands[minIndex][j] != 0 && islands[j] > disWithIslands[minIndex][j]) {
					islands[j] = disWithIslands[minIndex][j];
				}
			}

		}
		
		for (int i = 0; i < islandNum; i++) {
			if(islands[i] == INF) return -1;
		}

		return result;

	}

	private static void getDisWithIsland(int[][] map) { //각각의 섬에서 사방탐색하는 함수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					for (int d = 0; d < 4; d++) {
						makeBridge(map, i, j, d);
					}
				}
			}
		}

	}

	private static void makeBridge(int[][] map, int i, int j, int d) { //한 방향에서 길게 가면서 거리 계산하는 함수
		int nx = i;
		int ny = j;

		int count = 0;
		while (true) {

			nx += dx[d];
			ny += dy[d];

			if (0 > nx || nx >= N || 0 > ny || ny >= M)
				return;
			
			
			if (map[nx][ny] == 0) {
				count++;
			} else if (map[nx][ny] == map[i][j]) {
				return;
			} else {
				if (count >= 2) {
					int from = map[i][j] - 2;
					int to = map[nx][ny] - 2;
					if (disWithIslands[from][to] > count) {
						disWithIslands[from][to] = count;
						disWithIslands[to][from] = count;
					}
				}
				return;
			}

		}

	}

	private static void printMap(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
