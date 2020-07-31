public class Num0101判定字符是否唯一 {
    public boolean isUnique(String astr) {
        if (astr.length() == 0) return true;
        int[] arr = new int[26];
        for (int i = 0; i < astr.length(); i++) {
            int index = astr.charAt(i) - 'a';
            if (arr[index] == 1) return false;
            arr[index]++;
        }
        return true;
    }
}
