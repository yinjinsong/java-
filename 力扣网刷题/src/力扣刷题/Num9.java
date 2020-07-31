package 力扣刷题;

public class Num9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
    //方法一，将整数反转比较是否相同
//    public static boolean isPalindrome(int x){
//        int cur=x;
//        if(cur<0){
//            return  false;
//        }
//        int rev=0;
//        while (cur!=0){
//            int pos=cur%10;
//            rev=rev*10+pos;
//            cur/=10;
//        }
//        if(rev==x){
//            return true;
//        }
//        return  false;
//    }
    public static boolean isPalindrome(int x) {
        if(x<0){
            return  false;
        }
        String str=Integer.toString(x);
        StringBuffer sb=new StringBuffer();
        for(int i=str.length()-1;i>=0;i--){
            sb.append(str.charAt(i));
        }
        if(str.equals(sb.toString())){
            return true;
        }
        return false;


    }
}
