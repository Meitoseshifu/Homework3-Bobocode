package bobocode.training;

/**
 * After running all test cases we can make the following conclusion:
 * 1. MergeSort show significant worst performance with sorted data in arrays with all sizes
 * 2. MergeSort show worst performance when array has small length.
 * 3. MergeSort show significant better performance with reverse sorted array of >=500 length.
 * 4. MergeSort show significant better performance with random sorted array when its length >=500.
 * 5. MergeSort is more resource consuming and more effective with randomized or reversed data sets in large arrays.
 */
public class MergeSort {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    public void sort(int[] array) {
        divideArrayOnHalves(array, ZERO, array.length - ONE);
    }

    private void divideArrayOnHalves(int[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / TWO;
            divideArrayOnHalves(array, left, middle);
            divideArrayOnHalves(array, middle + ONE, right);
            merge(array, left, middle, right);
        }
    }

    private void merge(int[] array, int left, int middle, int right) {
        int leftArrSize = middle - left + ONE;
        int rightArrSize = right - middle;

        int[] leftSubArray = createSubArrayWithData(array, leftArrSize, left);
        int[] rightSubArray = createSubArrayWithData(array, rightArrSize, middle + ONE);

        int startLeftArr = ZERO;
        int startRightArr = ZERO;
        int mergeFrom = left;

        while (startLeftArr < leftArrSize && startRightArr < rightArrSize) {
            if (leftSubArray[startLeftArr] <= rightSubArray[startRightArr]) {
                array[mergeFrom] = leftSubArray[startLeftArr];
                startLeftArr++;
            } else {
                array[mergeFrom] = rightSubArray[startRightArr];
                startRightArr++;
            }
            mergeFrom++;
        }

        if (startLeftArr < leftArrSize) {
            mergeMissedData(array, leftSubArray, startLeftArr, mergeFrom);
        } else {
            mergeMissedData(array, rightSubArray, startRightArr, mergeFrom);
        }
    }

    private int[] createSubArrayWithData(int[] array, int size, int start) {
        int[] subArray = new int[size];
        for (int i = 0; i < size; i++) {
            subArray[i] = array[start + i];
        }
        return subArray;
    }

    private void mergeMissedData(int[] array, int[] subArray, int start, int mergeFrom) {
        while (start < subArray.length) {
            array[mergeFrom] = subArray[start];
            start++;
            mergeFrom++;
        }
    }

}
