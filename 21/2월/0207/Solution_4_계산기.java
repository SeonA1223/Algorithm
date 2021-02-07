package problem210207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_4_계산기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Stack<Integer> numbers = new Stack<>();
	static Stack<Character> operations = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int tc = 1; tc <=10; tc++) {
			int count = Integer.parseInt(br.readLine());
			String expresses = br.readLine();

			for (int i = 0; i < count; i++) { //여기서 1 더 더해짐
				char express = expresses.charAt(i);

				switch (express) {
				case '+':
					operations.push(express);
					break;
				case '*':
					int multipleNum = numbers.pop() * (expresses.charAt(i + 1) - 48);
					numbers.push(multipleNum);
					i++; //여기서 1더해지고 
					break;
				default:
					numbers.push(express - 48);
					break;

				}

			}

			while (!operations.empty()) {
				operations.pop();
				int num2 = numbers.pop();
				int num1 = numbers.pop();
				numbers.push(num1 + num2);
			}

			System.out.println("#" + tc + " " + numbers.peek());

		}

	}

}
