package test4;

public class Demo1 {
    public static void main(String[] args) {

    }

    public static String demo1(String s) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        //将01反序
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                sb1.append('0');
            } else {
                sb1.append('1');
            }
        }
        //去掉开头的0,写入sb2
        for (int i = 0; i < sb1.length(); i++) {
            //如果开头是0则continue
            if (sb2.length() == 0 && sb1.charAt(i) == '0') {
                continue;
            }
            sb2.append(sb1.charAt(i));
        }
        //判断T是不是由S和rev(S)组成的
        return "";
    }
}
