package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode78 {

    //二维数组result
    private static List<List<Integer>> result = new ArrayList<>();

    //一维数组path路径
    private static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        dsf(nums, 0);
        System.out.println(result);
    }


    private static void dsf(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            dsf(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

}