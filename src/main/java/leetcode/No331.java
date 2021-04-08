package leetcode;

public class No331 {
    public boolean isValidSerialization(String preorder) {
        String[] list = preorder.split(",");
        if ((list.length)%2!=1) return false;
        int diff = 1;
        for(int i=0;i<list.length;i++){
            diff-=1;
            if(diff<0) return false;
            if(!list[i].equals("#")) diff+=2;
        }
        return diff == 0;
    }

    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        No331 solution = new No331();
        solution.isValidSerialization(preorder);
    }
}
