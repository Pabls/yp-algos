package sprint_3.xyz_final_tasks.a;

// A. Поиск в сломанном массиве
// Отчет 81925510
// https://contest.yandex.ru/contest/23815/run-report/81925510/

/*
-- ПРИНЦИП РАБОТЫ И ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ  --
* На вход подается массив элементов и значение, индекс которого необходимо найти в массиве и подать на выход (либо вернуть -1)
* Из условия задачи известно, что массив был отсортирован но в текущем представлении имеет смещение первого элемент с первой позиции на неизвестную
* Исходя из условий, поиск индекса можно разделить на 2 этапа:
* 1) Поиск индекса минимального (первого) элемента в массиве
* Осуществляется в методе searchIndexOfSmallestItem путем разделения массива пополам и рекурсивного поиска в полученных интервалах
* Поскольку по условию задачи исходный массив был отсотрирован, определить интервал с местоположением наименьшего элемента можно сравнив первый, последний  и центральный элементы
* 2) Поиск индекса искомого элемента с применением полученных ранее интервалов
* В обоих случаях поиск осуществляется с помощью бинарного поиска, основанного на сокращении интервалов поиска путем их деления пополам
* что позволяет осуществить поиск за O(log n)
* После того, как найден индекс мимнимального элемента, можно понять в каком из интервалов искать элемент int k
-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
* Поиск индекса мимнимально элемента в массиве выполняется за за O(log n)
* После того, как найден индекс минимального элемента, выполнятся поиск искомого элемента, что занимает в худшем случае
* тоже O(log n), получается что общая сложность доиска будет О (2 log n)
-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
* Входной массив состоит из n элементов, в процессе поиска дополнительной памяти под поиск не выделяется,
* получается что пространственную сложность можно представить как О(n)
* */
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
