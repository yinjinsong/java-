public class Num415字符串相加 {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        int n1, n2, sum = 0, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (index1 >= 0 || index2 >= 0 || carry != 0) {
            n1 = index1 < 0 ? 0 : num1.charAt(index1--) - '0';
            n2 = index2 < 0 ? 0 : num2.charAt(index2--) - '0';
            carry = n1 + n2 + carry;
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
