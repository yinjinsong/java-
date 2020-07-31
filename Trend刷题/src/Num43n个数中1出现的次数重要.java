public class Num43n个数中1出现的次数重要 {
    public int countDigitOne(int n) {
        int high = n / 10, cur = n % 10, low = 0, digit = 1, ans = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) ans += digit * high;
            else if (cur == 1) ans += digit * high + low + 1;
            else ans += (high + 1) * digit;

            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return ans;
    }

}
