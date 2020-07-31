package 剑指offer;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Num50第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            //如果已经包含则置成false，如果不包含则置成true
            map.put(arr[i], !map.containsKey(arr[i]));
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i])) {
                return arr[i];
            }
        }
        return ' ';
    }

    //linkedhashmap是按照插入的先后顺序，不会改变顺序
    public char firstUniqChar2(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        LinkedHashMap<Character,Boolean> map = new LinkedHashMap<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], !map.containsKey(arr[i]));
        }
        for (Character character : map.keySet()) {
            if (map.get(character)) {
                return character;
            }
        }
        return ' ';
    }
}
