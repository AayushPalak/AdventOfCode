package org.aoc.day1;

import org.aoc.utils.Helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PuzzleTwoDayOne {

    public long similarityScore(List<String> input) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        Helpers.parseDayOneInput(input, list1, list2);

        Map<Integer, Integer> map = new HashMap<>();
        list2.forEach(number -> {
            map.computeIfAbsent(number, k -> 0);
            map.put(number, map.get(number) + 1);
        });

        long res = 0L;

        for(int number: list1)
            res += (long) number * map.getOrDefault(number, 0);

        return res;
    }
}
