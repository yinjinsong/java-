package kmp;

import java.util.Arrays;

public class KmpSearchDemo {
    public static void main(String[] args) {
        int[] next = kmpNext("ABABCABCDAB");
        System.out.println(Arrays.toString(next));
        System.out.println(kmpSearch("BBC ABCDAB ABCDABCDABDE ABCDABD", "ABCDABD", next));
    }
    public int strStr(String haystack, String needle) {
        int[] next=kmpNext(needle);
        return kmpSearch(haystack,needle,next);
    }
    //kmp匹配
    public static int kmpSearch(String haystack, String needle, int[] next) {
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    //获取pat的部分匹配表
    public static int[] kmpNext(String dest) {
        //新建一个部分匹配表的数组
        int[] next = new int[dest.length()];
        next[0] = 0;

        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
