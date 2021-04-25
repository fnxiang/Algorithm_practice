package com.fring.nums;

public class NumsPractice {
    public int minArray(int[] numbers) {
        int length = numbers.length;
        int l = 0;
        int r = length-1;
        while(l<r&&numbers[l]==numbers[r]) l++;
        while(l<r){
            int mid = l+(r-l)>>1;
            if(numbers[mid]>numbers[0]){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        return (r+1)<=length?numbers[r+1]:numbers[0];
    }
}
