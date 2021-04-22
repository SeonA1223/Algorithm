package Day210422;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_D4_5643_키순서_Floyd_김태희 {

	static int N,M,adj[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());
		for(int t=1; t<=T; ++t) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			adj = new int[N + 1][N + 1];// 0행, 0열 메모 목적으로 1씩 크기 늘림 (각행 0열 : 자신보다 큰 대상 개수, 0행 각열 : 자신보다 작은 대상  개수)
			
			for (int m = 0; m < M; ++m) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1;
			}
			int answer = 0;
			//N^3 : 1억2500만
			for (int k=1; k<= N; ++k) {// 경유
				for(int i=1; i<=N; ++i) { // 출발
					if(i==k) continue;
					for(int j=1; j<=N; ++j) { // 도착
						if(i==j || k==j || adj[i][j]==1) continue;
						if(adj[i][k]==1 && adj[k][j]==1) {  //  i가 k보다 키가 작고, k가 j보다 키가 작으면  i는 j보다 키가 작다.
							adj[i][j] = 1;
						}
					}
				}
			}
			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					adj[i][0] += adj[i][j]; // i보다 큰 j가 결국 카운트에 누적
					adj[0][j] += adj[i][j]; // j보다 작은 i가 결국 카운트에 누적
				}
			}
			for (int k = 1; k <= N; ++k) {
				if (adj[k][0] + adj[0][k] == N - 1)
					answer++;
			}
			System.out.println("#"+t+" "+answer);
		}
	}
}
