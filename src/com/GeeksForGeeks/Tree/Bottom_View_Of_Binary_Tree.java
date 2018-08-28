package com.GeeksForGeeks.Tree;

import java.util.*;

/**
 * Created by anuj on 5/5/16.
 */
public class Bottom_View_Of_Binary_Tree {

    Map<Integer,Integer> map = new HashMap<>();

    private void printBottomView(Node node, int width){
        if(!map.containsKey(width))
            map.put(width,node.key);
        else if(width<=0)
            map.put(width,node.key);

        if(node.left!=null){
            width--;
            printBottomView(node.left,width);
        }
        if(node.right!=null){
            width+=2;
            printBottomView(node.right,width);
        }
    }

    private void printMap(){
        Iterator iterator = map.keySet().iterator();

        List<Integer> arr = new ArrayList();
        while (iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            arr.add(key);
        }
        Collections.sort(arr);
        for(Integer i : arr){
            System.out.print(map.get(i)+" ");
        }
    }

    public static void main(String[] args) {

        Bottom_View_Of_Binary_Tree btobt = new Bottom_View_Of_Binary_Tree();
        Binary_Tree bt = new Binary_Tree();
        bt.root = new Node(20);
        bt.root.left = new Node(8);
        bt.root.right = new Node(22);
        bt.root.left.left = new Node(5);
        bt.root.left.right = new Node(3);
        bt.root.right.left = new Node(4);
        bt.root.right.right = new Node(25);
        bt.root.left.right.left = new Node(10);
        bt.root.left.right.right = new Node(14);

        btobt.printBottomView(bt.root,0);
        btobt.printMap();

    }
}
