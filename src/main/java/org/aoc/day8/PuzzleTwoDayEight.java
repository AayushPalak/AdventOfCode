package org.aoc.day8;

import org.aoc.utils.Helpers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class PuzzleTwoDayEight {
    public long solve(List<String> input) {
        Map<Character, List<int[]>> inputMap = new HashMap<>();
        Helpers.parseDayEightInput(input, inputMap);
        AtomicLong res = new AtomicLong(0L);
        int rows = input.size();
        int cols = input.getFirst().length();
        int[][] visited = new int[rows][cols];

        inputMap.forEach((_, positionList) -> {
            positionList.sort(Comparator.comparingInt(a -> a[0]));
            res.addAndGet(positionList.size());
            for(int[] position: positionList)
                visited[position[0]][position[1]] = 1;
        });

        inputMap.forEach((_, positionList) -> {
            for(int i = 0; i < positionList.size(); ++i) {
                int[] firstPos = positionList.get(i);
                for(int j = i+1; j < positionList.size(); ++j) {
                    int[] secondPos = positionList.get(j);
                    int rowDiff = secondPos[0] - firstPos[0];
                    int colDiff = firstPos[1] - secondPos[1];
                    int factor = 1;
                    while(firstPos[0] - (rowDiff*factor) >= 0 && firstPos[0] - (rowDiff*factor) < rows && firstPos[1] + (colDiff*factor) >= 0 && firstPos[1] + (colDiff*factor) < cols) {
                        if(visited[firstPos[0] - (rowDiff*factor)][firstPos[1] + (colDiff*factor)] == 0) {
                            visited[firstPos[0] - (rowDiff*factor)][firstPos[1] + (colDiff*factor)] = 1;
                            res.incrementAndGet();
                        }
                        ++factor;
                    }
                    factor = 1;
                    while(secondPos[0] + (rowDiff*factor) >= 0 && secondPos[0] + (rowDiff*factor) < rows && secondPos[1] - (colDiff*factor) >= 0 && secondPos[1] - (colDiff*factor) < cols) {
                        if(visited[secondPos[0] + (rowDiff*factor)][secondPos[1] - (colDiff*factor)] == 0) {
                            visited[secondPos[0] + (rowDiff*factor)][secondPos[1] - (colDiff*factor)] = 1;
                            res.incrementAndGet();
                        }
                        ++factor;
                    }
                }
            }
        });

        return res.get();
    }
}
