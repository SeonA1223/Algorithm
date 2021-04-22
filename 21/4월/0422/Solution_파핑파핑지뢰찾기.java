package Day210422;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution_파핑파핑지뢰찾기 {
    static int n, cnt;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static class Pos{
        int x;
        int y;
         
        public Pos(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int [n][n];
            cnt = 0;
            for(int r = 0; r < n; r++) {
                String str = br.readLine();
                for(int c = 0; c < n; c++) {
                    if(str.charAt(c)=='*') map[r][c] = -1;
                    if(map[r][c] == -1) {
                        for(int d = 0; d < 8; d++) {
                            int nx = r + dx[d];
                            int ny = c + dy[d];
                            if(nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == -1) continue;
                            map[nx][ny]++;
                        }
                    }
                    else cnt++;
                }
            }
            visited = new boolean [n][n];
 
            for(int r = 0; r < n; r++) {
                for(int c = 0; c < n; c++) {
                    if(map[r][c] == 0 && !visited[r][c]) {
                        dfs(r, c);
                        cnt++;
                    }
                }
            }
            System.out.println("#" + tc + " " + (cnt));
        }
        br.close();
    }
    private static void dfs(int r, int c) {
        if(visited[r][c]) return;
        visited[r][c] = true;
        if(map[r][c] == 0) {
            cnt--;
            for(int d = 0; d < 8; d++) {
                int nx = r + dx[d];
                int ny = c + dy[d];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n || 
                        map[nx][ny] == -1) continue;
                dfs(nx, ny);
            }
        }
        else {
            cnt--;
        }
    }
}