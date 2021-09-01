import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_Boj_12908_텔레포트 {
	static long minRes;
	static int sx, sy, ex, ey;
	static int[][] teleport;
	static boolean[] isSelected;
	static List<Integer> nodes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());

		minRes = Math.abs(sx - ex) + Math.abs(sy - ey);

		teleport = new int[3][4];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				teleport[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 부분집합
		isSelected = new boolean[3];
		nodes = new ArrayList<>();
		subset(0);

		System.out.println(minRes);
	}

	private static void subset(int cnt) {
		if (cnt == 3) {
			nodes.clear();
			for (int i = 0; i < 3; i++) {
				if (isSelected[i]) {
					nodes.add(i);
				}
			}
			if (nodes.size() > 0) {
				perm(0, new int[nodes.size()], new boolean[nodes.size()]);
			}
			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);

	}

	private static void perm(int cnt, int[] order, boolean[] visited) {
		if (cnt == nodes.size()) {
			int res = Math.abs(sx - teleport[order[0]][0]) + Math.abs(sy - teleport[order[0]][1]);
			getDistance(teleport[order[0]][2], teleport[order[0]][3], 1, res + 10, order);
			res = Math.abs(sx - teleport[order[0]][2]) + Math.abs(sy - teleport[order[0]][3]);
			getDistance(teleport[order[0]][0], teleport[order[0]][1], 1, res + 10, order);
			return;
		}
		for (int i = 0; i < nodes.size(); i++) {
			if (visited[i])
				continue;
			order[cnt] = nodes.get(i);
			visited[i] = true;
			perm(cnt + 1, order, visited);
			visited[i] = false;
		}

	}

	private static void getDistance(int x, int y, int index, long res, int[] order) {
		if (res > minRes)
			return;
		if (index == order.length) {
			minRes = Math.min(minRes,
					res + Math.abs(ex - teleport[order[index - 1]][0]) + Math.abs(ey - teleport[order[index - 1]][1]));
			minRes = Math.min(minRes,
					res + Math.abs(ex - teleport[order[index - 1]][2]) + Math.abs(ey - teleport[order[index - 1]][3]));
			return;
		}

		// x1 -> x2
		getDistance(teleport[order[index]][2], teleport[order[index]][3], index + 1,
				res + Math.abs(x - teleport[order[index]][0]) + Math.abs(y - teleport[order[index]][1]) + 10, order);
		// x2 -> x1
		getDistance(teleport[order[index]][0], teleport[order[index]][1], index + 1,
				res + Math.abs(x - teleport[order[index]][2]) + Math.abs(y - teleport[order[index]][3]) + 10, order);

	}
}
