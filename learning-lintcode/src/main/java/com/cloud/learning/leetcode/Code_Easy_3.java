package com.cloud.learning.leetcode;

/**
 * @ClassName: Code_Easy_3
 * @Description:判断回文数
 * @Author: pzl
 * @CreateDate: 2021/1/27 15:32
 * @Version: 1.0
 *
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 */
public class Code_Easy_3 {
    /**
     * 字符方法
     * @param x
     * @return
     */
    public static boolean isPalindromeByString(int x) {
        StringBuilder s=new StringBuilder().append(x).reverse();
        int y =Integer.parseInt(s.toString());
        return x==y?true:false;
    }

    public static boolean isPalindrome(int x){
        if(x<0){
            return false;
        }
        int y=x;
        long result = 0;
        while(y!=0){
            result = result * 10 + y % 10;
            y = y / 10;
        }
        return x==result?true:false;
    }


    public static void main(String[] args) {
        //System.out.println(isPalindromeByString(-121));
        System.out.println(isPalindrome(100));
    }
}
