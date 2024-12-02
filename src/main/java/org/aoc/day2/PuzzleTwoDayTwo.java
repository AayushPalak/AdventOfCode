package org.aoc.day2;

import org.aoc.utils.Helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PuzzleTwoDayTwo {

    public long countSafeReports(List<String> input) {
        List<List<Integer>> list = new ArrayList<>();

        Helpers.parseDayTwoInput(input, list);

        long res = 0L;

        for(List<Integer> innerList: list) {
            if(innerList.size() == 1) {
                ++res;
                continue;
            }
            for(int k = 0; k < innerList.size(); ++k) {
                boolean isAscOrDesc = isAscending(innerList, k) || isDescending(innerList, k);
                if(isAscOrDesc) {
                    ++res;
                    break;
                }
                    
            }
        }

        return res;
    }

    private boolean isAscending(List<Integer> list, int remove) {
        int prev = -1;
        boolean flag = true;
        for(int i = 0; i < list.size(); ++i) {
            if(i == remove)
                continue;
            if(prev != -1 && (list.get(i) <= prev || list.get(i) > prev+3)) {
                flag = false;
                break;
            }
            prev = list.get(i);
        }
        return flag;
    }

    private boolean isDescending(List<Integer> list, int remove) {
        int prev = -1;
        boolean flag = true;
        for(int i = 0; i < list.size(); ++i) {
            if(i == remove)
                continue;
            if(prev != -1 && (list.get(i) >= prev || list.get(i) < prev-3)) {
                flag = false;
                break;
            }
            prev = list.get(i);
        }
        return flag;
    }

}
