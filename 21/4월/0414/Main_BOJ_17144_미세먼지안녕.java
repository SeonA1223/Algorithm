package Day210414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17144_미세먼지안녕 {
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int room[][] = new int[n][m];
		int copy[][] = new int[n][m];; 

		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		Queue<int[]> q = new LinkedList<>();
		int airP[] = new int[2];

		int index = 0;

		// 방에 있는 미세먼지 값 입력받기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value > 0)
					q.offer(new int[] { i, j });
				if (value == -1) {
					airP[index] = i;
					index++;
				}
				room[i][j] = value;
			}
		}

		int[] temp;
		int time = 0;
		int size;
		int cnt;
		while (!q.isEmpty()) {
			size = q.size();

			for (int i = 0; i < size; i++) {
				temp = q.poll();
				int x = temp[0];
				int y = temp[1];

				cnt = 0;
				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m || room[nx][ny] == -1)
						continue;

					cnt++;
					copy[nx][ny] += room[x][y] / 5;

				}
				copy[x][y] -= (room[x][y] / 5 * cnt);
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					room[i][j] += copy[i][j];
					copy[i][j] = 0;
				}
			}
			airpurifyup(room, airP[0]);
			airpurifydown(room, airP[1]);

			if (++time == T)
				break;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (room[i][j] > 0)
						q.offer(new int[] { i, j });
				}
			}
		}

		System.out.println(amoutDust(room) + 2);

	}

	private static int amoutDust(int[][] room) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sum += room[i][j];
			}
		}
		return sum;

	}

	private static void airpurifydown(int[][] room, int airP) {
		int dx[] = { 1, 0, -1, 0 }; // 하 우 상 좌
		int dy[] = { 0, 1, 0, -1 };

		int loc = 0;
		int x = airP;
		int y = 0;
		int nx, ny;
		while (loc < 4) {
			nx = x + dx[loc];
			ny = y + dy[loc];

			if (nx < airP || nx >= n || ny < 0 || ny >= m) {
				loc++;
				continue;
			}

			if (room[nx][ny] == -1) {
				room[x][y] = 0;
				return;
			}

			if (room[x][y] != -1)
				room[x][y] = room[nx][ny];
			x = nx;
			y = ny;

		}

	}

	private static void airpurifyup(int[][] room, int airP) {
		int dx[] = { -1, 0, 1, 0 }; // 상 우 하 좌
		int dy[] = { 0, 1, 0, -1 };

		int loc = 0;
		int x = airP;
		int y = 0;
		int nx, ny;
		while (loc < 4) {
			nx = x + dx[loc];
			ny = y + dy[loc];

			if (nx < 0 || nx > airP || ny < 0 || ny >= m) {
				loc++;
				continue;
			}
			if (room[nx][ny] == -1) {
				room[x][y] = 0;
				return;
			}

			if (room[x][y] != -1)
				room[x][y] = room[nx][ny];
			x = nx;
			y = ny;

		}

	}

}
