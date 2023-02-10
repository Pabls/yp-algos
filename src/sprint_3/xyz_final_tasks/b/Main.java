package sprint_3.xyz_final_tasks.b;

import java.util.Scanner;

// B. Эффективная быстрая сортировка
// Отчет 82079116
// https://contest.yandex.ru/contest/23815/run-report/82079116/

/*
-- ПРИНЦИП РАБОТЫ И ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
* На вход подается массив строк, содержащих имя участника, кол-во заработанных и штрафных баллов, необходимо отсортировать
* участников и вывести их имена в определнной последовательности
* Для удобства работы с данными кождого участника, заведен класс Participant, хранящий в себе информацию об участнике
* По условию задачи сортировка должна быть произведена метеодом быстрой сортировки без использования дополнительной памяти
* Для сравнения пользователей между собой, чтобы понять как их сортировать, класс Participant реализует интерфейс Comparable
* По условию задачи пользователи сравниваются сперва по кол-ву баллов, если кол-во баллов одинаковое , то по кол-ву штрафных баллов,
* если и они одинаковы то сравниваются их имена в лексикографическом порядке
* Для сортировыки сделан метод quickSort в котором проверяется граничный случай рекурсии для выхода, производится получение
* индекса опорного элемента и рекурсивный вызов самого себя (quickSort()) с интервалами разделенными опорным элементом
* Выбор опорного элемента и  распределение элементов до и после опорного элемента производится в методе partition
* В качестве опорного элемента берется первый элемент интервала, далее в цикле все последующие элементы сравниваются с ним
* и распределяются на две части (те что больше опорного и потом те что меньше него) идущие друг за другом.
* После прохода по всем элементам, опорный элемент меняется меняется местами и последним элементом больше него и тем самы помещяется на свое место
* Все перемещения элементов по массиву осуществляются без выделения памяти в методе swapTwoElements
* В финал получаем отсортированный массив
-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
* В худшем случае, когда опорный элемент выбирается неудачно и из за этого интервалы не удается делить пополам равномерно,
алгоритм будет работать за O(n^2),  а в лучшем случае, при удачном выборе опорного элемента за O(n log n).
-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
* Входной массив состоит из n элементов, как и требовалось в условии задачи, в процессе поиска дополнительной памяти под поиск не выделяется,
* получается что пространственную сложность можно представить как О(n)
* */
public class Main {

    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = Integer.parseInt(scanner.nextLine());
        Comparable<Participant>[] participants = new Participant[arraySize];
        for (int i = 0; i < arraySize; i++) {
            participants[i] = parseParticipant(scanner.nextLine());
        }
        quickSort(participants);
        System.out.println(stringBuilder);
    }

    public static void quickSort(Comparable[] participants) {
        quickSort(participants, 0, participants.length);
    }

    private static void quickSort(Comparable[] arr, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            if (leftIndex < arr.length && arr[leftIndex] instanceof Participant) {
                String name = ((Participant) arr[leftIndex]).name;
                stringBuilder.append(name).append("\n");
            }
            return;
        }

        int pivotIndex = partition(arr, leftIndex, rightIndex);
        quickSort(arr, leftIndex, pivotIndex);
        quickSort(arr, pivotIndex + 1, rightIndex);
    }

    private static int partition(Comparable[] arr, int leftIndex, int rightIndex) {
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

    private static void swapTwoElements(Comparable[] arr, int leftIndex, int rightIndex) {
        Comparable tmp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex] = tmp;
    }

    private static boolean isElementGreaterThanPivot(Comparable element, Comparable pivot) {
        return element.compareTo(pivot) > 0;
    }

    private static Participant parseParticipant(String str) {
        String[] data = str.split(" ");
        String name = data[0];
        int scores = Integer.parseInt(data[1]);
        int penalty = Integer.parseInt(data[2]);
        return new Participant(name, scores, penalty);
    }

    private static class Participant implements Comparable<Participant> {
        private String name;
        private int scores;
        private int penalty;

        public Participant(String name, int scores, int penalty) {
            this.name = name;
            this.scores = scores;
            this.penalty = penalty;
        }

        @Override
        public int compareTo(Participant p) {
            if (this.scores > p.scores) {
                return 1;
            } else if (this.scores < p.scores) {
                return -1;
            }

            if (this.penalty < p.penalty) {
                return 1;
            } else if (this.penalty > p.penalty) {
                return -1;
            }
            return p.name.compareTo(this.name);
        }
    }
}
