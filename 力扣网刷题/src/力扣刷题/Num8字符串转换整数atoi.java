package 力扣刷题;

public class Num8字符串转换整数atoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("   "));
        System.out.println(Integer.MIN_VALUE % 10);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println((Integer.MIN_VALUE));
    }
    public static int myAtoi(String str) {
        char[] arr = str.toCharArray();
        int index = 0;
        //去除前置空格
        while (index < arr.length) {
            if (arr[index] != ' ') break;
            index++;
        }
        //["     "]这种情况
        if (index == arr.length) {
            return 0;
        }
        //确定符号位
        int flag = 1;
        if (arr[index] == '+' || arr[index] == '-') {
            if (arr[index] == '-') flag = -1;
            ++index;
        }
        int result = 0;
        while (index < arr.length) {
            if (arr[index] >= '0' && arr[index] <= '9') {
                if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && (arr[index]-'0') > Integer.MAX_VALUE % 10) {
                    return Integer.MAX_VALUE;
                }
                if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && (arr[index]-'0') > -(Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + flag * (arr[index] - '0');
                index++;

            } else {
                break;
            }
        }
        return result;


    }

    public static int myAtoi2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        String s = str.trim();
        if (s.length() == 0 || Character.isLetter(s.charAt(0))) {
            return 0;
        }
        int flag = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == '-') {
                    flag = -1;
                    continue;
                } else if (s.charAt(i) == '+') {
                    continue;
                }
            }
            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                break;
            }
        }
        if (sb.length() == 0) {
            return 0;
        }
        int ans = 0;
        try {
            ans = Integer.parseInt(sb.toString()) * flag;
        } catch (NumberFormatException e) {
            return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return ans;

    }
    public static int myAtoi3(String str) {
        int len = str.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = str.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }


}
