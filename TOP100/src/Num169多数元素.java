public class Num169多数元素 {

    public int majorityElement(int[] nums) {
        int count = 0;
        int major = 0;
        for (int num : nums) {
            if (count == 0) {
                major = num;
                count = 1;
            } else {
                if (num == major) count++;
                else count--;
            }
        }
        return major;
    }
}
