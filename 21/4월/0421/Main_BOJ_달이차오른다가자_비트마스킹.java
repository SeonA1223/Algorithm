package Day210421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_달이차오른다가자_비트마스킹 {

	private static class Node {
		int x, y;
		int move;
		int key;

		public Node(int x, int y, int move, int key) {
			this.x = x;
			this.y = y;
			this.move = move;
			this.key = key;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] maze = new char[N][M];

		for (int i = 0; i < N; i++) {
			maze[i] = br.readLine().toCharArray();
		}

		int sx = 0, sy = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maze[i][j] == '0') {
					sx = i;
					sy = j;
					maze[i][j] = '.';
					break;
				}
			}
		}
		boolean visited[][][] = new boolean[1 << 6][N][M];
		Queue<Node> q = new LinkedList<>();
		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };

		q.offer(new Node(sx, sy, 0, 0));
		visited[0][sx][sy] = true;

		Node temp;
		boolean flag = true;
		while (!q.isEmpty()) {
			temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			int move = temp.move;
			int key = temp.key; // 키갯수

			if (maze[x][y] == '1') {
				System.out.println(move);
				flag = false;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 > nx || nx >= N || 0 > ny || ny >= M)
					continue;
				if (maze[nx][ny] == '#')
					continue;  

				if ('a' <= maze[nx][ny] && maze[nx][ny] <= 'f') {
					key |= (1 << (maze[nx][ny] - 'a'));
					visited[key][nx][ny] = true;
					q.offer(new Node(nx, ny, move + 1, key));

				}
				if ('A' <= maze[nx][ny] && maze[nx][ny] <= 'F') {
					if ((key & (1 << (maze[nx][ny] - 'A'))) > 0) {
						visited[key][nx][ny] = true;
						q.offer(new Node(nx, ny, move + 1, key));
					}
				}
				if (visited[key][nx][ny])
					continue;
				if (maze[nx][ny] == '.' || maze[nx][ny] == '1') {
					visited[key][nx][ny] = true;
					q.offer(new Node(nx, ny, move + 1, key));
				}

			}
		}

		if (flag) {
			System.out.println(-1);
		}

	}
}
