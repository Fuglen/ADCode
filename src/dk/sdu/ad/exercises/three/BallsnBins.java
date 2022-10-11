package dk.sdu.ad.exercises.three;

import java.util.Arrays;
import java.util.Random;

public class BallsnBins {
    public static void main(String[] args) {
        uniform(10007);
        uniform(32749);

        powerOfTwo(1007);
        powerOfTwo(32749);
    }

    public static void uniform(int b) {
        int balls = b;
        int[] bins = new int[b];

        for (int i = 0; i < balls; i++) {
//            Random r = new Random();
            int random = (int) (Math.random() * balls);
//            System.out.println(random);
            bins[random] = bins[random] + 1;
        }
        System.out.println("The bins looks like this: " + Arrays.toString(bins));
        System.out.println("Max: " + Arrays.stream(bins).max().getAsInt());
        System.out.println("Average: " + Arrays.stream(bins).sum() / bins.length);
    }

    public static void powerOfTwo(int balls) {
        int[] bins = new int[balls];

        for (int i = 0; i < balls; i++) {
            int random1 = (int) (Math.random() * balls);
            int random2 = (int) (Math.random() * balls);
            if(bins[random1] <= bins[random2])
                bins[random1] = bins[random1]+1;
            else
                bins[random2] = bins[random2]+1;
        }
        System.out.println("Power of two: " + Arrays.toString(bins));
        System.out.println("Max: " + Arrays.stream(bins).max().getAsInt());
        System.out.println("Average: " + Arrays.stream(bins).sum() / bins.length);
    }
}
