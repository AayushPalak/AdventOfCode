package org.aoc.day10;

import org.aoc.utils.Helpers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PuzzleOneDayTen {

    long res;
    Set<String> visited;

    public long solve(List<String> input) {
        int[][] matrix = Helpers.parseDayTenInput(input);
        visited = new HashSet<>();
        res = 0L;
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                if(matrix[i][j] == 0) {
                    visited.clear();
                    checkHikingTrail(matrix, i, j, 0);
                }
            }
        }
        return res;
    }

    private void checkHikingTrail(int[][] matrix, int i, int j, int length) {
        if(length == 9) {
            if(!visited.contains(i+""+j)) {
                visited.add(i + "" + j);
                res += 1L;
            }
            return;
        }

        if(i-1 >= 0 && matrix[i-1][j] == matrix[i][j]+1) {
            checkHikingTrail(matrix, i-1, j, length+1);
        }
        if(i+1 < matrix.length && matrix[i+1][j] == matrix[i][j]+1) {
            checkHikingTrail(matrix, i+1, j, length+1);
        }
        if(j-1 >= 0 && matrix[i][j-1] == matrix[i][j]+1) {
            checkHikingTrail(matrix, i, j-1, length+1);
        }
        if(j+1 < matrix[0].length && matrix[i][j+1] == matrix[i][j]+1) {
            checkHikingTrail(matrix, i, j+1, length+1);
        }
    }
}
