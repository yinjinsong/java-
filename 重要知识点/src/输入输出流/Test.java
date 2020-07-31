package 输入输出流;

import java.io.*;

//把一个txt中的大写字母转换成小写字母，小写字母转换成大写字母
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("S:\\a.txt"));
        int c = 0;
        while ((c = bis.read()) >= 0) {
            if (Character.isUpperCase(c)) {
                c = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            }
            System.out.println((char)c + " ");
        }
        bis.close();
    }
}




