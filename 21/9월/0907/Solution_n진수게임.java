import java.util.*;

class Solution_n진수게임 {
    List<String> list;
    public String solution(int n, int t, int m, int p) {
        int length = m * t + 1;
        list = new ArrayList<>();
        list.add("x");
        int start = 0;
        while(list.size() <= length){

            if(start == 0){
                list.add("0");
                start++;
                continue;
            }
            int temp = start;
            int first = list.size();
            while(temp > 0){
                int b = temp % n;
                
                String s = "";
                if(b == 10){
                    s = "A"; 
                }else if(b == 11){
                    s = "B";
                }else if(b ==12){
                    s = "C";
                }else if(b == 13){
                    s = "D";
                }else if( b == 14){
                    s = "E";
                }else if( b== 15){
                    s = "F";
                }
                if(s.equals("")){
                    list.add(first, "" + b);
                }else{
                    list.add(first, s);
                }
                
                temp = temp / n;
        
            }
            
            start++;
        }
        
        // for(int i=0; i<=length; i++){
        //     System.out.print(list.get(i) + " ");
        // }
        
        StringBuilder sb = new StringBuilder();
        int order = p;
        for(int i=0; i<t; i++){
            sb.append(list.get(order));
            order += m;
        }
        
        String answer = sb.toString();
        return answer;
    }
}