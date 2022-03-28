package xyz.squig;

public class Tree {
    TreeNode head;
    public Tree(){
        head = null;
    }

    public void addTreeNode(int rank, int x, int y, int xa, int ya){
        TreeNode newTreeNode = new TreeNode();
        newTreeNode.rank = rank;
        newTreeNode.x = x;
        newTreeNode.y = y;
        newTreeNode.xa = xa;
        newTreeNode.ya = ya;
        if(head == null){
            head = newTreeNode;
        }
        else{
            TreeNode current = head;
            TreeNode parent;
            while(true){
                parent = current;
                if(rank < current.rank){
                    current = current.leftTreeNode;
                    if(current == null){
                        parent.leftTreeNode = newTreeNode;
                        break;
                    }
                }
                else{
                    current = current.rightTreeNode;
                    if(current == null){
                        parent.rightTreeNode = newTreeNode;
                        break;
                    }
                }
            }

        }
    }
}
