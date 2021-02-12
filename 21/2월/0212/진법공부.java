package problem210212_보충;

public class 진법공부 {
	
	public static void main(String[] args) {
		int i = 127;
		
		String binaryString = Integer.toBinaryString(i); //10진수 => 2진수

		String octalString = Integer.toOctalString(i);
		String hexString = Integer.toHexString(i);
		
		System.out.println(binaryString);
		System.out.println(octalString);
		System.out.println(hexString);
		
		System.out.println(Integer.parseInt(binaryString, 2)); //2진수 => 10진수, binaryString이 2진수이다. Integer.parseInt는 10진수로 바꿔주는 거!
	}
}
