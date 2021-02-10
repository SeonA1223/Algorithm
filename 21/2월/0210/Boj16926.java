package problem210210;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16926 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int direct[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; //우  하  좌 상
	static int visit[][];
	static int list[][];
	static int N, M, R;
	static int sx, sy, ex, ey;

	static void print() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(list[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	static int dfs(int x, int y, int idx) { 
		visit[x][y]++;

		int nx = x + direct[idx][0];
		int ny = y + direct[idx][1];

		if (nx < sx || ny < sy || nx > ex || ny > ey) {
			idx++;
			nx = x + direct[idx][0];
			ny = y + direct[idx][1];
		}

		if (visit[nx][ny] == visit[x][y]) {
			int tmp = list[x][y];
			list[x][y] = list[nx][ny];
			return tmp;
		}

		int tmp = list[x][y];
		list[x][y] = dfs(nx, ny, idx); //현재 값에 다음값 넣기
		return tmp;
	}

	static void solve() {
		sx = 0;
		sy = 0;
		ex = N - 1;
		ey = M - 1;
		int count = Math.min(N, M) / 2;
		int n = N;
		int m = M;
		for (int i = 0; i<count; i++) {
			//회전시킬 때 회전시키는 배열의 크기 (n - 1) * 2 + (m - 1) * 2번이 한바퀴 => mod 연산을 통해 R을 낮춰준 후에 회전. 다음 구간으로 넘어가면 크기를 2만큼 줄여줘야합니다.
			for (int j = 0; j < R % ((n - 1) * 2 + (m - 1) * 2); j++) {  
				dfs(i, i, 0);
			}
			sx++;
			sy++;
			ex--;
			ey--;
			n -= 2;
			m -= 2;

		}
	}

	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		list = new int[N][M];
		visit = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		solve();
		print();
	}
}