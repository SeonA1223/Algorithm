package Day210506;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_9935_문자열폭발 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		StringBuilder explode = new StringBuilder(br.readLine());

		Stack<Character> stack = new Stack<>();
		
		char lastChar = explode.charAt(explode.length()-1);

		for (int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) != lastChar)
				stack.push(sb.charAt(i));
			else {
				int index = explode.length()-2;
				int sIndex = stack.size() -1;
				while(stack.size() >= explode.length()-1) {
					if(stack.get(sIndex) == explode.charAt(index)) {
						sIndex--;
						index--;
					}else {
						stack.push(sb.charAt(i));
						break;
					}
					
					if(index < 0) {
						for (int j = 0; j < explode.length()-1; j++) {
							stack.pop();
						}
						break;
					}
				}
			}
		}



		if (stack.isEmpty())	
			System.out.println("FRULA");
		else {
			StringBuilder res = new StringBuilder();
			for(Character ch : stack) {
				res.append(ch);
			}
			System.out.println(res.toString());
		}
	}
}
