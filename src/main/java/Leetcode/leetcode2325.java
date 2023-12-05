package Leetcode;

import java.util.HashMap;
import java.util.Map;


public class leetcode2325 {

    public static void main(String[] args) {
        String key = key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.print(decodeMessage(key,message));

    }

    public static String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) != ' ') {
                if (!map.containsKey(key.charAt(i))) {
                    map.put(key.charAt(i), (char) ('a' + count));
                    count++;
                }
            }
        }
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != ' ')
                res.append(map.get(message.charAt(i)));
            else
                res.append(' ');
        }
        return res.toString();
    }
}
