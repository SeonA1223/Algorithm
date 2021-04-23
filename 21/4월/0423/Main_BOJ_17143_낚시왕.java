package Day210423;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_17143_낚시왕 {
	static int R, C, M, sum;
	static int sea[][][];
	static Shark[] sharks;
	// 1 = 위 2 = 아래 3 오른쪽 4 왼쪽
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };

	public static class Shark {
		int x, y;
		int velocity;
		int dir;
		int size;
		boolean alive;

		public Shark(int x, int y, int velocity, int dir, int size) {
			super();
			this.x = x;
			this.y = y;
			this.velocity = velocity;
			this.dir = dir;
			this.size = size;
			this.alive = true;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 바다는 (1,1)부터 시작
		sea = new int[M][R + 1][C + 1];
		sharks = new Shark[M];
		sum = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int velocity = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			// 샤크 정보 담기
			sharks[i] = new Shark(x, y, velocity, dir, size);
			// 바다의 상어 위치 담기
			sea[i][x][y] = 1;
		}

		if (M == 0) {
			System.out.println(0);
			return;
		}
		for (int king = 1; king <= C; king++) { // 1초마다 열 한칸식 움직이는 낚시 왕
			// 상어들과 낚시왕 사이의 거리 재고 제일 가까운 상어 잡기
			getDistanceWithSharks(king);
			moveSharks();
		}
		System.out.println(sum);
	}

	private static void moveSharks() {
		boolean moved[] = new boolean[M];

		for (int i = 0; i < M; i++) {
			if (sharks[i].alive) {
				int sx = sharks[i].x;
				int sy = sharks[i].y;
				int d = sharks[i].dir;
				int v = sharks[i].velocity;

				sea[i][sx][sy] = 0;

				if (d <= 2)
					v = v % 2 * (R - 1);
				if (2 < d)
					v = v % 2 * (C - 1);
				int nx;
				int ny;
				for (int j = 0; j < v; j++) { // 이동횟수
					nx = sx + dx[d];
					ny = sy + dy[d];

					if (1 > nx || nx > R || 1 > ny || ny > C) {// 범위를 나가면
						d = reverseDirection(d);
						sx = sx + dx[d];
						sy = sy + dy[d];
					} else {
						sx = nx;
						sy = ny;
					}

				}
				boolean flag = true;
				for (int j = 0; j < M; j++) {
					// 움직이지 않은 친구의 sx, sy의 값이 1이면
					if (i != j && sharks[j].alive && moved[j] && sea[j][sx][sy] == 1) {
						int size1 = sharks[i].size;
						int size2 = sharks[j].size;

						if (size1 < size2) {
							// i의 상어 없애기
							sharks[i].alive = false;
							flag = false;
							moved[i] = true;

						} else {
							// i 상어가 더 크면
							sea[j][sx][sy] = 0;
							sharks[j].alive = false;
						}
					}
				}
				if (flag) {
					sea[i][sx][sy] = 1;
					sharks[i].x = sx;
					sharks[i].y = sy;
					sharks[i].dir = d;
					moved[i] = true;
				}
			}
		}

	}

	private static void getDistanceWithSharks(int king) {

		int sx = Integer.MAX_VALUE;
		int index = 0;
		boolean flag = false;

		for (int i = 0; i < M; i++) {
			if (sharks[i].alive && sharks[i].y == king) {
				if (sx > sharks[i].x) {
					sx = sharks[i].x;
					index = i;
					flag = true;
				}
			}
		}

		if (flag) {
			sum += sharks[index].size;
			sharks[index].alive = false;
			sea[index][sx][king] = 0;
		}

	}

	private static int reverseDirection(int d) {
		if (d == 1)
			return 2;
		if (d == 2)
			return 1;
		if (d == 3)
			return 4;
		if (d == 4)
			return 3;
		return d;
	}
}
