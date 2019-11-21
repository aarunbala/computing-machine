package com.challenge.code;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private static final Integer[] NUMBERS = {2, 5, 8};

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++)
            findMinimumPacks(i);
    }

    public static void findMinimumPacks(int count) {
        boolean found = false;
        List<Integer> elements = new ArrayList<>();
        if(count > NUMBERS[0])
        for (int i = NUMBERS.length - 1; i >= 0 && !found; i--) {
            elements.add(NUMBERS[i]);
            if (count == calcTotal(elements)) {
                found = true;
                break;
            } else if(count > calcTotal(elements)){
                for (int j = NUMBERS.length - 1; j >= 0; j--) {
                    elements.add(NUMBERS[j]);
                    if (count == calcTotal(elements)) {
                        found = true;
                        break;
                    } else if (count > calcTotal(elements)) {
                        int difference = count - calcTotal(elements);
                        if (difference >= NUMBERS[j]) {
                            j++;
                        }
                    } else if (count < calcTotal(elements)) {
                        //int difference = calcTotal(elements) - count;
                        //if(Math.abs(difference - NUMBERS[j]) > 0 && Math.abs(difference - NUMBERS[j]) < NUMBERS[j]) elements.remove(elements.size()-2);
                        if (elements.size() > 0) {
                            elements.remove(elements.size() == 0 ? 0 : elements.size() - 1);
                        }
                        if (elements.size() > 0) {
                            elements.remove(elements.size() == 0 ? 0 : elements.size() - 1);
                        }
                        //j++;
                    }
                }
            }
            if (!found) {
                //elements.remove(elements.size() - 1);
                elements.clear();
            }
        }
        System.out.println("Required : " + count + " - " + elements);
    }

    public static int calcTotal(List<Integer> elements) {
        int sum = 0;
        for (int element : elements) {
            sum += element;
        }
        return sum;
    }


}
