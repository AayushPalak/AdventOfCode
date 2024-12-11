package org.aoc.day11;

import org.aoc.utils.Helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PuzzleTwoDayEleven {

    Map<Integer, Map<Long, Long>> dp;

    public long solve(List<String> input) {
        List<Long> inputList = new ArrayList<>();
        Helpers.parseDayElevenPuzzleTwoInput(input, inputList);
        dp = new HashMap<>();
        long res = 0L;

        for(Long number: inputList) {
            res += countAfterBlinks(75, number);
        }

        return res;
    }

    private long countAfterBlinks(int blinks, long number) {
        if(blinks == 0)
            return 1L;

        long res;

        Map<Long, Long> dpMap = dp.getOrDefault(blinks, new HashMap<>());
        if(dpMap.get(number) != null)
            return dpMap.get(number);

        if(number == 0) {
            res = countAfterBlinks(blinks-1, 1L);
        } else if(String.valueOf(number).length() % 2 == 0) {
            String originalNumber = String.valueOf(number);
            long firstNumber = Long.parseLong(originalNumber.substring(0, originalNumber.length()/2));
            long secondNumber = Long.parseLong(originalNumber.substring(originalNumber.length()/2));
            res = countAfterBlinks(blinks-1, firstNumber) + countAfterBlinks(blinks-1, secondNumber);
        } else {
            res = countAfterBlinks(blinks-1, number * 2024L);
        }

        dpMap.put(number, res);
        dp.put(blinks, dpMap);

        return res;
    }
}
