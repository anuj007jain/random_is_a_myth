package com.GeeksForGeeks.Tree;

import java.util.*;

/**
 * Created by anuj on 5/5/16.
 */
public class Top_View_Of_Binary_Tree {


    Map<Integer, Integer> map = new HashMap<>();

    private void printMap(){
        Iterator iterator = map.keySet().iterator();

        List<Integer> arr = new ArrayList();
        while (iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            Integer value = map.get(key);

            arr.add(key);
        }
        Collections.sort(arr);
        for(Integer i : arr){
            System.out.print(map.get(i)+" ");
        }
    }

    private void printTopView(Node node, int width){

        if(!map.containsKey(width))
            map.put(width,node.key);
        if(width>0)
            map.put(width,node.key);

        //System.out.println(node.key+ " "+width);
        if(node.left!=null) {
            width--;
            printTopView(node.left,width);
        }

        //System.out.println(node.key+" "+width);
        if(node.right!=null) {
            width+=2;
            printTopView(node.right, width);
        }

    }

    public static void main(String[] args) {

        Top_View_Of_Binary_Tree tvobt = new Top_View_Of_Binary_Tree();

        Binary_Tree t = new Binary_Tree();
        t.root=new Node(20);
        t.root.left=new Node(8);
        t.root.right=new Node(22);
        t.root.left.left=new Node(5);
        t.root.left.right=new Node(3);
        t.root.left.right.left=new Node(10);
        t.root.left.right.right=new Node(14);
        t.root.left.right.right.right=new Node(13);
        t.root.left.right.right.right.right=new Node(12);
        t.root.right.right=new Node(25);

        tvobt.printTopView(t.root,0);
        tvobt.printMap();


    }

}
