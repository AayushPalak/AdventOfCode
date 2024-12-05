package org.aoc;

import org.aoc.day1.PuzzleOneDayOne;
import org.aoc.day1.PuzzleTwoDayOne;
import org.aoc.day2.PuzzleOneDayTwo;
import org.aoc.day2.PuzzleTwoDayTwo;
import org.aoc.day3.PuzzleOneDayThree;
import org.aoc.day3.PuzzleTwoDayThree;
import org.aoc.day4.PuzzleOneDayFour;
import org.aoc.day4.PuzzleTwoDayFour;
import org.aoc.day5.PuzzleOneDayFive;
import org.aoc.day5.PuzzleTwoDayFive;
import org.aoc.utils.Helpers;

public class Main {
    public static void main(String[] args) {

        String answer;

        /*
        PuzzleOneDayOne puzzleOneDayOne = new PuzzleOneDayOne();
        answer = String.valueOf(puzzleOneDayOne.findDistance(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayOneInput.txt")));
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

        PuzzleOneDayThree puzzleOneDayThree = new PuzzleOneDayThree();
        answer = String.valueOf(puzzleOneDayThree.calculateInstructions(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayThreeInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleOneDayThreeOutput.txt");

        PuzzleTwoDayThree puzzleTwoDayThree = new PuzzleTwoDayThree();
        answer = String.valueOf(puzzleTwoDayThree.calculateInstructions(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayThreeInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleTwoDayThreeOutput.txt");



        PuzzleOneDayFour puzzleOneDayFour = new PuzzleOneDayFour();
        answer = String.valueOf(puzzleOneDayFour.countInstances(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayFourInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleOneDayFourOutput.txt");


        PuzzleTwoDayFour puzzleTwoDayFour = new PuzzleTwoDayFour();
        answer = String.valueOf(puzzleTwoDayFour.countInstances(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayFourInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleTwoDayFourOutput.txt");
        */

        PuzzleOneDayFive puzzleOneDayFive = new PuzzleOneDayFive();
        answer = String.valueOf(puzzleOneDayFive.countMiddleNumber(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayFiveInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleOneDayFiveOutput.txt");

        PuzzleTwoDayFive puzzleTwoDayFive = new PuzzleTwoDayFive();
        answer = String.valueOf(puzzleTwoDayFive.countMiddleNumber(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayFiveInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleTwoDayFiveOutput.txt");

    }
}