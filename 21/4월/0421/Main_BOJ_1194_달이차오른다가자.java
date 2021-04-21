package Day210421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1194_달이차오른다가자 {

	private static class Node {
		int x, y;
		int move;
		int keyNum;
		int[] keys;

		public Node(int x, int y, int move, int keyNum) {
			super();
			this.x = x;
			this.y = y;
			this.move = move;
			this.keyNum = keyNum;
			this.keys = new int[6];
		}

	}
	
	public static void copyKey(int[] nkey, int[]pkey) {
		for (int i = 0; i < pkey.length; i++) {
			nkey[i] = pkey[i];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// HashMap 설정
		HashMap<Character, Character> sol = new HashMap<>();
		char sAlphabet = 97;
		char bAlphabet = 65;
		int index = 0;
		while (++index <= 6) {
			sol.put(String.valueOf(bAlphabet).charAt(0), String.valueOf(sAlphabet).charAt(0));
			sAlphabet++;
			bAlphabet++;
		}
		;

		char[][] maze = new char[N][M];

		for (int i = 0; i < N; i++) {
			maze[i] = br.readLine().toCharArray();
		}

		int sx = 0, sy = 0;
		int keyCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if ('a' <= maze[i][j] && maze[i][j] <= 'f')
					keyCount++;
				if (maze[i][j] == '0') {
					sx = i;
					sy = j;
					maze[i][j] = '.';
				}
			}
		}
		boolean visited[][][] = new boolean[16][N][M];
		int keys[] = new int[6]; // 소문자 A 아스키코드 97
		Queue<Node> q = new LinkedList<>();
		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };

		q.offer(new Node(sx, sy, 0, 0));
		visited[0][sx][sy] = true;

		Node temp;
		boolean flag = false;
		while (!q.isEmpty()) {
			temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			int move = temp.move;
			int key = temp.keyNum; // 키갯수
			int haskeys[] = temp.keys;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (visited[key][nx][ny])
						continue;
					if (maze[nx][ny] == '#')
						continue;
					else if (maze[nx][ny] == '.') {
						visited[key][nx][ny] = true;
						Node node = new Node(nx, ny, move + 1, key);
						copyKey(node.keys, haskeys);
						q.offer(node);
					} else if ('a' <= maze[nx][ny] && maze[nx][ny] <= 'f') {
						visited[key][nx][ny] = true;
						Node node = new Node(nx, ny, move + 1, key+1);
						copyKey(node.keys, haskeys);
						node.keys[maze[nx][ny] - 'a']++;
						maze[nx][ny] = '.';
						q.offer(node);
					} else if ('A' <= maze[nx][ny] && maze[nx][ny] <= 'F') {
						char value = sol.get(maze[nx][ny]);
						if (key > 0 && haskeys[value - 'a'] > 0) {
							visited[key][nx][ny] = true;
							Node node = new Node(nx, ny, move + 1, key);
							copyKey(node.keys, haskeys);
							q.offer(node);
						}
					} else if (maze[nx][ny] == '1') {
						System.out.println(move + 1);
						flag = true;
						return;
					}

				}
			}
		}
		if(!flag) {
			System.out.println("-1");
		}

	}
}
