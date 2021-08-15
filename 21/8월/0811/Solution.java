package problem210811;
import java.util.regex.Pattern;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		solution("124,999,999");
	}
	
    private static boolean solution(String amountText) {
        
        //1. 0-9, ,만 포함되었냐 아니냐
        if(containCharacter(amountText)){
        	int size = amountText.length();
            if(size > 1 && amountText.charAt(0) == 0) return false;
             if(onlyContainNumber(amountText)) return true;
            
            //3자리 구분자
            if(commaThreeSplit(amountText)) return true;
            else return false;
            
        }
        return false;
    }
    
    private static boolean containCharacter(String text){
        String pattern = "^[0-9|,]*$";
        if(Pattern.matches(pattern, text)) return true;
        return false;
    }
    
    private static boolean onlyContainNumber(String text){
        String pattern = "^[0-9]*$";
        if(Pattern.matches(pattern, text)) return true;
            return false;
    }
    
    static boolean commaThreeSplit(String text){
        Stack<Character> stack = new Stack();
        int index = text.length() - 1;
        while(index >= 0){
            char temp = text.charAt(index--);
            System.out.println(temp);
            if(stack.isEmpty() && temp == ',') return false;
            if('0' <= temp && temp <= '9') stack.push(temp);
            else{
                if(stack.size() == 3) stack.clear();
                else return false;
                if(index < 2) return true;
            }
        }
        
        return false;
    }
    

}