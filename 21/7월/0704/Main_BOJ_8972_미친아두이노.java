package Day210704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_8972_미친아두이노 {
	static int R, C;
	static char board[][];
	static Queue<int[]> crazyAduino;
	static int[][][] visited;
	static int[] dx = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int[] dy = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		crazyAduino = new LinkedList<>();
		int sx = 0;
		int sy = 0;

		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'I') {
					sx = i;
					sy = j;
				}
				if (board[i][j] == 'R') {
					crazyAduino.offer(new int[] { i, j });
				}
			}

		}

		String s = br.readLine();
		visited = new int[s.length()][R][C];
		int[] move = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			move[i] = s.charAt(i) - '0';
		}

		if (bfs(sx, sy, move)) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
		}
	}

	private static boolean bfs(int sx, int sy, int[] move) {
		int time = move.length;
		int x = sx;
		int y = sy;
		for (int i = 0; i < time; i++) {
			int ax = x + dx[move[i]];
			int ay = y + dy[move[i]];

			board[x][y] = '.';

			if (board[ax][ay] == 'R') {
				System.out.println("kraj " + (i + 1));
				return false;
			}
			board[ax][ay] = 'I';
			x = ax;
			y = ay;

			int[] temp = null;
			int size = crazyAduino.size();
			while (--size >= 0) {
				temp = crazyAduino.poll();
				int cx = temp[0];
				int cy = temp[1];
				int sdis = Integer.MAX_VALUE;
				int mx = 0;
				int my = 0;

				for (int j = 1; j <= 9; j++) {
					if (j == 5)
						continue;
					int nx = cx + dx[j];
					int ny = cy + dy[j];
					if (nx < 0 || nx >= R || ny < 0 || ny >= C)
						continue;
					int dis = getDistance(ax, ay, nx, ny);
					if (dis < sdis) {
						sdis = dis;
						mx = nx;
						my = ny;
					}
				}
				board[cx][cy] = '.';
				if(ax == mx && ay == my) {
					System.out.println("kraj " + (i + 1));
					return false;
				}
				visited[i][mx][my]++;
			}
			findCrazyAduino(i);
		}
		return true;
	}


	private static void findCrazyAduino(int time) {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(visited[time][i][j] > 1) {
					board[i][j] = '.';
				}else if(visited[time][i][j] == 1) {
					board[i][j] = 'R';
					crazyAduino.add(new int[] {i, j});
				}
			}
		}
		
	}

	private static int getDistance(int x, int y, int nx, int ny) {
		return Math.abs(x - nx) + Math.abs(y - ny);
	}
}
