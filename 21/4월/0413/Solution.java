package Day210413;

import java.util.Stack;

class Solution {
	public static void main(String[] args) {
		String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
		System.out.println(solution(8,2, cmd));
	}
	public static String solution(int n, int k, String[] cmd) {
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < cmd.length; i++) {
			char c = cmd[i].charAt(0);
			if (c == 'U') {
				int count = cmd[i].charAt(cmd[i].length() - 1) - '0';
				k -= count;
			} else if (c == 'D') {
				int count = cmd[i].charAt(cmd[i].length() - 1) - '0';
				k += count;
			} else if (c == 'C') {
				if (k == n - 1) {
					stack.push(k);
					n--;
					k -= 1;
				} else {
					stack.push(k);
					n--;
				}
			} else if (c == 'Z') {
				int temp = stack.pop();
				if(temp <= k) k++;
				n++;
			}
		}
		
		for(int i=0; i<n; i++) {
			sb.append("O");
		}
		while(!stack.isEmpty()) {
			int temp = stack.pop();
			sb.insert(temp, "X");
		}
		String answer = sb.toString();
		return answer;
	}
}