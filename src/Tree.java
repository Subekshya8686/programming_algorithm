public class Tree {

    public static class Node{
        Node left;
        Node right;
        int data;

        Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }

    void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    void preorder(Node root){
        if(root==null) return;
        System.out.println(root.data);
        inorder(root.left);
        inorder(root.right);
    }

    void postorder(Node root){
        if(root==null) return;
        inorder(root.left);
        inorder(root.right);
        System.out.println(root.data);
    }


    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(50);
        root.left.left=new Node(30);
        root.left.right=new Node(50);
    }
}
