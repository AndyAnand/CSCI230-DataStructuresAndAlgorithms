public interface BinaryTreeNode<E> {

    //Returns the element in this node.
    E getElement();

    //Sets the element value for this node.
    void setElement(E data);

    //Returns the parent of this node, or null if this node is a root.
    BinaryTreeNode<E> getParent();

    //Sets the parent of this node, or null if this node is a root.
    void setParent(BinaryTreeNode<E> p);

    //Returns the left child of this node
    BinaryTreeNode<E> getLeft();

    //Returns the right child of this node
    BinaryTreeNode<E> getRight();

    //sets the left child of this node
    void setLeft(BinaryTreeNode<E> child);

    //sets the right child of this node
    void setRight(BinaryTreeNode<E> child);

    //Disconnects a node from its parent
    void removeFromParent();

}
