package org.aoc.day12;

import org.aoc.utils.Helpers;

import java.util.*;

public class PuzzleTwoDayTwelve {

    int[][] visited;

    public long solve(List<String> input) {
        char[][] matrix = Helpers.parseDayTwelveInput(input);
        visited = new int[matrix.length][matrix[0].length];
        List<Set<List<Integer>>> boundedRegions = new ArrayList<>();
        long res = 0L;

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                if(visited[i][j] == 0) {
                    boundedRegions.add(getBoundedRegion(matrix, i, j));
                }
            }
        }

        for(Set<List<Integer>> region: boundedRegions) {
            res += calculateCostForRegion(region);
        }

        return res;
    }

    private Set<List<Integer>> getBoundedRegion(char[][] matrix, int i, int j) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(i, j));
        Set<List<Integer>> output = new HashSet<>();

        while(!queue.isEmpty()) {
            List<Integer> current = queue.poll();

            if(visited[current.getFirst()][current.getLast()] == 1)
                continue;

            visited[current.getFirst()][current.getLast()] = 1;
            output.add(current);

            char currentChar = matrix[current.getFirst()][current.getLast()];
            //up
            if(current.getFirst()-1 >= 0 && matrix[current.getFirst()-1][current.getLast()] == currentChar && visited[current.getFirst()-1][current.getLast()] == 0)
                queue.offer(List.of(current.getFirst()-1, current.getLast()));
            //down
            if(current.getFirst()+1 < matrix.length && matrix[current.getFirst()+1][current.getLast()] == currentChar && visited[current.getFirst()+1][current.getLast()] == 0)
                queue.offer(List.of(current.getFirst()+1, current.getLast()));
            //left
            if(current.getLast()-1 >= 0 && matrix[current.getFirst()][current.getLast()-1] == currentChar && visited[current.getFirst()][current.getLast()-1] == 0)
                queue.offer(List.of(current.getFirst(), current.getLast()-1));
            //right
            if(current.getLast()+1 < matrix[0].length && matrix[current.getFirst()][current.getLast()+1] == currentChar && visited[current.getFirst()][current.getLast()+1] == 0)
                queue.offer(List.of(current.getFirst(), current.getLast()+1));
        }

        return output;
    }

    private long calculateCostForRegion(Set<List<Integer>> region) {
        Set<String> outerCorners = new HashSet<>();
        Set<String> innerCorners = new HashSet<>();

        for(List<Integer> pos: region) {
            List<List<Integer>> ulPositions = getUpperLeftPositions(pos);
            if(!region.contains(ulPositions.get(0)) && !region.contains(ulPositions.get(1)) && !region.contains(ulPositions.get(2)))
                outerCorners.add(pos.getFirst() + "," + pos.getLast() + ",UL");
            List<List<Integer>> urPositions = getUpperRightPositions(pos);
            if(!region.contains(urPositions.get(0)) && !region.contains(urPositions.get(1)) && !region.contains(urPositions.get(2)))
                outerCorners.add(pos.getFirst() + "," + pos.getLast() + ",UR");
            List<List<Integer>> llPositions = getLowerLeftPositions(pos);
            if(!region.contains(llPositions.get(0)) && !region.contains(llPositions.get(1)) && !region.contains(llPositions.get(2)))
                outerCorners.add(pos.getFirst() + "," + pos.getLast() + ",LL");
            List<List<Integer>> lrPositions = getLowerRightPositions(pos);
            if(!region.contains(lrPositions.get(0)) && !region.contains(lrPositions.get(1)) && !region.contains(lrPositions.get(2)))
                outerCorners.add(pos.getFirst() + "," + pos.getLast() + ",LR");
        }

        List<List<Integer>> nonInclusiveBoundaryPosList = getNonInclusiveBoundaryPositions(region);
        for(List<Integer> nonInclusiveBoundaryPos: nonInclusiveBoundaryPosList) {
            List<List<Integer>> ulPositions = getUpperLeftInnerPositions(nonInclusiveBoundaryPos);
            if(region.contains(ulPositions.getFirst()) && region.contains(ulPositions.getLast())) {
                int x = -1;
                int y = -1;
                if(region.contains(List.of(nonInclusiveBoundaryPos.getFirst()+x, nonInclusiveBoundaryPos.getLast()+y))) {
                    innerCorners.add((nonInclusiveBoundaryPos.getFirst()+x) + "," + (nonInclusiveBoundaryPos.getLast()+y) + ",UL");
                } else {
                    innerCorners.add(ulPositions.getFirst().get(0) + "," +  ulPositions.getFirst().get(1) + ",UL");
                    innerCorners.add(ulPositions.getLast().get(0) + "," + ulPositions.getLast().get(1) + ",LR");
                }
            }
            List<List<Integer>> urPositions = getUpperRightInnerPositions(nonInclusiveBoundaryPos);
            if(region.contains(urPositions.getFirst()) && region.contains(urPositions.getLast())) {
                int x = -1;
                int y = 1;
                if(region.contains(List.of(nonInclusiveBoundaryPos.getFirst()+x, nonInclusiveBoundaryPos.getLast()+y))) {
                    innerCorners.add((nonInclusiveBoundaryPos.getFirst()+x) + "," + (nonInclusiveBoundaryPos.getLast()+y) + ",UR");
                } else {
                    innerCorners.add(urPositions.getFirst().get(0) + "," +  urPositions.getFirst().get(1) + ",UR");
                    innerCorners.add(urPositions.getLast().get(0) + "," + urPositions.getLast().get(1) + ",LL");
                }
            }
            List<List<Integer>> llPositions = getLowerLeftInnerPositions(nonInclusiveBoundaryPos);
            if(region.contains(llPositions.getFirst()) && region.contains(llPositions.getLast())) {
                int x = 1;
                int y = -1;
                if(region.contains(List.of(nonInclusiveBoundaryPos.getFirst()+x, nonInclusiveBoundaryPos.getLast()+y))) {
                    innerCorners.add((nonInclusiveBoundaryPos.getFirst()+x) + "," + (nonInclusiveBoundaryPos.getLast()+y) + ",LL");
                } else {
                    innerCorners.add(llPositions.getFirst().get(0) + "," +  llPositions.getFirst().get(1) + ",LL");
                    innerCorners.add(llPositions.getLast().get(0) + "," + llPositions.getLast().get(1) + ",UR");
                }
            }
            List<List<Integer>> lrPositions = getLowerRightInnerPositions(nonInclusiveBoundaryPos);
            if(region.contains(lrPositions.getFirst()) && region.contains(lrPositions.getLast())) {
                int x = 1;
                int y = 1;
                if(region.contains(List.of(nonInclusiveBoundaryPos.getFirst()+x, nonInclusiveBoundaryPos.getLast()+y))) {
                    innerCorners.add((nonInclusiveBoundaryPos.getFirst()+x) + "," + (nonInclusiveBoundaryPos.getLast()+y) + ",LR");
                } else {
                    innerCorners.add(lrPositions.getFirst().get(0) + "," +  lrPositions.getFirst().get(1) + ",LR");
                    innerCorners.add(lrPositions.getLast().get(0) + "," + lrPositions.getLast().get(1) + ",UL");
                }
            }
        }

        return (long) region.size() * (outerCorners.size() + innerCorners.size());
    }

    private List<List<Integer>> getUpperLeftPositions(List<Integer> pos) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(List.of(pos.getFirst(), pos.getLast()-1));
        output.add(List.of(pos.getFirst()-1, pos.getLast()));
        output.add(List.of(pos.getFirst()-1, pos.getLast()-1));
        return output;
    }

    private List<List<Integer>> getUpperRightPositions(List<Integer> pos) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(List.of(pos.getFirst(), pos.getLast()+1));
        output.add(List.of(pos.getFirst()-1, pos.getLast()));
        output.add(List.of(pos.getFirst()-1, pos.getLast()+1));
        return output;
    }

    private List<List<Integer>> getLowerLeftPositions(List<Integer> pos) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(List.of(pos.getFirst(), pos.getLast()-1));
        output.add(List.of(pos.getFirst()+1, pos.getLast()));
        output.add(List.of(pos.getFirst()+1, pos.getLast()-1));
        return output;
    }

    private List<List<Integer>> getLowerRightPositions(List<Integer> pos) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(List.of(pos.getFirst(), pos.getLast()+1));
        output.add(List.of(pos.getFirst()+1, pos.getLast()));
        output.add(List.of(pos.getFirst()+1, pos.getLast()+1));
        return output;
    }

    private List<List<Integer>> getUpperLeftInnerPositions(List<Integer> pos) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(List.of(pos.getFirst(), pos.getLast()-1));
        output.add(List.of(pos.getFirst()-1, pos.getLast()));
        return output;
    }

    private List<List<Integer>> getUpperRightInnerPositions(List<Integer> pos) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(List.of(pos.getFirst(), pos.getLast()+1));
        output.add(List.of(pos.getFirst()-1, pos.getLast()));
        return output;
    }

    private List<List<Integer>> getLowerLeftInnerPositions(List<Integer> pos) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(List.of(pos.getFirst(), pos.getLast()-1));
        output.add(List.of(pos.getFirst()+1, pos.getLast()));
        return output;
    }

    private List<List<Integer>> getLowerRightInnerPositions(List<Integer> pos) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(List.of(pos.getFirst(), pos.getLast()+1));
        output.add(List.of(pos.getFirst()+1, pos.getLast()));
        return output;
    }

    private List<List<Integer>> getNonInclusiveBoundaryPositions(Set<List<Integer>> region) {
        List<List<Integer>> nonInclusivePositions = new ArrayList<>();
        for(List<Integer> pos: region) {
            List<Integer> top = List.of(pos.getFirst()-1, pos.getLast());
            List<Integer> bottom = List.of(pos.getFirst()+1, pos.getLast());
            List<Integer> left = List.of(pos.getFirst(), pos.getLast()-1);
            List<Integer> right = List.of(pos.getFirst(), pos.getLast()+1);

            if(!region.contains(top))
                nonInclusivePositions.add(top);
            if(!region.contains(bottom))
                nonInclusivePositions.add(bottom);
            if(!region.contains(left))
                nonInclusivePositions.add(left);
            if(!region.contains(right))
                nonInclusivePositions.add(right);
        }

        return nonInclusivePositions;
    }

}
