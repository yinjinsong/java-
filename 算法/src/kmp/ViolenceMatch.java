package kmp;

public class ViolenceMatch {
    public static void main(String[] args) {
        System.out.println(violencSearch("BBC ABCDAB ABCDABCDABDE ABCDABD", "ABCDABD"));
    }

    public static int violencSearch(String haystack, String needle) {
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }
}
