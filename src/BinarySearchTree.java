import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    static Node larger =null;
    static class Node {
//        Node root;
        Integer key;
        Node left;
        Node right;


        public Node(int key) {
            this.key = key;
        }

        public Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
//            this.root = parent;
        }

        public Node() {

        }
        boolean isGreater(Node node){
            if(this.key> node.key)
                return true;
            return false;
        }

        Node leftNode(Node node) {
            if(left==null)
                left = new Node();
            return left;
        }

        Node rightNode(Node node) {
            if(right==null)
                right = new Node();
            return right;
        }
        void insert(Node node) {
            if(key==null) {
                this.key = node.key;
//                this.root = node;

            }
            else{
                 if( isGreater(node))
                     leftNode(node).insert(node);
                 else
                     rightNode(node).insert(node);

            }
        }

        public Node immediateSuccessor(Node node) {

            if(key==null)
                return larger;
            else{
                if(this.key>node.key)
                    larger=this;

                if(isGreater(node)){
                    if( leftNodeExists(this))
                        return left.immediateSuccessor(node);
                    return larger;
                }else{
                    if( rightNodeExists(this))
                        return right.immediateSuccessor(node);
                    return larger;
                }
            }
        }

        private boolean leftNodeExists(Node node) {
            if(node.left!=null)
                return true;
            return false;
        }
        private boolean rightNodeExists(Node node) {
            if(node.right!=null)
                return true;
            return false;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree.Node node = new Node();
        List<Integer> digits = new ArrayList<>();
        digits.add(20);
        digits.add(9);
        digits.add(25);
        digits.add(5);
        digits.add(12);
        digits.add(11);
        digits.add(14);
        for (Integer i:digits
             ) {
            node.insert(new Node(i));
        }
//        node.insert(20);
//        node.insert(5);
    Node immediateSuccessor = node.immediateSuccessor(new Node(9));
        System.out.println(immediateSuccessor.key);
    }
}
