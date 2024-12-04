package org.aoc.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
}
