package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode46 {

    // 二维数组result
    private static List<List<Integer>> result = new ArrayList<>();

    // 一维数组path路径
    private static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int[] used = new int[nums.length];
        dsf(nums, used);
        System.out.println(result);
    }


    private static void dsf(int[] nums, int[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            dsf(nums, used);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }


}