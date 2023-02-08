package sprint_3.xyz_final_tasks.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int arraySize = Integer.parseInt(reader.readLine());
        int[] arr = new int[arraySize];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arraySize; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        quickSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return;
        }

        int pivotIndex = partition(arr, leftIndex, rightIndex);
        quickSort(arr, leftIndex, pivotIndex);
        quickSort(arr, pivotIndex + 1, rightIndex);
    }

    private static int partition(int[] arr, int leftIndex, int rightIndex) {
        int pivotIndex = leftIndex;
        int elementsLessThanPivotIndex = leftIndex;
        int elementsGreaterThanPivotIndex = leftIndex;

//        for (int i = leftIndex + 1; i < rightIndex; i++) {
//            if (arr[i] < arr[pivotIndex]) {
//                ++elementsLessThanPivotIndex;
//                swapTwoElements(arr, elementsLessThanPivotIndex, i);
//                ++elementsGreaterThanPivotIndex;
//            } else {
//                ++elementsGreaterThanPivotIndex;
//            }
//        }
//
//        swapTwoElements(arr, pivotIndex, elementsLessThanPivotIndex);
//        pivotIndex = elementsLessThanPivotIndex;

        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (arr[i] > arr[pivotIndex]) {
                ++elementsGreaterThanPivotIndex;
                swapTwoElements(arr, elementsGreaterThanPivotIndex, i);
            }
            ++elementsLessThanPivotIndex;
        }

        swapTwoElements(arr, pivotIndex, elementsGreaterThanPivotIndex);
        pivotIndex = elementsGreaterThanPivotIndex;


        return pivotIndex;
    }

    private static void swapTwoElements(int[] arr, int leftIndex, int rightIndex) {
        int tmp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = tmp;
    }
}
