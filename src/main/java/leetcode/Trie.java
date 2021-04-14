package leetcode;
class TrieNode{
    boolean is_end;
    TrieNode[] nums=new TrieNode[26];
}

/** 前缀树的实现 */
public class Trie {

    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tmp = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(tmp.nums[index]==null) tmp.nums[index] = new TrieNode();
            tmp = tmp.nums[index];
        }
        tmp.is_end = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tmp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i)-'a';
            if(tmp.nums[index]==null) return false;
            tmp = tmp.nums[index];
        }
        return tmp.is_end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i)-'a';
            if(tmp.nums[index]==null) return false;
            tmp = tmp.nums[index];
        }
        return true;
    }
}
