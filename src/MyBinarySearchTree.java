public class  MyBinarySearchTree {

    private BSTNode<Integer> root;

    public BSTNode<Integer> search(BSTNode<Integer> root, int key) {
        if (root == null || root.getData() == key) {
            return root;
        }

        if (root.getData() < key) {
            return search(root.getRight(), key);
        }

        return search(root.getLeft(), key);
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private BSTNode<Integer> insert(BSTNode<Integer> root, int key) {
        if (root == null) {
            root = new BSTNode<>(key, null, null);
            return root;
        }

        if (key < root.getData()) {
            root.left = insert(root.left, key);
        } else if (key > root.getData()) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(BSTNode<Integer> root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.getData() + " ");
            inorder(root.right);
        }
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(BSTNode<Integer> root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.getData() + " ");
        }
    }


}
