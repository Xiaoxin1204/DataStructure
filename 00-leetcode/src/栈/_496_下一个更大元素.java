package 栈;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *https://leetcode-cn.com/problems/next-greater-element-i/
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 */
public class _496_下一个更大元素 {
    public static void main(String[] args) {
       int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] ints = nextGreaterElement(nums1, nums2);
        for (int i : ints) {
            System.out.print(i);

        }
    }

    /**
     * 双层for，没用到栈
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i; j <nums2.length ; j++) {
                if (nums2[j] > nums2[i]) {
                    map.put(nums2[i],nums2[j]);
                    break;
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i],-1);
        }
        return nums1;

    }
}
