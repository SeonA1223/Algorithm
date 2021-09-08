//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//public class Main_BOJ_15659_연산자끼워넣기 {
//	static int N, minNum, maxNum;
//	static int[] num;
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		N = Integer.parseInt(br.readLine());
//		minNum = Integer.MAX_VALUE;
//		maxNum = Integer.MIN_VALUE;
//
//		num = new int[N];
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//			num[i] = Integer.parseInt(st.nextToken());
//		}
//		int plus, minus, multiple, share;
//		st = new StringTokenizer(br.readLine());
//		plus = Integer.parseInt(st.nextToken()); // 0
//		minus = Integer.parseInt(st.nextToken()); // 1
//		multiple = Integer.parseInt(st.nextToken()); // 2
//		share = Integer.parseInt(st.nextToken()); // 3
//
//		dfs(0, plus, minus, multiple, share, new char[N - 1]);
//
//		System.out.println(maxNum);
//		System.out.println(minNum);
//	}
//
//	private static void dfs(int index, int plus, int minus, int multiple, int share, int[] order) {
//		if (index == N - 1) {
//			getCalculation(order);
//		}
//
//		if (plus > 0) {
//			order[index] = 0;
//			dfs(index + 1, plus - 1, minus, multiple, share, order);
//		}
//		if (minus > 0) {
//			order[index] = 1;
//			dfs(index + 1, plus, minus - 1, multiple, share, order);
//		}
//		if (multiple > 0) {
//			order[index] = 2;
//			dfs(index + 1, plus, minus, multiple - 1, share, order);
//		}
//		if (share > 0) {
//			order[index] = 3;
//			dfs(index + 1, plus, minus, multiple, share - 1, order);
//		}
//	}
//
//	private static void getCalculation(int[] order) {
//		Stack<Integer> stack = new Stack<>();
//		List<Integer> temp = new ArrayList<>();
//		List<Integer> list = new ArrayList<>();
//		boolean[] isInt = new boolean[2 * N - 1];
//
//		int numIndex = 0;
//		int orderIndex = 0;
//		for (int i = 0; i < N + N - 1; i++) {
//			if (i % 2 == 0) {
//				temp.add(num[numIndex++]);
//			} else {
//				temp.add(order[orderIndex++]);
//			}
//		}
//
//		// 후위 연산자로 만들기
//		int index = 0;
//		while (true) {
//			if (index == temp.size())
//				break;
//			if (index % 2 == 0) {
//				list.add(temp.get(index));
//				isInt[index] = true;
//			} else {
//				int oper = temp.get(index);
//				if (oper == 0 || oper == 1) {
//					while (!stack.isEmpty()) {
//						list.add(stack.pop());
//					}
//					stack.push(oper);
//				} else {
//					while (!stack.isEmpty()) {
//						char temp2 = stack.peek();
//						if (temp2 == '+' || temp2 == '-') {
//							stack.push(c);
//							break;
//						} else {
//							list.add(stack.pop());
//						}
//					}
//				}
//
//			}
//		}
//
//		while (!stack.isEmpty()) {
//			list.add(stack.pop());
//		}
//
//		// 후위연산자 계신
//		calculate(list);
//
//	}
//
//	private static void calculate(List<Character> list) {
//
//		Stack<Integer> stack = new Stack<>();
//
//		for (char c : list) {
//			int temp = 0;
//			if (1 <= c - '0' && c - '0' <= 9) {
//				stack.push(c - '0');
//			} else {
//				int second = stack.pop();
//				int first = stack.pop();
//				if (c == '+') {
//					temp = first + second;
//				} else if (c == '-') {
//					temp = first - second;
//				} else if (c == '*') {
//					temp = first * second;
//				} else {
//					temp = first / second;
//				}
//				stack.push(temp);
//
//			}
//		}
//
//		int res = stack.pop();
//		minNum = Math.min(minNum, res);
//		maxNum = Math.max(maxNum, res);
//
//	}
//}
