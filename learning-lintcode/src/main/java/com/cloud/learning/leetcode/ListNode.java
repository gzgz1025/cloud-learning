package com.cloud.learning.leetcode;

/**
 * @ClassName: ListNode
 * @Description:
 * @Author: pzl
 * @CreateDate: 2021/1/27 17:15
 * @Version: 1.0
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
