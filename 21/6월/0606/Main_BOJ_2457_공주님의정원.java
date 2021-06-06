package Day210606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_2457_공주님의정원 {
	static int month[], N, cnt;
	static int monthSum[];
	static Node[] flowers;
	static int startMonth, endMonth;

	static class Node implements Comparable<Node> {
		int start;
		int end;

		public Node(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Node o) {
			if (this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		month = new int[13];
		monthSum = new int[13];
		month[1] = month[3] = month[5] = month[7] = month[8] = month[10] = month[12] = 31;
		month[4] = month[6] = month[9] = month[11] = 30;
		month[2] = 28;

		for (int i = 2; i <= 12; i++) {
			monthSum[i] = monthSum[i - 1] + month[i - 1];
		}

		N = Integer.parseInt(br.readLine());
		flowers = new Node[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m1 = Integer.parseInt(st.nextToken());
			int d1 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());
			flowers[i] = new Node(monthSum[m1] + d1, monthSum[m2] + d2);
		}

		Arrays.sort(flowers);
		cnt = 0;
		startMonth = monthSum[3]+1;
		endMonth = monthSum[12]+1;

		int lastDay = 0;
		int index = 0;
		boolean flag = true;
		while (true) {
			if(startMonth >= endMonth) break;
			if(index >= N) {
				flag = false;
				break;
			}
			for (int i = index; i < N; i++) {
				if (flowers[i].start <= startMonth) {
					if (lastDay < flowers[i].end) {
						lastDay = flowers[i].end;
						index = i;
					}else if(lastDay == flowers[i].end) {
						int diff1 = startMonth - flowers[index].start;
						int diff2 = startMonth - flowers[i].start;
						if(diff1 > diff2) index = i;
					}
				} else
					break;
			}
			startMonth = lastDay;
			cnt++;
			index++;
		}
		
		if(flag) {
		System.out.println(cnt);
		}else {
			System.out.println(0);
		}

	}
}
