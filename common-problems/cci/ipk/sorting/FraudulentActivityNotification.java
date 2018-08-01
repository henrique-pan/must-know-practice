package algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FraudulentActivityNotification {

    public static void main(String[] args) {
        // int d = 5; int[] expenditures = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        // int d = 4; int[] expenditures = {1, 2, 3, 4, 4};
        int d = 3; int[] expenditures = {10, 20, 30, 40, 50};

        System.out.println("TOTAL NOTIFICATIONS: " + activityNotifications(expenditures, d));
    }

    // NAIVE
    private static int activityNotificationsNaive(int[] expenditure, int d) {
        int totalNotifications = 0;

        for(int i = d; i < expenditure.length; i++) {
            int[] lastExpenditures = new int[d];
            int index = 0;
            for(int j = i - 1; j >= i - d; j--) {
                lastExpenditures[index++] = expenditure[j];
            }

            Arrays.sort(lastExpenditures);

            if(lastExpenditures.length % 2 != 0) {
                int medianIndex = lastExpenditures.length / 2;
                if(expenditure[i] >= (lastExpenditures[medianIndex] * 2)) totalNotifications++;
            } else {
                int middle = lastExpenditures.length / 2;
                double avg = (lastExpenditures[middle] + lastExpenditures[middle-1]) / 2.0;
                if(expenditure[i] >= (avg * 2)) totalNotifications++;
            }
        }

        return totalNotifications;
    }

    private static int activityNotifications(int[] expenditures, int d) {
        int n = expenditures.length;
        int totalNotifications = 0;

        Queue<Integer> queue = new LinkedList<>();
        int[] pastActivity = new int[201];

        int currentIndex = 0;

        for (int i = 0; i < d; i++) {
            int transaction = expenditures[currentIndex++];
            queue.offer(transaction);
            pastActivity[transaction]++;
        }

        for (int i = currentIndex; i < n; i++) {
            int newTransaction = expenditures[currentIndex++];

            double median = median(pastActivity, d);
            if (newTransaction >= (2 * median)) totalNotifications++;

            int oldestTransaction = queue.poll();
            pastActivity[oldestTransaction]--;

            queue.offer(newTransaction);
            pastActivity[newTransaction]++;
        }

        return totalNotifications;
    }

    private static double median(int[] pastActivity, int elements) {
        int index = 0;

        if (elements % 2 == 0) {
            int counter = (elements / 2);

            while (counter > 0) counter -= pastActivity[index++];

            if (counter <= -1) {
                return --index;
            } else {
                int firstIndex = --index;
                int secondIndex = index + 1;

                while (pastActivity[secondIndex] == 0) secondIndex++;
                return (firstIndex + secondIndex) / 2.0;
            }
        } else {
            int counter = (elements / 2);

            while (counter >= 0) counter -= pastActivity[index++];

            return (double) index - 1;
        }
    }

}
