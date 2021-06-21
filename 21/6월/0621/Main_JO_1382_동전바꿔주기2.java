package problem210621;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class Main_JO_1382_동전바꿔주기2 {
    static int K, T;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        T = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
 
        int paper[][] = new int[K + 1][2];
        int dp[][] = new int[K + 1][T + 1];
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            paper[i][0] = a;
            paper[i][1] = b;
        }
 
        Arrays.sort(paper, new Comparator<int[]>() {
 
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
 
        });// 오름차순 정렬
        dp[0][0] =1;
        for (int j = 1; j <= K; j++) {
            int money = paper[j][0];
            int cnt = paper[j][1];
 
            for (int k = 0; k <= cnt; k++) {
                int real = money * k;
                if (real > T)
                    break;
                for (int i = real; i <= T; i++) {
                    dp[j][i] +=  dp[j-1][i-real];
                }
            }
        }
         
 

        System.out.println(dp[K][T]);
    }
 
}