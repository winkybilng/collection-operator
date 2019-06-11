package com.thoughtworks.collection;


import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().reduce(Integer::max).get();
    }

    public double getMinimum() {

        return arrayList.stream().reduce(Integer::min).get();
    }

    public double getAverage() {
        return arrayList.stream().mapToDouble(i->i).average().getAsDouble();
    }

    public double getOrderedMedian() {

        return arrayList.size() % 2 == 0 ? arrayList.stream().skip(arrayList.size() / 2 - 1).limit(2).mapToDouble(i -> i).average().getAsDouble() : arrayList.stream().skip(arrayList.size() / 2).limit(1).mapToDouble(i -> i).findFirst().getAsDouble();

    }

    public int getFirstEven() {

        return arrayList.stream().filter(i -> i % 2 == 0).findFirst().orElse(-1);
    }

    public int getIndexOfFirstEven() {
        return IntStream.range(0,arrayList.size()-1).filter(a->arrayList.get(a)==arrayList.stream().filter(i -> i % 2 == 0).findFirst().get()).findFirst().getAsInt();
    }

    public boolean isEqual(List<Integer> arrayList) {
        //return this.arrayList.equals(arrayList);
        return this.arrayList.size() == arrayList.size() && IntStream.range(0, this.arrayList.size()).allMatch(i -> this.arrayList.get(i).intValue() == arrayList.get(i).intValue());

    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        arrayList.forEach(singleLink::addTailPointer);
        return arrayList.size() % 2 == 0 ? ((Integer) singleLink.getNode(arrayList.size() / 2 + 1) + (Integer) singleLink.getNode(arrayList.size() / 2)) / 2.0 :
                (Integer) singleLink.getNode((arrayList.size() + 1) / 2) / 1.0;
    }

    public int getLastOdd() {
        Collections.reverse(arrayList);
        return arrayList.stream().filter(i -> i % 2 == 1).findFirst().orElse(-1);
    }

    public int getIndexOfLastOdd() {
        Collections.reverse(arrayList);
        return arrayList.size()-1-IntStream.range(0,arrayList.size()-1).filter(a->arrayList.get(a)==arrayList.stream().filter(i -> i % 2 == 1).findFirst().get()).findFirst().getAsInt();

    }
}
