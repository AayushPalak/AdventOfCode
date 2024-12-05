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
            int middlePageNumber = findMiddlePageIfInCorrectOrder(ordering, graph, pageRules);
            if(middlePageNumber != -1)
                res.addAndGet(middlePageNumber);
        });

        return res.get();
    }

    private void addEdge(int number1, int number2, Map<Integer, List<Integer>> graph) {
        graph.putIfAbsent(number1, new ArrayList<>());
        graph.get(number1).add(number2);
    }

    private int findMiddlePageIfInCorrectOrder(String pageOrdering, Map<Integer, List<Integer>> graph, List<String> pageRules) {
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

        List<Integer> correctedList = rearrangeIncorrectList(numbers, pageRules);

        return numbers.get(numbers.size()/2);
    }

    private List<Integer> rearrangeIncorrectList(List<Integer> input, List<String> pageRules) {

        Map<Integer, List<Integer>> mapOne = new HashMap<>();

        pageRules.forEach(rule -> {
            String[] arr = rule.split("\\|");
            addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), mapOne);
        });

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(Integer number: input) {
            map.put(number, mapOne.get(number));
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        // Initialize the graph and in-degree
        for (Integer key : map.keySet()) {
            graph.putIfAbsent(key, new ArrayList<>());
            inDegree.putIfAbsent(key, 0);

            for (Integer value : map.get(key)) {
                graph.putIfAbsent(value, new ArrayList<>());
                inDegree.putIfAbsent(value, 0);
                graph.get(key).add(value);
                inDegree.put(value, inDegree.get(value) + 1);
            }
        }

        // Step 2: Perform topological sort using Kahn's algorithm
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Add all nodes with in-degree 0 to the queue
        for (Integer num : input) {
            if (inDegree.get(num) == 0) {
                queue.offer(num);
            }
        }

        // Process the queue
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            for (Integer neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }
}
