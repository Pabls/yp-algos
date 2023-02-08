package sprint_3.xyz_final_tasks.b;

import java.util.Comparator;
import java.util.Scanner;

// B. Эффективная быстрая сортировка
// Отчет 81993164
// https://contest.yandex.ru/contest/23815/run-report/81993164/
public class Main {

    public static ParticipantComparator comparator = new ParticipantComparator();
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = Integer.parseInt(scanner.nextLine());
        Participant[] participants = new Participant[arraySize];
        for (int i = 0; i < arraySize; i++) {
            participants[i] = parseParticipant(scanner.nextLine());
        }
        quickSort(participants, 0, participants.length);
        System.out.println(stringBuilder);
    }

    private static void quickSort(Participant[] arr, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            if (leftIndex < arr.length) {
                stringBuilder.append(arr[leftIndex].name).append("\n");
            }
            return;
        }

        int pivotIndex = partition(arr, leftIndex, rightIndex);
        quickSort(arr, leftIndex, pivotIndex);
        quickSort(arr, pivotIndex + 1, rightIndex);
    }

    private static int partition(Participant[] arr, int leftIndex, int rightIndex) {
        int pivotIndex = leftIndex;
        int elementsLessThanPivotIndex = leftIndex;
        int elementsGreaterThanPivotIndex = leftIndex;

        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (isElementGreaterThanPivot(arr[i], arr[pivotIndex])) {
                ++elementsGreaterThanPivotIndex;
                swapTwoElements(arr, elementsGreaterThanPivotIndex, i);
            }
            ++elementsLessThanPivotIndex;
        }

        swapTwoElements(arr, pivotIndex, elementsGreaterThanPivotIndex);
        pivotIndex = elementsGreaterThanPivotIndex;
        return pivotIndex;
    }

    private static void swapTwoElements(Participant[] arr, int leftIndex, int rightIndex) {
        Participant tmp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = tmp;
    }

    private static boolean isElementGreaterThanPivot(Participant element, Participant pivot) {
        int res = comparator.compare(element, pivot);
        return res > 0;
    }

    private static Participant parseParticipant(String str) {
        String[] data = str.split(" ");
        String name = data[0];
        int scores = Integer.parseInt(data[1]);
        int penalty = Integer.parseInt(data[2]);
        return new Participant(name, scores, penalty);
    }

    private static class Participant {
        private String name;
        private int scores;
        private int penalty;

        public Participant(String name, int scores, int penalty) {
            this.name = name;
            this.scores = scores;
            this.penalty = penalty;
        }
    }

    private static class ParticipantComparator implements Comparator<Participant> {

        @Override
        public int compare(Participant p1, Participant p2) {
            if (p1.scores > p2.scores) {
                return 1;
            } else if (p1.scores < p2.scores) {
                return -1;
            }

            if (p1.penalty < p2.penalty) {
                return 1;
            } else if (p1.penalty > p2.penalty) {
                return -1;
            }
            return p2.name.compareTo(p1.name);
        }
    }
}
