import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BOJ_18234_당근훔쳐먹기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] taste = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			taste[i][0] = a;
			taste[i][1] = b;
		}

		Arrays.sort(taste, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}

		});

		long res = 0L;

		for (int i = 0; i < N; i++) {
			res += taste[i][0] + (long) taste[i][1] * (T - 1);
			T--;
		}

		System.out.println(res);
	}

}
