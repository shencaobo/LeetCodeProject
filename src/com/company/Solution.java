package com.company;


public class Solution {

    //最长子串
//    public int lengthOfLongestSubstring(String s) {
//        if (s == "")
//            return 0;
//        else {
//            int max = 1;
//            for (int i = 0; i < s.length(); i++) {
//                int len = 0;
//                for (int y = i + 1; y < s.length(); y++) {
//                    String ss = s.substring(i, y);
//
//                    if (ss.contains(s.charAt(y)) {
//                        len = ss.length();
//                    }
//                }
//                if(len>max)
//                    max=len;
//            }
//            return max;
//        }
//
//    }

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
        while (1 == 1) {
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
