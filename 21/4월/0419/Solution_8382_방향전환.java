package Day210419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8382_방향전환 {
	static int[] dx = {1,-1,0,0}; //0, 1 가로 이동 // 2,3세로 이동
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken()) + 100;
			int y1 = Integer.parseInt(st.nextToken()) + 100;
			int x2 = Integer.parseInt(st.nextToken()) + 100;
			int y2 = Integer.parseInt(st.nextToken()) + 100;
			boolean visited[][][] = new boolean[2][201][201]; //0이면 가로이동 1이면 세로이동
			
			Queue<int[]> q = new LinkedList<>();
			visited[0][x1][y1] = true;
			q.offer(new int[] {x1, y1, 0, 0}); //가로 이동
			visited[1][x1][y1] = true;
			q.offer(new int[] {x1, y1, 1, 0}); // 세로이동
			
			int[] temp;
			while(!q.isEmpty()) {
				temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				int dir = temp[2];
				int cnt = temp[3];
				
				if(x == x2 && y == y2) {
					sb.append(cnt).append("\n");
					break;
				}
				
				if(dir == 0) { //가로 이동 
					for (int i = 2; i < 4; i++) {//세로이동
						int nx = x + dx[i];
						int ny = y + dy[i];
						
						if(0 <= nx && nx <= 200 && 0<=ny && ny<=200) {
							if(!visited[1][nx][ny]) {
								visited[1][nx][ny] = true;
								q.offer(new int[] {nx, ny, 1, cnt+1});
							}
						}
					}
				}else { //세로이동
					for (int i = 0; i < 2; i++) { //가로이동
						int nx = x + dx[i];
						int ny = y + dy[i];
						
						if(0 <= nx && nx <= 200 && 0<=ny && ny<=200) {
							if(!visited[0][nx][ny]) {
								visited[0][nx][ny] = true;
								q.offer(new int[] {nx, ny, 0, cnt+1});
							}
						}
					}
				}
			}
			
		}
		System.out.println(sb.toString());
	}
}
