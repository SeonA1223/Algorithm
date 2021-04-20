package Day210420;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_캐슬디펜스 {
	static int[][] map, origin;
	static int ans;
	static int N, M, D;
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	static Point[] archers;
	static int tmpDie;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		
		origin = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				origin[i][j] = sc.nextInt();
			}
		}
		
		archers = new Point[3]; // 궁수 세명의 위치 좌표를 저장할 3칸짜리 배열
		comb(0,0);
		
		System.out.println(ans);
	}
	
	static void comb(int idx, int cnt) {
		if(cnt==3) { // 궁수자리 3개 정해졌나봄! 이 경우로 게임 진행해보자!
			map = new int[N+1][M];
			for(int i=0; i<N; i++) { // 시뮬레이션을 위한 맵 카피
				for(int j=0; j<M; j++) {
					map[i][j] = origin[i][j];
				}
			}
			
			tmpDie=0;
			for(int i=0; i<N; i++) {
				attack(); // 세명의 궁수가 한번씩 쏨!
				move(); // 적들이 한줄 내려옴.
			}
			
			if(ans<tmpDie)
				ans = tmpDie;
			
			return;
		}
		if(idx==M)
			return;
		
		archers[cnt] = new Point(N, idx); // 현재 인덱스에 궁수를 놔보자!
		comb(idx+1, cnt+1); // 방금 cnt번 궁수 위치를 정했으니 다음 놈은 cnt+1번 궁수의 위치를 정해!
		comb(idx+1, cnt); // cnt번 궁수 위치 내가 안정했어..다음 idx중에서 cnt번 궁수의 위치 정해봐...
	}
	
	static void attack() {
		boolean[][] shoot = new boolean[N][M];
		
		for(int a=0; a<3; a++) { // 궁수 한명당 bfs 한번 시작!
			boolean[][] visit = new boolean[N][M];
			Queue<Point> queue = new LinkedList<>();
			PriorityQueue<Point> enemy = new PriorityQueue<>();
			
			queue.add(archers[a]);
			int dist = 0; // bfs 점차 넓어지지만 무제한은 아님. 거리제한 때문에 거리 기록하면서 진행.
			
			while(!queue.isEmpty() && dist<=D) {
				int size = queue.size();
				for(int s=0; s<size; s++) {
					Point pt = queue.poll();
					
					if(map[pt.i][pt.j] == 1)
						enemy.add(pt);
					
					for(int d=0; d<4; d++) {
						int ni = pt.i + di[d];
						int nj = pt.j + dj[d];
						
						if(ni>=0 && ni<N && nj>=0 && nj<M && !visit[ni][nj]) {
							visit[ni][nj]= true;
							queue.add(new Point(ni,nj));
						}
					}
				}
				dist++;
				
				if(!enemy.isEmpty()) {
					Point target = enemy.poll();
					shoot[target.i][target.j] = true;
					break; // while bfs 나가서  archer for로 가세염
				}
			} // 궁수 한명당 bfs
		}// 궁수 3명 for
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(shoot[i][j]) {
					tmpDie++;
					map[i][j] = 0;
				}
			}
		}
	}
	
	static void move() {
		for(int i=N-1; i>0; i--) {
			for(int j=0; j<M; j++) {
				map[i][j] = map[i-1][j];
			}
		}
		for(int j=0; j<M; j++) {
			map[0][j] = 0;
		}
	}
	
	
	static class Point implements Comparable<Point>{
		int i,j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
		
		@Override
		public int compareTo(Point o) {
			return this.j - o.j;
		}
	}
}