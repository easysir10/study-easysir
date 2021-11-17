package algorithms;

import java.util.Arrays;

public class AlgorithmsMain {

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    /**
     * 求最长公共前缀
     *
     * @param strArray 字符串数组
     * @return 公共前缀
     */
    private static String commonPreStr(String[] strArray) {
        if (null == strArray || strArray.length == 0) {
            return "";
        }
        int arrayLen = strArray.length;
        Arrays.sort(strArray);
        int m = strArray[0].length();
        int n = strArray[arrayLen - 1].length();
        int num = Math.min(m, n);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            if (strArray[0].charAt(i) == strArray[strArray.length - 1].charAt(i)) {
                result.append(strArray[0].charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }

    /**
     * 找出数组中任意一组重复数字
     * 思路：遍历数组，第一次遇到数字 x 时，将其交换至索引 x 处；
     * 而当第二次遇到数字 x 时，一定有 nums[x] = x ，此时即可得到一组重复数字
     *
     * @param nums 原始数组
     * @return 重复数字
     */
    public static int findRepeatNumber(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // 交换位置
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
