package quick_sort;

public class InsertionSort {

    public static void main(String[] args) {
        int[] o_arr = ReadData.readData();
        InsertionSort insertionSort = new InsertionSort();
        int[] result = insertionSort.insertSort(o_arr);
       // System.out.println(Arrays.toString(result));
    }


    //实现简单插入排序
    public int[] simplelyInsertionSort(int[] o_arr){
        long start = System.currentTimeMillis();
        int preIndex;
        int current;
        for(int i=1;i<o_arr.length;i++){
            preIndex = i-1;
            current=o_arr[i];
            while(preIndex>=0&&current<o_arr[preIndex]){
                o_arr[preIndex+1] = o_arr[preIndex];
                preIndex--;
            }

        }
        long end = System.currentTimeMillis();
        System.out.println(String.valueOf(end - start));
        return o_arr;
    }

    public int[] insertSort(int[] nums){
        long start = System.currentTimeMillis();
        for(int i = 1; i < nums.length; i++){
            int value = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > value){
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = value;
        }
        System.out.println("Insertion sort cost time: "+String.valueOf(System.currentTimeMillis()-start)+"ms");
        return nums;
    }
}
