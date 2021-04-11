package Day210411;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main_BOJ_13913_숨바꼭칠4 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();

		int time[] = new int[100001];
		int parent[] = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		Stack<Integer> s = new Stack<>();

		time[n] = 1;
		parent[n] = n;
		q.add(n);

		int x;
		int index;
		while (!q.isEmpty()) {
			x = q.poll();

			if (x == k) {
				s.push(k);
				index = k;
				
				while(index != n) {
					s.push(parent[index]);
					index = parent[index];
				}
				
				System.out.println(time[k] - 1);
				while(!s.isEmpty()) {
					System.out.print(s.pop() + " ");
				}
				return;
			}

			if (x + 1 >= 0 && x + 1 <= 100000 && time[x + 1] == 0) {
				time[x + 1] = time[x] + 1;
				parent[x + 1] = x;
				q.add(x + 1);
			}

			if (x - 1 >= 0 && x - 1 <= 100000 && time[x - 1] == 0) {
				time[x - 1] = time[x] + 1;
				parent[x - 1] = x;
				q.add(x - 1);
			}
			if (x * 2 >= 0 && x * 2 <= 100000 && time[2 * x] == 0) {
				time[x * 2] = time[x] + 1;
				parent[x * 2] = x;
				q.add(x * 2);
			}

		}
	}
}
