package com.GeeksForGeeks.Tree;

/**
 * Created by anuj.jain02 on 5/6/16.
 */

//http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
public class Check_If_A_Binary_Tree_Is_A_Subset_Of_Another_Binary_Tree {

    int flag = 0;
    private void isSubTree(Node treeNode, Node subtreeNode){

        if(treeNode.key == subtreeNode.key){
            if(treeNode.left != null && subtreeNode.left !=null && flag!=-1)
                isSubTree(treeNode.left,subtreeNode.left);
            if(treeNode.right != null && subtreeNode.right != null && flag!=-1)
                isSubTree(treeNode.right, subtreeNode.right);
            if(flag!=-1 && treeNode.left == null && treeNode.right == null && subtreeNode.left == null && subtreeNode.right == null)
                flag = 1;
        }
        else
            flag=-1;
    }

    private void CheckIfSubTreeUtil(Node treeNode, Node subtreeNode){

        if(treeNode.key != subtreeNode.key) {
            if (treeNode.left != null)
                CheckIfSubTreeUtil(treeNode.left, subtreeNode);
            if(treeNode.right != null)
                CheckIfSubTreeUtil(treeNode.right,subtreeNode);
        }
        else{
            flag=0;
            isSubTree(treeNode,subtreeNode);
            if(flag == 1) {
                System.out.print("True");
            }
        }


    }

    public static void main(String[] args) {

        Check_If_A_Binary_Tree_Is_A_Subset_Of_Another_Binary_Tree ciabtiasoabt = new Check_If_A_Binary_Tree_Is_A_Subset_Of_Another_Binary_Tree();

        Binary_Tree tree1 = new Binary_Tree();
        tree1.root = new Node(10);
        tree1.root.left = new Node(4);
        tree1.root.right = new Node(6);
        tree1.root.left.right = new Node(30);

        Binary_Tree tree2 = new Binary_Tree();
        tree2.root = new Node(26);
        tree2.root.left = new Node(10);
        tree2.root.right = new Node(3);
        tree2.root.left.left = new Node(4);
        tree2.root.left.right = new Node(6);
        tree2.root.right.right = new Node(3);
        tree2.root.left.left.right = new Node(30);

        ciabtiasoabt.CheckIfSubTreeUtil(tree2.root,tree1.root);



    }

}
