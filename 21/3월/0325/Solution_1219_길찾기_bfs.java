package problem210325;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1219_길찾기_bfs {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("inpu.txt"));
//      Scanner sc = new Scanner(System.in);
		int res = 0;
		int cnt = 0;
		int from, to;

//       ArrayList => 삽입,삭제는 적고, 불러오기(get) 많은 작업   arrr.get(5555);
//       LinkedList=> 삽입삭제가 많고,  랜덤한 불러오기가 적은경우,
		ArrayList<Integer>[] list = null;
		for (int t = 1; t <= 10; t++) {
			list = new ArrayList[100];
			for (int i = 0; i < 100; i++) {
				list[i] = new ArrayList<Integer>();
			}
			res = 0;
			sc.nextInt();
			cnt = sc.nextInt();
			for (int i = 0; i < cnt; i++) {
				from = sc.nextInt();
				to = sc.nextInt();
				list[from].add(to);
			}
			Queue<Integer> q = new LinkedList<>();
			int[] v = new int[100];
			q.offer(0);
			v[0] = 1;
			Integer cur;
			while (!q.isEmpty()) {
				cur = q.poll();
				if (cur == 99) {
					res = 1;
//                  break;
				}
				ArrayList<Integer> temp = list[cur];

				for (Integer next : temp) {
//                  방문체크
					if (v[next] != 0) {
						v[next]++;
						continue;
					}
//                  새로연결
					q.offer(next);
					v[next] = 1;
				}

			}
//          진출차수
			for (int i = 0; i < 100; i++) {
				System.out.print(list[i].size() + " ");
			}
			System.out.println();
			System.out.println(Arrays.toString(v));
			System.out.println("#" + t + " " + res);
		}

	}
}
