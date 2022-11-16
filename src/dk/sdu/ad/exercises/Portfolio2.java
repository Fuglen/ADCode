package dk.sdu.ad.exercises;

public class Portfolio2 {


    public void main(String[] args) {
        System.out.println("------------------------- Exercise 1 -------------------------\n");
        System.out.println("---- Test 1 ----");
        String some_input1 = "The cattle were running back and forth, but there was no wolf to be seen, heard, or smelled, so the shepherd decided to take a little nap in a bed of grass and early summer flowers. Soon he was awakened by a sound he had never heard before."; //Fill in your input
        System.out.println("Input is: \n" + some_input1);
        String some_result1 = exercise1(some_input1);
        System.out.println("Result is: \n" + some_result1);
    }

    private String exercise1(String s) {
        String[] words = s.split("\\W");
        words.
    }
}
