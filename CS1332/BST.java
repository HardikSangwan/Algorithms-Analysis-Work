import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your implementation of a binary search tree.
 *
 * @author Hardik Sangwan
 * @version 1.14
 */
public class BST<T extends Comparable<? super T>> implements BSTInterface<T> {
    // DO NOT ADD OR MODIFY INSTANCE VARIABLES.
    private BSTNode<T> root;
    private int size;

    /**
     * A no argument constructor that should initialize an empty BST.
     * YOU DO NOT NEED TO IMPLEMENT THIS CONSTRUCTOR!
     */
    public BST() {
    }

    /**
     * Initializes the BST with the data in the Collection. The data in the BST
     * should be added in the same order it is in the Collection.
     *
     * @param data the data to add to the tree
     * @throws IllegalArgumentException if data or any element in data is null
     */
    public BST(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("The data provided is null");
        }
        for (T a : data) {
            add(a);
        }
    }

    @Override
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data provided is null");
        }
        size++;
        root = addR(root, data);
    }

    /**
    * Helper method to add to the BST recusivley
    * @param node the node that we are currently traversing
    * @param data the data that we want to add to the BST
    * @return the node added
    */
    private BSTNode<T> addR(BSTNode<T> node, T data) {
        if (node == null) {
            return new BSTNode<>(data);
        }
        if (data.compareTo(node.getData()) == 0) {
            size--;
            return node;
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(addR(node.getLeft(), data));
        } else {
            node.setRight(addR(node.getRight(), data));
        }
        return node;
    }

    @Override
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data provided is null");
        }
        root = removeR(root, data);
        size--;
        //return data;
        return root.getData(); // the correct way of doing it
    }

    /**
     * Helper method to use recursion to remove a particular node
     * @param node the node we are currently traversing
     * @param data the data we need to be removed
     * @return the node
     */
    private BSTNode<T> removeR(BSTNode<T> node, T data) {
        if (node == null) {
            throw new java.util.NoSuchElementException("Data does not exist");
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(removeR(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(removeR(node.getRight(), data));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                node.setData(getSuccessor(node.getRight()));
                node.setRight(removeR(node.getRight(), node.getData()));
            }
        }
        return node;
    }

    /**
     * Helper method for the remove method to get an element's successor
     * @param node the node which we are currently traversing
     * @return the data of the successor
     */
    private T getSuccessor(BSTNode<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getData();
    }

    @Override
    public T get(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data provided is null");
        }
        return getR(root, data).getData();
    }

    /**
     * Helper method to use recursion to get the data
     * @param node the node we are currently traversing
     * @param data the data which we need to look for
     * @return the node
     */
    private BSTNode<T> getR(BSTNode<T> node, T data) {
        if (node == null) {
            throw new java.util.NoSuchElementException("Data  does not exist");
        }
        if (data.compareTo(node.getData()) == 0) {
            return node;
        } else if (data.compareTo(node.getData()) < 0) {
            return getR(node.getLeft(), data);
        } else {
            return getR(node.getRight(), data);
        }
    }

    @Override
    public boolean contains(T data) {
        try {
            get(data);
            return true;
        } catch (java.util.NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<T> preorder() {
        return preorderR(root);
    }

    /**
    * Helper Method to traverse the list in preorder using recursion
    * @param node the node we are currently traversing
    * @return list the list that contains the data from the tree
    */
    private List<T> preorderR(BSTNode<T> node) {
        ArrayList<T> result = new ArrayList<>();
        if (node != null) {
            result.add(node.getData());
            result.addAll(preorderR(node.getLeft()));
            result.addAll(preorderR(node.getRight()));
        }
        return result;
    }

    @Override
    public List<T> postorder() {
        return postorderR(root);
    }

    /**
     * Helper method for the postorder traversal
     * @param node the current node from the traversal
     * @return the list containing the traversal
     */
    private List<T> postorderR(BSTNode<T> node) {
        ArrayList<T> result = new ArrayList<>();
        if (node != null) {
            result.addAll(postorderR(node.getLeft()));
            result.addAll(postorderR(node.getRight()));
            result.add(node.getData());
        }
        return result;
    }

    @Override
    public List<T> inorder() {
        return inorderR(root);
    }

    /**
    * Helper Method to traverse the list in inorder using recursion
    * @param node the node we are currently traversing
    * @return list the list that contains the data from the tree
    */
    private List<T> inorderR(BSTNode<T> node) {
        ArrayList<T> result = new ArrayList<>();
        if (node != null) {
            result.addAll(inorderR(node.getLeft()));
            result.add(node.getData());
            result.addAll(inorderR(node.getRight()));
        }
        return result;
    }

    @Override
    public List<T> levelorder() {
        ArrayList<T> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<BSTNode<T>> q = new LinkedList<BSTNode<T>>();
        q.add(root);
        while (!q.isEmpty()) {
            BSTNode<T> node = q.poll();
            result.add(node.getData());
            if (node.getLeft() != null) {
                q.add(node.getLeft());
            }
            if (node.getRight() != null) {
                q.add(node.getRight());
            }
        }
        return result;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public int height() {
        return heightR(root);
    }

    /**
     * Helper method to use recursion to find the height of a particular node
     * @param node the node we are currently traversing
     * @return the height of the node
     */
    private int heightR(BSTNode<T> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(heightR(node.getLeft()), heightR(node.getRight()));
    }

    @Override
    public BSTNode<T> getRoot() {
        // DO NOT EDIT THIS METHOD!
        return root;
    }
}