import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_15831_준표의조약돌3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken()); // 검은 조약돌 최대개수
		int W = Integer.parseInt(st.nextToken()); // 하얀조약돌 최소갯수

		char[] rocks = br.readLine().toCharArray();

		int start = 0;
		int end = 0;

		int bNum = 0;
		int wNum = 0;
		int slideSize = 0;
		int maxLength = 0;

		while (start <= end) {
			if (end >= N)
				break;

			if (bNum > B) {
				if (rocks[start++] == 'W') {
					wNum--;
				} else {
					bNum--;
				}
				slideSize--;
			} else {
				if (rocks[end++] == 'W')
					wNum++;
				else
					bNum++;
				slideSize++;
			}

			if (bNum <= B && wNum >= W) {
				maxLength = Math.max(maxLength, slideSize);
			}
		}

		System.out.println(maxLength);

	}
}
