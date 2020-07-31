//求最长回文子串,力扣第五题
public class Demo1 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbad"));
    }

    //基于动态规划的解法
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int longest = 1;
        int start = 0;
        //isPalindrome[i][j]为true代表从i到j的字符串是回文串
        boolean[][]  isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length()-1; i++) {
            //判断相邻两个数是不是回文数
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (isPalindrome[i][i + 1]) {
                start = i;
                longest = 2;
            }
        }
        //dp数组初始化完毕开始求解长度更长的回文串
        //长的子串依赖于短的子串的值，如[1,4]-->[2,3]
        // 所以i只能从大到小，j只能从小到大
        //因为i会依赖i+1，j会依赖j-1
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (isPalindrome[i][j] && j - i + 1 > longest) {
                    start = i;
                    longest = j - i + 1;
                }
            }
        }
        return s.substring(start, start + longest);

    }



}
