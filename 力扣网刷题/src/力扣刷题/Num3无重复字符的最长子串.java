package 力扣刷题;

import java.util.HashMap;

public class Num3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int ans = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                int index = map.get(s.charAt(right));
                if(index>=left) left = index + 1;
            }
            //更新right所在字符的下标
            map.put(s.charAt(right), right);
            //更新答案
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }


    public int lengthOfLongestSubstring2(String s) {
        char[] arr = s.toCharArray();
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        //更新i的时候，只有可能新加进来的arr[i]重复，所以当arr[i]的次数大于1次
        //就让j向右移动，直到没有重复字符
        for (int i = 0, j = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                while (map.getOrDefault(arr[i], 0) > 1) {
                    map.put((arr[j]), map.getOrDefault(arr[j], 0) - 1);
                    j++;
                }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}



















