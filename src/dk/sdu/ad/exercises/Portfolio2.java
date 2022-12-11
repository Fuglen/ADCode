package dk.sdu.ad.exercises;

import java.util.Arrays;

public class Portfolio2 {


    public static void main(String[] args) {
        System.out.println("------------------------- Exercise 1 -------------------------\n");
        System.out.println("---- Test 1 ----");
        String some_input1 = "The cattle were running back and forth, but there was no wolf to's be seen, heard, or smelled, so the shepherd decided to take a little nap in a bed of grass and early summer flowers. Soon he was awakened by a sound he had never heard before."; //Fill in your input
        System.out.println("Input is: \n" + some_input1);
        String some_result1 = exercise1(some_input1);
        System.out.println("Result is: \n" + some_result1);
    }

    private static String exercise1(String s) {
        String[] words = s.toLowerCase().split("\\P{L}+");
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        int maxCount = 0, count = 1;
        String prev = words[0], popular = words[0];

        for (int i = 1; i < words.length; i++) {
            if (words[i].equals(prev))
                count++;
            else {
                if (count > maxCount) {
                    popular = words[i - 1];
                    maxCount = count;
                }
                prev = words[i];
                count = 1;
            }
        }
        return popular;
    }
}
