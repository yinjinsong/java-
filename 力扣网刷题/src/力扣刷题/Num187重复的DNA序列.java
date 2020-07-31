package 力扣刷题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Num187重复的DNA序列 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String substring = s.substring(i, i + 10);
            map.put(substring, map.getOrDefault(substring, 0) + 1);
            if(map.get(substring)==2) ans.add(substring);
        }
        return ans;
    }
}
