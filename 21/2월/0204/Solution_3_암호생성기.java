package problem210204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3_암호생성기 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();

		for (int t = 1; t <= 10; t++) {
			int minus = 1;
			int tc = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String st[] = str.split(" ");
			
			for(int i=0; i<8; i++) {
				queue.offer(Integer.parseInt(st[i]));
			}
//
			int num;
			while (true) {
				if(minus>5) minus=1;
				num = queue.poll()-minus;
				
				if (num <= 0) {
					num = 0;
					queue.offer(num);
					break;
				}
				queue.offer(num);
				minus++;
			}
			System.out.print("#" + tc);
			for (int i = 0; i < 8; i++) {
				System.out.print(" " + queue.poll());
			}
			System.out.println();
			queue.clear();
		}
	}

}
