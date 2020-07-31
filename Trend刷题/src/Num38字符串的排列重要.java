import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num38字符串的排列重要 {
    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    boolean[] visited;

    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        visited = new boolean[arr.length];
        Arrays.sort(arr);
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
            if (i > 0 && visited[i - 1] && arr[i] == arr[i - 1]) continue;
            int len = path.length();
            visited[i] = true;
            path.append(arr[i]);
            dfs(arr);
            //path.delete(len, path.length());
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;
        }
    }
}
