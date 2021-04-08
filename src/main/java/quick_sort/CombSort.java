package quick_sort;

public class CombSort {
    public static int[] combSort(int nums[]){
        int gap_length = nums.length;
        float shrink_factor = 1.3f;
        boolean swapped = false;

        long start=System.currentTimeMillis();

        while(gap_length > 1 || swapped){
            if(gap_length > 1){
                gap_length = (int)(gap_length/shrink_factor);
            }
            swapped = false;

            for(int i=0;gap_length+i < nums.length; i++){
                if(nums[i] > nums[i+gap_length]){
                    swap(nums, i, i+gap_length);
                    swapped = true;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("cost time："+String.valueOf(end-start)+"ms");
        return nums;
    }

    public static void swap(int nums[], int x, int y){
        Integer temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {12, 3, 17, 56, 13, 1, 88, 55, 67, 98, 45};
        combSort(ReadData.readData());
        //System.out.println(Arrays.toString(combSort(quick_sort.ReadData.readData())));
    }
}
