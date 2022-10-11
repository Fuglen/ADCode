package dk.sdu.ad.exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class Portfolio {

    public static int es_num = 1;
    public static int es_sum = 0;
    public static int exercise1(int n) {
        if (es_num <= n) {
            es_sum = es_sum + (es_num * es_num);
            es_num = es_num + 2;
        } else if (es_num > n) {
            return es_sum;
        }
        return exercise1(n);
    }

    public static int myMethod( int N )
    {
        int x = 0; int y = 0;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                for (int k = 0; k < N*Math.sqrt(N); k++)
                //square root; C++: #include <math.h>
                {
                    x++;
                }
                j *= 2;
            }
            i += i;
        }
        for (int i = 0; i < N*N; i++)
            y++;
        return x+y;
    }

    public static int fib_result = 0;
    public static ArrayList<Integer> fib_list = new ArrayList<Integer>();
    public static boolean additive(String s) {
//        fib_list = Arrays.to(s.toCharArray());
        System.out.println();
        for (int i = 0; i < s.toCharArray().length; i++) {
            fib_list.add(i, (int) s.toCharArray()[0]);
//            fib_list.set(i, (int) s.toCharArray()[i]);
        }
        System.out.println(fib_list);
//        if (fib_list.size() == 0) {
//            fib_list.add(0);
//            fib_list.add(1);
//        } else if (fib_list.size() < n + 1) {
////            System.out.println(fib_list.get(fib_list.size()-2));
//            fib_result = fib_list.get(fib_list.size() - 1) + fib_list.get(fib_list.size() - 2);
//            fib_list.add(fib_result);
////            System.out.println(fib_result);
//        } else if (fib_list.size() == n + 1) {
//            return fib_list.get(n);
//        }
//        return additive(n);
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Exercise 1: " + exercise1(4));
//        System.out.println(myMethod(10));

        System.out.println(additive("82842605"));
    }
}
