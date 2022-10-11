package dk.sdu.ad.exercises.two;

public class CircularArray {

    public int[] circularArr = new int[10];

    int indexForNewEntries = 0;
    int indexOfQueueEnd = 0;

    CircularArray() {
    }

    public void dequeue() {
            circularArr[indexOfQueueEnd] = 0;
            indexOfQueueEnd = indexOfQueueEnd+1;
    }

    public void enqueue(int input) {
        for (int i = 0; i < circularArr.length - 1; i++) {
//            System.out.println(circularArr[i]);
            if (circularArr[i] == 0 && indexOfQueueEnd != indexForNewEntries) {
                circularArr[i] = input;
                indexForNewEntries = indexForNewEntries+1;
                break;
            }
        }
    }

    public int[] getCircularArr() {
        return circularArr;
    }
}
