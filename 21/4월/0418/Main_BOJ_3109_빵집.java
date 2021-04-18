package Day210418;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3109_빵집 {
	static int[][] connect = {{-1,1}, {0,1}, {1,1}};
	static int count;
	static int R,C;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		count = 0;
		char[][] map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			if(connectPipeLine(i, 0, map)) count++;
		}
		System.out.println(count);
		
		
	}

	private static boolean connectPipeLine(int row, int col, char[][] map) {
		if(col == C-1) {
			return true;
		}
		
		for (int i = 0; i < 3; i++) {
			int nx = row + connect[i][0];
			int ny = col + connect[i][1];
			
			if(0 > nx || nx >= R || 0 > ny || ny >= C) continue;
			if(map[nx][ny] == 'x' || map[nx][ny] == 'p') continue;
			
			map[nx][ny] = 'p';
			if(connectPipeLine(nx, ny, map)) return true;
		}
		return false;
		
	}
}
