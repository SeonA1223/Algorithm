package Day210417;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prim_adjMatrix { //pq X
	static int[] minEdge;
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][N];
		minEdge = new int[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		//시작은 0부터
		minEdge[0] = 0;
		
		int min, res=0, minVertex;
		for (int i = 0; i < N; i++) {
			min = Integer.MAX_VALUE;
			minVertex = 0;
			
			for (int j = 0; j < N; j++) {
				if(!visited[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}				
			}
			
			res += min;
			visited[minVertex] = true;
			
			for (int j = 0; j < N; j++) {
				if(!visited[j] && map[minVertex][j] != 0 && minEdge[j] > map[minVertex][j])
					minEdge[j] = map[minVertex][j];
			}
			
		}
		
		System.out.println(res);
	}

}
