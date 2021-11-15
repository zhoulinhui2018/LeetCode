package LeetCode_2021_04.LeetCode_208;

public class Trie {
    static class TrieNode{
        boolean isEnd=false;
        TrieNode[] next=new TrieNode[26];
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c-'a']==null){
                node.next[c-'a']=new TrieNode();
            }
            node=node.next[c-'a'];
        }
        node.isEnd=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node=root;
        for (char c : word.toCharArray()) {
            if (node.next[c-'a']==null){
                return false;
            }
            node=node.next[c-'a'];
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node=root;
        for (char c : prefix.toCharArray()) {
            if (node.next[c-'a']==null){
                return false;
            }
            node=node.next[c-'a'];
        }
        return true;
    }

    public void quickSort(int[] arr,int l,int r){
        if (l<r){
            int partition = partition(arr, l, r);
            quickSort(arr, l,partition-1);
            quickSort(arr, partition+1,r);
        }
    }

    public int partition(int[] arr,int l,int r){
        int temp=arr[l];
        int i=l,j=r;
        while (i<j){
            while (i<j&&arr[j]>temp){
                j--;
            }
            arr[i]=arr[j];
            while (i<j&&arr[i]<=temp){
                i++;
            }
            arr[j]=arr[i];
        }
        arr[i]=temp;
        return i;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        int[] arr = {5, 4, 1, 2, 3};
        trie.quickSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
