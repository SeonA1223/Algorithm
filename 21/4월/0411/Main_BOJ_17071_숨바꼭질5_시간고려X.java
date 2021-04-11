package Day210411;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_17071_숨바꼭질5_시간고려X {
	public static void main(String[] args) throws IOException{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		
		if(n==k) {
			System.out.println("0");
			return;
		}
		
		
		final int MAX_NUM = 500000;
		Queue<Integer> q = new LinkedList<>();
//		Queue<Integer> q2 = new LinkedList<>();
		int visited[] = new int[MAX_NUM + 1];
		Arrays.fill(visited, -1);
		
		q.add(n);
//		q2.add(k);
		
		int x;
		int time = 0;
		int size = 0;
		int add = 0;
		int y = k;
		loop:
		while(!q.isEmpty()) {
			size = q.size();
			
			for (int i = 0; i < size; i++) {
				x = q.poll();
				
				if(x == y) {
					System.out.println(time);
					break loop;
				}
				
				for (int nx : new int[]{x+1, x-1, x*2}) {
					if(0 <= nx && nx <= MAX_NUM && visited[nx] != time ) {
						visited[nx] = time;
						q.add(nx);
					}
				}
				
				
			}
			time++;
			y += time;
			if( y > MAX_NUM) {
				System.out.println("-1");
				return;
			}
		}
		
	}
}
