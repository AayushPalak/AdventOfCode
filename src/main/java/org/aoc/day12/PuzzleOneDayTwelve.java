package org.aoc.day12;

import org.aoc.utils.Helpers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PuzzleOneDayTwelve {

    int[][] visited;

    public long solve(List<String> input) {
        char[][] matrix = Helpers.parseDayTwelveInput(input);
        visited = new int[matrix.length][matrix[0].length];
        List<List<int[]>> boundedRegions = new ArrayList<>();

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                if(visited[i][j] == 0) {
                    boundedRegions.add(getBoundedRegion(matrix, i, j));
                }
            }
        }

        return 0L;
    }

    private List<int[]> getBoundedRegion(char[][] matrix, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        List<int[]> output = new ArrayList<>();

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            if(visited[current[0]][current[1]] == 1)
                continue;

            visited[current[0]][current[1]] = 1;
            output.add(current);

            char currentChar = matrix[current[0]][current[1]];
            //up
            if(current[0]-1 >= 0 && matrix[current[0]-1][current[1]] == currentChar && visited[current[0]-1][current[1]] == 0)
                queue.offer(new int[]{current[0]-1, current[1]});
            //down
            if(current[0]+1 < matrix.length && matrix[current[0]+1][current[1]] == currentChar && visited[current[0]+1][current[1]] == 0)
                queue.offer(new int[]{current[0]+1, current[1]});
            //left
            if(current[1]-1 >= 0 && matrix[current[0]][current[1]-1] == currentChar && visited[current[0]][current[1]-1] == 0)
                queue.offer(new int[]{current[0], current[1]-1});
            //right
            if(current[1]+1 < matrix[0].length && matrix[current[0]][current[1]+1] == currentChar && visited[current[0]][current[1]+1] == 0)
                queue.offer(new int[]{current[0], current[1]+1});
        }

        return output;
    }


}
