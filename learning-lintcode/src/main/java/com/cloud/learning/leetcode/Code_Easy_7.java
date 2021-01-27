package com.cloud.learning.leetcode;

/**
 * @ClassName: Code_Easy_7
 * @Description:合并两个有序链表
 * @Author: pzl
 * @CreateDate: 2021/1/27 16:50
 * @Version: 1.0
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class Code_Easy_7 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1==null||l2==null){
            return l1==null?l2:l1;
        }
        if(l1.val<=l2.val){
            l1.next =mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next =mergeTwoLists(l2.next,l1);
            return l2;
        }
    }

    public ListNode mergeTwoListsTwo(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(Integer.MAX_VALUE);
        ListNode p = ans;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        } else if (l2 != null) {
            p.next = l2;
        }
        return ans.next;
    }

    public static ListNode reverseList(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if(head==null || head.next==null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }
    public static void main(String[] args) {

    }
}

