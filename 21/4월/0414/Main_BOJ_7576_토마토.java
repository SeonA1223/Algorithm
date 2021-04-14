package Day210414;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7576_토마토 {

	private static boolean allTomatoRipen(int tomato[][]) {
		boolean check = true;
		top:
		for (int i = 0; i < tomato.length; i++) {
			for (int j = 0; j < tomato[i].length; j++) {
				if (tomato[i][j] == 0) {
					check = false;
					break top;
				}
			}
		}
		return check;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<int[]> q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int dx[] = { 1, -1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		int box[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 1) {
					q.offer(new int[] { i, j });
				}
				box[i][j] = value;
			}
		}

		int time = 0;
		int[] temp;
		int size;
		while (!q.isEmpty()) {
			size = q.size();

			for (int i = 0; i < size; i++) {
				temp = q.poll();
				int x = temp[0];
				int y = temp[1];

				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];

					if (0 > nx || nx >= n || 0 > ny || ny >= m)
						continue;
					if (box[nx][ny] == 1 || box[nx][ny] == -1)
						continue;

					if (box[nx][ny] == 0) {
						box[nx][ny] = 1;
						q.offer(new int[] { nx, ny });
					}
				}

			}
			if (allTomatoRipen(box)) {
				System.out.println(time);
				return;
			}
			time++;
		}

		if (allTomatoRipen(box)) {
			System.out.println(time);
		} else {
			System.out.println("-1");
		}

	}

}
