import java.util.ArrayList;
import java.util.List;

public class Num1620T9键盘 {
    List<String> ans = new ArrayList<>();

    public List<String> getValidT9Words(String num, String[] words) {
        char[] arr = num.toCharArray();
        String[] map = new String[10];
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "exyz";
        for (String word : words) {
            dfs(num, 0, word, 0, map);
        }
        return ans;
    }

    private void dfs(String num, int i, String word, int j, String[] map) {
        if (j == word.length()) {
            ans.add(word);
            return;
        }
        if (i > num.length()) return;
        if (map[num.charAt(i) - '0'].indexOf(word.charAt(j)) == -1) {
            return;
        }
        dfs(num, i + 1, word, j + 1, map);
    }
}
