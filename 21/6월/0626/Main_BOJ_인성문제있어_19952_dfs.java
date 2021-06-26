package problem210626;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_인성문제있어_19952_dfs {
	static int H, W, O, F, sx, sy, ex, ey;
	static int arr[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static String success = "잘했어!!";
	static String fail = "인성 문제있어??";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		while (--tc >= 0) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			O = Integer.parseInt(st.nextToken());
			F = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			sx = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());

			arr = new int[W + 1][H + 1];

			for (int i = 0; i < O; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int h = Integer.parseInt(st.nextToken());
				arr[x][y] = h;
			}
			int f = F;
			boolean isArrival = dfs(sx, sy, f, new boolean[W + 1][H + 1]);
			System.out.println(isArrival ? success : fail);
		}
	}

	private static boolean dfs(int x, int y, int f, boolean[][] visited) {
		visited[x][y] = true;
		if (x == ex && y == ey)
			return true;
		if (f <= 0)
			return false;
		int height = arr[x][y];

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (isValid(nx, ny) && !visited[nx][ny]) {
				int nheight = arr[nx][ny];
				if (height >= nheight) {
					if (dfs(nx, ny, f - 1, visited))
						return true;
					visited[nx][ny] = false;
				} else {
					int jump = nheight - height;
					if (jump <= f) {
						if (dfs(nx, ny, f - 1, visited))
							return true;
						visited[nx][ny] = false;
					}

				}
			}

		}
		return false;
	}

	private static boolean isValid(int x, int y) {
		if (x <= 0 || x > W || y <= 0 || y > H)
			return false;
		else
			return true;
	}
}
