import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_22343_괄호의값비교 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (--T >= 0) {
			char[] A = br.readLine().toCharArray();
			char[] B = br.readLine().toCharArray();

			int scoreA = getScore(A, 0, A.length);
			int scoreB = getScore(B, 0, B.length);
			
			System.out.println(scoreA);
			System.out.println(scoreB);
			if (scoreA == scoreB)
				System.out.println("=");
			else if (scoreA > scoreB)
				System.out.println(">");
			else
				System.out.println("<");
		}
	}

	private static int getScore(char[] bracket, int s, int e) {
		Stack<Character> stack = new Stack<>();
		int index = 0;
		int totalscore = 0;
		int score = 0;

		while (index < bracket.length) {
			char temp = bracket[index];
			if (temp == '(') {
				if (index + 1 < bracket.length) {
					if (bracket[index + 1] == ')') {
						if (stack.isEmpty()) {
							totalscore += 1;
						} else {
							score += 1;
						}
						index++;
					} else {
						stack.push(temp);
					}
				}
			} else {
				if (!stack.isEmpty()) {
					score *= 2;
					stack.pop();
				}

				if (stack.isEmpty()) {
					totalscore += score;
					score = 0;
				}
			}
			index++;
		}
		return totalscore;
	}
}


