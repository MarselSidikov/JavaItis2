package ru.itis;

public class SorterMergeImpl implements Sorter {

    private int helpArray[];

    public void sort(int[] array) {
        initHelpArray(array.length);
        sort(array, 0, array.length - 1);
    }

    private void initHelpArray(int maxSize) {
        this.helpArray = new int[maxSize];
    }

    private void sort(int array[], int lower, int higher) {
        LogUtils.log(array, "sort", lower, higher);

        if (higher <= lower) {
            return;
        }

        int middle = lower + (higher - lower) / 2;

        LogUtils.indentUp();

        sort(array, lower, middle); // C(N/2)
        sort(array, middle + 1, higher); // (C/2)
        merge(array, lower, middle, higher); // N

        LogUtils.indentDown();


    }

    private void merge(int array[], int lower, int middle, int higher) {

        for (int currentIndex = lower; currentIndex <= higher; currentIndex++) {
            helpArray[currentIndex] = array[currentIndex];
        }

        // System.arraycopy(array, lower, helpArray, lower, higher - lower);

        int i = lower, j = middle + 1;

        for (int currentIndex = lower; currentIndex <= higher; currentIndex++) {
            if (i > middle) {
                array[currentIndex] = helpArray[j];
                j++;
            } else if (j > higher) {
                array[currentIndex] = helpArray[i];
                i++;
            } else if (helpArray[j] < helpArray[i]) {
                array[currentIndex] = helpArray[j];
                j++;
            } else {
                array[currentIndex] = helpArray[i];
                i++;
            }
        }

        LogUtils.log(array, "merge", lower, higher);
    }
}
