package test1;

import java.util.Scanner;

public class Demo2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int count = palindromeCount(s);
        System.out.println(count);

    }

    public static int palindromeCount(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        //true代表palindrome[i]..palindrome[j]是回文串
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        //字母本身
        for (int i = 0; i < s.length(); i++) {
            palindrome[i][i] = true;
            count++;
        }
        //相邻的
        for (int i = 0; i < s.length()-1; i++) {
            palindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (palindrome[i][i + 1]) {
                count++;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 2; j < s.length() ; j++) {
                if (palindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    palindrome[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
