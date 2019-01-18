/*
package com.GeeksForGeeks.Tree;

import java.util.LinkedList;

public class Google_Delete_Nodes {

    class Node {
        String val;
    }

    public List<String> solution = new ArrayList<>();

    public List<Node> RootsAfterDeletion(Node node) {
        RootsAfterDeletionInternal(null, 0, node, true); //check if 1st node is deleted while dry run
        return solution;
        LinkedList ll = new LinkedList();
    }

    public void RootsAfterDeletionInternal(Node prevNode, boolean movement, Node node, boolean lastNodeDeleted) {
        boolean deleted = false;
//terminal condition
        if(node == null) {
            return;
        }

        if(shouldBeErased(node)) {
            if(!lastNodeDeleted) {
                if(!movement) {
                    prevNode.left = null;
                } else {
                    prevNode.right = null;
                }
            }
            deleted = true;
        }
        else if(lastNodeDeleted) {
            solution.add(node.val); //make node class with val as string
        }
        RootsAfterDeletionInternal(node, false, node.left, deleted);
        RootsAfterDeletionInternal(node, true, node.right, deleted);
        return;
    }


}
*/
