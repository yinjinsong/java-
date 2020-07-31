package 力扣刷题;

import java.util.Arrays;
import java.util.List;

public class Num756金字塔转换矩阵 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("ABD", "BCE", "DEF", "FFF");
        System.out.println(pyramidTransition("ABC", list));
    }
    private static char[][] alloows = new char[7][7];
    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            int a = s.charAt(0) - 'A';
            int b = s.charAt(1) - 'A';
            char c = s.charAt(2);
            alloows[a][b] = c;
        }

        return dfs(bottom, "");
    }

    private static boolean dfs(String last, String now) {
        if (last.length() == 1) {
            return true;
        }
        if (now.length() + 1 == last.length()) {
            return dfs(now, "");
        }
        int a = last.charAt(now.length()) - 'A';
        int b = last.charAt(now.length() + 1) - 'A';
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                char c = alloows[i][j];
                if (dfs(last, now + c)) {
                    return true;
                }
            }
        }
        return false;

    }
}
