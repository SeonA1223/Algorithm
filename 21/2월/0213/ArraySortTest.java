
package problem210213;
import java.util.Arrays;

public class ArraySortTest {
   public static void main(String[] args) {
	   int[]su= {13, 8, 7, 10, 100, 5};
	   //위의 배열을 오름차순 정렬하시오. (선택정렬)
/*
  
               i[0   1  2   3   4]
               j    [1  2   3   4   5]
	   int[]su= {13, 8, 7, 10, 100, 5};
                 ↑ > ↑
                 8   13 7  10  100 5  
                 ↑      ↑
                 7   13 8  10  100 5
                 ↑          ↑ 
                 7   13 8  10  100 5
                 ↑              ↑                 
                 7   13 8  10  100 5
                 ↑                 ↑                   
                 5   13 8  10  100 7
                 ==> 한 사이클 (i=0일때 j값 변경하며 비교한 결과)   : 최소값을 맨 좌측으로 이동!!
                 
*/	   
	   int temp;
	   for(int i=0; i<su.length-1; i++) {//기준: 비교왼쪽 번지데이터
		  for(int j=i+1; j<su.length; j++) {// 비교오른쪽 번지데이터
			 if(su[i] < su[j]) {//앞에 값이 클때 교환~!! 
			  temp  = su[i];
			  su[i] = su[j];
			  su[j] = temp;
			 }
		  }
	   }
	   
	   System.out.println(Arrays.toString(su));
	   
   }//main
}