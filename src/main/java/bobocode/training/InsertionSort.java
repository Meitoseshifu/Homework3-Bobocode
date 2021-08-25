package bobocode.training;

/**
 * After running all test cases we can make the following conclusion:
 * 1. InsertionSort show better performance when data already sorted regardless to array length
 * 2. InsertionSort show better performance when array has small length
 * 3. InsertionSort show worst performance with reverse sorted array of all sizes. When array length > 500 performance
 *    become significant lower vs MergeSort
 * 4. InsertionSort show worst performance with random data array, when array length is
 *    5000 performance become significant lower vs MergeSort
 * 5. InsertionSort is less resource consuming and more effective with simple data sets in small arrays.
 */
public class InsertionSort {

    public void sort(int [] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int current = array[i];
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = current;
        }
    }
}
