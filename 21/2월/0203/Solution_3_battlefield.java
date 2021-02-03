package problem210203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3_battlefield {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());

		for (int i = 1; i <= testcase; i++) {
			StringTokenizer in = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(in.nextToken());
			int W = Integer.parseInt(in.nextToken());

			char map[][] = new char[H][W];

			for (int j = 0; j < H; j++) { // map 기본 setting
				String str = br.readLine();
				for (int k = 0; k < W; k++) {
					map[j][k] = str.charAt(k);
				}
			}

			int input = Integer.parseInt(br.readLine());

			char inputs[] = br.readLine().toCharArray();

			int x = 0;
			int y = 0;
			int direction = 0;
			int dx[] = { -1, 1, 0, 0 };
			int dy[] = { 0, 0, -1, 1 };

			for (int j = 0; j < H; j++) {
				for (int k = 0; k < W; k++) {
					if (map[j][k] == '^') {
						direction = 0;
						x = j;
						y = k;
						break;
					}
					if (map[j][k] == 'v') {
						direction = 1;
						x = j;
						y = k;
						break;
					}
					if (map[j][k] == '<') {
						direction = 2;
						x = j;
						y = k;
						break;
					}
					if (map[j][k] == '>') {
						direction = 3;
						x = j;
						y = k;
						break;
					}
				}
			}

			for (int j = 0; j < input; j++) {
				int nx, ny;
				if (inputs[j] == 'U') {
					nx = x - 1;
					ny = y;
					direction = 0;
					map[x][y] = '^';
					if (0 <= nx && nx < H && 0 <= ny && ny < W && map[nx][ny] == '.') {
						map[x][y] = '.';
						x = nx;
						y = ny;
						map[x][y] = '^';
					}
				}
				if (inputs[j] == 'D') {
					nx = x + 1;
					ny = y;
					direction = 1;
					map[x][y] = 'v';
					if (0 <= nx && nx < H && 0 <= ny && ny < W && map[nx][ny] == '.') {
						map[x][y] = '.';
						x = nx;
						y = ny;
						map[x][y] = 'v';
					}
				}
				if (inputs[j] == 'L') {
					nx = x;
					ny = y - 1;
					direction = 2;
					map[x][y] = '<';
					if (0 <= nx && nx < H && 0 <= ny && ny < W)
						if (map[nx][ny] == '.') {
							map[x][y] = '.';
							x = nx;
							y = ny;
							map[x][y] = '<';
						}
				}
				if (inputs[j] == 'R') {
					nx = x;
					ny = y + 1;
					direction = 3;
					map[x][y] = '>';
					if (0 <= nx && nx < H && 0 <= ny && ny < W && map[nx][ny] == '.') {
						map[x][y] = '.';
						x = nx;
						y = ny;
						map[x][y] = '>';
					}
				}
				if (inputs[j] == 'S') {
					int sx = x;
					int sy = y;
					switch(map[x][y]) {
					case '^':
						while (true) {
							nx = sx + dx[direction];
							ny = sy + dy[direction];
							if (0 <= nx && nx < H && 0 <= ny && ny < W) {
								if (map[nx][ny] == '*') {
									map[nx][ny] = '.';
									break;
								}
								if (map[nx][ny] == '#')
									break;
								if (map[nx][ny] == '-' || map[nx][ny] == '.') {
									sx = nx;
									sy = ny;
								}
							} else
								break;

						}
						break;
					case 'v':
						while (true) {
							nx = sx + dx[direction];
							ny = sy + dy[direction];
							if (0 <= nx && nx < H && 0 <= ny && ny < W) {
								if (map[nx][ny] == '*') {
									map[nx][ny] = '.';
									break;
								}
								if (map[nx][ny] == '#')
									break;
								if (map[nx][ny] == '-' || map[nx][ny] == '.') {
									sx = nx;
									sy = ny;
								}
							} else
								break;
						}
						break;
					case '<':
						while (true) {
							nx = sx + dx[direction];
							ny = sy + dy[direction];
							if (0 <= nx && nx < H && 0 <= ny && ny < W) {
								if (map[nx][ny] == '*') {
									map[nx][ny] = '.';
									break;
								}
								if (map[nx][ny] == '#')
									break;
								if (map[nx][ny] == '-' || map[nx][ny] == '.') {
									sx = nx;
									sy = ny;
								}
							} else
								break;

						}
						break;
					case '>':
						while (true) {
							nx = sx + dx[direction];
							ny = sy + dy[direction];
							if (0 <= nx && nx < H && 0 <= ny && ny < W) {
								if (map[nx][ny] == '*') {
									map[nx][ny] = '.';
									break;
								}
								if (map[nx][ny] == '#')
									break;
								if (map[nx][ny] == '-' || map[nx][ny] == '.') {
									sx = nx;
									sy = ny;
								}
							} else
								break;

						}
						break;
					}

				}

			}
			System.out.print("#" + i + " ");
			for (int k = 0; k < H; k++) {
				for (int k2 = 0; k2 < W; k2++) {
					System.out.print(map[k][k2]);
				}
				System.out.println();
			}

		}

	}

}
