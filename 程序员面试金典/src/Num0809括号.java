import java.util.ArrayList;
import java.util.List;

public class Num0809括号 {
    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n);
        return ans;
    }

    private void dfs(int left, int right, int n) {
        if (right > left || left > n || right > n) return;
        if (left == n && right == n) {
            ans.add(path.toString());
            return;
        }
        path.append("(");
        dfs(left + 1, right, n);
        path.deleteCharAt(path.length() - 1);
        path.append(")");
        dfs(left, right + 1, n);
        path.deleteCharAt(path.length() - 1);
    }
}
