public class MyBinarySearchTree {

    public static void main(String[] args) {
        MyBinarySearchTree mbt = new MyBinarySearchTree();
        Node root = new Node(10);

        mbt.insert(root, 1);
        mbt.insert(root, 12);
        mbt.insert(root, 31);
        mbt.insert(root, 15);
        mbt.inOrder(root);

        System.out.println("******************");
        mbt.delete(root, 12);
        mbt.inOrder(root);

    }

    public void test(Node root, int x) {
        root = new Node(x);
    }
    static class Node {
        Node left;
        Node right;
        public int val;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public Node insert(Node root, int x) {
        if (root == null) {
            root = new Node(x);
            return root;
        }

        if (x < root.val) {
            root.left = insert(root.left, x);
        } else {
            root.right = insert(root.right, x);
        }
        return root;
    }


    public Node delete(Node root, int x) {
        if (root == null) {
            return root;
        }

        if (x < root.val) {
            root.left = delete(root.left, x);
        } else if (x > root.val) {
            root.right = delete(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            int min = getMin(root.right);
            root.val = min;
            root.right = delete(root.right, min);
        }
        return root;
    }
    // why wrong
/*    public void insert1(Node root, int x) {
        if (root == null) {
            root = new Node(x);
            return;
        }

        if (x < root.val) {
            insert1(root.left, x);
        } else {
            insert1(root.right, x);
        }
    }*/


    public Node search(Node root, int x){
        if (root == null) return null;
        if (root.val == x) {
            return root;
        }

        if (x < root.val) {
            return search(root.left, x);
        } else {
            return search(root.right, x);
        }
    }



    public int getMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
