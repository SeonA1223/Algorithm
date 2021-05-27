package Day210527;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16235_나무재태크 {
	static int N, M, K; // N : 땅크기, M : 나무 갯수, K : 년도
	static int[][] A; // 매년 겨울마다 보충하는 양분의 양
	static int[][] field;
	static PriorityQueue<Tree> trees;
	static Queue<Tree> nextTree;
	static Queue<Tree> deathTree;
	static Queue<Tree> fiveTimesTree;
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static class Tree implements Comparable<Tree> {
		int x;
		int y;
		int year;

		public Tree(int x, int y, int year) {
			super();
			this.x = x;
			this.y = y;
			this.year = year;
		}

		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return this.year - o.year;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N + 1][N + 1]; 
		field = new int[N + 1][N + 1]; 
		trees = new PriorityQueue<>();
		deathTree = new LinkedList<>();
		fiveTimesTree = new LinkedList<>();
		nextTree = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(field[i], 5);
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());

			trees.offer(new Tree(x, y, year));
		}

		int k = 0;

		while (!trees.isEmpty()) {
			int size = trees.size();
			// 봄
			spring(size);

			// 여름
			summer();

			// 가을
			Autumn();

			// 겨울
			winter();

			trees.addAll(nextTree);
			nextTree.clear();
			// 1년 지남
			if (++k == K)
				break;
			
		}
		System.out.println(trees.size());
	}

	private static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				field[i][j] += A[i][j];
			}
		}

	}

	private static void Autumn() {
		while (!fiveTimesTree.isEmpty()) {
			Tree tree = fiveTimesTree.poll();
			int x = tree.x;
			int y = tree.y;

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 1 || nx > N || ny < 1 || ny > N)
					continue;
				nextTree.offer(new Tree(nx, ny, 1));
			}
		}

	}

	private static void summer() {
		while (!deathTree.isEmpty()) {
			Tree tree = deathTree.poll();
			int x = tree.x;
			int y = tree.y;
			int year = tree.year;
			field[x][y] += (year / 2);
		}

	}

	private static void spring(int size) {
		while (--size >= 0) {
			Tree tree = trees.poll();
			int x = tree.x;
			int y = tree.y;
			int year = tree.year;

			if (field[x][y] < year) {
				deathTree.offer(new Tree(x, y, year));
			} else {
				field[x][y] -= year;
				year += 1;
				if (year % 5 == 0) {
					fiveTimesTree.offer(new Tree(x, y, year));
				}
				nextTree.offer(new Tree(x, y, year));
			}
		}

	}
}
