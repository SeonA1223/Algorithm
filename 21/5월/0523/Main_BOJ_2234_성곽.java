package Day210523;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2234_성곽 {
	static int N, M;
	static int rooms[][];
	static int roomNums[][];
	static int roomSize[];
	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		rooms = new int[N][M];
		roomNums = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				rooms[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		// 방 갯수 구하기
		int roomCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (roomNums[i][j] == 0) {
					roomCnt++;
					bfs(i, j, roomCnt);
				}
			}
		}
		sb.append(roomCnt).append("\n");
		// 큰 방 갯수 구하기
		roomSize = new int[roomCnt+1];
		sb.append(getRoomSize(roomCnt)).append("\n");

		// 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
		int maxRSize = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int wall = rooms[i][j];
				int rNum = roomNums[i][j]; 
				for (int k = 0; k < 4; k++) {
					if ((wall & (1 << k)) != 0) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if (nx < 0 || nx >= N || ny < 0 || ny >= M)
							continue;
						if(rNum == roomNums[nx][ny]) continue;
						int size = roomSize[rNum] + roomSize[roomNums[nx][ny]];
						maxRSize = maxRSize < size ? size : maxRSize;
					}
				}
			}
		}
		sb.append(maxRSize).append("\n");
		System.out.println(sb.toString());
	}

	private static int getRoomSize(int roomCnt) {
		int maxSize = 0;
		for (int i = 1; i <= roomCnt; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (roomNums[j][k] == i)
						cnt++;
				}
			}
			roomSize[i] = cnt;
			maxSize = maxSize < cnt ? cnt : maxSize;
		}
		return maxSize;

	}

	private static void bfs(int i, int j, int roomCnt) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		roomNums[i][j] = roomCnt;

		int[] temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			int wall = rooms[x][y];

			for (int k = 0; k < 4; k++) {
				if ((wall & (1 << k)) != 0)
					continue;
				// 벽이아니면
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (roomNums[nx][ny] != 0)
					continue;

				roomNums[nx][ny] = roomCnt;
				q.offer(new int[] { nx, ny });
			}
		}

	}
}
