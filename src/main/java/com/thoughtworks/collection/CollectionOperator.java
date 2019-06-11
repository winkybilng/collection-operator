package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        return (left <= right)?IntStream.rangeClosed(left, right).boxed().collect(Collectors.toList()) : IntStream.rangeClosed(right, left).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return (left <= right) ? IntStream.rangeClosed(left, right).boxed().filter(i -> i % 2 == 0).collect(Collectors.toList()) : IntStream.rangeClosed(right, left).boxed().sorted(Comparator.reverseOrder()).filter(i -> i % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(i->i%2==0).boxed().collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray).filter(i -> Arrays.stream(secondArray).boxed().collect(Collectors.toList()).contains(i)).boxed().collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> result = Arrays.stream(firstArray).collect(Collectors.toList());
        List<Integer> uncommon = Arrays.stream(secondArray).filter(i -> !Arrays.stream(firstArray).collect(Collectors.toList()).contains(i)).collect(Collectors.toList());
        result.addAll(uncommon);
        return result;
    }
}
