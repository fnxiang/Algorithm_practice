package tools;

import java.io.BufferedReader;
import java.util.Scanner;

public class ali {
    public int contact(String input){
        int ans = -1, step = 0;
        String[] lines = input.split("\n");
        String[] tmp = lines[0].split(" ");
        UnionFind union = new UnionFind(Integer.valueOf(tmp[0]));
        step = Integer.valueOf(tmp[1]);
        for(int i=1;i<step+1;i++){
            String[] contect_tmp = lines[i].split(" ");
            union.merge(Integer.valueOf(contect_tmp[0]), Integer.valueOf(contect_tmp[0]));
        }
        int num_cont = Integer.valueOf(lines[step+1]);
//        System.out.println(num_cont);
        for(int j=step;j<step+num_cont;j++){
            String[] ob_tmp = lines[j].split(" ");
            if(Integer.valueOf(ob_tmp[1])==union.find(Integer.valueOf(ob_tmp[0]), ans)){
                System.out.println(ans);
            }else{
                System.out.println(-1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ali obj = new ali();
        Scanner scanner = new Scanner(System.in);
        obj.contact("3 2\n" +
                "1 2\n" +
                "2 3\n" +
                "2\n" +
                "1 3\n" +
                "3 1");
    }

    class UnionFind{
        int[] parent;
        int union_count = 0;
        public UnionFind(int n){
            parent = new int[n];
            union_count = n;
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        public int find(int x, int times){
            times++;
            return x==parent[x]?parent[x]:find(parent[x], times);
        }

        public int find_cont(int x, int y){
            return parent[x];
        }

        public boolean merge(int x, int y){
            int fx = find(x, 0);
            int fy = find(y, 0);

            if(fx==fy) return false;

            parent[x]=y;
            return true;
        }
    }

}
