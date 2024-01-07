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

    Node deleteNode(Node root, int data){
        if(root==null){
            return null;
        }
        if(data< root.data){
            root.left=deleteNode(root.left,data);
        }
        else if(data> root.data){
            root.right=deleteNode(root.right,data);
        }
        else {
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                root.data=findMin(root.right);
                root.right=deleteNode(root.right,root.data);

            }
        }
      return root;
    }

    int findMin(Node root){
        int min=root.data;
        while (root.left!=null){
            root=root.left;
            min= root.data;
        }
        return min;
    }


}
