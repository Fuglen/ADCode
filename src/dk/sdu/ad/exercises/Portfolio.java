package dk.sdu.ad.exercises;

import java.math.BigInteger;
import java.util.Arrays;

public class Portfolio {

    public static int es_num = 1;
    public static int es_sum = 0;

    public static int exercise1(int n) {
        if (n % 2 == 0) {
            if (n == 0) {
                return 0;
            }
            return exercise1(n - 1);
        } else
            return (n * n) + exercise1(n - 1);
    }

    public static int myMethod(int N) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N * Math.sqrt(N); k++)
                //square root; C++: #include <math.h>
                {
                    x++;
                }
                j *= 2;
            }
            i += i;
        }
        for (int i = 0; i < N * N; i++)
            y++;
        return x + y;
    }

    public static boolean additive(String s) { //“82842605”
        if (s.length() < 3)
            return false;
        System.out.println(s.charAt(s.length() - 1) - 48);
        return (s.charAt(s.length() - 3) - 48) + (s.charAt(s.length() - 2) - 48) == (s.charAt(s.length() - 1) - 48) || additive(s.substring(0, s.length() - 1));
    }

    // Opgave 4: Den skal finde 3 tilfældige tal der til sammen giver et tal der er tættest på "power of 2", altså 2, 4, 8, 16, 32... 512
    public static void exercise4(int arr[], int data[], int start,
                                  int end, int index, int r){ // {23,56,22,11,65,89,3,44,87,910,45,35,98}
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(data[j]+" ");
            System.out.println("");
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            exercise4(arr, data, i+1, end, index+1, r);
        }
    }

    // Opgave 6
    public static int sumDivisibleBy3(int N) {
        if (N % 3 > 0) {
            return sumDivisibleBy3(N - 1);
        } else if (N == 0) {
            return 0;
        }
        return N + sumDivisibleBy3(N - 1);

    }

    // Opgave 7
    public static String exercise7(int power) {
        if (power > 100000)
            return "Illegal value";
        String result = "No solution found";
        int maxX = 3;

        for (int x = 3; x <= 46; x++) {
            for (int y = 3; y <= 10; y++) {
                int calculatedPower = (int) Math.pow(x, y);
                if (calculatedPower < 100000)
                    if (calculatedPower == power)
                        if (x > maxX) {
                            maxX = x;
                            result = "The power " + power + " with the highest x is: X= " + x + " Y=" + y;
                        }
            }
        }
        return result;
    }

    // Opgave 10
    public static int logTo(int N) {
        if (N < 2)
            return 0;
        return 1 + logTo(N / 2);
    }

    // Opgave 11 O(n log n) complexity
    public static int exercise11(int[] votes) { // {7,4,3,5,3,1,6,4,5,1,7,5} {7,7,7,5,5,5,5,3,3,3,3,3,3,3}
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
        System.out.println("Exercise 1: " + exercise1(8));
//        System.out.println(myMethod(10));
        int arr[] = {1, 2, 3, 4, 5};
        int r = 3;
        int n = arr.length;
        exercise4(arr, n));

        System.out.println(additive("82842605"));
        System.out.println("Exercise 6: " + sumDivisibleBy3(14));
        System.out.println("Exercise 7: " + exercise7(59049));
        System.out.println("Exercise 10: " + logTo(4096));
        System.out.println("Exercise 11: " + exercise11(new int[]{7,4,3,5,3,1,5,1,7,7,7,7,7,7}));
    }
}
