package dk.sdu.ad.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Portfolio {

    public static int exercise1(int n) {
        if (n % 2 == 0) {
            if (n == 0) {
                return 0;
            }
            return exercise1(n - 1);
        } else
            return (n * n) + exercise1(n - 1);
    }

    public static boolean additive(String s) {
        if (s.length() < 3)
            return false;
        return (s.charAt(s.length() - 3) - 48) + (s.charAt(s.length() - 2) - 48) == (s.charAt(s.length() - 1) - 48) || additive(s.substring(0, s.length() - 1));
    }

    public static int[] exercise4(int[] arr) {

        List<int[]> list = new ArrayList<int[]>();
        int[] result = new int[0];
        int smallestDiff = 99999;
        int sum;
        int po2;
        int po2_floor;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    sum = arr[i] + arr[j] + arr[k];
                    po2 = powerof2(sum);
                    po2_floor = powerof2(sum / 2);
                    if (po2 - sum < sum - po2_floor && po2 - sum < smallestDiff) {
                        smallestDiff = po2 - sum;
                        result = new int[]{arr[i], arr[j], arr[k], po2};
                    } else if (sum - po2_floor < po2 - sum && sum - po2_floor < smallestDiff) {
                        smallestDiff = sum - po2_floor;
                        result = new int[]{arr[i], arr[j], arr[k], po2_floor};
                    }
                }
            }
        }
        return result;
    }

    static int powerof2(int x) {
        x = x - 1;
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        return x + 1;
    }

    public static int sumDivisibleBy3(int N) {
        if (N % 3 > 0) {
            return sumDivisibleBy3(N - 1);
        } else if (N == 0) {
            return 0;
        }
        return N + sumDivisibleBy3(N - 1);
    }

    public static String exercise7(int Z) {
        if (Z > 100000)
            return "Illegal value";
        String result = "No solution found";
        int maxX = 3;

        for (int x = 3; x <= 46; x++) {
            for (int y = 3; y <= 10; y++) {
                int calculatedPower = (int) Math.pow(x, y);
                if (calculatedPower < 100000)
                    if (calculatedPower == Z)
                        if (x > maxX) {
                            maxX = x;
                            result = "The power " + Z + " with the highest x is: X=" + x + " Y=" + y;
                        }
            }
        }
        return result;
    }

    public static int logTo(int N) {
        if (N < 2)
            return 0;
        return 1 + logTo(N / 2);
    }

    // Opgave 11 O(n log n) complexity
    public static int exercise11(int[] votes) {
        Arrays.sort(votes);
        int maxCount = 0, count = 1;
        int prev = votes[0], popular = votes[0];

        for (int i = 1; i < votes.length; i++) {
            if (votes[i] == prev)
                count++;
            else {
                if (count > maxCount) {
                    popular = votes[i - 1];
                    maxCount = count;
                }
                prev = votes[i];
                count = 1;
            }
        }

        if (count > maxCount && count > votes.length / 2)
            return votes[votes.length - 1];
        else if (maxCount > count && maxCount > votes.length / 2) {
            return popular;
        } else
            return -1;
    }

    public static void main(String[] args) {
        System.out.println("------------------------- Exercise 1 -------------------------\n");
        System.out.println("---- Test 1 ----");
        int some_input1 = 8;//Fill in your input
        System.out.println("Input is: \n" + some_input1);
        int some_result1 = exercise1(some_input1);
        System.out.println("Result is: \n" + some_result1);

        System.out.println("\n------------------------- Exercise 3 -------------------------\n");
        System.out.println("---- Test 1 ----");
        String some_input3 = "82842605";
        System.out.println("Input is: \n" + some_input3);
        boolean some_result3 = additive(some_input3);
        System.out.println("Result is: \n" + some_result3);

        System.out.println("\n------------------------- Exercise 4 -------------------------\n");
        System.out.println("---- Test 1 ----");
        int[] some_input4 = {23, 56, 22, 11, 65, 89, 3, 44, 87, 910, 45, 35, 98};
        System.out.println("Input is: \n" + Arrays.toString(some_input4));
        int[] some_result4 = exercise4(some_input4);
        System.out.println("Result is: \n" + Arrays.toString(some_result4));

        System.out.println("\n------------------------- Exercise 6 -------------------------\n");
        System.out.println("---- Test 1 ----");
        int some_input6 = 12;
        System.out.println("Input is: \n" + some_input6);
        int some_result6 = sumDivisibleBy3(some_input6);
        System.out.println("Result is: \n" + some_result6);

        System.out.println("\n---- Test 2 ----");
        int some_input62 = 14;
        System.out.println("Input is: \n" + some_input62);
        int some_result62 = sumDivisibleBy3(some_input62);
        System.out.println("Result is: \n" + some_result62);

        System.out.println("\n------------------------- Exercise 7 -------------------------\n");
        System.out.println("---- Test 1 ----");
        int some_input7 = 6561;
        System.out.println("Input is: \n" + some_input7);
        String some_result7 = exercise7(some_input7);
        System.out.println("Result is: \n" + some_result7);

        System.out.println("\n---- Test 2 ----");
        int some_input72 = 3125;
        System.out.println("Input is: \n" + some_input72);
        String some_result72 = exercise7(some_input72);
        System.out.println("Result is: \n" + some_result72);

        System.out.println("\n---- Test 3 ----");
        int some_input73 = 1337;
        System.out.println("Input is: \n" + some_input73);
        String some_result73 = exercise7(some_input73);
        System.out.println("Result is: \n" + some_result73);

        System.out.println("\n------------------------- Exercise 10 -------------------------\n");
        System.out.println("---- Test 1 ----");
        int some_input10 = 32;
        System.out.println("Input is: \n" + some_input10);
        int some_result10 = logTo(some_input10);
        System.out.println("Result is: \n" + some_result10);

        System.out.println("\n---- Test 2 ----");
        int some_input102 = 4096;
        System.out.println("Input is: \n" + some_input102);
        int some_result102 = logTo(some_input102);
        System.out.println("Result is: \n" + some_result102);

        System.out.println("\n------------------------- Exercise 11 -------------------------\n");
        System.out.println("---- Test 1 ----");
        int[] some_input11 = {7, 4, 3, 5, 3, 1, 6, 4, 5, 1, 7, 5};
        System.out.println("Input is: \n" + Arrays.toString(some_input11));
        int some_result11 = exercise11(some_input11);
        System.out.println("Result is: \n" + some_result11);

        System.out.println("\n---- Test 2 ----");
        int[] some_input112 = {7, 2, 2, 2, 3, 2, 6, 4, 2, 1, 2, 5, 2, 2};
        System.out.println("Input is: \n" + Arrays.toString(some_input112));
        int some_result112 = exercise11(some_input112);
        System.out.println("Result is: \n" + some_result112);

        // Test
    }
}
