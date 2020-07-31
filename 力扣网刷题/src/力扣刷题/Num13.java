package 力扣刷题;

import java.util.HashMap;

public class Num13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIVO"));
    }
    public static int romanToInt(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int result=0;
        int len=s.length();
        for(int i=0;i<len-1;i++){
            char ch1=s.charAt(i);
            char ch2=s.charAt(i+1);
            if(map.get(ch1)<map.get(ch2)){
                result-=map.get(ch1);
            }else{
                result+=map.get(ch1);
            }
        }
        result+=map.get(s.charAt(len-1));
        return result;
    }
}
