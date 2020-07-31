import java.util.List;

public class Num46 {
    public static void main(String[] args) {

    }
    //最坏情况是3,1,2,1,5,1,6,1,1大于数组长度一半的元素一定会活到最后
    public int majorityNumber(List<Integer> nums) {
        int count = 0;
        int majorNum = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                majorNum = nums.get(i);
                count++;
            } else if (majorNum == nums.get(i)) {
                count++;
            } else {
                count--;
            }
        }
        return majorNum;
    }
}
