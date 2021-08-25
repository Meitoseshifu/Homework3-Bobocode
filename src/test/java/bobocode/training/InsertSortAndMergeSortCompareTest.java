package bobocode.training;

import org.junit.jupiter.api.*;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InsertSortAndMergeSortCompareTest {

    private final InsertionSort insertionSort = new InsertionSort();

    private final MergeSort mergeSort = new MergeSort();

    private final int[] array = { 56,42,33,2,5,99,7 };
    private final int[] sorted = { 2,5,7,33,42,56,99 };

    int[] sortedInSequentialOrderSmall = new int[50];
    int[] sortedInSequentialOrderAverage = new int[500];
    int[] sortedInSequentialOrderHuge = new int[5000];

    int[] partiallySortedSmall = new int[50];
    int[] partiallySortedAverage = new int[500];
    int[] partiallySortedHuge = new int[5000];

    int[] sortedInReverseOrderSmall = new int[50];
    int[] sortedInReverseOrderAverage = new int[500];
    int[] sortedInReverseOrderHuge = new int[5000];

    int[] sortedInRandomOrderSmall = new int[50];
    int[] sortedInRandomOrderAverage = new int[500];
    int[] sortedInRandomOrderHuge = new int[5000];

    public InsertSortAndMergeSortCompareTest() {
        insertDataInSequentialOrder(sortedInSequentialOrderSmall);
        insertDataInSequentialOrder(sortedInSequentialOrderAverage);
        insertDataInSequentialOrder(sortedInSequentialOrderHuge);

        insertDataInPartiallySortedOrder(partiallySortedSmall);
        insertDataInPartiallySortedOrder(partiallySortedAverage);
        insertDataInPartiallySortedOrder(partiallySortedHuge);

        insertDataInReverseOrder(sortedInReverseOrderSmall);
        insertDataInReverseOrder(sortedInReverseOrderAverage);
        insertDataInReverseOrder(sortedInReverseOrderHuge);

        insertDataInRandomOrder(sortedInRandomOrderSmall);
        insertDataInRandomOrder(sortedInRandomOrderAverage);
        insertDataInRandomOrder(sortedInRandomOrderHuge);
    }

    @Test
    @Order(1)
    @DisplayName("InsertSort works!")
    void insertSortWorks() {
        insertionSort.sort(array);
        assertThat(array).isEqualTo(sorted);
    }

    @Test
    @Order(2)
    @DisplayName("MergeSort works!")
    void mergeSortWorks() {
        mergeSort.sort(array);
        assertThat(array).isEqualTo(sorted);
    }

    @Test
    @Order(3)
    @DisplayName("MergeSort worst with sorted array of small size")
    void compareOnSortedDataSmall() {
        long startInner = System.nanoTime();
        insertionSort.sort(sortedInSequentialOrderSmall);
        long finishInner = System.nanoTime();
        long resultInner = finishInner - startInner;

        long startMerge = System.nanoTime();
        mergeSort.sort(sortedInSequentialOrderSmall);
        long finishMerge = System.nanoTime();
        long resultMerge = finishMerge - startMerge;

        assertTrue(resultInner < resultMerge);
        System.out.println("CompareOnSortedDataSmall Result Inner: " + resultInner);
        System.out.println("CompareOnSortedDataSmall Result Merge: " + resultMerge);
    }

    @Test
    @Order(4)
    @DisplayName("MergeSort worst with sorted array of average size")
    void compareOnSortedDataAverage() {
        long startInner = System.nanoTime();
        insertionSort.sort(sortedInSequentialOrderAverage);
        long finishInner = System.nanoTime();
        long resultInner = finishInner - startInner;

        long startMerge = System.nanoTime();
        mergeSort.sort(sortedInSequentialOrderAverage);
        long finishMerge = System.nanoTime();
        long resultMerge = finishMerge - startMerge;

        assertTrue(resultInner < resultMerge);
        System.out.println("CompareOnSortedDataAverage Result Inner: " + resultInner);
        System.out.println("CompareOnSortedDataAverage Result Merge: " + resultMerge);
    }

    @Test
    @Order(5)
    @DisplayName("MergeSort worst with sorted array of huge size")
    void compareOnSortedDataHuge() {
        long startInner = System.nanoTime();
        insertionSort.sort(sortedInSequentialOrderHuge);
        long finishInner = System.nanoTime();
        long resultInner = finishInner - startInner;

        long startMerge = System.nanoTime();
        mergeSort.sort(sortedInSequentialOrderHuge);
        long finishMerge = System.nanoTime();
        long resultMerge = finishMerge - startMerge;

        assertTrue(resultInner < resultMerge);
        System.out.println("CompareOnSortedDataHuge Result Inner: " + resultInner);
        System.out.println("CompareOnSortedDataHuge Result Merge: " + resultMerge);
    }

    @Test
    @Order(6)
    @DisplayName("MergeSort worst with partial sorted array of small size")
    void compareOnPartiallySequentialDataSmall() {
        long startInner = System.nanoTime();
        insertionSort.sort(partiallySortedSmall);
        long finishInner = System.nanoTime();
        long resultInner = finishInner - startInner;

        long startMerge = System.nanoTime();
        mergeSort.sort(partiallySortedSmall);
        long finishMerge = System.nanoTime();
        long resultMerge = finishMerge - startMerge;

        assertTrue(resultInner < resultMerge);
        System.out.println("CompareOnPartiallySequentialDataSmall Result Inner: " + resultInner);
        System.out.println("CompareOnPartiallySequentialDataSmall Result Merge: " + resultMerge);
    }

    @Test
    @Order(7)
    @DisplayName("MergeSort worst with partial sorted array of average size")
    void compareOnPartiallySequentialDataAverage() {
        long startInner = System.nanoTime();
        insertionSort.sort(partiallySortedAverage);
        long finishInner = System.nanoTime();
        long resultInner = finishInner - startInner;

        long startMerge = System.nanoTime();
        mergeSort.sort(partiallySortedAverage);
        long finishMerge = System.nanoTime();
        long resultMerge = finishMerge - startMerge;

        assertTrue(resultInner < resultMerge);
        System.out.println("CompareOnPartiallySequentialDataAverage Result Inner: " + resultInner);
        System.out.println("CompareOnPartiallySequentialDataAverage Result Merge: " + resultMerge);

    }

    @Test
    @Order(7)
    @DisplayName("MergeSort worst with partial sorted array of huge size")
    void compareOnPartiallySequentialDataHuge() {
        long startInner = System.nanoTime();
        insertionSort.sort(partiallySortedHuge);
        long finishInner = System.nanoTime();
        long resultInner = finishInner - startInner;

        long startMerge = System.nanoTime();
        mergeSort.sort(partiallySortedHuge);
        long finishMerge = System.nanoTime();
        long resultMerge = finishMerge - startMerge;

        assertTrue(resultInner < resultMerge);
        System.out.println("CompareOnPartiallySequentialDataHuge Result Inner: " + resultInner);
        System.out.println("CompareOnPartiallySequentialDataHuge Result Merge: " + resultMerge);
    }

    @Test
    @Order(8)
    @DisplayName("MergeSort better with reverse sorted array of small size")
    void compareOnReverseDataSmall() {
        long startInner = System.nanoTime();
        insertionSort.sort(sortedInReverseOrderSmall);
        long finishInner = System.nanoTime();
        long resultInner = finishInner - startInner;

        long startMerge = System.nanoTime();
        mergeSort.sort(sortedInReverseOrderSmall);
        long finishMerge = System.nanoTime();
        long resultMerge = finishMerge - startMerge;

        assertTrue(resultInner > resultMerge);
        System.out.println("CompareOnReverseDataSmall Result Inner: " + resultInner);
        System.out.println("CompareOnReverseDataSmall Result Merge: " + resultMerge);
    }

    @Test
    @Order(9)
    @DisplayName("MergeSort better with reverse sorted array of average size")
    void compareOnReverseDataAverage() {
        long startInner = System.nanoTime();
        insertionSort.sort(sortedInReverseOrderAverage);
        long finishInner = System.nanoTime();
        long resultInner = finishInner - startInner;

        long startMerge = System.nanoTime();
        mergeSort.sort(sortedInReverseOrderAverage);
        long finishMerge = System.nanoTime();
        long resultMerge = finishMerge - startMerge;

        assertTrue(resultInner > resultMerge);
        System.out.println("CompareOnReverseDataAverage Result Inner: " + resultInner);
        System.out.println("CompareOnReverseDataAverage Result Merge: " + resultMerge);
    }

    @Test
    @Order(10)
    @DisplayName("MergeSort better with reverse sorted array of huge size")
    void compareOnReverseDataHuge() {
        long startInner = System.nanoTime();
        insertionSort.sort(sortedInReverseOrderHuge);
        long finishInner = System.nanoTime();
        long resultInner = finishInner - startInner;

        long startMerge = System.nanoTime();
        mergeSort.sort(sortedInReverseOrderHuge);
        long finishMerge = System.nanoTime();
        long resultMerge = finishMerge - startMerge;

        assertTrue(resultInner > resultMerge);
        System.out.println("CompareOnReverseDataHuge Result Inner: " + resultInner);
        System.out.println("CompareOnReverseDataHuge Result Merge: " + resultMerge);
    }

    @Test
    @Order(11)
    @DisplayName("MergeSort better with random sorted array of small size")
    void compareOnRandomDataSmall() {
        long startInner = System.nanoTime();
        insertionSort.sort(sortedInRandomOrderSmall);
        long finishInner = System.nanoTime();
        long resultInner = finishInner - startInner;

        long startMerge = System.nanoTime();
        mergeSort.sort(sortedInRandomOrderSmall);
        long finishMerge = System.nanoTime();
        long resultMerge = finishMerge - startMerge;

        assertTrue(resultInner > resultMerge);
        System.out.println("CompareOnRandomDataSmall Result Inner: " + resultInner);
        System.out.println("CompareOnRandomDataSmall Result Merge: " + resultMerge);
    }

    @Test
    @Order(12)
    @DisplayName("Merge sort better with random sorted array of average size")
    void compareOnRandomDataAverage() {
        long startInner = System.nanoTime();
        insertionSort.sort(sortedInRandomOrderAverage);
        long finishInner = System.nanoTime();
        long resultInner = finishInner - startInner;

        long startMerge = System.nanoTime();
        mergeSort.sort(sortedInRandomOrderAverage);
        long finishMerge = System.nanoTime();
        long resultMerge = finishMerge - startMerge;

        assertTrue(resultInner > resultMerge);
        System.out.println("CompareOnRandomDataAverage Result Inner: " + resultInner);
        System.out.println("CompareOnRandomDataAverage Result Merge: " + resultMerge);
    }

    @Test
    @Order(13)
    @DisplayName("MergeSort better with random sorted array of huge size")
    void compareOnRandomDataHuge() {
        long startInner = System.nanoTime();
        insertionSort.sort(sortedInRandomOrderHuge);
        long finishInner = System.nanoTime();
        long resultInner = finishInner - startInner;

        long startMerge = System.nanoTime();
        mergeSort.sort(sortedInRandomOrderHuge);
        long finishMerge = System.nanoTime();
        long resultMerge = finishMerge - startMerge;

        assertTrue(resultInner > resultMerge);
        System.out.println("CompareOnRandomDataHuge Result Inner: " + resultInner);
        System.out.println("CompareOnRandomDataHuge Result Merge: " + resultMerge);
    }

    private void insertDataInSequentialOrder(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    private void insertDataInRandomOrder(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(500);
        }
    }

    private void insertDataInReverseOrder(int[] array) {
        int num = array.length;
        for (int i = 0; i < array.length; i++) {
            array[i] = num;
            num--;
        }
    }

    private void insertDataInPartiallySortedOrder(int[] array) {
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = num;
            num++;
            if (i == 6 || i == 9 || i == 60 || i == 90 || i == 600 || i == 900) {
                num = num - 5;
            }
        }
    }
}
