package problem210205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4_정사각형방 {

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int N;
	static int rooms[][];

	static int dfs(int x, int y, int count) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if (rooms[nx][ny] - rooms[x][y] == 1) {
					count = dfs(nx, ny, ++count);
				}
			} else // 범위 밖이면 다음 상하좌우 파악
				continue;
		}
		return count;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			rooms = new int[N][N];
			int max = 0;
			int result;
			int roomNumber = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					result = dfs(i, j, 1);
					if (max < result) {
						max = result;
						roomNumber = rooms[i][j];
					} else if (max == result) {
						if (roomNumber > rooms[i][j])
							roomNumber = rooms[i][j];
					}

				}
			}
			System.out.println("#" + t + " " + roomNumber + " " + max);

		}
	}

}
