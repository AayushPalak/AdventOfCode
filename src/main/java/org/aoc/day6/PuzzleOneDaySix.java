package org.aoc.day6;

import org.aoc.utils.Helpers;

import java.util.List;

public class PuzzleOneDaySix {

    public long solve(List<String> input) {
        char[][] matrix = Helpers.parseDaySixInput(input);
        int[][] visited = new int[matrix.length][matrix.length];
        int[] startingPos = getStartingPosition(matrix);
        visited[startingPos[0]][startingPos[1]] = 1;
        int currentRow = startingPos[0]-1;
        int currentCol = startingPos[1];
        char currentDir = 'U';
        long res = 1L;

        while(currentRow < matrix.length && currentCol < matrix.length && currentRow >= 0 && currentCol >= 0) {
            if(matrix[currentRow][currentCol] == '#') {
                if(currentDir == 'U') {
                    currentDir = 'R';
                    ++currentRow;
                } else if(currentDir == 'R') {
                    currentDir = 'D';
                    --currentCol;
                } else if(currentDir == 'D') {
                    currentDir = 'L';
                    --currentRow;
                } else {
                    currentDir = 'U';
                    ++currentCol;
                }
            } else {
                if(visited[currentRow][currentCol] == 0) {
                    ++res;
                    visited[currentRow][currentCol] = 1;
                }
                if(currentDir == 'U') {
                    --currentRow;
                } else if(currentDir == 'R') {
                    ++currentCol;
                } else if(currentDir == 'D') {
                    ++currentRow;
                } else {
                    --currentCol;
                }
            }
        }

        return res;
    }

    private int[] getStartingPosition(char[][] matrix) {
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix.length; ++j) {
                if(matrix[i][j] == '^')
                    return new int[] {i,j};
            }
        }
        return new int[] {-1,-1};
    }
}
