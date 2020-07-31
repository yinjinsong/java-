package 力扣刷题;

import java.util.ArrayList;
import java.util.List;

public class Num17电话号码的字母组合 {

    private  String letterMap[] = {
            "",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
    private List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        dfs(digits, 0, new StringBuilder());
        return ans;
    }

    private void dfs(String digits, int start, StringBuilder path) {
        if (start == digits.length()) {
            ans.add(path.toString());
            return;
        }
        String s = letterMap[digits.charAt(start) - '0'];
        for (int i = 0; i < s.length(); i++) {
            int len = path.length();
            dfs(digits, start + 1, path.append(s.charAt(i)));
            path.delete(len, path.length());
        }
    }


}
