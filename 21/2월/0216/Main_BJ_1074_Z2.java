package problem210216;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1074_Z2 {
    public static int count;
/*
 * 교수님 풀이는 가로가 X 세로가 Y
 \x 0 1 2 3 
 y\ 1
 	2
 	3
 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        solve(N, c, r); //r과 c의 위치를 바꿔놈
        System.out.println(count);
    }

    public static void solve(int N, int x, int y) {
        if (N == 0) {
            return;
        }

        int len = (int) Math.pow(2, N);
        int size = len * len;
        int partLen = len / 2;

        if (x < partLen && y < partLen) { //1사분면
        	solve(N - 1, x, y);
        } else if (partLen <= x && y < partLen) { //2
            count += (size / 4);
            solve(N - 1, x - partLen, y);
        } else if (x < partLen && partLen <= y) { //3
            count += (size / 4) * 2;
            solve(N - 1, x, y - partLen);
        } else if (partLen <= x && partLen <= y) { //4
            count += (size / 4) * 3;
            solve(N - 1, x - partLen, y - partLen);
        }
    }
}