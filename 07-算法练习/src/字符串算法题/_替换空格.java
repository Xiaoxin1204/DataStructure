package 字符串算法题;

/**
 * @Author Lijx
 * @Date 2020/8/22 19:05
 **/
public class _替换空格 {
    /**
     * 第一种方法：常规方法。利用String.charAt(i)以及String.valueOf(char).equals(" ")
     * 遍历字符串并判断元素是否为空格。是则替换为"%20",否则不替换
     *
     * @param str 入参
     * @return
     */
    public static String replaceSpace(StringBuilder str) {
        return str.toString().replaceAll("\\s", "空格");
    }

    public static String replaceSpace2(StringBuilder str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char b = str.charAt(i);
            if (" ".equals(String.valueOf(b))) {
                result.append("空格");
            } else {
                result.append(b);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace2(new StringBuilder(" adc de")));
    }
}
