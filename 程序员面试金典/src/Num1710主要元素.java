public class Num1710主要元素 {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 0, major = 0;
        for (int num : nums) {
            if (count == 0) {
                major = num;
                count++;
            } else {
                if (num == major) count++;
                else count--;
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == major) count++;
        }
        return count > nums.length / 2 ? major : -1;
    }
}

