package com.ybjx.leetcode.solution;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目地址：https://leetcode-cn.com/problems/combination-sum-ii/
 * 题目：
 *      给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 *      candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *      所有数字（包括目标数）都是正整数。
 *      解集不能包含重复的组合。
 *
 * 示例 1:
 *      输入: candidates = [10,1,2,7,6,1,5], target = 8,
 *      所求解集为:
 *          [
 *              [1, 7],
 *              [1, 2, 5],
 *              [2, 6],
 *              [1, 1, 6]
 *          ]
 *
 * 示例 2:
 *      输入: candidates = [2,5,2,1,2], target = 5,
 *      所求解集为:
 *          [
 *              [1,2,2],
     *          [5]
 *          ]
 * @author ybjx
 * @date 2019/5/27 22:07
 */
public class L040CombinationSum2 extends AbstractSolution {

    @LeetCodeSolution
    public List<List<Integer>> solution1(int[] candidates, int target){
        Arrays.sort(candidates);
        return find(candidates, 0, target);
    }

    private List<List<Integer>> find(int[] candidates, int start, int target){
        List<List<Integer>> result = new ArrayList<>();
        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            if(candidates[i] < target){
                List<List<Integer>> temp = find(candidates, i + 1, target - candidates[i]);
                if(temp.size() > 0){
                    for(List<Integer> l: temp){
                        l.add(0, candidates[i]);
                        result.add(l);
                    }
                }
            }
            else if(candidates[i] == target){
                List<Integer> l = new ArrayList<>();
                l.add(candidates[i]);
                result.add(l);
            }
            else{
                break;
            }
        }
        return result;
    }
}
