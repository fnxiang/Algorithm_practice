package leetcode;

public class No706 {
    /** value will always be non-negative. */
    int[] values = new int[1000009];

    public No706() {
        for(int i=0;i<1000009;i++){
            values[i] = -1;
        }
    }

    public void put(int key, int value) {
        values[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return values[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        values[key] = -1;
    }
}
