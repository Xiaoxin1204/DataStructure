package 字符串算法题;

/**
 * @Author Lijx
 * @Date 2020/8/23 10:19
 **/
public class _最长回文子串 {
    private static int index, len;

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abaddx"));
    }

    private static String longestPalindrome(String str) {
        int length = str.length();
        if (length < 2) return str;
        for (int i = 0; i < length; i++) {
            palindromeHelper(str, i, i);
            palindromeHelper(str, i, i + 1);
        }
        return str.substring(index, index + len);
    }

    private static void palindromeHelper(String str, int l, int r) {
        while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        int length = r - l - 1;
        if (len < length) {
            len = length;
            index = l + 1;
        }
    }

}
