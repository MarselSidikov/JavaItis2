package ru.itis;

public class Main {

    /**
     * Быстрая сортировка
     * @param array - сортируемый массив
     * @param start - левая граница (откуда начинать)
     * @param end - правая граница (где заканчивать)
     */
    public static void quickSort(int[] array, int start, int end) {
        // если начало и конец встретились
        if (start >= end) {
            // заканчиваем работу
            return;
        }

        // начинаем сначала
        int i = start;
        // заканчиваем в конце
        int j = end;

        // позиция опорного элемента
        int curPosition = start - (start - end) / 2;

        // пока не дошли до конца
        while (i < j) {

            // пока мы еще левее чем опорный элемент и текущий элемент меньше опорного
            while(i < curPosition && array[i] <= array[curPosition]) {
                // идем вправо
                i++;
            }
            // пока мы правее чем опорный элемент и текущий больше опорного
            while(j > curPosition && array[j] >= array[curPosition]) {
                // идем влево
                j--;
            }
            // если у нас оба элемента слева и справа от опорного
            if (i < j) {
                // меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                // новый опорный
                if (i == curPosition) {
                    curPosition = j;
                } else if (j == curPosition) {
                    curPosition = i;
                }
            }
        }

        // рекурсивно для левой стороны от опорного
        quickSort(array, start, curPosition);
        // рекурсивно для правой стороны от опорного
        quickSort(array, curPosition + 1, end);
    }

    // глобальная переменная - доступна всем функциям, размер кучи
    public static int heapSize;

    // пирамидальная сортировка
    public static void heapSort(int array[]) {
        // строим кучу
        buildHeap(array);
        // пока куча не пустая
        while (heapSize > 1) {
            // меняем последний с первым
            swap(array, 0, heapSize - 1);
            // уменьшаем размер кучи
            heapSize--;
            // перестраиваем кучу
            heapify(array, 0);
        }
    }
    public static void buildHeap(int array[]) {
        // изначально размер кучи - размер массива
        heapSize = array.length;
        // начиная с серединки
        for (int i = array.length / 2; i >= 0; i--) {
            // перестраиваем кучу
            heapify(array, i);
        }
    }

    /**
     *
     * @param array куча
     * @param i узел дерева, для которого нужно выполнить перестроение - родитель
     */
    public static void heapify(int[] array, int i) {
        // левый сын
        int left = 2 * i + 2;
        // правый сын
        int right = 2 * i + 1;

        // предполагаем, что родитель - максимальный (largest - индекс максимального)
        int largest = i;

        // если есть левый сын и он больше - то он максимальный
        if (left < heapSize && array[i] < array[left]) {
            largest = left;
        }
        // если есть правый сын и он больше, чем левый либо родитель - то он максимальный
        if (right < heapSize && array[largest] < array[right]) {
            largest = right;
        }

        // если родитель - не максимальный
        if (i != largest) {
            // меняем местами
            swap(array, i, largest);
            // перестраиваем дерево относительно бывшего максимального
            heapify(array, largest);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }



    public static void main(String[] args) {
        int[] array = {4,8, 11, 16, 10, 6, 2, 5, 9, 1};
        //quickSort(array, 0 , array.length - 1);

        /*
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        */

        heapSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
