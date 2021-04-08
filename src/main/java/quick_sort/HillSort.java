package quick_sort;

public class HillSort {

    public static void main(String[] args) {
        int[] array = ReadData.readData();
        HillSort hillSort = new HillSort();
        hillSort.sort(array);
    }

    public  void sort(int[] array) {
        long start_time = System.currentTimeMillis();
        int number = array.length / 2;
        int i;
        int j;
        int temp;
        while (number >= 1) {
            for (i = number; i < array.length; i++) {
                temp = array[i];
                j = i - number;
                while (j >= 0 && array[j] > temp) { //需要注意的是，这里array[j] > temp将会使数组从小到到排序。
                    array[j + number] = array[j];
                    j = j - number;
                }
                array[j + number] = temp;
            }
            number = number / 2;
        }

        System.out.println("Hill sort cost time :" + String.valueOf(System.currentTimeMillis() - start_time)+ "ms");
    }
}
