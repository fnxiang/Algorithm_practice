package leetcode;

/**
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 */

class Solution {
    int[] set = new int[1000];
    public int find(int i){
        if(i==set[i])
            return i;
        else
            return set[i]=find(set[i]);
    }

    public void joint(int i, int j){
        i=find(i);
        j=find(j);
        set[j]=i;
    }

    public boolean same(int i, int j){
        i=find(i);
        j=find(j);
        return i==j;
    }

    public int[] findRedundantConnection(int[][] edges) {

        for(int i=0;i<1000;i++){
            set[i]=i;
        }

        for (int[] value: edges) {
            if(same(value[0], value[1])) return value;
            else joint(value[0], value[1]);
        }
        return null;
    }
}
