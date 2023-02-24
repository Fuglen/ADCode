package dk.sdu.ad.exercises.exam;

import java.util.Arrays;

public class ReExam {
    public static void main(String[] args) {
        System.out.println(problem6(36789));
//        System.out.println(problem5("inagrassrootcampaignunlikeanyotherbeforeorsince"));
//        System.out.println(myMethod1(16));
//        System.out.println(divByThreeAndOrFour(11));
    }

    public static String problem6(int number) {
        String strNum = Integer.toString(number);
        char[] charNum = strNum.toCharArray();

        String prev = null, curr;
        int countDes = 0, countAsc = 0;
        for (char c :strNum.toCharArray()) {
            curr = String.valueOf(c);
            if(prev == null) {
                countDes = countAsc + 1;
                countAsc = countAsc + 1;
            }
            else if (Integer.valueOf(curr) > Integer.valueOf(prev))
                countAsc = countAsc+1;
            else
                countDes = countDes+1;
            prev = String.valueOf(c);
        }
        if (countDes > countAsc)
            return "The number is in the category of descending";
        else
            return "The number is in the category of ascending";
    }


    private static String problem5(String s) {
        String[] chars = s.toLowerCase().split("");
        Arrays.sort(chars);
        System.out.println(Arrays.toString(chars));
        int maxCount = 0, count = 1;
        String prev = chars[0], popular = chars[0];

        for (int i = 1; i < chars.length; i++) {
            if (chars[i].equals(prev))
                count++;
            else {
                if (count > maxCount) {
                    popular = chars[i - 1];
                    maxCount = count;
                }
                prev = chars[i];
                count = 1;
            }
        }
        return popular + String.valueOf(maxCount);
    }



    static int myMethod1(int x) {
        int y = 0;
        for (int i = 0; i <= x; i++) {
            if (x < 256)
                y += myMethod2(x * x);
            else
                y += myMethod2(x / 2);
        }
        return y;
    }

    static int myMethod2(int x) {
        int y = 0;
        for (int i = 0; i <= x; i++) {
            if (x < 256)
                y += myMethod3(x);
            else
                y += myMethod3(x * 2);
        }
        return y;
    }

    static int myMethod3(int x) {
        int y = 0;
        for (int i = x; i > 0; i /= 2)
            y++;
        return y;
    }

    public static int divByThreeAndOrFour(int N) {
        if (N < 3)
            return 0;
        else if(N%3==0 || N%4 == 0)
            return N + divByThreeAndOrFour(N-1);
        else
            return divByThreeAndOrFour(N-1);
    }
}
