package viratkohli;

import java.util.Arrays;
import java.util.Scanner;

import priority.PriorityQueue;
import priority.Queue;
import priority.QueueItem;

public class ViratKohli {

    private Queue queue;
    private int numberOfBowlers;
    QueueItem queueArray[];
    static Scanner sc = new Scanner(System.in);

    // Getter and Setters START
    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public int getNumberOfBowlers() {
        return numberOfBowlers;
    }

    public QueueItem[] getQueueArray() {
        return queueArray;
    }

    public void setQueueArray(QueueItem[] queueArray) {
        this.queueArray = queueArray;
    }

    // Getters and Setters END

    /**
     * Function to set attributes like, number of bowlers, their quota
     */
    public void setAttributesAndAddToQueue() {
        int bowler = 0, quota = 0;
        try {

            System.out.println("Eneter number of bowlers : ");
            numberOfBowlers = sc.nextInt();

            queueArray = new QueueItem[numberOfBowlers];
            queue = new PriorityQueue(queueArray);

            for (int i = 0; i < numberOfBowlers; i++) {

                System.out.println("Enter bowler number : ");
                bowler = sc.nextInt();

                System.out.println("Enter bowler Quota : ");
                quota = sc.nextInt();

                queue.addElement(bowler, quota);
            }

        } catch (Exception e) {
            System.out.println("Error !! Input Incorrect");

        }

    }

    /**
     * Function to arrange bowlers so that virat can score low
     */
    public int[] arrangeBowlersToBowl() {

        int orderOfBowlers[] = new int[numberOfBowlers];
        for (int i = 0; i < orderOfBowlers.length; i++) {
            // Arranging bowlers according to priority queue
            orderOfBowlers[i] = queue.getHighestPriorityElement();
            queue.deleteHighestPriorityElement();
        }
        return orderOfBowlers;

    }

    public static void main(String args[]) {
        ViratKohli virat = new ViratKohli();
        virat.setAttributesAndAddToQueue();

        int orderOfBowlers[] = virat.arrangeBowlersToBowl();

        for (int i = 0; i < orderOfBowlers.length; i++) {

            System.out.println("Bowler " + (i + 1) + " : " + orderOfBowlers[i]);
        }
    }
}
