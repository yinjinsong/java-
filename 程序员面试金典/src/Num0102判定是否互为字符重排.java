import java.util.Arrays;

public class Num0102判定是否互为字符重排 {
    public boolean CheckPermutation(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr2);
        return Arrays.toString(arr1).equals(Arrays.toString(arr2));
    }
}
