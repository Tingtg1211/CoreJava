package jianzhi;

import java.util.LinkedHashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 */
public class Solution_FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        
        // use linkedhashmap to keep the order.
        // 如果只使用hashmap有可能造成存进去和取出来的顺序不一样，无法满足第一个只出现一次条件
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < str.length(); i ++) {
            if(map.containsKey(str.charAt(i))) {
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++ time);
            }else {
                map.put(str.charAt(i), 1);
            }
        }
        int i = 0;
        for(; i < str.length(); i ++) {
            if (map.get(str.charAt(i)) == 1) return i;
        }
        return -1;
    }
    
}
