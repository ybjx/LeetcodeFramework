package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/reverse-bits/
 * 题目：
 *     颠倒给定的 32 位无符号整数的二进制位。
 *
 * 示例 1：
 *     输入: 00000010100101000001111010011100
 *     输出: 00111001011110000010100101000000
 *     解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 *
 * 示例 2：
 *     输入：11111111111111111111111111111101
 *     输出：10111111111111111111111111111111
 *     解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *          因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 */
public class L190ReverseBits extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int n){
        int r = 0;
        for(int i = 0; i < 32; i++){
            r = r << 1;
            if((n & (1 << i)) != 0){
                r += 1;
            }
        }
        return r;
    }
}