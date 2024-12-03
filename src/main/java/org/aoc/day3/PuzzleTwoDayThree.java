package org.aoc.day3;

import org.aoc.utils.Helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class PuzzleTwoDayThree {

    public long calculateInstructions(List<String> input) {
        List<String> parsedInput = new ArrayList<>();
        Helpers.parseDayThreePuzzleTwoInput(input, parsedInput);
        String prev = null;
        AtomicLong res = new AtomicLong(0L);
        for(String instruction: parsedInput) {
            if(instruction.startsWith("mul") && (prev == null || prev.equalsIgnoreCase("do()"))) {
                instruction = instruction.replaceAll("mul\\(", "");
                instruction = instruction.replaceAll("\\)", "");
                String[] arr = instruction.split(",");
                res.addAndGet((long) Integer.valueOf(arr[0]) * Integer.valueOf(arr[1]));
            } else if(instruction.startsWith("do") || instruction.startsWith("don't")) {
                prev = instruction;
            }
        }

        return res.get();
    }
}
