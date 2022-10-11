package dk.sdu.ad.exercises.two;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise2 {
    public static void main(String[] args) {
        int[] myArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
//        System.out.println("Method 1: " + myMethod(myArr));
//        System.out.println("Method 2: " + myMethod2(myArr));
//
//        System.out.println("Stack: " + balPar("()(()()"));
        CircularArray myCircularArray = new CircularArray();
        myCircularArray.enqueue(2);
        myCircularArray.enqueue(3);
        myCircularArray.enqueue(6);
        System.out.println(Arrays.toString(myCircularArray.getCircularArr()));
        myCircularArray.dequeue();
        myCircularArray.enqueue(99);
        System.out.println(Arrays.toString(myCircularArray.getCircularArr()));
    }

    public static boolean balPar(String text) {
        ArrayList<String> stack = new ArrayList<String>();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[0] == ')') {
                return false;
            } else if (chars[i] == '(') {
                stack.add("(");
            } else if (chars[i] == ')') {
                if (stack.size() == 0)
                    return false;
                else
                    stack.remove(stack.size()-1);

            }
        }
        return stack.size()==0 ? true : false;
    }

    public static int myMethod(int[] arr) { // N * N/2 * 2 = O(N^2) Der er 2 N'er
        int x = 0;
        for (int i = 0; i < arr.length; i++) // 16 | N
            for (int j = 0; j < arr.length / 2; j++) // 8 | N/2
                for (int k = 0; k < arr.length; k++) { // 2 2
                    x++;
                    if (k == 1)
                        break;
                }
        return x;
    }

    public static int myMethod2(int[] arr) { // N/2 * N * (N/2+1) = O(N^3) Der er 3 N'er
        int x = 0;
        for (int i = 0; i < arr.length / 2; i++) // 8 N/2
            for (int j = 0; j < arr.length; j++) // 16 N
                for (int k = 0; k < arr.length; k++) { // 9 N+1
                    x++;
                    if (k == arr.length / 2) {
                        break;
                    }
                }
        return x;
    }
}
