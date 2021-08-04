package problem210804;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BOJ_10800_컬러볼 {

	public static class Ball {
		int index;
		int color;
		int size;

		public Ball(int index, int color, int size) {
			super();
			this.index = index;
			this.color = color;
			this.size = size;
		}

	}

	static int N;
	static Ball[] balls;
	static int[] sizeSum;
	static int[] colorSum;
	static int[] res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		balls = new Ball[N];
		sizeSum = new int[N];
		colorSum = new int[N];
		res = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			balls[i] = new Ball(i, color, size);
		}

		Arrays.sort(balls, new Comparator<Ball>() {

			@Override
			public int compare(Ball o1, Ball o2) {
				return o1.size - o2.size;
			}

		});

		for (int i = 1; i < N; i++) {
			sizeSum[i] = sizeSum[i - 1] + balls[i - 1].size;
			if (balls[i - 1].size == balls[i].size) {
				res[balls[i].index] = res[balls[i-1].index];
			}else {
				res[balls[i].index] = sizeSum[i];
			}
		}

		Arrays.sort(balls, new Comparator<Ball>() {

			@Override
			public int compare(Ball o1, Ball o2) {
				if (o1.color == o2.color)
					return o1.size - o2.size;
				return o1.color - o2.color;
			}

		});

		for (int i = 1; i < N; i++) {
			if (balls[i - 1].color != balls[i].color) {
				continue;
			}
			if (balls[i - 1].size == balls[i].size) {
				colorSum[i] = colorSum[i - 1];
			} else {
				colorSum[i] = colorSum[i - 1] + balls[i - 1].size;
			}
		}

		for (int i = 1; i < N; i++) {
			res[balls[i].index] -= colorSum[i];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(res[i]).append("\n");
		}
		System.out.println(sb.toString());

	}

//	private static int getOtherBall(int index, Ball ball, int maxSize) {
//		int myColor = ball.color;
//
//		for (int i = 0; i < index; i++) {
//			Ball otherBall = balls[i];
//			int otherColor = otherBall.color;
//			if (myColor == otherColor)
//				maxSize -= otherBall.size;
//		}
//		return maxSize;
//	}
}
