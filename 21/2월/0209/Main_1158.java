package problem210209;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1158 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		int N = scan.nextInt(); //N명의 사람
		int K = scan.nextInt(); //k번째 사람 제거
		
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		
		while(!queue.isEmpty()) {
			for (int i = 0; i < K-1; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll()).append(", ");
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb.toString());
		scan.close();
	}

}
