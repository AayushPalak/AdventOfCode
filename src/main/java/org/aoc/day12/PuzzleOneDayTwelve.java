package org.aoc.day12;

import org.aoc.utils.Helpers;

import java.util.*;

import static org.aoc.utils.Helpers.convertToStringSet;

public class PuzzleOneDayTwelve {

    int[][] visited;

    public long solve(List<String> input) {
        char[][] matrix = Helpers.parseDayTwelveInput(input);
        visited = new int[matrix.length][matrix[0].length];
        List<Set<String>> boundedRegions = new ArrayList<>();
        long res = 0L;

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                if(visited[i][j] == 0) {
                    boundedRegions.add(convertToStringSet(getBoundedRegion(matrix, i, j)));
                }
            }
        }

        for(Set<String> region: boundedRegions) {
            res += calculateCostForRegion(region);
        }

        return res;
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

    private long calculateCostForRegion(Set<String> region) {
        long perimeter = 0L;
        for(String pos: region) {
            String[] split = pos.split(",");
            String top = (Integer.valueOf(split[0]) - 1) + "," + Integer.valueOf(split[1]);
            String bottom = (Integer.valueOf(split[0]) + 1) + "," + Integer.valueOf(split[1]);
            String left = Integer.valueOf(split[0]) + "," + (Integer.valueOf(split[1]) - 1);
            String right = Integer.valueOf(split[0]) + "," + (Integer.valueOf(split[1]) + 1);

            if(!region.contains(top))
                ++perimeter;
            if(!region.contains(bottom))
                ++perimeter;
            if(!region.contains(left))
                ++perimeter;
            if(!region.contains(right))
                ++perimeter;
        }

        long area = region.size();

        return area * perimeter;
    }


}
