package org.aoc.day14;

import org.aoc.utils.Helpers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PuzzleTwoDayFourteen {
    private static final int MAX_ROWS = 103;
    private static final int MAX_COLS = 101;

    public long solve(List<String> input) {
        List<List<int[]>> inputList = Helpers.parseDayFourteenInput(input);
        int[][] matrix = new int[MAX_ROWS][MAX_COLS];
        long timeElapsed = 0L;
        Set<List<Integer>> set = new HashSet<>();

        while(true) {
            matrix = new int[MAX_ROWS][MAX_COLS];
            for(List<int[]> startingPos: inputList) {
                int[] finalPos = getFinalPositionAfterElapsedTime(startingPos, 1);
                set.add(List.of(finalPos[0], finalPos[1]));
                ++matrix[finalPos[0]][finalPos[1]];
                startingPos.get(0)[0] = finalPos[0];
                startingPos.get(0)[1] = finalPos[1];
            }
            ++timeElapsed;
            if(set.size() == inputList.size())
                break;
            set.clear();
        }

        printMatrix(matrix);
        return timeElapsed;
    }

    private int[] getFinalPositionAfterElapsedTime(List<int[]> start, int time) {
        int row = start.get(0)[0];
        int col = start.get(0)[1];
        int rowVel = start.get(1)[0];
        int colVel = start.get(1)[1];

        while(time-- > 0) {
            int tempRow = row + rowVel;
            if(tempRow < 0) {
                row = MAX_ROWS - Math.abs(tempRow);
            } else if(tempRow >= MAX_ROWS) {
                row = tempRow % MAX_ROWS;
            } else {
                row = tempRow;
            }
            int tempCol = col + colVel;
            if(tempCol < 0) {
                col = MAX_COLS - Math.abs(tempCol);
            } else if(tempCol >= MAX_COLS) {
                col = tempCol % MAX_COLS;
            } else {
                col = tempCol;
            }
        }

        return new int[]{row, col};
    }

    private void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
