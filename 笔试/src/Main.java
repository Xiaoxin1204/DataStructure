
import java.util.Scanner;

//阿里笔试题  二分查找
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution ans = new Solution();
        while (sc.hasNextLine()) {
            String[] targetLine = sc.nextLine().split(" ");
            int[] targets = new int[targetLine.length];
            for (int i = 0; i < targetLine.length; i++) {
                targets[i] = Integer.parseInt(targetLine[i]);
            }
            int target = Integer.parseInt(sc.nextLine());
            int out = ans.search(targets, target);
            System.out.println(out + "\n");
        }
    }


}

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int length = nums.length;
        int l = 0;
        int r = length - 1;
        int mid = length >> 1;
        while (l < r ) {
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                l = mid;
                mid = (r + l) >> 1;
            } else {
                r = mid;
                mid = (r + l) >> 1;
            }
        }
        return -1;
    }
}
