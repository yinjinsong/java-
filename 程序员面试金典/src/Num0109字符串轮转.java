public class Num0109字符串轮转 {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        if(s1.equals(s2)) return true;
        return (s1 + s1).contains(s2);
    }

}
