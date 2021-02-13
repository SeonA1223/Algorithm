package problem210213;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	static int N, M, K;
	static boolean[] isChecked;
	static int[][] arr;
	static int[] order;
	static int[] dx = { 1, 0, -1, 0 };// 행인덱스 상 좌 하 우
	static int[] dy = { 0, 1, 0, -1 };// 열인덱스
	static int result = Integer.MAX_VALUE;

	static void permutation(int[][] rotate, int count) {
		if (count == K) {
			System.out.println(Arrays.toString(order));
			arrRotate(rotate, order);

		}
		for (int i = 0; i < K; i++) {
			if (isChecked[i] == true)
				continue;
			order[count] = i; // 인덱스 값 저장
			isChecked[i] = true;
			permutation(rotate, count + 1);
			isChecked[i] = false;
		}

	}

	static int[][] copyArray() {
		int copyarr[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyarr[i][j] = arr[i][j];
			}
		}
		return copyarr;
	}

	static void arrRotate(int[][] rotate, int[] order) {
		int arr1[][] = copyArray();
		for (int i = 0; i < K; i++) { // 회전 연산 갯수 K번
			int dir = 0;// 우 아 좌 상
			int sx = rotate[order[i]][0] - rotate[order[i]][2] - 1; // rotate 시작위치 행
			int sy = rotate[order[i]][1] - rotate[order[i]][2] - 1; // rotate 시작위치 열
			int x = rotate[order[i]][0] - rotate[order[i]][2] - 1; // rotate 시작위치 행
			int y = rotate[order[i]][1] - rotate[order[i]][2] - 1; // rotate 시작위치 열
			
			int ex = rotate[order[i]][0] + rotate[order[i]][2] - 1; // 가장 오른쪽 아랫칸 x
			int ey = rotate[order[i]][1] + rotate[order[i]][2] - 1; // 가장 오른쪽 아랫칸 y
			int value = arr1[x][y];

			for (int j = 0; j < rotate[i][2]; j++) {
				while (dir < 4) {// dir=0,1,2,3
					int nx = sx + dx[dir];// ny = 0, 0, 0
					int ny = sy + dy[dir];// nx = 1, 2, 3

					if (ny >= y && nx >= x && ny <= ey - j && nx <= ex - j) {// 배열 범위 안이라면

						arr1[sx][sy] = arr1[nx][ny]; // 값 시프트

						sy = ny; // 이동
						sx = nx; // 이동
					} else {
						dir++;
					}
				}
				dir = 0;
				sx++;
				sy++;
				x=sx;
				y=sy;
				ex--;
				ey--;
				arr1[x][y + 1] = value;
			}

		}
		findRowMin(arr1);
	}

	private static void findRowMin(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sum += arr[i][j];
			}
			result = Math.min(result, sum);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		 N = Integer.parseInt(st.nextToken()); // 배열 행
		 M = Integer.parseInt(st.nextToken()); // 배열 열
		K = Integer.parseInt(st.nextToken()); // 회전 연산의 개수 K

		arr = new int[N][M]; // 전체 배열
		int[][] rotate = new int[K][3]; // 회전연산 r,c,s
		isChecked = new boolean[K]; // 회전연산 선택 중복체크
		order = new int[K]; // 회전연산 순서

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			rotate[i][0] = Integer.parseInt(st.nextToken());
			rotate[i][1] = Integer.parseInt(st.nextToken());
			rotate[i][2] = Integer.parseInt(st.nextToken());
		}

		permutation(rotate, 0); // 순열 및 count => 모든 수가 중복없이 한번씩 순서대로 나열되어야 한다.
		System.out.println(result);
	}
}
