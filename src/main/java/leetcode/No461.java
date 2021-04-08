package leetcode;

public class No461 {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        if(x>y) {
            x=y+x;
            y=x-y;
            x=x-y;
        }
        y=x|y;
        while(y>x){
            y=y>>1;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        No461 obj = new No461();
        System.out.println(obj.hammingDistance(93, 73));
    }
}
