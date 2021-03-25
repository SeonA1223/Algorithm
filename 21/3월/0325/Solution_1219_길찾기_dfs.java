package problem210325;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_1219_길찾기_dfs {
	static ArrayList<Integer>[] list = null;
	static int res = 0;

	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(new FileInputStream("inpu.txt"));
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int from, to;
		boolean visited[];

//       ArrayList => 삽입,삭제는 적고, 불러오기(get) 많은 작업   arrr.get(5555);
//       LinkedList=> 삽입삭제가 많고,  랜덤한 불러오기가 적은경우,
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
			visited = new boolean[100];
			dfs(0, visited);

			System.out.println("#" + t + " " + res);
		}
	}

	private static void dfs(int index, boolean[] visited) {
		visited[index] = true;

		if (index == 99) {
			res = 1;
			return;
		}

		int size = list[index].size();

		if (size == 0)
			return;

		for (int i = 0; i < size; i++) {
			int num = list[index].get(i);
			if (!visited[num]) {
				dfs(num, visited);
			}
		}

	}

}