package problem210703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOj_9177_단어섞기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("Data set ").append(tc).append(": ");
			st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			String s3 = st.nextToken();

			if(bfs(s1, s2, s3)) {
				sb.append("yes").append("\n");
			}else {
				sb.append("no").append("\n");
			}

		}
		
		System.out.println(sb.toString());

	}


	private static boolean bfs(String s1, String s2, String s3) {
		Queue<Node> q = new LinkedList<>();
		boolean checkA[] = new boolean[s1.length()];
		boolean checkB[] = new boolean[s2.length()];
		q.offer(new Node(0, 0, 0));
		q.offer(new Node(0, 0, 1));

		Node tmp = null;
		while (!q.isEmpty()) {
			tmp = q.poll();
			int index = tmp.index;
			int start = tmp.start;
			int word = tmp.word;

			if (start >= s3.length())
				continue;

			if (word == 0) {
				if (index >= s1.length())
					continue;
				if (s1.charAt(index) == s3.charAt(start)) {
					checkA[index] = true;
					q.offer(new Node(index + 1, start + 1, word));
				} else {
					q.offer(new Node(index, start + 1, word));
				}
			} else {
				if (index >= s2.length())
					continue;
				if (s2.charAt(index) == s3.charAt(start)) {
					checkB[index] = true;
					q.offer(new Node(index + 1, start + 1, word));
				} else {
					q.offer(new Node(index, start + 1, word));
				}
			}
		}

		boolean flag = true;
		for (int i = 0; i < checkA.length; i++) {
			if (checkA[i] == false) {
				flag = false;
				break;
			}
		}

		if (flag) {
			for (int i = 0; i < checkB.length; i++) {
				if (checkB[i] == false) {
					flag = false;
					break;
				}
			}
		}

		if (!flag) {
			return false;
		}
		return true;

	}

	static class Node {
		int index;
		int start;
		int word;

		public Node(int index, int start, int word) {
			super();
			this.index = index;
			this.start = start;
			this.word = word;
		}

	}
}



