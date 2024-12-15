package org.aoc.day13;

import org.aoc.utils.Helpers;

import java.util.List;

public class PuzzleTwoDayThirteen {

    public long solve(List<String> input) {
        List<List<List<Long>>> gameList = Helpers.parseDayThirteenPuzzleTwoInput(input);
        long res = 0L;

        for(List<List<Long>> game: gameList) {
            long tokenCost = calculateMoves(game);
            res += tokenCost;
        }

        return res;
    }

    private long calculateMoves(List<List<Long>> input) {
        long optionAPress = (input.get(2).get(1) * input.get(1).get(0) - input.get(2).get(0) * input.get(1).get(1)) / (input.get(0).get(1) * input.get(1).get(0) - input.get(0).get(0) * input.get(1).get(1));
        long optionARem = (input.get(2).get(1) * input.get(1).get(0) - input.get(2).get(0) * input.get(1).get(1)) % (input.get(0).get(1) * input.get(1).get(0) - input.get(0).get(0) * input.get(1).get(1));
        if(optionARem != 0L)
            return 0L;
        long optionBPress = (input.get(2).get(0) - optionAPress * input.get(0).get(0)) / input.get(1).get(0);
        long optionBRem = (input.get(2).get(0) - optionAPress * input.get(0).get(0)) % input.get(1).get(0);
        if(optionBRem != 0L)
            return 0L;
        return (optionAPress * 3L) + optionBPress;
    }

}
