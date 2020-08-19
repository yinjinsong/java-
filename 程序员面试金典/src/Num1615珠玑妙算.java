public class Num1615珠玑妙算 {
    public int[] masterMind(String solution, String guess) {
        char[] src = solution.toCharArray();
        char[] pat = guess.toCharArray();
        int[] ans = new int[2];
        for (int i = 0; i < src.length; i++) {
            if (src[i] == pat[i]) {
                ans[0]++;
                src[i] = 'a';
                pat[i] = 'b';
            }
        }
        for (int i = 0; i < pat.length; i++) {
            for (int j = 0; j < src.length; j++) {
                if (pat[i] == src[j]) {
                    ans[1]++;
                    src[j] = 'a';
                    break;
                }
            }
        }
        return ans;
    }
}
