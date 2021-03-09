package com.company;


import javax.swing.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    //    Z 字形变换
    //    输入：s = "PAYPALISHIRING", numRows = 4
    //    输出："PINALSIGYAHRPI"
    //    解释：
    //    P     I    N
    //    A   L S  I G
    //    Y A   H R
    //    P     I
    public String convert(String s, int numRows) {
        StringBuilder str = new StringBuilder();
        int totalLen = s.length();
        if (s == null || totalLen == 0)
            return "";
        if (numRows == 1) {
            return s;
        }
        int baseInt = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            if (i < totalLen) {
                str.append(s.charAt(i));
            }
            int j = 1;
            boolean leftBol = true, rightBol = true;
            while (leftBol || rightBol) {
                int left = i + j * baseInt - 2 * i;
                int right = i + j * baseInt;
                //判断左边 left
                if (leftBol && i != 0 && i != numRows - 1 && left < totalLen) {
                    str.append(s.charAt(left));
                } else
                    leftBol = false;

                //判断右边 right
                if (rightBol && right < totalLen) {
                    str.append(s.charAt(right));
                } else
                    rightBol = false;
                j++;
            }
        }
        return str.toString();
    }


    //给你一个字符串 s，找到 s 中最长的回文子串。 动态规划   ，解题思路，定位中间，往两边拓展，算臂长，最后来截取字符串。
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        int max = 1;
        int strLen = 0;
        //先考虑第一位的情况
        if (s.length() > 1 && s.charAt(0) == s.charAt(1)) {
            max++;
        }
        //循环字符串依次作为 中心，往两边拓展
        for (int i = 1; i < s.length(); i++) {
            //关键算法，算最长的串
            int a = getLongestPalindrome(s, i);
            if (max < a) {
                max = a;
                strLen = i;
            }
        }
        int half = max / 2;
        if (max % 2 == 1) {
            return s.substring(strLen - half, strLen - half + max);
        } else {
            return s.substring(strLen - half + 1, strLen - half + 1 + max);
        }

    }

    private int getLongestPalindrome(String s, int i) {
        int count1 = 1;
        int count2 = 1;
        int y = 1;
        // 中心为单个的 回文串
        while (i - y >= 0 && i + y < s.length()) {
            if (s.charAt(i - y) == s.charAt(i + y)) {
                count1 += 2;
            } else
                break;
            y++;
        }
        y = 1;
        boolean flag = true;
        //中心为偶数的回文串。
        while (i - y + 1 >= 0 && i + y < s.length()) {
            if (s.charAt(i) == s.charAt(i + y) && flag) {
                count2++;
                flag = false;
            } else if (s.charAt(i - y + 1) == s.charAt(i + y)) {
                count2 += 2;
            } else
                break;
            y++;

        }
        return Math.max(count1, count2);
    }

    //寻找两个正序数组的中位数  二分查找
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            int mid = total / 2;
            return getKthElement(nums1, nums2, mid + 1);
        } else {
            int mid = total / 2 - 1;
            return (getKthElement(nums1, nums2, mid + 1) + getKthElement(nums1, nums2, mid + 2)) / 2;
        }

    }

    // k 需要查找的第几个，总共5个，查的是，第三个传入3，但是数组下标为2.
    private double getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kth = 0;
        while (true) {
            //先考虑边界
            if (len1 == index1) {
                return nums2[index2 + k - 1];
            }
            if (len2 == index2) {
                return nums1[index2 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            //正常情况
            int half = k / 2;
            //对半查
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            //分别取到两个数
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            // 比较
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }

        }

    }


    //最长子串  "abcabcbb" 返回3
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        if (s.equals(""))
            return 0;
        else {
            int max = 0;
            int y = -1;
            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    occ.remove(s.charAt(i - 1));
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
    public int[] twoSum(int[] nums, int target) {
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