package org.aoc.day2;

import org.aoc.utils.Helpers;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

public class PuzzleOneDayTwo {

    public long countSafeReports(List<String> input) {
        List<List<Integer>> list = new ArrayList<>();

        Helpers.parseDayTwoInput(input, list);

        long res = 0L;

        for(List<Integer> innerList: list) {
            if(innerList.size() == 1) {
                ++res;
                continue;
            }
            if(Objects.equals(innerList.get(0), innerList.get(1)))
                continue;
            if(innerList.get(0) < innerList.get(1)) {
                int prev = innerList.getFirst();
                boolean flag = true;
                for(int i = 1; i < innerList.size(); ++i) {
                    if(innerList.get(i) <= prev || innerList.get(i) > prev+3) {
                        flag = false;
                        break;
                    }
                    prev = innerList.get(i);
                }
                if(flag)
                    ++res;
            } else {
                int prev = innerList.getFirst();
                boolean flag = true;
                for(int i = 1; i < innerList.size(); ++i) {
                    if(innerList.get(i) >= prev || innerList.get(i) < prev-3) {
                        flag = false;
                        break;
                    }
                    prev = innerList.get(i);
                }
                if(flag)
                    ++res;
            }
        }

        return res;
    }
}
