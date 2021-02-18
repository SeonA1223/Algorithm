package problem210218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3109_빵집 {
	static char map[][];
	static int R, C, pipeNum, pipeLineNum;
	static int dx[] = { -1, 0, 1 };
	static int dy[] = { 1, 1, 1 };

	private static boolean makePipeLine(int x, int y) {

		if (y == C - 1) {
			pipeNum++;
			return true;
		}

		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (isAvailable(nx, ny)) {
				map[x][y] = 'p';
				if (makePipeLine(nx, ny)) { //파이프라인이 완성됐다면, 처음으로 쭉 돌아가기 위해 return true/false를 활용한다.
					return true;
				}
//				map[x][y] = '.'; //실패했던 흔적 되돌리지 않기 : 뒤의 선택지 방향은 현재보다 유리 X 상황이고 결국 같은 상황

			}
		}
		return false;

	}

	private static boolean isAvailable(int x, int y) {
		if (0 <= x && x < R) { // 열은 범위체크 할 필요가 없다. 기저조건에서 끝낼 것이기 때문에!
			if (map[x][y] != 'x') {
				if (map[x][y] != 'p') {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		pipeNum = 0;

		for (int r = 0; r < R; r++) {
			map[r][0] = 'p';
			makePipeLine(r, 0);
		}
		System.out.println(pipeNum);

	}
}
