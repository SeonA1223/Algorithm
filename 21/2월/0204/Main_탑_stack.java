package problem210204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 문제 논리
 * 1. 맨 왼쪽에 있는 탑의 값은 언제나 0, 스택에 우선 담는다. => 담을 때, index도 중요하기 때문에 {index, value} 순으로 넣는다.
 * 2. if stack.peek()[1] >= tops[i] 레이저 신호 수신 O => sysout stack.peek()[0] 
 * 3. if stack.peek()[1] < tops[i] 레이저 신호 수신 X => stack.pop() 그 다음 스택에 있는 값과 비교(for문 안에서 또 while(!stack.isEmpty()) 로 처리)
 * 4. stack이 비어있으면, 현재 tops[i]왼쪽에 현재 탑 높이보다 큰게 없다는 의미로 sysout 0
 * 5. 모든 값이 비교 대상이므로 현재 tops[i]는 다 stack.push()한다.
 * 
 */
public class Main_탑_stack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		Stack<int[]> stack = new Stack<>();

		int num = Integer.parseInt(br.readLine());
		int tops[] = new int[num + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= num; i++) {
			tops[i] = Integer.parseInt(st.nextToken());
		}

		stack.push(new int[] { 1, tops[1] });
		sb.append("0 ");

		for (int i = 2; i <= num; i++) {
			while (!stack.isEmpty()) {
				if (tops[i] < stack.peek()[1]) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty())
				sb.append("0 ");
			stack.push(new int[] { i, tops[i] });
		}
		System.out.println(sb.toString());
	}

}
