package LeetCode_2021_04.LeetCode_211;

import java.util.Calendar;

public class WordDictionary {

    static class TrieNode{
        boolean isEnd=false;
        TrieNode[] next=new TrieNode[26];
    }

    private TrieNode root;

    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node=root;
        for (char c : word.toCharArray()) {
            if (node.next[c-'a']==null){
                node.next[c-'a']=new TrieNode();
            }
            node=node.next[c-'a'];
        }
        node.isEnd=true;
    }

    public boolean search(String word) {
        return searchFromNode(root,word);
    }

    public boolean searchFromNode(TrieNode node,String word) {
        if (node==null){
            return false;
        }
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c=chars[i];
            if (chars[i]=='.'){
                for (int j=0;j<26;j++){
                    if (searchFromNode(node.next[j],word.substring(i+1))){
                        return true;
                    }
                }
                return false;
            }else {
                if (node.next[c-'a']==null){
                    return false;
                }else {
                    node=node.next[c-'a'];
                }
            }
        }
        return node.isEnd;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}
