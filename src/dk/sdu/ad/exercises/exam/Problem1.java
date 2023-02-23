package dk.sdu.ad.exercises.exam;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
//        System.out.println(myMethod(5));
        int[] secondLargestElem_input = new int[] {23,13,10,14,18,22,15,39,51,45,49,61,65,68,80};
        System.out.println(secondLargestElem(secondLargestElem_input, secondLargestElem_input.length));
    }

    static int largest = 0; static int secondLargest = 0;
    public static int secondLargestElem(int arr[], int length)
    {
        if (length < 1)
            return secondLargest;
        if (arr[length-1] > largest)
        {
            secondLargest = largest;
            largest = arr[length-1];
        }
        return secondLargestElem(arr,length-1);
    }



    public static long myMethod(long N) {
        long x = 0;
        long y = 0;
        for (long i = N; i > 0; i = i / 4) {
            for (long j = 0; j < N; j++) {
                for (long k = 0; k < N * N * N; k++) {
                    x++;
                    k *= k;
                }
            }
        }
        return x;
    }
}
