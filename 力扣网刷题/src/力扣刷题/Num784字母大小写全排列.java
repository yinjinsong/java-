package 力扣刷题;

import java.util.ArrayList;
import java.util.List;

public class Num784字母大小写全排列 {
    public static void main(String[] args) {
        letterCasePermutation("a1b2");
    }
    private static List<String> ans = new ArrayList<>();

    public static List<String> letterCasePermutation(String s) {
        if (s == null || s.length() == 0) {
            return ans;
        }
        char[] arr = s.toCharArray();
        dfs(arr, 0);
        return ans;
    }

    private static void dfs(char[] arr, int i) {
        if (i == arr.length) {
            ans.add(new String(arr));
            return;
        }
        //先一条路径搜索完，不做任何改变
        dfs(arr, i + 1);
        //在上面的dfs的下面就是回退的过程，执行到这里的时候上面的dfs是处于返回的过程
        //即i是一个递减的过程
        if (Character.isLetter(arr[i])) {
            //大小写转化
            arr[i] ^= 32;
            //在dfs(arr, i + 1);i回退的过程中如果当前位是字母
            //则改变字母，改变后往下遍历，这就是改变字母的路径
            dfs(arr, i + 1);
        }
    }
}
