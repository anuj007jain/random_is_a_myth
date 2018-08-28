package com.GeeksForGeeks.Tree;

/**
 * Created by anuj on 19/5/16.
 */

//http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
public class Check_If_Binary_Tree_Is_BST {

    private boolean isBSTUtil(Node node, int min, int max){


        if(node==null)
            return true;
        else if(node.key < min || node.key > max)
            return false;


            return isBSTUtil(node.left,min,node.key) &&
            isBSTUtil(node.right,node.key,max);
    }

    private void isBST(Binary_Tree tree){
        if(isBSTUtil(tree.root,Integer.MIN_VALUE,Integer.MAX_VALUE))
            System.out.print("True");
        else
            System.out.print("False");
    }

    int k = 0;
    private void isBSTUsingInOrder(Node node,int[] arr){
        if(node == null)
            return;
        if(node.left!=null)
            isBSTUsingInOrder(node.left,arr);

        arr[k++] = node.key;

        if(node.right!=null)
            isBSTUsingInOrder(node.right,arr);

    }

    public static void main(String[] args) {
        Check_If_Binary_Tree_Is_BST cibtibst = new Check_If_Binary_Tree_Is_BST();
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        cibtibst.isBST(tree);
        int[] arr = new int[5];
        cibtibst.isBSTUsingInOrder(tree.root,arr);
        int i;
        for(i = 1; i < 5 ; i++){
            if(arr[i]> arr[i-1])
                continue;
            else
                break;
        }
        if(i==5)
            System.out.print("True");
        else
            System.out.print("False");
    }

}
