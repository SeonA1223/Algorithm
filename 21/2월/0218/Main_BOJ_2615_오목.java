package problem210218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_2615_오목 {
	static final int BOARD_SIZE = 19;

	static class Node implements Comparator<Node> {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Node() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			int t = o1.x - o2.y;
			if (t == 0) {
				return o1.y - o2.y;
			}
			return t;
		}
	}
	
	private boolean findHorizontalLine(List<Node> list) {
		int count = 0;
		int index = 0;
		while(list.size() != 0) {
			int x = list.get(index).x;
			int y = list.get(index).y;
			
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		List<Node> black = new ArrayList<>();
		List<Node> white = new ArrayList<>();

		for (int i = 1; i <= BOARD_SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= BOARD_SIZE; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 1) {// 검은 바둑알
					black.add(new Node(i, j));
				} else if (a == 2) // 흰 바둑알
					white.add(new Node(i, j));
			}
		}

		Collections.sort(black, new Node());
		Collections.sort(white, new Node());

	}

}
