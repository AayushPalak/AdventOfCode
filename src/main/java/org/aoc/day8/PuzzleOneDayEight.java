package org.aoc.day8;

import org.aoc.utils.Helpers;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class PuzzleOneDayEight {
    public long solve(List<String> input) {
        Map<Character, List<int[]>> inputMap = new HashMap<>();
        Helpers.parseDayEightInput(input, inputMap);
        inputMap.forEach((_, positionList) -> {
            positionList.sort(Comparator.comparingInt(a -> a[0]));
        });

        int rows = input.size();
        int cols = input.getFirst().length();

        int[][] visited = new int[rows][cols];
        AtomicLong res = new AtomicLong(0L);

        inputMap.forEach((_, positionList) -> {
            for(int i = 0; i < positionList.size(); ++i) {
                int[] firstPos = positionList.get(i);
                for(int j = i+1; j < positionList.size(); ++j) {
                    int[] secondPos = positionList.get(j);
                    int rowDiff = secondPos[0] - firstPos[0];
                    int colDiff = firstPos[1] - secondPos[1];
                    if(firstPos[0] - rowDiff >= 0 && firstPos[0] - rowDiff < rows
                            && firstPos[1] + colDiff >= 0 && firstPos[1] + colDiff < cols
                            && visited[firstPos[0] - rowDiff][firstPos[1] + colDiff] == 0) {
                        visited[firstPos[0] - rowDiff][firstPos[1] + colDiff] = 1;
                        res.incrementAndGet();
                    }
                    if(secondPos[0] + rowDiff >= 0 && secondPos[0] + rowDiff < rows
                            && secondPos[1] - colDiff >= 0 && secondPos[1] - colDiff < cols
                            && visited[secondPos[0] + rowDiff][secondPos[1] - colDiff] == 0) {
                        visited[secondPos[0] + rowDiff][secondPos[1] - colDiff] = 1;
                        res.incrementAndGet();
                    }
                }
            }
        });

        return res.get();
    }
}
