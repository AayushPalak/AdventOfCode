package org.aoc.day4;

import org.aoc.utils.Helpers;

import java.util.List;

public class PuzzleTwoDayFour {

    public long countInstances(List<String> input) {
        String[] parsedInput = Helpers.parseDayFourInput(input);
        long res = 0L;

        for(int i = 1; i < parsedInput.length-1; ++i) {
            for(int j = 1; j < parsedInput[0].length()-1; ++j) {
                if(checkForMASInXShape(i, j, parsedInput))
                    ++res;
                else if(checkForSAMInXShape(i, j, parsedInput))
                    ++res;
                else if(checkMASInFirstSAMInSecond(i, j, parsedInput))
                    ++res;
                else if(checkSAMInFirstMASInSecond(i, j, parsedInput))
                    ++res;
            }
        }

        return res;
    }

    private boolean checkForMASInXShape(int centerRow, int centerCol, String[] input) {

        if(input[centerRow].charAt(centerCol) != 'A')
            return false;

        // Check if the "X" pattern can form with 'M' at center, 'A' top-left, 'S' top-right
        // Check diagonal top-left to bottom-right for "M" -> "A"
        if (input[centerRow - 1].charAt(centerCol - 1) != 'M' ||  // Top-left for 'M'
                input[centerRow - 1].charAt(centerCol + 1) != 'M') {          // Center for 'A'
            return false;
        }

        // Check diagonal top-right to bottom-left for "S"
        if (input[centerRow + 1].charAt(centerCol - 1) != 'S' ||
                input[centerRow + 1].charAt(centerCol + 1) != 'S') {  // Top-right for 'S'
            return false;
        }

        // If both diagonals check out, it's a valid "MAS" in X shape
        return true;
    }

    private static boolean checkForSAMInXShape(int centerRow, int centerCol, String[] input) {
        if(input[centerRow].charAt(centerCol) != 'A')
            return false;

        // Check for "MAS" in backwards direction ("S" -> "A" -> "M")
        // Check diagonal top-left to bottom-right for "S" -> "A"
        if (input[centerRow - 1].charAt(centerCol - 1) != 'S' ||  // Top-left for 'S'
                input[centerRow - 1].charAt(centerCol + 1) != 'S') {          // Center for 'A'
            return false;
        }

        // Check diagonal top-right to bottom-left for "M"
        if (input[centerRow + 1].charAt(centerCol + 1) != 'M' ||
                input[centerRow + 1].charAt(centerCol - 1) != 'M') {  // Top-right for 'M'
            return false;
        }

        // If both diagonals check out, it's a valid "MAS" backwards in X shape
        return true;
    }

    private static boolean checkMASInFirstSAMInSecond(int centerRow, int centerCol, String[] input) {
        // Check diagonal top-left to bottom-right for "MAS"
        if (input[centerRow - 1].charAt(centerCol - 1) != 'M' || // Top-left for 'M'
                input[centerRow].charAt(centerCol) != 'A' ||         // Center for 'A'
                input[centerRow + 1].charAt(centerCol + 1) != 'S') { // Bottom-right for 'S'
            return false;
        }

        // Check diagonal top-right to bottom-left for "SAM"
        if (input[centerRow - 1].charAt(centerCol + 1) != 'S' || // Top-right for 'S'
                input[centerRow].charAt(centerCol) != 'A' ||         // Center for 'A'
                input[centerRow + 1].charAt(centerCol - 1) != 'M') { // Bottom-left for 'M'
            return false;
        }

        // If both diagonals check out, it's a valid "MAS" -> "SAM" in X shape
        return true;
    }

    private static boolean checkSAMInFirstMASInSecond(int centerRow, int centerCol, String[] input) {
        // Check diagonal top-left to bottom-right for "SAM"
        if (input[centerRow - 1].charAt(centerCol - 1) != 'S' || // Top-left for 'S'
                input[centerRow].charAt(centerCol) != 'A' ||         // Center for 'A'
                input[centerRow + 1].charAt(centerCol + 1) != 'M') { // Bottom-right for 'M'
            return false;
        }

        // Check diagonal top-right to bottom-left for "MAS"
        if (input[centerRow - 1].charAt(centerCol + 1) != 'M' || // Top-right for 'M'
                input[centerRow].charAt(centerCol) != 'A' ||         // Center for 'A'
                input[centerRow + 1].charAt(centerCol - 1) != 'S') { // Bottom-left for 'S'
            return false;
        }

        // If both diagonals check out, it's a valid "SAM" -> "MAS" in X shape
        return true;
    }
}
