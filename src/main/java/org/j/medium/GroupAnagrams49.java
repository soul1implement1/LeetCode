package org.j.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 给定一个字符串数组strs，将字谜分组在一起。您可以按任何顺序返回答案。
 * 一个字谜是通过重新排列不同的单词或短语的字母，通常使用的所有原始字母恰好一旦形成一个单词或短语。
 * @date 2020-09-02 10:24
 **/
public class GroupAnagrams49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 键值映射
            char[] key = new char[26];
            for (char c : str.toCharArray()) {
                key[c -'a']++;
            }
            // 键
            String keyStr=String.valueOf(key);
            if (!map.containsKey(keyStr)){
                map.put(keyStr,new ArrayList<>());
            }
            map.get(keyStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        for (List<String> list:groupAnagrams(new String[]{"abc","cba","aaa","bac","a","oa",""}) ){
            for (String s:list){
                System.out.print(s+",");
            }
            System.out.println();
        }
    }
}
