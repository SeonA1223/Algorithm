package problem210204;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_2493_탑2 {
 
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tokens = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Wall> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            int newHeight = Integer.parseInt(tokens.nextToken());
            // 새로운 타워가 왔는데 기존 장벽 중 새 장벽보다 작은 녀석들은 pop으로 버림
            // System.out.println(stack.size() + " : " + height);
            while (!stack.isEmpty()) {
                if (stack.peek().height > newHeight) {
                	sb.append(stack.peek().idx + " ");
                	break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append("0 ");
            } 
            
            // 마지막 타워를 스택에 추가
            stack.push(new Wall(newHeight, i));
        }

        System.out.println(sb);
    }

    static class Wall {
        int height;
        int idx;

        public Wall(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }
}