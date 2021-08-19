import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BOJ_16724_피리부는사나이 {
	static Map<Character, Integer> direction;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M, circle;
	static char[][] map;
//	회전당 하나씩 safezone + 해주면 될 듯
	static int[][] visited;

	// find
	static int union;

	public static int find(int num) {
		int x = num / N;
		int y = num % M;

		if (visited[x][y] == num) {
			return num;
		}
		return visited[x][y] = find(visited[x][y]);
	}

	public static void union(int numA, int numB) {
		int parentA = find(numA);
		int parentB = find(numB);

		if (parentA <= parentB)
			visited[parentB / N][parentB / M] = parentA;
		else
			visited[parentA / N][parentB / M] = parentB;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		direction = new HashMap<>();
		direction.put('U', 0);
		direction.put('D', 1);
		direction.put('L', 2);
		direction.put('R', 3);

		map = new char[N][M];
		visited = new int[N][M];
		circle = 1;

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = i * N + j;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == -1) {
					isCircle(i, j, map[i][j]);
				}
			}
		}

		int res = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				res = Math.max(res, visited[i][j]);
			}
		}

		System.out.println(res);

	}

	private static void isCircle(int i, int j, char move) {
		int index = direction.get(move);

		int nx = i + dir[index][0];
		int ny = j + dir[index][1];
		
		int parent = find(i * N + j);
		if (parent == i * N + j) {
			isCircle(nx, ny, map[nx][ny]);
		} else {
			union(i * N + j, nx * N + ny);
		}

	}
}
