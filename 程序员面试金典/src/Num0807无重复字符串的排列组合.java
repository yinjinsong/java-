import java.util.ArrayList;
import java.util.List;

public class Num0807无重复字符串的排列组合 {
    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    boolean[] visited;

    public String[] permutation(String S) {
        char[] arr = S.toCharArray();
        visited = new boolean[arr.length];
        dfs(arr);
        return ans.toArray(new String[0]);
    }

    private void dfs(char[] arr) {
        if (path.length() == arr.length) {
            ans.add(path.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            path.append(arr[i]);
            visited[i] = true;
            dfs(arr);
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;
        }
    }
}
