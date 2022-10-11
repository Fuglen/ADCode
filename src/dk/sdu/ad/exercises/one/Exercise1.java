package dk.sdu.ad.exercises.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {
        System.out.println("Sum of n natural numbers: " + sum(3)); // sum
        System.out.println("Sum of n even numbers: " + evenSquares(3)); // evenSquares
        System.out.println("Fibonacci number: " + fib(43));
        System.out.println("String contains character: " + linear("abcdefghijklmn", 'n', 13));

        int[] binaryArr = {1, 2, 5, 9, 25};
        System.out.println("BinarySearch: " + binarySearch(binaryArr, 9));
    }

    public static boolean binarySearch(int[] arr, int value) {
        int begin = 0;
        int mid = 0;
        int end = arr.length - 1;
        while (begin <= end) {
            mid = (begin + end) / 2;
            System.out.println(begin + " " + mid + " " + end);
            if (arr[mid] < value)
                begin = mid + 1;
            else if (arr[mid] > value)
                end = mid - 1;
            else
                return true;
        }
        return false;
    }

    // 1+2+3+4+...n+1 = n(n+1)/2
    // returns the sum of the first n natural numbers
    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
//        System.out.println("Current number is " + n);
        return n + sum(--n);
    }

    // 2^2 + 4^2 + 6^2 = [2n(n + 1)(2n + 1)] / 3
    // Returns the sum of the first n even numbers squares.
    public static int es_num = 2;
    public static int es_totalNum = 0;
    public static int es_sum = 0;

    public static int evenSquares(int n) {
//        2 * n * (n + 1) * (2 * n + 1) / 3;
//        while (true) {
//            if (num % 2 == 0 && totalNum != n) {
//                sum = sum + (num * num);
//                num = num + 2;
//                ++totalNum;
//            } else if (totalNum == n) {
//                break;
//            }
//        }
//        return sum;
        if (es_totalNum != n) {
            es_sum = es_sum + (es_num * es_num);
            es_num = es_num + 2;
            ++es_totalNum;
        } else if (es_totalNum == n) {
            return es_sum;
        }
        return evenSquares(n);
    }

    public static int fib_prevNum = 0;
    public static int fib_curNum = 1;
    public static int fib_result = 0;
    public static int fib_end = 0;
    public static ArrayList<Integer> fib_list = new ArrayList<Integer>();

    public static int fib(int n) {
        if (fib_list.size() == 0) {
            fib_list.add(0);
            fib_list.add(1);
        } else if (fib_list.size() < n + 1) {
//            System.out.println(fib_list.get(fib_list.size()-2));
            fib_result = fib_list.get(fib_list.size() - 1) + fib_list.get(fib_list.size() - 2);
            fib_list.add(fib_result);
//            System.out.println(fib_result);
        } else if (fib_list.size() == n + 1) {
            return fib_list.get(n);
        }
        return fib(n);
    }

    public static boolean linear(String s, char c, int l) {
        char[] chars = s.toCharArray();
//        System.out.println(chars[l]);
        if (l < 0) {
            return false;
        } else if (chars[l] == c) {
            return true;
        } else
            return linear(s, c, l - 1);
//        return cut.contains(Character.toString(c));
    }
}
