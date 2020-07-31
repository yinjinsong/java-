package 力扣刷题;




import java.util.*;

public class Num49字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //将每个字符串排序，排序后的字符串作为map的key，value作为需要的集合
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
