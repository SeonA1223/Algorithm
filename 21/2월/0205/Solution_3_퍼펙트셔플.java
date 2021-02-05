package problem210205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_3_퍼펙트셔플 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int cardNum = Integer.parseInt(br.readLine());
			LinkedList<String> cards = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < cardNum; i++) {
				cards.add(st.nextToken());
			}
			int split = cardNum / 2;
			if (cardNum % 2 == 0) { // 짝수일 때
				for (int i = split; i < cardNum - 1; i++) {
					cards.add((i - split)*2 + 1, cards.get(i));
					cards.remove(i + 1);
				}

			} else { // 홀수일 때
				int j = 0;
				for (int i = split + 1; i < cardNum; i++) {
					cards.add(i - split + j, cards.get(i));
					cards.remove(i + 1);
					j++;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < cardNum; i++) {
				sb.append(cards.get(i)).append(" ");
			}
			System.out.println(sb.toString());
			System.out.println();
		}
	}

}
