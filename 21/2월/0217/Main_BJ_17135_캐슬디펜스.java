package problem210217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_17135_캐슬디펜스 {
	final static int soldier = 3;
	static int N, M, D;
	static int[][] grid;
	static List<Enemy> enemies;
	static int maxNum = Integer.MIN_VALUE;

	static class Enemy {
		int x, y, distance;

		public Enemy(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static void combSoldierLoc(int count, int index, int[] arr) { // 궁수의 y좌표 구하기 (M), 궁수의 x좌표 고정
		if (count == soldier) {
			maxNum = Math.max(maxNum, attackEnemies(arr));
			return;
		}

		for (int i = index; i < M; i++) {
			arr[count] = i;
			combSoldierLoc(count + 1, index + 1, arr);
		}
	}

//거리가 D이하인 적들 중에, 가장 적은 거리, 가장 왼
	
	
	
	
	
	
//	왼쪽에 있는 적의 위치를 찾아 지운다.
	static int attackEnemies(int[] arr) {
		int c = 0;
		List<int[]> availEnemies = new ArrayList<>();
		HashSet<Integer> enemiesLoc = new HashSet<>();
		while (!enemies.isEmpty()) {
			for (int i = 0; i < soldier; i++) { // 궁수당
				for (int j = 0; j < enemies.size(); j++) { // 여러 적
					int distance = getDistance(enemies.get(j).x, N, enemies.get(j).y, arr[i]);
					if (distance <= D) {
						availEnemies.add(new int[] { j, distance }); // 공격가능한 적들 배열에 넣기
					}
				}
				if (availEnemies.size() >= 1) {
					Collections.sort(availEnemies, (o1, o2) -> o1[1] - o2[1]);
					enemiesLoc.add(availEnemies.get(0)[0]);
					availEnemies.clear();
				}
//			enemiesLoc[i] = findAEnemies(availEnemies, i);// 가능한 적 제거하기
			}
			Iterator<Integer> it = enemiesLoc.iterator();
			while (it.hasNext()) {
				int index = it.next();
				grid[enemies.get(index).x][enemies.get(index).y] = 0;
				c++;
			}
			for (int i = 0; i < enemies.size(); i++) {
				int x = enemies.get(i).x + 1;
				if (x == N)
					enemies.remove(i);
				else
					enemies.get(i).x = x;
			}
		}
		return c;

	}

//	static int findAEnemies(List<int[]> enemies, int i) {
//		int minNum = 15;
//		if (enemies.size() > 1) {
//			Collections.sort(enemies, (o1, o2) -> o1[1] - o2[1]); // 거리가 작은 순
//			int minDist = enemies.get(0)[1];
//			int count = 0; // 제일 거리가 작은값이 몇개냐?
//			for (int j = 1; j < enemies.size(); j++) {
//				if (minDist < enemies.get(j)[1]) {
//					break;
//				} else {
//					count++;
//				}
//			}
//			if (count == 0) {
//				return enemies.get(0)[0];
//			} else { // 가장 가까운 거리의 적이 여럿일 경우, 가장 왼쪽의 값을 구한다. 
//				for (int j = 0; j < count; j++) {
//					if (enemies.get(j)[0] < minNum)
//						minNum = enemies.get(j)[0];
//				}
//				return minNum;
//			}
//		} else {
//			return enemies.get(0)[0];
//		}
//	}

	static int getDistance(int x1, int x2, int y1, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

//	static boolean getLeftEnemy(int y1, int y2) { //y1 : 적  y2: 궁수
//		if(y1 >= y2)
//	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		grid = new int[N + 1][M];
		enemies = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 1)
					enemies.add(new Enemy(i, j)); // 적에 위치 파악
				grid[i][j] = a;
			}
		}
		for (int i = 0; i < M; i++) {
			grid[N][i] = 2;
		}
		// 궁수의 위치 조합
		int[] soldLoc = new int[3];
		combSoldierLoc(0, 0, soldLoc);
		System.out.println(maxNum);

	}
}
