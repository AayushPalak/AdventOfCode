package org.aoc;

import org.aoc.day1.PuzzleOneDayOne;
import org.aoc.day1.PuzzleTwoDayOne;
import org.aoc.day10.PuzzleOneDayTen;
import org.aoc.day10.PuzzleTwoDayTen;
import org.aoc.day11.PuzzleOneDayEleven;
import org.aoc.day11.PuzzleTwoDayEleven;
import org.aoc.day12.PuzzleOneDayTwelve;
import org.aoc.day12.PuzzleTwoDayTwelve;
import org.aoc.day13.PuzzleOneDayThirteen;
import org.aoc.day13.PuzzleTwoDayThirteen;
import org.aoc.day14.PuzzleOneDayFourteen;
import org.aoc.day14.PuzzleTwoDayFourteen;
import org.aoc.day2.PuzzleOneDayTwo;
import org.aoc.day2.PuzzleTwoDayTwo;
import org.aoc.day3.PuzzleOneDayThree;
import org.aoc.day3.PuzzleTwoDayThree;
import org.aoc.day4.PuzzleOneDayFour;
import org.aoc.day4.PuzzleTwoDayFour;
import org.aoc.day5.PuzzleOneDayFive;
import org.aoc.day5.PuzzleTwoDayFive;
import org.aoc.day6.PuzzleOneDaySix;
import org.aoc.day6.PuzzleTwoDaySix;
import org.aoc.day7.PuzzleOneDaySeven;
import org.aoc.day7.PuzzleTwoDaySeven;
import org.aoc.day8.PuzzleOneDayEight;
import org.aoc.day8.PuzzleTwoDayEight;
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

        PuzzleOneDayFive puzzleOneDayFive = new PuzzleOneDayFive();
        answer = String.valueOf(puzzleOneDayFive.countMiddleNumber(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayFiveInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleOneDayFiveOutput.txt");

        PuzzleTwoDayFive puzzleTwoDayFive = new PuzzleTwoDayFive();
        answer = String.valueOf(puzzleTwoDayFive.countMiddleNumber(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayFiveInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleTwoDayFiveOutput.txt");

        PuzzleOneDaySix puzzleOneDaySix = new PuzzleOneDaySix();
        answer = String.valueOf(puzzleOneDaySix.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDaySixInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleOneDaySixOutput.txt");

        PuzzleTwoDaySix puzzleTwoDaySix = new PuzzleTwoDaySix();
        answer = String.valueOf(puzzleTwoDaySix.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDaySixInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleTwoDaySixOutput.txt");

        PuzzleOneDaySeven puzzleOneDaySeven = new PuzzleOneDaySeven();
        answer = String.valueOf(puzzleOneDaySeven.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDaySevenInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleOneDaySevenOutput.txt");

        PuzzleTwoDaySeven puzzleTwoDaySeven = new PuzzleTwoDaySeven();
        answer = String.valueOf(puzzleTwoDaySeven.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDaySevenInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleTwoDaySevenOutput.txt");

        PuzzleOneDayEight puzzleOneDayEight = new PuzzleOneDayEight();
        answer = String.valueOf(puzzleOneDayEight.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayEightInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleOneDayEightOutput.txt");

        PuzzleTwoDayEight puzzleTwoDayEight = new PuzzleTwoDayEight();
        answer = String.valueOf(puzzleTwoDayEight.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayEightInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleTwoDayEightOutput.txt");

        PuzzleOneDayTen puzzleOneDayTen = new PuzzleOneDayTen();
        answer = String.valueOf(puzzleOneDayTen.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayTenInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleOneDayTenOutput.txt");

        PuzzleTwoDayTen puzzleTwoDayTen = new PuzzleTwoDayTen();
        answer = String.valueOf(puzzleTwoDayTen.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayTenInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleTwoDayTenOutput.txt");

        PuzzleOneDayEleven puzzleOneDayEleven = new PuzzleOneDayEleven();
        answer = String.valueOf(puzzleOneDayEleven.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayElevenInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleOneDayElevenOutput.txt");

        PuzzleTwoDayEleven puzzleTwoDayEleven = new PuzzleTwoDayEleven();
        answer = String.valueOf(puzzleTwoDayEleven.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayElevenInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleTwoDayElevenOutput.txt");

        PuzzleOneDayTwelve puzzleOneDayTwelve = new PuzzleOneDayTwelve();
        answer = String.valueOf(puzzleOneDayTwelve.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayTwelveInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleOneDayTwelveOutput.txt");

        PuzzleTwoDayTwelve puzzleTwoDayTwelve = new PuzzleTwoDayTwelve();
        answer = String.valueOf(puzzleTwoDayTwelve.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayTwelveInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleTwoDayTwelveOutput.txt");

        PuzzleOneDayThirteen puzzleOneDayThirteen = new PuzzleOneDayThirteen();
        answer = String.valueOf(puzzleOneDayThirteen.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayThirteenInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleOneDayThirteenOutput.txt");

        PuzzleTwoDayThirteen puzzleTwoDayThirteen = new PuzzleTwoDayThirteen();
        answer = String.valueOf(puzzleTwoDayThirteen.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayThirteenInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleTwoDayThirteenOutput.txt");

        PuzzleOneDayFourteen puzzleOneDayFourteen = new PuzzleOneDayFourteen();
        answer = String.valueOf(puzzleOneDayFourteen.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayFourteenInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleOneDayFourteenOutput.txt");

        */

        PuzzleTwoDayFourteen puzzleTwoDayFourteen = new PuzzleTwoDayFourteen();
        answer = String.valueOf(puzzleTwoDayFourteen.solve(Helpers.readFromFile("/Users/aayushpalak/TechDocs/PuzzleOneDayFourteenInput.txt")));
        Helpers.writeToFile(answer, "/Users/aayushpalak/TechDocs/PuzzleTwoDayFourteenOutput.txt");
    }
}