import java.util.ArrayList;
import java.util.List;

public class Num22括号生成 {
    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0);
        return ans;
    }

    private void dfs(int n, int left, int right) {
        if (left == n && right == n) {
            ans.add(path.toString());
            return;
        }
        if (left < right || left > n || right > n) return;
        path.append("(");
        dfs(n, left + 1, right);
        path.deleteCharAt(path.length() - 1);
        path.append(")");
        dfs(n, left, right + 1);
        path.deleteCharAt(path.length() - 1);
    }
}
