import java.util.HashMap;

public class Num48最长不含重复字符的子字符串重要 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                int index = map.get(s.charAt(right));
                if (index >= left) {
                    left = index + 1;
                }
            }
            map.put(s.charAt(right), right);
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
