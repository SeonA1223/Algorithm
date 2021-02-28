package problem210228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10158_개미 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int antX = Integer.parseInt(st.nextToken());
		int antY = Integer.parseInt(st.nextToken());

		int t = Integer.parseInt(br.readLine());

		// width
		int a = (antX + t) % w;
		int b = (antY + t) % h;

		if (((antX + t) / w) % 2 != 0) {
			a = w - a;
		}

		// height
		if (((antY + t) / h) % 2 != 0) {
			b = h - b;
		}

		sb.append(a).append(" ").append(b);
		System.out.println(sb.toString());
	}

}
