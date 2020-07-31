package 力扣刷题;

import java.util.ArrayList;
import java.util.List;

public class Num93复原IP地址 {
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0, new StringBuilder());
        return ans;
    }
    private void dfs(String s, int start, int count, StringBuilder path) {
        if (start == s.length()) {
            if (count == 4) {
                ans.add(path.substring(1));
            }
            return;
        }
        //剪枝
        if (count > 4) {
            return;
        }
        //如果当前位是0的话就只能做一位
        if (s.charAt(start) == '0') {
            int len = path.length();
            dfs(s, start + 1, count + 1, path.append(".0"));
            path.delete(len, path.length());

        } else {
            for (int i = start, t = 0; i < s.length(); i++) {
                t = t * 10 + s.charAt(i) - '0';
                if (t < 256) {
                    int len = path.length();
                    dfs(s, i + 1, count + 1, path.append(".").append(t));
                    path.delete(len, path.length());
                } else {
                    break;
                }
            }
        }
    }
}
