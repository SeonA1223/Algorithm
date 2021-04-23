package Day210423;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_이상한자석 {
	static int[][] magnets;
	static int[][] rotateOrder;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		magnets = new int[4][8];

		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				magnets[i][j] = s.charAt(j) - '0';
			}
		}

		int K = Integer.parseInt(br.readLine());
		rotateOrder = new int[K][2];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rotateOrder[i][0] = Integer.parseInt(st.nextToken()) - 1;
			rotateOrder[i][1] = Integer.parseInt(st.nextToken());

		}

		for (int i = 0; i < K; i++) {
			int magnet = rotateOrder[i][0];
			int dir = rotateOrder[i][1];

			int now = magnet, before = 0;
			int rotate = dir;
			List<int[]> dirInfo = new ArrayList<>();
			dirInfo.add(new int[] { magnet, dir });
			while (now - 1 >= 0) { // 있으면 자기의 2와 그 다음값의 6을 체크
				before = now - 1;
				if (magnets[before][2] != magnets[now][6]) {
					// 해당 자석을 어느방향으로 넣을지 우선 저장
					dirInfo.add(new int[] { before, rotate * -1 });
					// 그 다음 값 보기
					now = before;
					rotate *= -1;
				} else {
					break;
				}
			}
			now = magnet;
			rotate = dir;
			int next = 0;
			while (now + 1 < 4) {
				next = now + 1;
				if (magnets[now][2] != magnets[next][6]) {
					dirInfo.add(new int[] { next, rotate * -1 });
					now = next;
					rotate *= -1;
				} else {
					break;
				}
			}

			rotateAll(dirInfo);
		}

		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if (magnets[i][0] == 1) {
				sum += (int) Math.pow(2, i);
			}

		}
		System.out.println(sum);
	}

	private static void rotateAll(List<int[]> dirInfo) {
		for (int i = 0; i < dirInfo.size(); i++) {
			int magnetNum = dirInfo.get(i)[0];
			int rotate = dirInfo.get(i)[1];

			switch (rotate) {
			case 1: // 시계방향
				int temp = magnets[magnetNum][7];
				for (int j = 6; j >= 0; j--) {
					magnets[magnetNum][j + 1] = magnets[magnetNum][j];
				}
				magnets[magnetNum][0] = temp;
				break;
			case -1: // 반시계방향
				int temp2 = magnets[magnetNum][0];
				for (int j = 1; j <= 7; j++) {
					magnets[magnetNum][j - 1] = magnets[magnetNum][j];
				}
				magnets[magnetNum][7] = temp2;
				break;

			}
		}

	}
}
