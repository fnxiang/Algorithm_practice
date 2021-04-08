package leetcode;

public class No1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        /** 三种返回值 */
        int ans = 0;

        /** 先判断是否可以完全遍历（利用并查集） */
        UnionFind alice_union = new UnionFind(n);
        UnionFind bob_union = new UnionFind(n);

        for (int[] edge : edges){
            if(edge[0] == 3){
                if(!alice_union.merge(edge[1]-1, edge[2]-1)) ans++;
                else bob_union.merge(edge[1]-1, edge[2]-1);
            }
        }

        for (int[] edge : edges){

            if(edge[0]==1&&!alice_union.merge(edge[1]-1, edge[2]-1))ans++;

            if(edge[0]==2&&!bob_union.merge(edge[1]-1, edge[2]-1)) ans++;
        }

        if(alice_union.unionCount!=1||bob_union.unionCount!=1) return -1;


        return ans;

    }

    class UnionFind{
        int [] parent;
        /** 记录有几个根结点 */
        int unionCount;

        public  UnionFind(int n){
            parent = new int[n];
            unionCount = n;

            for(int i=0;i<unionCount;i++){
                parent[i]=i;
            }
        }

        public int findParent(int x){
            return x!=parent[x]? findParent(parent[x]):parent[x];
        }

        public boolean merge(int x, int y){
            int px = findParent(x);
            int py = findParent(y);

            if(px==py) return false;

            parent[px] = py;
            unionCount--;
            return true;
        }
    }
}
