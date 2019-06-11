package com.thoughtworks.collection;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {

        return IntStream.rangeClosed(1,number/2).mapToObj(i-> number-i*2).collect(Collectors.toList());


    }
}
