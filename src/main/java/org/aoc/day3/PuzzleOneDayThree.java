package org.aoc.day3;

import org.aoc.utils.Helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class PuzzleOneDayThree {
    public long calculateInstructions(List<String> input) {
        List<String> parsedInput = new ArrayList<>();
        Helpers.parseDayThreeInput(input, parsedInput);
        List<List<Integer>> numbersList = new ArrayList<>();
        AtomicLong res = new AtomicLong(0L);
        parsedInput.forEach(str -> {
            str = str.replaceAll("mul\\(", "");
            str = str.replaceAll("\\)", "");
            String[] arr = str.split(",");
            List<Integer> pairs = new ArrayList<>();
            res.addAndGet((long) Integer.valueOf(arr[0]) * Integer.valueOf(arr[1]));
        });

        return res.get();
    }
}
