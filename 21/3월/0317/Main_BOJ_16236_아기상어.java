package problem210317;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BOJ_16236_아기상어 {

	static class Point implements Comparable<Point> {
		int x;
		int y;
		int dis;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.dis == o.dis) {
				if (this.x == o.x) {
					return this.y - o.y; // 다 오름차순 정렬
				}
				return this.x - o.x;
			}
			return this.dis - o.dis;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int space[][] = new int[N][N];
		int sharkX = 0, sharkY = 0, sharkSize = 2;
		int bigger = 0, same = 0, smaller = 0;
		int dx[] = { -1, 0, 1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		LinkedList<Point> smallList = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				space[i][j] = input;
				if (input == 9) {
					sharkX = i;
					sharkY = j;
				}
				if (input > sharkSize) {
					bigger++;
				}
				if (input == sharkSize) {
					same++;
				}
				if (input < sharkSize) {
					smaller++;
					smallList.add(new Point(i, j));
				}
			}
		}
		if (smaller <= 0)
			System.out.println("0");

		// 작은 물고기들과의 거리 계산
		int smallDis = 50;
		for (int i = 0; i < smallList.size(); i++) {
			int dis = Math.abs(smallList.get(i).x - sharkX) + Math.abs(smallList.get(i).y - sharkY);
			if (smallDis > dis)
				smallDis = dis;
			smallList.get(i).dis = dis;
		} 

		int count = 0;
		int move = 1;
		while (true) {
			if (smaller <= 0)
				System.out.println(count);
			for (int i = 0; i < 4; i++) {
				int nx = sharkX + dx[i];
				int ny = sharkY + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N || space[nx][ny] > sharkSize)
					continue;

				for (int j = 0; j < smallList.size(); j++) {
					if (nx == smallList.get(j).x && ny == smallList.get(j).y) {
						smallList.get(j).dis = move;

					}

				}
			}
			++move;

		}

	}

}
