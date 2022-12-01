package com.sv.aoc2022.day1;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Calories {

  public int getMostCaloriesCarried(Stream<String> lines) {
    return getCaloriesPerElf(lines)
        .findFirst().orElse(0);
  }

  public int getCaloriesCarriedByTopN(Stream<String> lines, int topN) {
    return getCaloriesPerElf(lines).limit(topN).reduce(0, Integer::sum);
  }

  private static Stream<Integer> getCaloriesPerElf(Stream<String> lines) {
    List<List<Integer>> initial = new ArrayList<>();
    initial.add(new ArrayList<>());
    List<List<Integer>> result = lines
        .map(line -> line.trim().isEmpty() ? null : Integer.valueOf(line))
        .reduce(initial, (elfCalories, line) -> {
      if (line == null) {
        elfCalories.add(new ArrayList<>());
      } else {
        elfCalories.get(elfCalories.size() - 1).add(line);
      }
      return elfCalories;

    }, (list1, list2) -> emptyList());
    return getSortedElves(result);
  }

  private static Stream<Integer> getSortedElves(List<List<Integer>> elves) {
    return elves.stream()
        .map(elf -> elf.stream().reduce(0, Integer::sum))
        .sorted(Comparator.reverseOrder());
  }
}
