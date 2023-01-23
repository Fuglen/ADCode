package dk.sdu.ad.exercises.exam;

import java.util.ArrayList;

public class Exercises {
    public static void main(String[] args) {
        System.out.println("------------------------- Exercise 1 -------------------------\n");
        System.out.println("---- Test 1 ----");
        int input1 = 4096;
        System.out.println("Input is: \n" + input1);
        int result1 = logTwo(input1);
        System.out.println("Result is: \n" + result1);
        System.out.println("------------------------- Exercise 7 -------------------------\n");
        ArrayList<Integer> exercise7_output = Exercise7();
        System.out.println("Result is: \n" + exercise7_output);

        System.out.println("------------------------- Exercise 9 -------------------------\n");
        int findTriplet_output = findTriplet(1000);
        System.out.println("Result is: \n" + findTriplet_output);

        System.out.println("------------------------- getNumberEqual -------------------------\n");
        int getNumberEqual_output = getNumberEqual(new int[]{7, 4, 1, 3, 5, 6, 4, 8}, 8, 4);
        System.out.println("Result is: \n" + getNumberEqual_output);

        System.out.println("------------------------- getNumberEqual -------------------------\n");
        int oddNumbers_output = oddNumbers(9);
        System.out.println("Result is: \n" + oddNumbers_output);
    }
    public static int logTwo(int N) {
        if (N == 1)
            return 0;
        return 1 + logTwo(N/2);
    }

    public static ArrayList<Integer> Exercise7() {
        ArrayList<Integer> longestChain = new ArrayList<Integer>();
        int longestLength = 0;
        for(int number = 1; number < 10000; number++) {
            ArrayList<Integer> chain = new ArrayList<Integer>();
            int currentNumber = number;
            while (currentNumber != 1) {
                chain.add(currentNumber);
                if (currentNumber % 2 == 0) {
                    currentNumber = currentNumber / 2;
                } else {
                    currentNumber = 3 * currentNumber + 1;
                }
            }
            chain.add(1);

            if(chain.size() > longestLength) {
                longestLength = chain.size();
                longestChain = chain;
            }
        }
        return longestChain;
    }

//    This algorithm has a time complexity of O(n^2) because we are using two nested loops, one for 'a' and one for 'b'.
//    The outer loop iterates n/3 times, and the inner loop iterates n/2 times.
//    It's possible to improve the running time of this algorithm by using a mathematical property that states that a + b + c = 1000,
//    and c > b > a. So we can iterate only on 'a' and using this equation to calculate 'b' and 'c' so the complexity will be O(n) in this case.
    public static int findTriplet(int n) {
        for (int a = 1; a < n / 3; a++) {
            for (int b = a + 1; b < n / 2; b++) {
                int c = n - a - b;
                if (a * a + b * b == c * c) {
                    return a * b * c;
                }
            }
        }
        return -1;
    }

//    Write a recursive method/algorithm with the following signature:
//    int getNumberEqual(int[] x, int n, int val);
//    The algorithm returns the number of occurrences of a certain integer (parameter val) in an integer array
//    (parameter x)Parameter n is the number of elements in the array.
//    Called with the array {7,4,1,3,5,6,4,8} , n=8, and val=4, the correct return value is 2.
    public static int getNumberEqual(int[] x, int n, int val) {
        if (n == 0)
            return 0;
        if(x[n-1] == val)
            return 1 + getNumberEqual(x,n-1, val);
        else
            return getNumberEqual(x,n-1, val);

    }

    public static int oddNumbers(int n) {
        if (n < 0)
            return 0;
        if (n % 2 == 0) {
            return oddNumbers(n - 1);
        }
        return n + oddNumbers(n - 2);
    }


}
