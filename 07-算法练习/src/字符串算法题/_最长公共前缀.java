package 字符串算法题;

import java.util.Arrays;

/**
 * @Author Lijx
 * @Date 2020/8/22 19:34
 **/
public class _最长公共前缀 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int num = strs[0].length() < strs[strs.length - 1].length() ? strs[0].length() : strs[strs.length - 1].length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
                result.append(strs[0].charAt(i));
            }
        }
        return result.toString();
    }
}
