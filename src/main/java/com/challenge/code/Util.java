package com.challenge.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
    public static int calcTotal(List<Integer> elements) {
        int sum = 0;
        for (int element : elements) {
            sum += element;
        }
        return sum;
    }

    public static List<Integer> findMinimumPacks(int count, Integer[] NUMBERS) {
        boolean found = false;
        List<Integer> elements = new ArrayList<>();
        for (int i = NUMBERS.length - 1; i >= 0 && !found; i--) {
            elements.add(NUMBERS[i]);
            if (count == Util.calcTotal(elements)) {
                found = true;
                break;
            }
            for (int j = i; j >= 0; j--) {
                elements.add(NUMBERS[j]);
                if (count == Util.calcTotal(elements)) {
                    found = true;
                    break;
                } else if (count > Util.calcTotal(elements)) {
                    int difference = count - Util.calcTotal(elements);
                    if (difference > NUMBERS[j]) {
                        j++;
                    }
                } else if (count < Util.calcTotal(elements)) {
                    elements.remove(elements.size() - 1);
                }
            }
            if (!found) {
                elements.remove(elements.size() - 1);
            }
        }
        System.out.println("Required : " + count + " - " + elements);
        return elements;
    }

    public static ArrayList<Integer> recurseForMinimumPacks(int quantity, Integer[] NUMBERS) {
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
        return new ArrayList<Integer>(packs.values());
    }

    public static int calcTotal(Map<Integer, Integer> elements) {
        int sum = 0;
        for (int i = 0; i < elements.size(); i++) {
            sum += elements.get(i);
        }
        return sum;
    }
}
