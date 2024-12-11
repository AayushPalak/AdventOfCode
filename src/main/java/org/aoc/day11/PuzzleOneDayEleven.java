package org.aoc.day11;

import org.aoc.utils.Helpers;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PuzzleOneDayEleven {
    public long solve(List<String> input) {
        Queue<Long> inputQueue = new LinkedList<>();
        Helpers.parseDayElevenInput(input, inputQueue);

        int blinks = 25;

        while(blinks-- > 0) {
            int size = inputQueue.size();
            while(size-- > 0) {
                long number = inputQueue.poll();
                if(number == 0L) {
                    inputQueue.offer(1L);
                } else if(String.valueOf(number).length() % 2 == 0) {
                    String originalNumber = String.valueOf(number);
                    long firstNumber = Long.parseLong(originalNumber.substring(0, originalNumber.length()/2));
                    long secondNumber = Long.parseLong(originalNumber.substring(originalNumber.length()/2));
                    inputQueue.offer(firstNumber);
                    inputQueue.offer(secondNumber);
                } else {
                    inputQueue.offer(number * 2024L);
                }
            }
        }

        return inputQueue.size();
    }
}
