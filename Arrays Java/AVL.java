import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your implementation of an AVL Tree.
 *
 * @author Hardik Sangwan
 * @version 1.0
 */
public class AVL<T extends Comparable<? super T>> implements AVLInterface<T> {
    // DO NOT ADD OR MODIFY INSTANCE VARIABLES.
    private AVLNode<T> root;
    private int size;

    /**
     * A no argument constructor that should initialize an empty AVL tree.
     * DO NOT IMPLEMENT THIS CONSTRUCTOR!
     */
    public AVL() {
    }
        /**
     * Initializes the AVL tree with the data in the Collection. The data
     * should be added in the same order it is in the Collection.
     *
     * @param data the data to add to the tree
     * @throws IllegalArgumentException if data or any element in data is null
     */
    public AVL(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("Data provided is null");
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
        root = add(root, data);

    }

    /**
    * Helper method to add to the BST recusivley
    * @param node the node that we are currently traversing
    * @param data the data that we want to add to the BST
    * @return the node added
    */
    private AVLNode<T> add(AVLNode<T> node, T data) {
        if (node == null) {
            AVLNode<T> newNode = new AVLNode<>(data);
            newNode.setHeight(0);
            newNode.setBalanceFactor(0);
            return newNode;
        }
        if (data.compareTo(node.getData()) == 0) {
            size--;
            return node;
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(add(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(add(node.getRight(), data));
        }
        node.setHeight(height(node));
        node.setBalanceFactor(calculateBalanceFactor(node));
        if (node.getBalanceFactor() >= 2 || node.getBalanceFactor() <= -2) {
            node = balanceNode(node);
        }
        return node;
    }
    /**
    *Helper Method to calculate the balance factor of a node
    *@param node the node we want to calculate the balance factor of
    *@return the balance factor of the node
    */
    private int calculateBalanceFactor(AVLNode<T> node) {
        if (node == null) {
            return 0;
        } else {
            return ((node.getLeft() == null) ? -1 : node.getLeft().getHeight())
                - ((node.getRight() == null) ? -1 : node.getRight()
                    .getHeight());
        }
    }
    /**
    *Helper method to balance a node
    *@param node the node that needs to be balanced
    *@return the new node which is at the place of the node that
    * needed balancing
    */
    private AVLNode<T> balanceNode(AVLNode<T> node) {
        int bf = node.getBalanceFactor();
        int leftbf = (node.getLeft() == null) ? 0 : node.getLeft()
            .getBalanceFactor();
        int rightbf = (node.getRight() == null) ? 0 : node.getRight()
            .getBalanceFactor();
        if (bf >= 2) {
            if (leftbf == -1) {
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            } else if (leftbf >= 0) {
                return rotateRight(node);
            }
        } else if (bf <= -2) {
            if (rightbf == 1) {
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            } else if (rightbf <= 0) {
                return rotateLeft(node);
            }
        }
        return null;

    }

    @Override
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data provided is null");
        }
        T removeData = get(data);
        root = remove(root, data);
        size--;
        return removeData;
    }

