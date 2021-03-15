package problem210315;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_M4_미로2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<int[]> q;
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			int[][] map = new int[100][100];
			int sx = 1, sy = 1, ex=0, ey=0;
			boolean flag = false;
			q = new LinkedList<>();

			for (int x = 0; x < 100; x++) {
				String s = br.readLine();
				for (int y = 0; y < 100; y++) {
					int value = s.charAt(y) - '0';
					map[x][y] = value;
					if (value == 2) {
						sx = x;
						sy = y;
					} else if (value == 3) {
						ex = x;
						ey = y;
					}
				}
			}
			q.offer(new int[] { sx, sy });

			while (!q.isEmpty()) {
				int[] data = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = data[0] + dx[i];
					int ny = data[1] + dy[i];
					
					if(nx== ex && ny == ey) {
						System.out.println("#"+tc+" 1");
						flag = true;
					}

					if (map[nx][ny] == 0) {
						q.add(new int[] { nx, ny });
						map[nx][ny] = -1;
					}
				}
			}
			
			if(flag == false) {
				System.out.println("#"+tc+" 0");
			}
			

		}

	}

}
