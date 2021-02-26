package problem210226;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10157_자리배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(s.nextToken());
		int R = Integer.parseInt(s.nextToken());
		int num = Integer.parseInt(br.readLine());
		int move[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		int people = 1;
		int concert[][] = new int[R][C];

		int x = R;
		int y = 0;
		int nx = 0;
		int ny = 0;
		int dir = 0;
		int i;

		for (i = 1; i <= C * R; i++) {
			while (dir < 4) {
				nx = x + move[dir][0];
				ny = y + move[dir][1];
				if (0 <= nx && nx < R && 0 <= ny && ny < C && concert[nx][ny] == 0) {
					concert[nx][ny] = i;
					x = nx;
					y = ny;
					break;
				} else {
					dir = (dir + 1) % 4;
				}
			}
			if(i==num) {
				int rx = ny+1;
				int ry = R-nx;
				System.out.println(rx+" "+ry);
				break;
			}
		}
		if(i<num) {
			System.out.println("0");
		}
	}

}
