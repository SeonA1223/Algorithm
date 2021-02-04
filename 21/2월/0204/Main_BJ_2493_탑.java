package problem210204;
import java.io.*;
import java.util.*;

public class Main_BJ_2493_탑 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		String s = br.readLine();
////		StringTokenizer st = new StringTokenizer(s);//new StringTokenizer(s, " ");
//		int n = Integer.parseInt(st.nextToken()); // n 은 최대 50만
		
		int n = Integer.parseInt(br.readLine());//탑의 수

		StringTokenizer st = new StringTokenizer(br.readLine());
		//st=["6", "9", "5", "7", "4"];//탑의 높이 정보
		
		Stack<int[]> stack = new Stack<>();
		// input
		for (int i = 1; i <= n; i++) {//i ==> 탑의 순서: 1 2 3 4 5 ~
			int num = Integer.parseInt(st.nextToken()); //num: 탑의 높이
             //6  9  5  7  4
			
			while (!stack.empty()) {//스택에 비교할 값이 존재한다면
			//출력	"0 0 2 2 4"
				if (stack.peek()[1] > num) {//수신을 할수있는 탑을 만났다면
			/*
			                  6 > 9
			                  
			                  7 > 4   
			 */
					//스택에 마지막 입력된 탑의높이  >  새로입력의 탑의 높이 비교
					System.out.print(stack.peek()[0] + " ");
					break;
				}
				stack.pop();//remove
			}

			if (stack.empty()) {
				System.out.print("0 ");
			}
			//int []su = { i , num};
            //stack.push(su);
			stack.push(new int[] { i, num });
/*
    
    			
    |       |                               스택비었으므로 "0"출력
    ---------			
==============================================================    
     
    | (1,6 )|  > (2,9)    앞의 수가 적으면 pop 
    ---------
==============================================================    
    			
    |       |  > (2,9)                      스택비었으므로 "0"출력
    ---------			
==============================================================    

    | (2,9 )|  > (3,5)    앞의 수가 크면               앞의순서 출력 "2"
    ---------			
==============================================================    

    | (3,5 )|  > (4,7)    앞의 수가 적으면 pop   
    | (2,9 )|  
    ---------			
==============================================================    

    |       |  > (4,7)    앞의 수가 크면                앞의순서 출력 "2"
    | (2,9 )|  
    ---------	
==============================================================    
    		

    | (4,7 )|  > (5,4)    앞의 수가 크면                앞의순서 출력 "4"
    | (2,9 )|  
    ---------			
==============================================================    

    | (5,4 )|
    | (4,7 )|  
    | (2,9 )|  
    ---------			
==============================================================    
    
     
*/
			
			
			
			
			//stack[ (1,6)-  (2,9) (3,5)- (4,7)  (5,4)]
			//       int[]
			//       [0][1]
/*			
			=============================
			int []su= {1,2,3}; ok
			=============================			
			int []su;
			       su= {1,2,3}; ==> x
			       su = new int[]{4,5,6}; ==> ok
			=============================       
			int []su = new int[5];  ok
			
			=============================       
			int []su;
			      su = new int[5];  ok
			=============================       
			      
			      
*/			      
		}
	}
}





