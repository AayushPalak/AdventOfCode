package org.aoc.day6;

import org.aoc.utils.Helpers;

import java.util.List;

public class PuzzleTwoDaySix {

    public long solve(List<String> input) {
        char[][] matrix = Helpers.parseDaySixInput(input);
        int[] startingPos = getStartingPosition(matrix);
        long res = 0L;

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                if(matrix[i][j] == '.')
                    if(isObstructionFormingALoop(matrix, new int[]{i,j}, startingPos))
                        ++res;
            }
        }

        return res;
    }

    private boolean isObstructionFormingALoop(char[][] matrix, int[] obstruction, int[] startingPos) {
        int currentRow = startingPos[0];
        int currentCol = startingPos[1];
        char currentDir = 'U';

        matrix[obstruction[0]][obstruction[1]] = '#';
        boolean res = false;
        int[][] visited = new int[matrix.length][matrix[0].length];

        while(currentRow < matrix.length && currentCol < matrix[0].length && currentRow >= 0 && currentCol >= 0) {
            if (matrix[currentRow][currentCol] == '#') {
                visited[currentRow][currentCol] += 1;
                if(visited[currentRow][currentCol] >= 4) {
                    res = true;
                    break;
                }
                if (currentDir == 'U') {
                    currentDir = 'R';
                    ++currentRow;
                } else if (currentDir == 'R') {
                    currentDir = 'D';
                    --currentCol;
                } else if (currentDir == 'D') {
                    currentDir = 'L';
                    --currentRow;
                } else {
                    currentDir = 'U';
                    ++currentCol;
                }
            } else {
                if (currentDir == 'U')
                    --currentRow;
                else if (currentDir == 'R')
                    ++currentCol;
                else if (currentDir == 'D')
                    ++currentRow;
                else
                    --currentCol;
            }
        }

        matrix[obstruction[0]][obstruction[1]] = '.';
        return res;
    }

    private int[] getStartingPosition(char[][] matrix) {
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                if(matrix[i][j] == '^')
                    return new int[] {i,j};
            }
        }
        return new int[] {-1,-1};
    }
}
