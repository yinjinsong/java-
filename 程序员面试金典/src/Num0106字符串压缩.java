public class Num0106字符串压缩 {
    public String compressString(String S) {
        char[] arr = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ) {
            int index = i + 1;
            while (index < arr.length && arr[index] == arr[i]) index++;
            sb.append(arr[i]).append(index - i);
            i = index;
        }
        if (sb.length() >= arr.length) return S;
        else return sb.toString();
    }
}
