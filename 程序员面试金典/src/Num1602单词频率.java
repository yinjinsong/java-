import java.util.HashMap;

public class Num1602单词频率 {
    HashMap<String, Integer> map = new HashMap<>();

    public Num1602单词频率(String[] book) {
        for (String s : book) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    }

    public int get(String word) {
        return map.getOrDefault(word, 0);
    }
}
