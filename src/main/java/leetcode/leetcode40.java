package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode40 {

    // 二维数组result
    private static List<List<Integer>> result = new ArrayList<>();

    // 一维数组path路径
    private static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        //排序
        int[] candidates = new int[]{2, 5, 2, 1, 2};
        Arrays.sort(candidates);
        int[] used = new int[candidates.length];
        dsf(candidates, 5, 0, used);
        System.out.println(result);
    }


    private static void dsf(int[] candidates, int target, int startIndex, int[] used) {
        Integer sum = path.stream().mapToInt(Integer::intValue).sum();
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0) {
                continue;
            }
            path.add(candidates[i]);
            used[i] = 1;
            dsf(candidates, target, i + 1, used);
            path.remove(path.size() - 1);
            used[i] = 0;
        }
    }

}