package org.aoc.day5;

import org.aoc.utils.Helpers;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class PuzzleTwoDayFive {

    public long countMiddleNumber(List<String> input) {
        List<String> pageRules = new ArrayList<>();
        List<String> pageOrdering = new ArrayList<>();
        Helpers.parseDayFiveInput(input, pageRules, pageOrdering);

        Map<Integer, List<Integer>> graph = new HashMap<>();

        pageRules.forEach(rule -> {
            String[] arr = rule.split("\\|");
            addEdge(Integer.parseInt(arr[1]), Integer.parseInt(arr[0]), graph);
        });

        AtomicLong res = new AtomicLong(0L);

        pageOrdering.forEach(ordering -> {
            int middlePageNumber = findMiddlePageIfInCorrectOrder(ordering, graph);
            if(middlePageNumber != -1)
                res.addAndGet(middlePageNumber);
        });

        return res.get();
    }

    private void addEdge(int number1, int number2, Map<Integer, List<Integer>> graph) {
        graph.putIfAbsent(number1, new ArrayList<>());
        graph.get(number1).add(number2);
    }

    private int findMiddlePageIfInCorrectOrder(String pageOrdering, Map<Integer, List<Integer>> graph) {
        String[] arr = pageOrdering.split(",");
        List<Integer> numbers = Arrays.stream(arr).map(Integer::parseInt).toList();
        boolean flag = true;

        for(int i = 0; i < numbers.size(); ++i) {
            List<Integer> rules = graph.getOrDefault(numbers.get(i), null);
            if(rules == null)
                continue;
            for(int j = i+1; j < numbers.size(); ++j) {
                if(rules.contains(numbers.get(j))) {
                    flag = false;
                    break;
                }
            }
        }

        if(flag)
            return -1;

        numbers = rearrangeIncorrectList(new ArrayList<>(numbers), graph);

        return numbers.get(numbers.size()/2);
    }

    private List<Integer> rearrangeIncorrectList(List<Integer> input, Map<Integer, List<Integer>> graph) {

        input.sort(((o1, o2) -> {
            List<Integer> rules = graph.getOrDefault(o1, null);
            if(o1 == null)
                return 0;
            if(rules.contains(o2))
                return 1;
            return -1;
        }));

        return input;
    }
}
