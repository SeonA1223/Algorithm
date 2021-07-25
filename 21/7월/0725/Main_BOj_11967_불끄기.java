package problem210725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOj_11967_불끄기 {
	static int[][] room;
	static int N, M, res;
	static Map<String, List<int[]>> map;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };
	static boolean[][] turnon;
	static boolean[][] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		res = 0;
		room = new int[N + 1][N + 1];
		map = new HashMap<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb = new StringBuilder();
			sb.append(x).append(",").append(y);
			String s = sb.toString();
			if (map.containsKey(s)) {
				map.get(s).add(new int[] { a, b });
			} else {
				map.put(s, new ArrayList<>());
				map.get(s).add(new int[] { a, b });
			}
		}

		turnon = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		turnon[1][1] = true;
		visited[1][1] = true;
		turnOnLight(1, 1);

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (turnon[i][j])
					res++;
			}
		}

		System.out.println(res);
	}

	public static void turnOnLight(int sx, int sy) {
		Queue<int[]> q = new LinkedList<>();
		List<int[]> list = new LinkedList<>();

		q.add(new int[] { sx, sy });
		visited[sx][sy] = true;
		int[] temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			int x = temp[0];
			int y = temp[1];

			
			sb = new StringBuilder();
			sb.append(x).append(",").append(y);
			String s = sb.toString();
			if (map.containsKey(s)) {
				List<int[]> tList = map.get(s);
				for (int[] loc : tList) {
					int tx = loc[0];
					int ty = loc[1];
					turnon[tx][ty] = true;
				}
			}

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx <= 0 || nx > N || ny <= 0 || ny > N)
					continue;
				if (visited[nx][ny])
					continue;
				if (!turnon[nx][ny]) {
					list.add(new int[] { nx, ny });
					continue;
				}

				visited[nx][ny] = true;
				q.add(new int[] { nx, ny });
			}

			for (int i = 0; i < list.size(); i++) {
				int[] later = list.get(i);
				int lx = later[0];
				int ly = later[1];
				if (turnon[lx][ly] && !visited[lx][ly]) {
					q.add(new int[] { lx, ly });
					visited[lx][ly] = true;
				}
			}
		}
	}
}
