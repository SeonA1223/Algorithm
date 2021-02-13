package problem210213;
public class SwapTest {
   public static void main(String[] args) {
	  int su1=10;
	  int su2=20;
	  
	  System.out.println("su1과 su2의 값을 변경해서 출력하시오!!");
//	  su1=su2;//su1의 값을 잃게 된다 ==> temp변수
//	  su2=su1;
	 /*
	     <교환식>
	     temp = 변수1;
	         변수1 = 변수2;
	         변수2 = temp;	   
	  */
	  int temp;
	  temp = su1;
	  su1  = su2;
	  su2  = temp;
	  
	  
	  System.out.println("su1>> "+su1);
	  System.out.println("su2>> "+su2);
	  
	  int []arr= {30,40};
	  temp    = arr[0];
	  arr[0]  = arr[1];
	  arr[1]  = temp;
	  
	  System.out.println("arr[0]>> "+arr[0]);
	  System.out.println("arr[1]>> "+arr[1]);
	  
	  
   }
}