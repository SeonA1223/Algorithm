package problem210602;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_19238_스타트택시 {

	public static class Node {
		int sx;
		int sy;
		int ex;
		int ey;

		public Node(int sx, int sy, int ex, int ey) {
			super();
			this.sx = sx;
			this.sy = sy;
			this.ex = ex;
			this.ey = ey;
		}


	}

	static int N, M, power;
	static int map[][], aCustomer[];
	static Map<Integer, Node> customers;
//	static List<Node> customers;
	static int dx[] = { -1, 0, 0, 1 }; // 상좌우하
	static int dy[] = { 0, -1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		power = Integer.parseInt(st.nextToken());
		aCustomer = new int[2];
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					map[i][j] = -1;
			}
		}

		int taxiX = -1;
		int taxiY = -1;

		st = new StringTokenizer(br.readLine());
		taxiX = Integer.parseInt(st.nextToken());
		taxiY = Integer.parseInt(st.nextToken());
		int taxi[] = new int[] { taxiX, taxiY };

		customers = new HashMap<>();
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());

			customers.put(i, new Node(sx, sy, ex, ey));
			map[sx][sy] = i;
		}

		boolean flag = true;
		for (int i = 0; i < M; i++) {
			int dis = findCloseCustomer(taxi);
			if (dis == -1) {
				flag = false;
				break;
			}
			if (power - dis >= 0) {
				power -= dis;
				int customerNum = map[aCustomer[0]][aCustomer[1]];
				map[aCustomer[0]][aCustomer[1]] = 0;
				int[] destination = findDestination(customerNum);
				int arriveDestination = getDistance(destination);
				if (arriveDestination == -1) {
					flag = false;
					break;
				}
				if (power - arriveDestination >= 0) {
					power -= arriveDestination;
					power += (arriveDestination * 2);
					taxi[0] = destination[0];
					taxi[1] = destination[1];
				} else {
					flag = false;
					break;
				}
			} else {
				flag = false;
				break;
			}

		}

		if (flag) {
			System.out.println(power);
		} else {
			System.out.println(-1);
		}
	}

	private static int[] findDestination(int custNum) {
		Node node = customers.get(custNum);
		
		if(node == null) return null;
		else {
			int des[] = new int[]{node.ex, node.ey};
			return des;
		}
		
	}

	private static int getDistance(int[] dest) {
		Queue<int[]> q = new LinkedList<>();
		int visited[][] = new int[N + 1][N + 1];
		q.offer(new int[] { aCustomer[0], aCustomer[1] });
		visited[aCustomer[0]][aCustomer[1]] = 1;

		int[] temp = null;
		while (!q.isEmpty()) {
			temp = q.poll();
			int x = temp[0];
			int y = temp[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx <= 0 || nx > N || ny <= 0 || ny > N || map[nx][ny] == -1 || visited[nx][ny] != 0)
					continue;

				if (nx == dest[0] && ny == dest[1]) {
					return visited[x][y];
				}

				q.offer(new int[] { nx, ny });
				visited[nx][ny] = visited[x][y] + 1;

			}

		}
		return -1;

	}

	private static int findCloseCustomer(int[] taxi) {
		if (map[taxi[0]][taxi[1]] > 0) {
			aCustomer[0] = taxi[0];
			aCustomer[1] = taxi[1];
			return 0;
		}
		Queue<int[]> q = new LinkedList<>();
		boolean visited[][] = new boolean[N + 1][N + 1];
		q.offer(new int[] { taxi[0], taxi[1] });
		visited[taxi[0]][taxi[1]] = true;

		int[] temp = null;
		int cx = Integer.MAX_VALUE;
		int cy = Integer.MAX_VALUE;
		int depth = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			depth++;
			while (--size >= 0) {
				temp = q.poll();
				int x = temp[0];
				int y = temp[1];

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx <= 0 || nx > N || ny <= 0 || ny > N || map[nx][ny] == -1 || visited[nx][ny])
						continue;

					if (map[nx][ny] > 0) {
						if (cx >= nx) {
							if (cx == nx) {
								if (cy > ny) {
									cx = nx;
									cy = ny;
								}
							} else {
								cx = nx;
								cy = ny;
							}
						}

					} else if (map[nx][ny] == 0) {
						q.offer(new int[] { nx, ny });
						visited[nx][ny] = true;
					}

				}
			}
			if(cx != Integer.MAX_VALUE && cy != Integer.MAX_VALUE) {
				aCustomer[0] = cx;
				aCustomer[1] = cy;
				return depth;
				
			}
		}
		return -1;

	}
}
