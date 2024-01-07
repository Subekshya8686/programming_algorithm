
public class AVLTree {
    public static class  Node{
        Node left;
        Node right;
        int data;
        int height;
        Node(int data){
            this.data=data;
            this.left=this.right=null;
            this.height=1;
        }
    }

    Node createBST(Node root, int data){
        if(root==null){
            return new Node(data);
        }
        if(data< root.data){
            root.left=createBST(root.left, data);
        }
        else if (data> root.data){
            root.right=createBST(root.right,data);
        }
        else {
            return root;
        }
        root.height=1+Math.max(getHeight(root.left), getHeight(root.right));
        int balancefactor=getBalanceFactor(root);
        if(balancefactor>1 && data<root.left.data){
            //case ll
        }
        else if(balancefactor>1 && data>root.left.data){
            //care LR
        }



    }
    int getBalanceFactor(Node node){
        if(node==null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node
                .right);
    }

    int getHeight(Node node){
        if(node==null){
            return  0;
        }
        return node.height;
    }
}

