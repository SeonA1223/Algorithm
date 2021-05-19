package Day210519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_탈출_3055 {
	static int R, C, time;
	static char[][] arr;
	static List<int[]> list;
	static boolean[][] checked;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static Queue<int[]> hq, q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		checked = new boolean[R][C];
		hq = new LinkedList<>();
		q = new LinkedList<>();
		time = 0;


		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 'S') {
					hq.add(new int[] {i, j});
				} else if (arr[i][j] == '*') {
					q.add(new int[] { i, j });
				}
			}
		}
		
		spreadWater();

	}

	private static void spreadWater() {
		int size = 0;
		int[] temp;
		while (!hq.isEmpty()) {
			size = q.size();
			time++;

			while (--size >= 0) {
				temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (0 > nx || nx >= R || 0 > ny || ny >= C)
						continue;
					if (arr[nx][ny] == 'X' || arr[nx][ny] == 'D')
						continue;
					if (arr[nx][ny] == '.') {
						arr[nx][ny] = '*';
						q.offer(new int[] { nx, ny });
					}

				}
			} // 물이 1분 퍼질 때 고슴도치 체크

			if (moveHedgehog())
				return;

		}
		System.out.println("KAKTUS");
		return;
	}

	private static boolean moveHedgehog() {

		int[] temp;
		int size = hq.size();

		while (--size >= 0) {
			temp = hq.poll();
			int x = temp[0];
			int y = temp[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 > nx || nx >= R || 0 > ny || ny >= C)
					continue;
				if (arr[nx][ny] == 'X' || arr[nx][ny] == '*')
					continue;
				if (arr[nx][ny] == 'D') {
					System.out.println(time);
					return true;
				}
				if (!checked[nx][ny]) {
					checked[nx][ny] = true;
					hq.add(new int[] { nx, ny });
				}
			}

		}

		return false;

	}
}
