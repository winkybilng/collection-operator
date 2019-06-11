package com.thoughtworks.collection;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {

        int max = Math.max(leftBorder, rightBorder);
        int min = Math.min(leftBorder, rightBorder);

        int result = IntStream.rangeClosed(min, max).filter(i -> i % 2 == 0).sum();
        return result;
    }


    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int max = Math.max(leftBorder, rightBorder);
        int min = Math.min(leftBorder, rightBorder);

        int result = IntStream.rangeClosed(min, max).filter(i -> i % 2 == 1).sum();
        return result;

    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {

        return arrayList.stream().mapToInt(i -> i * 3 + 2).sum();
    }


    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {

        return arrayList.stream().map(i ->{
            if (i % 2 == 1) {
                i = i * 3 + 2;
            }
            return i;}).collect(Collectors.toList());

    }

      public int getSumOfProcessedOdds(List<Integer> arrayList) {

          return arrayList.stream().filter(i -> i % 2 == 1).mapToInt(i -> i * 3 + 5).sum();

      }

    public double getMedianOfEven(List<Integer> arrayList) {

        List<Integer> evenIndexList = arrayList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        return evenIndexList.size() % 2 == 1 ? evenIndexList.stream().skip(evenIndexList.size() / 2).limit(1).mapToDouble(i -> i).findFirst().getAsDouble()
                : evenIndexList.stream().skip(evenIndexList.size() / 2 - 1).limit(2).mapToDouble(i -> i).average().getAsDouble();

    }

    public double getAverageOfEven(List<Integer> arrayList) {

        return arrayList.stream().filter(i -> i % 2 == 0).mapToDouble(i->i).average().getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(i -> i % 2 == 0).anyMatch(i -> i == specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {

        return arrayList.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> result = arrayList.stream().filter(i -> i % 2 == 0).sorted().collect(Collectors.toList());
        result.addAll(arrayList.stream().filter(i -> i % 2 == 1).sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        return result;

    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {

        return IntStream.range(0, arrayList.size()).filter(i -> i < arrayList.size() - 1).mapToObj(i -> 3 * (arrayList.get(i) + arrayList.get(i + 1))).collect(Collectors.toList());
    }
}
