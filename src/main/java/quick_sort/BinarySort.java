package quick_sort;

public class BinarySort {

    public static void main(String[] args) {
        int[] o_arr = ReadData.readData();
        BinarySort binarySort = new BinarySort();
        binarySort.sort(o_arr);
    }

    public void sort(int[] a){
        long start_time = System.currentTimeMillis();
        //插入排序
        // 外循环规定从第二个元素开始，将元素插入到已排好的数组中
        for (int i = 1; i < a.length; i++) {
            //得到插入的位置
            int k = findByBinary(a, i);
            //保存a[i]
            int key = a[i];
            //元素后移
            for (int j = i - 1; j >= k; j--) {
                a[j + 1] = a[j];
            }
            a[k] = key;
        }
        System.out.println("Binary Sort cost time :" + String.valueOf(System.currentTimeMillis() - start_time)+"ms");
    }

    public static int findByBinary(int[] a, int i) {
        int highIndex = i - 1;
        int lowIndex = 0;
        int mid = -1;
        while (lowIndex <= highIndex) {
            mid = (highIndex + lowIndex) / 2;
            if (a[i] >= a[mid]) {
                //若相等，保证新元素插在旧元素后面
                lowIndex = mid + 1;
            } else {
                highIndex = mid - 1;
            }
        }
        return lowIndex;
    }
}
