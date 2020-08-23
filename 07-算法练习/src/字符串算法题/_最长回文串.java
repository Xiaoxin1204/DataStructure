package 字符串算法题;

import java.util.HashSet;

/**
 * @Author Lijx
 * @Date 2020/8/22 20:12
 **/
public class _最长回文串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abba"));
    }

    /**
     * 能组成回文串的情况：
     * 字符出现次数为双数的组合
     * 字符出现次数为偶数的组合+单个字符中出现次数最多且为奇数次的字符
     *
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        char[] c = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (char value : c) {
            if (!set.contains(value)) {
                set.add(value);
            } else {
                set.remove(value);
                count++;
            }
        }
        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }
}
