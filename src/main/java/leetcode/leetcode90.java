package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode90 {

    //二维数组result
    private static List<List<Integer>> result = new ArrayList<>();

    //一维数组path路径
    private static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        //排序
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        dsf(nums, 0, used);
        System.out.println(result);
    }


    private static void dsf(int[] nums, int startIndex, int[] used) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            dsf(nums, i + 1, used);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }

}