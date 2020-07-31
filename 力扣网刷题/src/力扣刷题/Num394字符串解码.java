package 力扣刷题;

public class Num394字符串解码 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c3[a]]]"));
    }
    //31[a22[c]]
    public static String decodeString(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length();) {
            if (!Character.isDigit(s.charAt(i))) {
                ans.append(s.charAt(i));
                i++;
            } else {
                int k = 0;
                while (Character.isDigit(s.charAt(i))) {
                    k = k * 10 + s.charAt(i) - '0';
                    i++;
                }
                //跳过左括号
                int j = i + 1;
                //剩余括号数量
                int sum = 1;
                while (sum > 0) {
                    if(s.charAt(j)=='[') sum++;
                    if(s.charAt(j)==']') sum--;
                    j++;
                }
                //此时j是最后一个括号的下一位
                //递归处理括号内的
                String r = decodeString(s.substring(i + 1, j - 1));
                for (int i1 = 0; i1 < k; i1++) {
                    ans.append(r);
                }
                i = j;
            }
        }
        return ans.toString();
    }
}
