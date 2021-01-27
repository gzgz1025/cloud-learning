package com.cloud.learning.leetcode;

/**
 * @ClassName: Code_Easy_2
 * @Description:数字反转
 * @Author: pzl
 * @CreateDate: 2021/1/27 15:04
 * @Version: 1.0
 * 难度：简单
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 */
public class Code_Easy_2 {
    public static int reverse(int x) {
        long result = 0;
        while(x!=0){
            result = result * 10 + x % 10;
            x = x / 10;
        }

        //防止溢出 int型的数值范围是 -2147483648～2147483647
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        //下面不符合题意
        StringBuilder s=new StringBuilder();
        int a=-999990123;
        s=a<0?s.append(Math.abs(a)).append("-"): s.append(a);
        System.out.println(Integer.parseInt(String.valueOf(s.reverse())));
    }

}
