package Day210414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기1 {
	static int N, W, H;
	static int count;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken()); // 구술 n번
			W = Integer.parseInt(st.nextToken()); // 열
			H = Integer.parseInt(st.nextToken()); // 행

			int[][] arr = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 중복순열
			count = W * H;
			perm(0, arr);
			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void perm(int cnt, int[][] arr) {
		if(countBrick(arr) == 0) {
			count = 0;
			return;
		}
		if (cnt == N) {
			count = Math.min(count, countBrick(arr));
			return;
		}
		int[][] temp = new int[H][W];
		temp = copymap(arr); //cnt = 0 일 때는 맨 처음에 들어온 배열이 저장되어짐.
		for (int i = 0; i < W; i++) {
			if(simulation(i, temp)) { //해당 위치에 temp 배열에 구슬 맞추기
				perm(cnt+1, temp);
			}else {
				continue;
			}
		}

	}

	private static int[][] copymap(int[][] arr) {
		int temp[][] = new int[H][W];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}

	private static boolean simulation(int order, int[][] temp) {
			// 특정위치에서 맨위에 있는 구슬 부시기
			boolean check = true;
			int x = 0;
			int y = order;

			while (x < H) {
				if (temp[x][y] > 1) { //첫번째로 맞은 구슬이 1보다 클 경우, 주변 구술에게 영향을 끼치므로 주변 구슬 깨트리기
					breakBrick(x, y, temp);
					break;
				} else if (temp[x][y] == 1) { //첫번째로 맞은 구슬이 1일 경우, 0으로 바꾸고, 그 다음 구슬 떨어트리기
					temp[x][y] = 0;
					break;
				} else
					x += 1;
			}
			if(x == H) { //구슬이 없다면, 깰 게 없다는 뜻이기 때문에 return false해주기
				check = false;
			}
			return check;
		
	}

	private static int countBrick(int[][] temp) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (temp[i][j] > 0)
					count++;
			}
		}
		return count;

	}

	private static int[][] breakBrick(int sx, int sy, int[][] arr) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sx, sy });

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];

			int c = arr[x][y];
			arr[x][y] = 0; //맞은 위치에 구슬도 제거해줘야한다.
			for (int i = 0; i < 4; i++) {
				int nx = x; // x값이 변경되면 안된다. 4방으로 구슬이 퍼져나갈 기준이 없어지면 안되니까
				int ny = y;
				for (int j = 0; j < c - 1; j++) {
					nx += dx[i];
					ny += dy[i];

					if (nx < 0 || nx >= H || ny < 0 || ny >= W)
						break;

					if (arr[nx][ny] == 1)
						arr[nx][ny] = 0;
					else if (arr[nx][ny] > 1) {
						q.offer(new int[] { nx, ny });
					}

				}
			}

		}

		// 빈공간이 있을 경우 벽돌 밑으로 떨어트리기
		checkEmptySpace(arr);
		return arr;

	}

	private static void checkEmptySpace(int[][] arr) {
		// 열중심으로 행 W -> 0 으로 하나씩 보기
		// 빈 공간 위에 항상 구슬이 있지 않고, 두칸 뒤에 구슬이 있을 수도 있기 때문에 고려해줘야한다!
		List<Integer> list = new ArrayList<>();
		for (int j = 0; j < W; j++) { // 열 중심으로
			for (int i = H-1; i >= 0; i--) {
				if(arr[i][j] > 0) {
					list.add(arr[i][j]);
					arr[i][j] = 0;
				}
			}

			if(list.size() <= 0) continue;
			int i = H-1;
			for (int k = 0; k < list.size(); k++) {
				arr[i][j] = list.get(k);
				i--;
			}
			list.clear();
		}

	}
//	private static void checkEmptySpace(int[][] arr) {
//		// 열중심으로 행 W -> 0 으로 하나씩 보기
//		// 빈 공간 위에 항상 구슬이 있지 않고, 두칸 뒤에 구슬이 있을 수도 있기 때문에 고려해줘야한다!
//		for (int j = 0; j < W; j++) { // 열 중심으로
//			int i = H - 1; //행의 값을 아래부터
//			while (i > 0) { // 1까지 0일 때는 위에서 끌어내릴 것이 없기 때문에
//				if (arr[i][j] == 0) { //빈공간이면
//					int ni = i - 1;
//					while (ni > 0 && arr[ni][j] == 0)
//						ni--;
//					arr[i][j] = arr[ni][j];
//					arr[ni][j] = 0;
//				}
//				i--;
//			}
//		}
//		
//	}
}
