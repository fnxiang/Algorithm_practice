package leetcode;

public class No191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            int tmp = n%10;
            if(tmp==1) {
                count++;
            }
            n=n/10;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 0000111101;
        No191 obj = new No191();
        System.out.println(obj.hammingWeight(n));
    }
}
