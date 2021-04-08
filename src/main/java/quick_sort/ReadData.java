package quick_sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class ReadData {

    public static int[] readData(){
        int nums[] = new int[500000];

        try{
            FileReader fileReader = new FileReader("/Users/fring/IdeaProjects/Algorithm_practice/src/main/resources/10wdataset.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int i = 0;
            while((line = bufferedReader.readLine()) != null){
                nums[i] = Integer.valueOf(line);
                i++;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //；；System.out.println(Arrays.toString(nums));
        return nums;
    }

    public static void main(String[] args) {
        readData();
    }
}
