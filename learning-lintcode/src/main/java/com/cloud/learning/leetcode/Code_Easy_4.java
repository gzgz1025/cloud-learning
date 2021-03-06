package com.cloud.learning.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Code_Easy_4
 * @Description: 罗马数字转正数
 * @Author: pzl
 * @CreateDate: 2021/1/27 15:47
 * @Version: 1.0
 * <p>
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 */
public class Code_Easy_4 {
    //public final static List list = Arrays.asList("elment1", "element2");
    private static final Map<String, Integer> map = new HashMap() {{
        put("M", 1000);
        put("CM", 900);
        put("D", 500);
        put("CD", 400);
        put("C", 100);
        put("XC", 90);
        put("L", 50);
        put("XL", 40);
        put("X", 10);
        put("IX", 9);
        put("V", 5);
        put("IV", 4);
        put("I", 1);
    }};

    public static int romanToInt(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ) {
            String str = "";
            if (i + 1 < n && map.get(s.substring(i + 1, i + 2)) > map.get(s.substring(i, i + 1))) {
                str = s.substring(i, i + 2);
                i += 2;
            } else {
                str = s.substring(i, i + 1);
                i++;
            }
            ans += map.get(str);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
