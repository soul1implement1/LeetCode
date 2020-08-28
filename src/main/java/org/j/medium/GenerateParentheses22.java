package org.j.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 冯玖霖
 * @version 1.0
 * @description 给定n对括号，编写一个函数以生成格式正确的括号的所有组合。
 * @date 2020-08-26 15:56
 **/
public class GenerateParentheses22 {
    public static List<String> generateParenthesis(int n) {
        if (n > 2) {
            List<String> result = generateParenthesis(n - 1);
            List<String> result1 = new ArrayList<>();
            for (String str : result) {
                StringBuilder stringBuilder = new StringBuilder(str);
                for (int i = 1; i < str.length(); i++) {
                    stringBuilder.insert(i, "()");
                    String a = stringBuilder.toString();
                    // System.out.println(a);
                    stringBuilder.delete(i, i + 2);
                    if (result1.contains(a)) {
                    } else {
                        result1.add(a);
                    }
                }
            }
            return result1;
        } else if (n == 2) {
            List<String> result = new ArrayList<>();
            result.add("()()");
            result.add("(())");
            return result;
        } else if (n == 1) {
            List<String> result = new ArrayList<>();
            result.add("()");
            return result;
        } else
            return null;


    }

    public static List<String> generateParenthesis2(int n) {
        List<String> ans = new LinkedList<String>();
        generateParenthesisHelper2(ans, n, 0, new String());
        return ans;

    }

    private static void generateParenthesisHelper2(List<String> ans, int n, int left,
                                                   String string) {
        int len = 2 * n;
        if (left > len - string.length() || left < string.length() - len)
            return;
        if (string.length() == len && left == 0) {
            ans.add(string);
            return;
        }

        if (left > 0)
            generateParenthesisHelper2(ans, n, left - 1, string + ")");
        if (string.length() < len - 1)
            generateParenthesisHelper2(ans, n, left + 1, string + "(");
    }

    public static List<String> generateParenthesis1(int n) {
        List<String> ans = new LinkedList<String>();
        generateParenthesisHelper(ans, n, 0, new String());
        return ans;

    }

    private static void generateParenthesisHelper(List<String> ans, int n, int left,
                                                  String string) {
        if (left > 2 * n - string.length() || left < string.length() - 2 * n)
            return;
        if (string.length() == n * 2 && left == 0) {
            ans.add(string);
            return;
        }

        if (left > 0)
            generateParenthesisHelper(ans, n, left - 1, string + ")");
        if (string.length() < 2 * n - 1)
            generateParenthesisHelper(ans, n, left + 1, string + "(");
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        List<String> result = generateParenthesis1(15);
        long b = System.currentTimeMillis();
        System.out.println(b - a);
        // for (String string : result
        // ) {
        //     System.out.println(string);
        // }
    }
}
