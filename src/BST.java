public class BST {
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }

    Node createBST(Node rootnode, int data){
        if(rootnode==null){
            return new Node(data);
        }
        if(data< rootnode.data){
            rootnode.left=createBST(rootnode.left,data);
        }
        else if(data> rootnode.data){
            rootnode.right=createBST(rootnode.right,data);
        }
        return rootnode;
    }
}
