package edu.test;
public class BinaryTree {  
    
    private Node root;  
      
    /**  
     *   
     * 内部节点类  
     *   
     * @author yhh  
     */  
    private class Node {  
        private Node left;  
        private Node right;  
        private float data;  
          
        public Node(float data) {  
            this.left = null;  
            this.right = null;  
            this.data = data;  
        }  
    }  
      
    public BinaryTree() {  
        root = null;  
    }  
      
    /**  
     * 递归创建二叉树  
     *   
     * @param node  
     * @param data  
     */  
    public void buildTree(Node node, float data) {  
        if (root == null) {  
            root = new Node(data);  
        }  
        else {  
            if (data < node.data) {  
                if (node.left == null) {  
                    node.left = new Node(data);  
                }  
                else {  
                    buildTree(node.left, data);  
                }  
            }  
            else {  
                if (node.right == null) {  
                    node.right = new Node(data);  
                }  
                else {  
                    buildTree(node.right, data);  
                }  
            }  
        }  
    }  
      
    /**  
     * 前序遍历  
     *   
     * @param node  
     */  
    public void leftOrder(Node node) {  
        if (node != null) {  
            System.out.print(node.data + "  ");  
            leftOrder(node.left);  
            leftOrder(node.right);  
        }  
    }  
      
    /**  
     * 中序遍历  
     *   
     * @param node  
     */  
    public void middleOrder(Node node) {  
        if (node != null) {  
            middleOrder(node.left);  
            System.out.print(node.data + "  ");  
            middleOrder(node.right);  
        }  
    }  
      
    /**  
     * 后序遍历  
     *   
     * @param node  
     */  
    public void rightOrder(Node node) {  
        if (node != null) {  
            rightOrder(node.left);  
            rightOrder(node.right);  
            System.out.print(node.data + "  ");  
        }  
    }  
      
    public static void main(String[] args) {  
    	float[] a = { 10,5,15,3,7,13,17,2,4,6,8,12,14,16,18,1,(float) 2.5,(float) 3.5,(float) 4.5};  
        BinaryTree bTree = new BinaryTree();  
          
        for (int i = 0; i < a.length; i++) {  
            bTree.buildTree(bTree.root, a[i]);  
        }  
          
        System.out.print("\n前序遍历 ： ");  
        bTree.leftOrder(bTree.root);  
        System.out.print("\n中 序遍历 ： ");  
        bTree.middleOrder(bTree.root);  
        System.out.print("\n后 序遍历 ： ");  
        bTree.rightOrder(bTree.root);  
    }  
      
}  