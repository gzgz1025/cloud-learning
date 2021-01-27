package com.cloud.learning.leetcode;

import java.util.Stack;

/**
 * @ClassName: Code_Easy_6
 * @Description:有效的括号
 * @Author: pzl
 * @CreateDate: 2021/1/27 16:22
 * @Version: 1.0
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 *
 * (01) Stack实际上也是通过数组去实现的。
 *        执行push时(即，将元素推入栈中)，是通过将元素追加的数组的末尾中。
 *        执行peek时(即，取出栈顶元素，不执行删除)，是返回数组末尾的元素。
 *        执行pop时(即，取出栈顶元素，并将该元素从栈中删除)，是取出数组末尾的元素，然后将该元素从数组中删除。
 * (02) Stack继承于Vector，意味着Vector拥有的属性和功能，Stack都拥有。
 */
public class Code_Easy_6 {
    public static boolean isValid(String s){
        //奇数个字符的字符串 显然无法完成括号匹配
        if(s.length()%2==1){
            return false;
        }
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char theChar=s.charAt(i);
            if(theChar=='('||theChar=='{'||theChar=='['){
                stack.push(theChar);
            }else{
                //栈中已无左括号，此时字符为右括号，无法匹配。
                if(stack.empty()){
                    return false;
                }

                char preChar=stack.peek();
                if((preChar == '{' && theChar == '}') || (preChar == '(' && theChar == ')') || (preChar == '[' && theChar == ']')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
