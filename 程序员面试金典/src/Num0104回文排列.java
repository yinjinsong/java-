public class Num0104回文排列 {
    public boolean canPermutePalindrome(String s) {
        if (s.length() <= 1) return true;
        char[] arr = s.toCharArray();
        int[] map = new int[128];
        for (char c : arr) {
            map[c]++;
        }
        int oddCount = 0;
        for (int i : map) {
            if (i % 2 == 1) oddCount++;
        }
        if (oddCount > 1) return false;
        return true;
    }
}
