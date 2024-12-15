package org.aoc.day13;

import org.aoc.utils.Helpers;

import java.util.Arrays;
import java.util.List;

public class PuzzleOneDayThirteen {

    private static final long MAX_VALUE = 1000000;
    long[][] dp;

    public long solve(List<String> input) {
        List<List<List<Integer>>> gameList = Helpers.parseDayThirteenInput(input);
        long res = 0L;
        dp = new long[1000][1000];

        for(List<List<Integer>> game: gameList) {
            for(long[] row: dp)
                Arrays.fill(row, -1L);

            long tokenCost = calculateMoves(0, 0, game);
            if(tokenCost < MAX_VALUE)
                res += tokenCost;
        }

        return res;
    }

    private long calculateMoves(int pressA, int pressB, List<List<Integer>> input) {
        int xTarget = pressA * input.get(0).get(0) + pressB * input.get(1).get(0);
        int yTarget = pressA * input.get(0).get(1) + pressB * input.get(1).get(1);

        if(xTarget == input.get(2).get(0) && yTarget == input.get(2).get(1))
            return pressA * 3L + pressB;

        if(xTarget > input.get(2).get(0) || yTarget > input.get(2).get(1))
            return MAX_VALUE;

        if(dp[pressA][pressB] != -1L)
            return dp[pressA][pressB];

        long optionA = calculateMoves(pressA+1, pressB, input);
        long optionB = calculateMoves(pressA, pressB+1, input);

        return dp[pressA][pressB] = Math.min(optionA, optionB);
    }
}
