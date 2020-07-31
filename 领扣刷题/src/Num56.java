import java.util.HashMap;

public class Num56 {

    public static void main(String[] args) {
        twoSum(new int[]{0, 4, 3, 0}, 0);
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return new int[]{-1, -1};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                if (map.get(target - numbers[i]) != i) {
                    return new int[]{map.get(target - numbers[i]), i};
                }

            }
            map.put(numbers[i], i);

        }
        //没找到
        return new int[]{-1, -1};
    }
}
