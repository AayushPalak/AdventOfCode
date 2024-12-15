package org.aoc.day14;

import org.aoc.utils.Helpers;

import java.util.Arrays;
import java.util.List;

public class PuzzleOneDayFourteen {

    private static final int MAX_ROWS = 103;
    private static final int MAX_COLS = 101;

    public long solve(List<String> input) {
        List<List<int[]>> inputList = Helpers.parseDayFourteenInput(input);
        int[] quardrantScores = new int[4];
        for(List<int[]> startingPos: inputList) {
            int[] finalPos = getFinalPositionAfterElapsedTime(startingPos, 100);
            int quadrant = findQuadrant(finalPos[0], finalPos[1], MAX_ROWS-1, MAX_COLS-1);
            if(quadrant != -1)
                ++quardrantScores[quadrant];
        }

        return Arrays.stream(quardrantScores).reduce(1, (a, b) -> a*b);
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

    public static int findQuadrant(int r, int c, int rows, int cols) {
        if (r >= 0 && r <= 50) {
            if (c >= 0 && c <= 49) {
                return 0;
            } else if (c >= 51 && c <= cols) {
                return 1;
            }
        }

        if (r >= 52 && r <= rows) {
            if (c >= 0 && c <= 49) {
                return 2;
            } else if (c >= 51 && c <= cols) {
                return 3;
            }
        }

        return -1;
    }
}
