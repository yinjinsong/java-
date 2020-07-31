package 剑指offer;

public class Num58II左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder(s);
        String substring = stringBuilder.substring(0, n);
        String preStr = stringBuilder.substring(n);
        return preStr + substring;
    }
}
