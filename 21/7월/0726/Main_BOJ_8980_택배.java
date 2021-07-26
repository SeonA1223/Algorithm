package problem210726;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_8980_택배 {
	static int N, C, M;
	static List<Node> lists;
	static int maxBox;

	static class Node implements Comparable<Node> {
		int reqCity;
		int sendCity;
		int boxCnt;

		public Node(int reqCity, int sendCity, int boxCnt) {
			this.reqCity = reqCity;
			this.sendCity = sendCity;
			this.boxCnt = boxCnt;
		}

		@Override
		public int compareTo(Node o) {
			if (this.sendCity == o.sendCity) {
				return o.reqCity - this.reqCity;
			}
			return this.sendCity - o.sendCity;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		maxBox = 0;

		lists = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int rec = Integer.parseInt(st.nextToken());
			int send = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			lists.add(new Node(rec, send, cnt));
		}

		Collections.sort(lists);

		int[][] delivery = new int[N + 1][N + 1];
		int totalCnt = 0;
//		for (int i = 1; i <= N; i++) {
//			if (i > 1) {
//				for (int j = 1; j < i; j++) {
//					if (delivery[j][i] > 0) {
//						totalCnt -= delivery[j][i];
//					}
//				}
//			}
//			for (Node node : lists[i]) {
//				int send = node.sendCity;
//				int cnt = node.boxCnt;
//				if (i < N / 2 && N == send)
//					continue;
//				if (totalCnt >= C)
//					break;
//				if (C <= cnt + totalCnt) {
//					int temp = C - totalCnt;
//					delivery[i][send] = temp;
//					totalCnt += temp;
//					maxBox += temp;
//				} else {
//					delivery[i][send] = cnt;
//					totalCnt += cnt;
//					maxBox += cnt;
//				}
//			}
//		}
		
		for(Node node : lists) {
			int req = node.reqCity;
			int send = node.sendCity;
			int cnt = node.boxCnt;
			
			for (int j = 1; j < req; j++) {
				if (delivery[j][req] > 0) {
					totalCnt -= delivery[j][req];
				}
			}
			if (totalCnt >= C)
				break;
			
			if (C <= cnt + totalCnt) {
				int temp = C - totalCnt;
				delivery[req][send] = temp;
				totalCnt += temp;
				maxBox += temp;
			} else {
				delivery[req][send] = cnt;
				totalCnt += cnt;
				maxBox += cnt;
			}
		}

		System.out.println(maxBox);
	}
}
