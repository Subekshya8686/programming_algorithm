
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
            return rightRotate(root);
        }
        else if(balancefactor>1 && data>root.left.data){
            //care LR
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }
        else if(balancefactor<1 && data>root.right.data){
            //care RR
            return leftRotate(root);
        }
        else if(balancefactor<1 && data<root.right.data){
            //care RL
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }
return root;
    }
    Node rightRotate(Node y){
       Node x=y.left;
       Node t2=x.right;
       x.right=y;
       y.left=t2;
       y.height=1+Math.max(getHeight(y.left),getHeight(y.right));
       x.height=1+Math.max(getHeight(x.right),getHeight(x.left));

      return x;
    }
    Node leftRotate(Node x){
        Node y=x.right;
        Node t2=y.left;
        y.left=x;
        x.right=t2;
        x.height=1+Math.max(getHeight(x.right),getHeight(x.left));
        y.height=1+Math.max(getHeight(y.left),getHeight(y.right));
        return y;

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

