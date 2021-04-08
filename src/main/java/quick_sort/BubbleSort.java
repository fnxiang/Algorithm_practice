package quick_sort;

public class BubbleSort {

    public static int[] bubbleSort(int nums[]){
        long start = System.currentTimeMillis();
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("cost time: "+String.valueOf(end-start)+"ms");
        return nums;
    }

    public static void main(String[] args) {
        int nums[] = {1, 5, 4, 8, 2, 12, 19, 14};
        bubbleSort(ReadData.readData());
        //System.out.println(Arrays.toString(bubbleSort(quick_sort.ReadData.readData())));
    }
}
