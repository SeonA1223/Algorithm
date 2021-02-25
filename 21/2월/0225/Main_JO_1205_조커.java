package problem210225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_JO_1205_조커 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		boolean cardList[] = new boolean[1000001];
		int jocker = 0; // 조커개수
		int maxCardNum = 0;

		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a == 0)
				jocker++;
			else {
				cardList[a] = true;
			}
			if (maxCardNum < a) {
				maxCardNum = a;
			}
		}

		int maxLength = jocker;
		Queue<Integer> jockers = new LinkedList<>();

		int size = 0;
		for (int i = 0; i < cardList.length; i++) {
			if (cardList[i]) {
				size++;
			} else {
				if (jockers.size() < jocker) {
					size++;
					jockers.offer(i);
				} else { // 조커를 이미 다 사용했다면, 조커를 다른 곳에 넣어줘야한다.
					if (!jockers.isEmpty()) {// 이 조건문을 해주는 이유는, 조커가 없을 수도 있기 때문이다.
						size = i - jockers.poll(); //이게 핵심!! 현재 인덱스(카드X)에서 첫 조커의 인덱스를 빼면 사이즈가 나온다!!
						jockers.add(i); //그러고 조커의 인덱스를 바꿔준다.
					}

				}
			}
			maxLength = Math.max(maxLength, size); //이게 모든 경우의 수를 다 찾아본 경우!
		}
		System.out.println(maxLength);

	}

}
