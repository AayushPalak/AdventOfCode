package org.aoc.day1;

import org.aoc.utils.Helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PuzzleOneDayOne {

    public long findDistance(List<String> input) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        Helpers.parseDayOneInput(input, list1, list2);

        Collections.sort(list1);
        Collections.sort(list2);

        long res = 0L;

        for(int i = 0; i < list1.size(); ++i) {
            res += Math.abs(list1.get(i) - list2.get(i));
        }

        return res;
    }
}
