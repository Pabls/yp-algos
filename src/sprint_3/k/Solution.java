//package sprint_3.k;

import java.util.Arrays;

public class Solution {
    public static int[] merge(int[] arr, int left, int mid, int right) {
        // Your code
        // “ヽ(´▽｀)ノ”
        int length = (mid - left) + (right - mid);
        int[] res = new int[length];

        int leftIndex = left;
        int rightIndex = mid;
        for (int i = 0; i < length; i++) {
            if (rightIndex >= length) {
                res[i] = arr[leftIndex];
                leftIndex++;
            } else if (arr[leftIndex] <= arr[rightIndex] && leftIndex < mid) {
                res[i] = arr[leftIndex];
                leftIndex++;
            } else {
                res[i] = arr[rightIndex];
                rightIndex++;
            }
        }
        return res;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        // Your code
        // “ヽ(´▽｀)ノ”
        Arrays.sort(arr, left, right);
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);

        int[] c = {1, 4, 2, 10, 1, 2};
        merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert Arrays.equals(c, expected2);
    }
}
