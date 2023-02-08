package sprint_3.xyz_final_tasks.a;

// A. Поиск в сломанном массиве
// Отчет 81925510
// https://contest.yandex.ru/contest/23815/run-report/81925510/
public class Solution {

    public static int brokenSearch(int[] arr, int k) {
        int searchIndex = -1;
        if (arr == null || arr.length == 0) {
            return searchIndex;
        }

        int startIndex = searchIndexOfSmallestItem(arr, 0, arr.length - 1);

        if (k >= arr[startIndex] && k <= arr[arr.length - 1]) {
            searchIndex = binarySearch(arr, k, startIndex, arr.length);
        } else {
            searchIndex = binarySearch(arr, k, 0, startIndex);
        }
        return searchIndex;
    }

    private static int searchIndexOfSmallestItem(int[] arr, int left, int right) {
        int middle = (left + right) / 2;
        if (arr[left] < arr[right]) {
            return left;
        } else if (arr[middle] > arr[right]) {
            return searchIndexOfSmallestItem(arr, middle + 1, right);
        } else if (arr[middle] < arr[left]) {
            return searchIndexOfSmallestItem(arr, left, middle);
        } else {
            return middle;
        }
    }

    private static int binarySearch(int[] arr, int searchItem, int left, int right) {
        if (right <= left) {
            return -1;
        }

        int middle = (left + right) / 2;
        if (arr[middle] == searchItem) {
            return middle;
        } else if (searchItem < arr[middle]) {
            return binarySearch(arr, searchItem, left, middle);
        } else {
            return binarySearch(arr, searchItem, middle + 1, right);
        }
    }

    private static void test() {
        int[] arr = {4, 5, 7, 12, 19, 21, 100, 101, 3};
        assert 6 == brokenSearch(arr, 1);
    }
}
