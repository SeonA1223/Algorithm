package problem210212_보충;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_Ladder1 {

	private static boolean checkRange(int x, int y) {
		if (0 <= x && x < 100 && 0 <= y && y < 100)
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int maze[][] = new int[100][100];
		int startY = 0;
		int startX = 0;
		int dx[] = { -1, 0, 0 }; // 상,좌,우
		int dy[] = { 0, -1, 1 };

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					int findArrive = Integer.parseInt(st.nextToken());
					maze[i][j] = findArrive;
					if (findArrive == 2) {
						startX = i;
						startY = j;
					}
				}
			}
			while (startX != 0) {
				int upX = startX + dx[0];
				int upY = startY + dy[0];

				int leftX = startX + dx[1];
				int leftY = startY + dy[1];

				int rightX = startX + dx[2];
				int rightY = startY + dy[2];

				if (checkRange(leftX, leftY) && maze[leftX][leftY] == 1) {
//					while (maze[leftX][leftY] == 1 && checkRange(leftX, leftY)) { //범위를 벗어나게 되면, 이차원배열안에 값을 넣을 때, ArrayIndexOutOfBoundsException이 일어날 수 있음
//						leftX = leftX + dx[1];
//						leftY = leftY + dy[1];
//					}
//					startX = leftX - dx[1] + dx[0];
//					startY = leftY - dx[1] + dy[0];
					while (true) {
						leftX = leftX + dx[1];
						leftY = leftY + dy[1];
						if (!checkRange(leftX, leftY) || maze[leftX][leftY] != 1)
							break;
					}
					startX = leftX - dx[1] + dx[0];
					startY = leftY - dy[1] + dy[0];
					/*
					 * 다른 분의 좋은 코드 그 다음 왼쪽 좌표를 확인한 후, 범위를 넘어가거나 1이 아니면, 그 전 startX or startY의 값에서
					 * dx[0],dy[0]을 해준다. 즉, 다음 좌표 확인 후 조건에 부합하지 않으면 startX,startY에 저장하지 않는 것이다.
					 * 
					 * while(true) { // 있다면 갈수 있는 범위 내 좌로 쭉 간 후, 아래로 한칸 내려간다. 
					 * leftOne = leftOne + dOne[1]; 
					 * leftTwo = leftTwo + dTwo[1]; 
					 * if(isOut(leftOne, leftTwo) ||  ladder[leftOne][leftTwo] != 1) break; 
					 * startOne = leftOne;  //조건을 잘 부합하면, 현재좌표를 바꿔준다.
					 * startTwo = leftTwo;
					 * } 
					 * startOne += dOne[0]; //조건을 부합하지 않으면 현재좌표에서 위로 올라간다.(이걸 해주지 않으면, 다시 왼쪽에서 판단했을 때 1의 값이 존재하므로)
					 * startTwo += dTwo[0];
					 */

				} else if (checkRange(rightX, rightY) && maze[rightX][rightY] == 1) {
					while (true) {
						rightX = rightX + dx[2];
						rightY = rightY + dy[2];
						if (!checkRange(rightX, rightY) || maze[rightX][rightY] != 1)
							break;
					}
					startX = rightX - dx[2] + dx[0];
					startY = rightY - dy[2] + dy[0];

				} else {
					startX = upX;
					startY = upY;
				}

			}
			sb.append("#").append(tc).append(" ").append(startY).append("\n");

		}
		System.out.println(sb.toString());
	}

}
