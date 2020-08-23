package 字符串算法题;



/**
 * @Author Lijx
 * @Date 2020/8/22 20:28
 **/
public class _验证回文串 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("sabslf"));
    }

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * @param str
     * @return
     */
    private static boolean isPalindrome(String str) {
        if (str.length() == 0) return true;
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(str.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(str.charAt(r))) {
                r--;
            } else {
                if (Character.toLowerCase(str.charAt(l)) != Character.toLowerCase(str.charAt(r)))
                    return false;
                l++;
                r--;
            }

        }
        return true;
    }
}
