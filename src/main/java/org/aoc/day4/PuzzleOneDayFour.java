package org.aoc.day4;

import org.aoc.utils.Helpers;

import java.util.List;

public class PuzzleOneDayFour {

    private static final int[][] DIRECTIONS = {
            {0, 1},  // Horizontal left to right
            {0, -1}, // Horizontal right to left
            {1, 0},  // Vertical top to bottom
            {-1, 0}, // Vertical bottom to top
            {1, 1},  // Diagonal top-left to bottom-right
            {-1, 1}, // Diagonal bottom-left to top-right
            {1, -1}, // Diagonal top-right to bottom-left
            {-1, -1} // Diagonal bottom-right to top-left
    };

    public long countInstances(List<String> input) {
        String[] parsedInput = Helpers.parseDayFourInput(input);
        long res = 0L;

        for(int i = 0; i < parsedInput.length; ++i) {
            for(int j = 0; j < parsedInput[0].length(); ++j) {
                for(int[] direction: DIRECTIONS) {
                    if(checkForXMAS(i, j, parsedInput, direction[0], direction[1]))
                        ++res;
                }
            }
        }

        return res;
    }

    private boolean checkForXMAS(int startRow, int startCol, String[] input, int rowDir, int colDir) {
        String search = "XMAS";
        int rows = input.length;
        int cols = input[0].length();

        for (int k = 0; k < search.length(); k++) {
            int newRow = startRow + k * rowDir;
            int newCol = startCol + k * colDir;

            // If out of bounds, return false
            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                return false;
            }

            // Check if the current character matches
            if (input[newRow].charAt(newCol) != search.charAt(k)) {
                return false;
            }
        }

        return true;
    }

}
