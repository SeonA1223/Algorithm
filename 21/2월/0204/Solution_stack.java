package problem210204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_stack {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int num = Integer.parseInt(br.readLine());
			char[] scopes = br.readLine().toCharArray();
			int valid = 1;
			Stack<Character> stack = new Stack<>();
			
			for (int i = 0; i < num; i++) {
				char scope = scopes[i];
				
				
				if(scope == '(' || scope == '{' || scope == '[' || scope == '<') {
					stack.push(scope);
				}
				
				else {
					char pop = stack.pop();
					if(scope == ')' && pop == '(' ) continue;
					else if(scope == '}' && pop == '{') continue;
					else if(scope == ']' && pop == '[') continue;
					else if(scope == '>' && pop == '<') continue;
					else {
						valid = 0;
						break;
					}
				}
				if(valid == 0) break;
			}
			if(stack.size() != 0) valid = 0;
			
			System.out.println("#"+tc+" "+valid);
		}
		
	}

}
