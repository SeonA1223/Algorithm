package problem210215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_규영인영카드게임 {
	static final int CARD_NUM = 9;
	static final int TOTALCARD = 18;
	static int[] aCard, bCard, cCard;
	static boolean[] isCheck;
	static boolean[] used;
	static int win, lose, c;

	private static void perm(int count) {
		if (count == CARD_NUM) {
			game();
			return;
		}
		for (int i = 0; i < CARD_NUM; i++) {
			if (used[i] == true)
				continue;
			used[i] = true;
			cCard[count] = bCard[i];
			perm(count + 1);
			used[i] = false;
		}
	}

	private static void game() {
		int aScore = 0, bScore = 0;
		for (int i = 0; i < CARD_NUM; i++) {
			if (aCard[i] > cCard[i])
				aScore += aCard[i] + cCard[i];
			else
				bScore += aCard[i] + cCard[i];
		}
		if (aScore > bScore)
			win++;
		else if (aScore < bScore)
			lose++;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		aCard = new int[CARD_NUM];
		bCard = new int[CARD_NUM];
		cCard = new int[CARD_NUM];
		used = new boolean[CARD_NUM];
		isCheck = new boolean[TOTALCARD + 1];

		for (int tc = 1; tc <= T; tc++) {
			win =  0;
			lose = 0;
			Arrays.fill(isCheck, false);
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < CARD_NUM; i++) {
				int card = Integer.parseInt(st.nextToken());
				aCard[i] = card;
				isCheck[card] = true;
			}

			int index = 0;
			for (int i = 1; i <= TOTALCARD; i++) {
				if (isCheck[i] == false) {
					bCard[index] = i;
					index++;
				}
			}

			perm(0);
			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		System.out.println(sb.toString());
	}
}
