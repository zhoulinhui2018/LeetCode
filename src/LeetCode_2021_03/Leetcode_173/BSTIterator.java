package LeetCode_2021_03.Leetcode_173;

import LeetCode_2021_03.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;

public class BSTIterator {

    private ArrayList<Integer> arrayList;
    private Iterator<Integer> iterator;

    public BSTIterator(TreeNode root) {
        arrayList=new ArrayList<>();
        inorderTravelsal(root);
        iterator=arrayList.iterator();
    }

    void inorderTravelsal(TreeNode root){
        if (root==null){
            return;
        }
        inorderTravelsal(root.left);
        arrayList.add(root.val);
        inorderTravelsal(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return iterator.next();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return iterator.hasNext();
    }
}
