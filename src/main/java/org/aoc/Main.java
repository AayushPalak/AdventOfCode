package org.aoc;

import org.aoc.day1.PuzzleOneDayOne;
import org.aoc.day1.PuzzleTwoDayOne;
import org.aoc.day2.PuzzleOneDayTwo;
import org.aoc.day2.PuzzleTwoDayTwo;
import org.aoc.day3.PuzzleOneDayThree;
import org.aoc.day3.PuzzleTwoDayThree;
import org.aoc.utils.Helpers;

public class Main {
    public static void main(String[] args) {
        /*
        PuzzleOneDayOne puzzleOneDayOne = new PuzzleOneDayOne();
        String answer = String.valueOf(puzzleOneDayOne.findDistance(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayOneInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleOneDayOneOutput.txt");

        PuzzleTwoDayOne puzzleTwoDayOne = new PuzzleTwoDayOne();
        answer = String.valueOf(puzzleTwoDayOne.similarityScore(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayOneInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleTwoDayOneOutput.txt");

        PuzzleOneDayTwo puzzleOneDayTwo = new PuzzleOneDayTwo();
        answer = String.valueOf(puzzleOneDayTwo.countSafeReports(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayTwoInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleOneDayTwoOutput.txt");

        PuzzleTwoDayTwo puzzleTwoDayTwo = new PuzzleTwoDayTwo();
        answer = String.valueOf(puzzleTwoDayTwo.countSafeReports(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayTwoInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleTwoDayTwoOutput.txt");
        */

        String answer;

        PuzzleOneDayThree puzzleOneDayThree = new PuzzleOneDayThree();
        answer = String.valueOf(puzzleOneDayThree.calculateInstructions(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayThreeInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleOneDayThreeOutput.txt");

        PuzzleTwoDayThree puzzleTwoDayThree = new PuzzleTwoDayThree();
        answer = String.valueOf(puzzleTwoDayThree.calculateInstructions(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayThreeInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleTwoDayThreeOutput.txt");

    }
}