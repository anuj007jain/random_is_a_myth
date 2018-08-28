package com.GeeksForGeeks.Tree;

/**
 * Created by anuj on 5/5/16.
 */
public class Height_Of_Binary_Tree_Using_Parent_Array {


    int maxCount =0;
    private void findHeight(int i,int[] parent){
        if(i == parent.length)
            System.out.println(maxCount);
        else{
            int count = 0;
            int x = i;
            while(x != -1){
                x = parent[x];
                count++;
            }
            if(count>maxCount)
                maxCount = count;
        }
        findHeight(i+1,parent);
    }

    public static void main(String[] args) {

        Height_Of_Binary_Tree_Using_Parent_Array hobtupa = new Height_Of_Binary_Tree_Using_Parent_Array();
        int[] parent = {-1, 0, 0, 1, 1, 3, 5};
        hobtupa.findHeight(0,parent);
    }

}
