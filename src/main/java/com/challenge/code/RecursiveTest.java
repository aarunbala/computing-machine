package com.challenge.code;

import java.util.*;

public class RecursiveTest {
    private static final Integer[] NUMBERS = {2, 5, 8};

    public static void main(String[] args) {
        for(int i =0;i<=150;i++)
            recurseForMinimumPacks(i);
    }

    public static void recurseForMinimumPacks(int quantity) {
        Map<Integer, Integer> packs = new HashMap<>();
        int mapIndex = 0;
        int indexer = 1;
        int timesIndexHitZero = 0;
        int index = NUMBERS.length - indexer;
        while (true) {
            int diff = quantity - calcTotal(packs);
            if(quantity < NUMBERS[0]) break;
            if (diff > 0) {
                if (diff >= NUMBERS[index]) {
                    packs.put(mapIndex++, NUMBERS[index]);
                } else if (diff < NUMBERS[index]) {
                    index--;
                    //packs.remove(--mapIndex);
                }
            } else if(diff == 0){
                break;
            }
            if (index == 0) timesIndexHitZero++;
            if (index == -1) {
                for (int i = 0; i < timesIndexHitZero; i++) {
                    if (mapIndex != 0) {
                        packs.remove(--mapIndex);
                    }
                }
                timesIndexHitZero = 0;
                indexer++;
                index = NUMBERS.length - indexer;
                if(index == -1) break;
            }
        }
        System.out.println("Required Quantity : " +quantity+ " - "  + packs.values());
    }

    public static int calcTotal(Map<Integer, Integer> elements) {
        int sum = 0;
        for (int i = 0; i < elements.size(); i++) {
            sum += elements.get(i);
        }
        return sum;
    }
}

class Pack {
    int packSize;
    boolean tested;

    public Pack(int packSize, boolean tested) {
        this.packSize = packSize;
        this.tested = tested;
    }

    @Override
    public String toString() {
        return "Pack{" +
                "packSize=" + packSize +
                ", tested=" + tested +
                '}';
    }
}




