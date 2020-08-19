import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num336回文对 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String s1 = words[i] + words[j];
                String s2 = words[j] + words[i];
                if (isPalindrome(s1)) {
                    ans.add(Arrays.asList(i, j));
                }
                if (isPalindrome(s2)) {
                    ans.add(Arrays.asList(j, i));
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
