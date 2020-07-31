import java.util.ArrayList;

public class Num0503翻转数位 {
    public int reverseBits(int num) {
        int len = 0;
        int t = num;
        while (t != 0) {
            len++;
            t >>>= 1;
        }
        t = num;
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        while (t != 0) {
            if ((t & 1) != t) list.add(index);
            t >>>= 1;
            index++;
        }
        int ans = 0;
        for (int i = 0; i + 2 < list.size(); i++) {
            ans = Math.max(list.get(i + 2) - list.get(i), ans);
        }
        return ans;
    }
}
