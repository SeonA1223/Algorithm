package problem210201;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_1244_스위치켜고끄기1 {
	
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int N = sc.nextInt();//스위치 개수
	  int[] switchArry = new int[N + 1];//스위치정보를 담을 배열
	  //입력되는 스위치 정보가 1부터 사용되기 때문에  
	  // ==> 배열의 0번지를 버림으로써  입력값과 배열번지를 일치시켜준다!!
	  
	  for (int i = 1; i <= N; i++) {
		  switchArry[i] = sc.nextInt();//스위치정보 입력
	  }
//			  System.out.println(Arrays.toString(switchArry));
	  
	  int stuNum = sc.nextInt();//학생수
	  
	  for(int i=0; i<stuNum; i++) {
		  int gender = sc.nextInt();//학생의 성별
		  int startNum = sc.nextInt();//스위치 시작번호
		  
		  if (gender == 1) {//남학생 : 시작번호를 기준해서 배수를 스위치
			  for (int j = startNum; j<= N; j+= startNum) {
				  if(switchArry[j] == 0) switchArry[j] = 1; //스위치 값변경
				  else switchArry[j] = 0;		  
			  }
//			  System.out.println(Arrays.toString(switchArry));
		  } 
		  else {//여학생: 시작번호를 기준해서 (좌우)대칭되는 가장 가까운 수부터 스위치, 비대칭 전까지
			  int limit=startNum;
			  if(N-startNum+1  < startNum) { //+1한 이유는 자기 자신(startNum)도 포함해야하기 때문이라고 생각됨.
				  limit = N-startNum+1;
			  }			  
//			  System.out.println("limit>>>"+limit);
			  
			  //선택된 스위치는 무조건 변경
			  if(switchArry[startNum] == 0) switchArry[startNum] = 1;
			  else switchArry[startNum] = 0;
			  
			  for(int right=startNum+1, left=startNum-1, j=0; 
					  j<limit-1; //여기서 자기자신(startNum)은 빼줘야 limit이 잘 지켜짐
					j++,right++,left--) {
				  if(switchArry[left] != switchArry[right]) break; //좌우 대칭이지 않다면 종료
				  
				  if(switchArry[left] == 0) switchArry[left] = 1;
				  else switchArry[left] = 0;
				  
				  if(switchArry[right] == 0) switchArry[right] = 1;
				  else switchArry[right] = 0;
			  }
		  }
	  }
	  for (int i = 1; i <= N; i++) {
		  System.out.print(switchArry[i] + " ");
//		  if (i==20 ) System.out.println();
//		  if (i==40 ) System.out.println();
//		  if (i==60 ) System.out.println();
		  if (i%20 == 0 ) System.out.println();
	  }
	  sc.close();
  }
}