package com.company;


import java.util.HashSet;
import java.util.Set;

public class Solution {

    //寻找两个正序数组的中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 2;
    }

    //最长子串  abcabcbb  返回3
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        if (s.equals(""))
            return 0;
        else {
            int max = 0;
            int y = -1;
            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    occ.remove(s.charAt(i-1));
                }

                for (; y + 1 < n; y++) {
                    if (!occ.contains(s.charAt(y + 1))) {
                        occ.add(s.charAt(y + 1));
                    } else {
                        break;
                    }
                }
                max = Math.max(max, y - i + 1);
            }
            return max;
        }

    }

    //两数相加
    //    输入：l1 = [2,4,3], l2 = [5,6,4]
    //    输出：[7,0,8]
    //    解释：342 + 465 = 807.
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode one = l1;
        ListNode two = l2;
        ListNode three = null;
        ListNode five = null;
        while (true) {
            if (one == null && two == null && add == 0) {
                break;
            }
            int a = 0, b = 0;
            if (one != null) {
                a = one.val;
                one = one.next;
            }
            if (two != null) {
                b = two.val;
                two = two.next;
            }
            int total = a + b + add;
            add = total / 10;
            ListNode four = new ListNode(total % 10);
            if (five == null) {
                three = four;
                five = three;
            } else {
                five.next = four;
                five = five.next;
            }
        }
        return three;
    }


    //两数之和
    //    int[] test = {2, 7, 11, 15};
    //   int[] a= Solution.twoSum(test, 9);
    ///    System.out.print(a[0]+"    "+a[1]);
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int[] need = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            need[i] = target - nums[i];
            if (i >= 1) {
                for (int y = 0; y < i; y++) {
                    if (nums[i] == need[y]) {
                        res[0] = i;
                        res[1] = y;
                        return res;
                    }
                }
            }
        }
        return res;
    }


}