    /**
     * Helper method to use recursion to remove a particular node
     * @param node the node we are currently traversing
     * @param data the data we need to be removed
     * @return the node
     */
    private AVLNode<T> remove(AVLNode<T> node, T data) {
        if (node == null) {
            throw new java.util.NoSuchElementException("Data does not exist");
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(remove(node.getLeft(), data));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(remove(node.getRight(), data));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                node.setData(getSuccessor(node.getRight()));
                node.setRight(remove(node.getRight(), node.getData()));
            }
        }
        node.setHeight(height(node));
        node.setBalanceFactor(calculateBalanceFactor(node));
        if (node.getBalanceFactor() >= 2 || node.getBalanceFactor() <= -2) {
            node = balanceNode(node);
        }
        return node;
    }

    /**
     * Helper method for the remove method to get an element's successor
     * @param node the node which we are currently traversing
     * @return the data of the successor
     */
    private T getSuccessor(AVLNode<T> node) {
        // while (node.getLeft() != null) {
        //     node = node.getLeft();
        // }
        // return node.getData();
        if (node.getLeft() == null) {
            return node.getData();
        }
        return getSuccessor(node.getLeft());
    }

    /**
    * Helper method for rotating left
    *@param node the node we need to do left rotation on
    *@return the new node that is in place of the initial node right now
    */
    private AVLNode<T> rotateLeft(AVLNode<T> node) {
        AVLNode<T> newNode = node.getRight();
        node.setRight(newNode.getLeft());
        newNode.setLeft(node);
        node.setHeight(height(node));
        newNode.setHeight(height(newNode));
        node.setBalanceFactor(calculateBalanceFactor(node));
        newNode.setBalanceFactor(calculateBalanceFactor(newNode));
        return newNode;
    }
    /**
    * Helper method for rotating right
    *@param node the node we need to do right rotation on
    *@return the new node that is in place of the initial node right now
    */
    private AVLNode<T> rotateRight(AVLNode<T> node) {
        AVLNode<T> newNode = node.getLeft();
        node.setLeft(newNode.getRight());
        newNode.setRight(node);
        node.setHeight(height(node));
        newNode.setHeight(height(newNode));
        node.setBalanceFactor(calculateBalanceFactor(node));
        newNode.setBalanceFactor(calculateBalanceFactor(newNode));
        return newNode;
    }
    @Override
    public T get(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data provided"
            + " cannot be null");
        }
        return get(root, data).getData();
    }

    /**
    *Helper method to recursively run get Method
    *@param node the node we are currently traversing
    *@param data the data we need to search for
    *@return the data in the tree that is equal to the data passed in
    */
    private AVLNode<T> get(AVLNode<T> node, T data) {
        if (node == null) {
            throw new java.util.NoSuchElementException("No such data exists");
        } else {
            if (data.compareTo(node.getData()) == 0) {
                return node;
            } else if (data.compareTo(node.getData()) < 0) {
                return get(node.getLeft(), data);
            } else {
                return get(node.getRight(), data);
            }
        }
    }

    @Override
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data provided"
            + " cannot be null");
        }
        return contains(root, data);
    }
    /**
    *Helper method to recursively run contains Method
    *@param node the node we are currently traversing
    *@param data the data we need to search for
    *@return the boolean if the tree contains the data passed in
    */
    private boolean contains(AVLNode<T> node, T data) {
        if (node == null) {
            return false;
        } else {
            if (data.compareTo(node.getData()) == 0) {
                return true;
            } else if (data.compareTo(node.getData()) < 0) {
                return contains(node.getLeft(), data);
            } else {
                return contains(node.getRight(), data);
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<T> preorder() {
        return preorder(root);
    }

    /**
    * Helper Method to traverse the list in preorder using recursion
    * @param node the node we are currently traversing
    * @return list the list that contains the data from the tree
    */
    private List<T> preorder(AVLNode<T> node) {
        java.util.ArrayList<T> list = new java.util.ArrayList();
        if (node != null) {
            list.add(node.getData());
            list.addAll(preorder(node.getLeft()));
            list.addAll(preorder(node.getRight()));
        }
        return list;
    }
    @Override
    public List<T> postorder() {
        return postorder(root);
    }

    /**
    * Helper Method to traverse the list in postorder using recursion
    * @param node the node we are currently traversing
    * @return list the list that contains the data from the tree
    */
    private List<T> postorder(AVLNode<T> node) {
        java.util.ArrayList<T> list = new java.util.ArrayList();
        if (node != null) {
            list.addAll(postorder(node.getLeft()));
            list.addAll(postorder(node.getRight()));
            list.add(node.getData());
        }
        return list;
    }
    @Override
    public List<T> inorder() {
        return inorder(root);
    }

    /**
    * Helper Method to traverse the list in inorder using recursion
    * @param node the node we are currently traversing
    * @return list the list that contains the data from the tree
    */
    private List<T> inorder(AVLNode<T> node) {
        ArrayList<T> list = new ArrayList();
        if (node != null) {
            list.addAll(inorder(node.getLeft()));
            list.add(node.getData());
            list.addAll(inorder(node.getRight()));
        }
        return list;
    }
    @Override
    public List<T> levelorder() {
        ArrayList<T> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<AVLNode<T>> q = new LinkedList<AVLNode<T>>();
        q.add(root);
        while (!q.isEmpty()) {
            AVLNode<T> node = q.poll();
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
        return height(root);
    }

    /**
     * Helper method to use recursion to find the height of a particular node
     *@param node the node we are currently traversing
     *@return the height of the node
     */
    private int height(AVLNode<T> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    @Override
    public AVLNode<T> getRoot() {
        // DO NOT EDIT THIS METHOD!
        return root;
    }
}
