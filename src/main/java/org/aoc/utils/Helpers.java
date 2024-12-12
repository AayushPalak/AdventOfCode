package org.aoc.utils;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helpers {

    public static List<String> readFromFile(String absoluteFilePath) {
        List<String> output = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(absoluteFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                output.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public static void writeToFile(String output, String absoluteFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(absoluteFilePath))) {
            writer.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseDayOneInput(List<String> input, List<Integer> list1, List<Integer> list2) {
        input.forEach(numbers -> {
            String[] arr = numbers.split("   ");
            list1.add(Integer.valueOf(arr[0]));
            list2.add(Integer.valueOf(arr[1]));
        });
    }

    public static void parseDayTwoInput(List<String> input, List<List<Integer>> list) {
        input.forEach(numbers -> {
            String[] arr = numbers.split(" ");
            List<Integer> innerList = new ArrayList<>();
            for(String number: arr)
                innerList.add(Integer.valueOf(number));
            list.add(innerList);
        });
    }

    public static void parseDayThreeInput(List<String> input, List<String> output) {
        input.forEach(str -> {
            String pattern = "mul\\(\\s*\\d+(\\.\\d+)?\\s*,\\s*\\d+(\\.\\d+)?\\s*\\)";

            // Create a Pattern object
            Pattern compiledPattern = Pattern.compile(pattern);

            // Create a Matcher object
            Matcher matcher = compiledPattern.matcher(str);

            // Find all matches
            while (matcher.find()) {
                output.add(matcher.group());
            }
        });
    }

    public static void parseDayThreePuzzleTwoInput(List<String> input, List<String> output) {
        input.forEach(str -> {
            String mulPattern = "mul\\(\\s*\\d+(\\.\\d+)?\\s*,\\s*\\d+(\\.\\d+)?\\s*\\)";
            String doPattern = "do\\(\\)";
            String dontPattern = "don't\\(\\)";

            String combinedPattern = mulPattern + "|" + doPattern + "|" + dontPattern;

            // Create a Pattern object
            Pattern compiledPattern = Pattern.compile(combinedPattern);

            // Create a Matcher object
            Matcher matcher = compiledPattern.matcher(str);

            while (matcher.find()) {
                output.add(matcher.group());
            }
        });
    }

    public static String[] parseDayFourInput(List<String> input) {
        int noOfLines = input.size();
        String[] output = new String[noOfLines];
        int lineNo = 0;
        for(String str: input) {
            output[lineNo++] = str;
        }
        return output;
    }

    public static void parseDayFiveInput(List<String> input, List<String> pageRules, List<String> pageOrdering) {
        input.forEach(str -> {
            if(str.contains("|"))
                pageRules.add(str);
            else if(str.contains(","))
                pageOrdering.add(str);
        });
    }

    public static char[][] parseDaySixInput(List<String> input) {
        char[][] matrix = new char[input.size()][input.size()];
        int i = 0;
        for(String str: input)
            matrix[i++] = str.toCharArray();
        return matrix;
    }

    public static void parseDaySevenInput(List<String> input, Map<Long, List<List<Long>>> map) {
        input.forEach(str -> {
            String[] arr = str.split(":");
            Long key = Long.valueOf(arr[0]);
            String[] valuesArr = arr[1].trim().split(" ");
            List<Long> values = Arrays.stream(valuesArr).map(Long::valueOf).toList();
            List<List<Long>> list = map.getOrDefault(key, new ArrayList<>());
            list.add(values);
            map.put(key, list);
        });
    }

    public static void parseDayEightInput(List<String> input, Map<Character, List<int[]>> map) {
        int rows = input.size();
        int cols = input.getFirst().length();
        for(int i = 0; i < rows; ++i) {
            char[] chArr = input.get(i).toCharArray();
            for(int j = 0; j < cols; ++j) {
                if(chArr[j] != '.') {
                    List<int[]> positionList = map.getOrDefault(chArr[j], new ArrayList<>());
                    positionList.add(new int[]{i,j});
                    map.put(chArr[j], positionList);
                }
            }
        }
    }

    public static int[][] parseDayTenInput(List<String> input) {
        int[][] matrix = new int[input.size()][input.getFirst().length()];
        int row = 0;
        int col = 0;
        for(String str: input) {
            col = 0;
            for(char ch: str.toCharArray()) {
                matrix[row][col++] = ch - '0';
            }
            row++;
        }
        return matrix;
    }

    public static void parseDayElevenInput(List<String> input, Queue<Long> queue) {
        input.forEach(str -> {
            String[] arr = str.split(" ");
            Arrays.stream(arr).forEach(number -> queue.offer(Long.valueOf(number)));
        });
    }

    public static void parseDayElevenPuzzleTwoInput(List<String> input, List<Long> list) {
        input.forEach(str -> {
            String[] arr = str.split(" ");
            Arrays.stream(arr).forEach(number -> list.add(Long.valueOf(number)));
        });
    }

    public static char[][] parseDayTwelveInput(List<String> input) {
        char[][] matrix = new char[input.size()][input.getFirst().length()];
        int row = 0;
        int col;
        for(String str: input) {
            col = 0;
            for(char ch: str.toCharArray()) {
                matrix[row][col++] = ch;
            }
            row++;
        }
        return matrix;
    }
}
