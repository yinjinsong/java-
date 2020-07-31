package 力扣刷题;

import java.util.HashMap;

public class Num76最小覆盖子串 {
    public static void main(String[] args) {
        System.out.println(minWindow("A", "B"));
    }
    public static String minWindow(String s, String t) {
        int[] hash = new int[128];
        for (char c : t.toCharArray()) {
            hash[c]++;
        }
        int cnt = 0;
        for (int i : hash) {
            if (i > 0) cnt++;
        }
        char[] arr = s.toCharArray();
        String ans = "";
        for (int i = 0, j = 0, c = 0; i < arr.length; i++) {
            if (hash[arr[i]] == 1) c++;
            hash[arr[i]]--;
            while (c == cnt && hash[arr[j]] < 0) {
                hash[arr[j++]]++;
            }
            if (c == cnt) {
                if (ans.length() == 0 || ans.length() > i - j + 1) {
                    ans = s.substring(j, i + 1);
                }
            }
        }
        return ans;
    }
























    public String minWindow2(String s, String t) {
        if (s == null || t == null) return null;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int cnt = map.size();
        char[] arr = s.toCharArray();
        String ans = "";
        for (int i = 0, j = 0, c = 0; i < arr.length; i++) {
            if (map.getOrDefault(arr[i], 0) == 1) c++;
            map.put(arr[i], map.getOrDefault(arr[i], 0) - 1);
            while (c == cnt && map.getOrDefault(arr[j], 0) < 0) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
                j++;
            }
            if (c == cnt) {
                if (ans.length() == 0 || ans.length() > i - j + 1) {
                    ans = s.substring(j, i);
                }
            }
        }
        return ans;

    }

}
