package com.ybjx.leetcode.solution._0101_0200;

import com.ybjx.leetcode.annotation.LeetCodeSolution;
import com.ybjx.leetcode.common.AbstractSolution;

/**
 * 题目地址：https://leetcode-cn.com/problems/dungeon-game/
 * 题目：
 *     一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。
 *     我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 *     骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 *     有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；
 *     其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 *     为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 *     编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 *
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 *     -2 (K)	-3	3
 *     -5	-10	1
 *     10	30	-5 (P)
 */
public class L174CalculateMinimumHP extends AbstractSolution {

    @LeetCodeSolution
    public int solution(int[][] dungeon){
        for(int i = dungeon.length - 1; i >= 0; i--){
            for(int j = dungeon[i].length - 1; j >= 0; j--){
                if(i < dungeon.length - 1 || j < dungeon[i].length - 1) {
                    int r = Integer.MIN_VALUE;
                    int b = Integer.MIN_VALUE;
                    if (i < dungeon.length - 1) {
                        b = dungeon[i + 1][j];
                    }
                    if (j < dungeon[i].length - 1) {
                        r = dungeon[i][j + 1];
                    }
                    dungeon[i][j] += Math.max(r, b);
                }
                if(dungeon[i][j] > 0){
                    dungeon[i][j] = 0;
                }
            }
        }
        return 1 - dungeon[0][0];
    }
}
