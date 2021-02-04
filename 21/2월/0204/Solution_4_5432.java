package problem210204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_4_5432 {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			char[] brackets = br.readLine().toCharArray();
			int count = 0;
			int raser = 0;
			int stick = 0;
			for (int i = 0; i < brackets.length; i++) {
				char bracket = brackets[i];
				if (!stack.isEmpty()) {
					char before = stack.pop();
					if (bracket == '(') {
						stick += 1;
					} else if (bracket == ')') {
						if (brackets[i - 1] == ')') {
							count += stick;
						} else {
							stick -= 1;
							raser += 1;
							if (stick == 0 && raser > 0)
								raser = 0;
						}
					}

				} else {
					stack.add(bracket);
					stick += 1;
				}

			}

		}
	}

}
