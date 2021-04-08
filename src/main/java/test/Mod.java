package test;

import java.util.HashSet;

public class Mod {
    public String divide(int i, int j){
        HashSet<Integer> set = new HashSet<>();
        float _f=1;
        float ans = 0;
        while(i<j){
            i*=10;
            _f*=0.1;
        }
        while(!set.contains(i)){
            set.add(i);
            int mod=i%j;
            int time = i/j;
            ans+=_f*time;
            _f*=0.1;
            if(mod==0) {
                return String.valueOf(ans);
            }
            i=mod*10;
        }
        String value = String.valueOf(ans);
        String[] list  = value.split("\\.");
        return "0.("+list[1]+")";
    }

    public static void main(String[] args) {
        Mod obj = new Mod();
        System.out.println(obj.divide(1,7));
    }
}
