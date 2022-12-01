package com.sv.aoc2022.day1;

import static org.assertj.core.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

public class CaloriesTest {

  @Test
  void solveExample() throws IOException {
    int mostCaloriesCarried = getMostCaloriesCarried("example.txt");
    assertThat(mostCaloriesCarried).isEqualTo(24000);
  }

  @Test
  void solvePuzzle() throws IOException {
    int mostCaloriesCarried = getMostCaloriesCarried("puzzle.txt");
    System.out.println("Day 1 Puzzle 1 solution: " + mostCaloriesCarried);
  }

  private static int getMostCaloriesCarried(String filename) throws IOException {
    Stream<String> lines = getLines(filename);
    return new Calories().getMostCaloriesCarried(lines);
  }

  private static Stream<String> getLines(String filename) throws IOException {
    File inputFile = new ClassPathResource("day1/" + filename).getFile();
    Stream<String> lines = new BufferedReader(new FileReader(inputFile)).lines();
    return lines;
  }

  @Test
  void solveExample2() throws IOException {
    int top3Calories = getCaloriesCarriedByTopN("example.txt", 3);
    assertThat(top3Calories).isEqualTo(45_000);
  }

  @Test
  void solvePuzzle2() throws IOException {
    int top3Calories = getCaloriesCarriedByTopN("puzzle.txt", 3);
    System.out.println("Day 1 Puzzle 2 solution: " + top3Calories);
  }

  private static int getCaloriesCarriedByTopN(String filename, int topN) throws IOException {
    Stream<String> lines = getLines(filename);
    return new Calories().getCaloriesCarriedByTopN(lines, topN);
  }
}
