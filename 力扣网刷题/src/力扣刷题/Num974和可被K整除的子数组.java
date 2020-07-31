package 力扣刷题;

import java.util.HashMap;

public class Num974和可被K整除的子数组 {
    public int subarraysDivByK(int[] A, int K) {
        int n = A.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + A[i - 1];
        }
        int ans = 0;
        for (int i =0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if((preSum[j]-preSum[i])%K==0) ans++;
            }
        }
        return ans;
    }


    public int subarraysDivByK2(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ans = 0;
        for (int i : A) {
            sum += i;
            int remainder = (sum % K + K) % K;
            int cnt = map.getOrDefault(remainder, 0);
            ans += cnt;
            map.put(remainder, cnt + 1);
        }
        return ans;
    }
}
