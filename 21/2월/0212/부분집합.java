package problem210212_보충;

public class 부분집합 {
	/*
	 * 집합에 포함된 원소들을 선택하는 것
	 */
	static int N = 3;
	static String[] animals = { "강아지", "고양이", "토끼" };
	static boolean isSelect[] = new boolean[N];

	private static void subset(int count) {
		if (count == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(isSelect[i] == true ? animals[i] : "X");
			}
			System.out.println();
			return;
		}
		isSelect[count] = true; //포함했을 때
		subset(count+1);
		isSelect[count] = false; //포함안했을 때
		subset(count+1);
	}

	public static void main(String[] args) {
		subset(0);
	}
}
