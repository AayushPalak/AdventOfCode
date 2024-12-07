package org.aoc.day7;

import org.aoc.utils.Helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PuzzleOneDaySeven {

    boolean currentResult = false;

    public long solve(List<String> input) {
        Map<Long, List<List<Long>>> inputMap = new HashMap<>();
        Helpers.parseDaySevenInput(input, inputMap);
        long res = 0L;
        for(Map.Entry<Long, List<List<Long>>> entry: inputMap.entrySet()) {
            Long key = entry.getKey();
            List<List<Long>> valuesList = entry.getValue();
            for(List<Long> values: valuesList) {
                currentResult = false;
                checkSumFromCombinations(key, values.getFirst(), values, 1);
                if(currentResult)
                    res += key;
                currentResult = false;
            }
        }

        return res;
    }

    private void checkSumFromCombinations(Long answer, Long current, List<Long> input, int i) {
        if(i == input.size()) {
            if(current.equals(answer))
                currentResult = true;
            return;
        }

        if(current.compareTo(answer) > 0)
            return;

        checkSumFromCombinations(answer, current + input.get(i), input, i+1);
        checkSumFromCombinations(answer, current * input.get(i), input, i+1);
    }
}
