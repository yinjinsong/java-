package 力扣刷题;


import java.util.ArrayList;
import java.util.List;

public class Num1431拥有最多糖果的孩子 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        ArrayList<Boolean> ans = new ArrayList<>(n);
        int max = -1;
        for (int candy : candies)
            if (candy > max) max = candy;
        for (int i = 0; i < n; i++)
            ans.add(i, candies[i] + extraCandies >= max);
        for (int i = 0; i < 10; i++) {
        	new Thread(() -> {
        	}, String.valueOf(i)).start();
        }
        
        return ans;

    }

}
