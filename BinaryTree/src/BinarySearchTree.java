import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	private TreeNode root;

	public BinarySearchTree() {
		root = null;
	}

	public void add(Comparable val) {
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree) {
		if (tree == null)
			tree = new TreeNode(val, null, null);

		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);


		if (dirTest < 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if (dirTest > 0)
			tree.setRight(add(val, tree.getRight()));

		return tree;
	}

	public void inOrder() {
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree) {
		if (tree != null) {
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	//add preOrder, postOrder, and revOrder
	public void preOrder() {
		preOrder(root);
		System.out.println("\n\n");
	}

	private void preOrder(TreeNode tree) {
		if (tree != null) {
			System.out.print(tree.getValue() + " ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}

	public void postOrder() {
		postOrder(root);
		System.out.println("\n\n");
	}

	private void postOrder(TreeNode tree) {
		if (tree != null) {
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
		}
	}

	public void revOrder() {
		revOrder(root);
		System.out.println("\n\n");
	}

	private void revOrder(TreeNode tree) {
		if (tree != null) {
			revOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
			revOrder(tree.getLeft());
		}
	}

	// ---------------

	public int getNumLevels() {
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree) {
		if (tree == null)
			return 0;
		else if (getNumLevels(tree.getLeft()) > getNumLevels(tree.getRight()))
			return 1 + getNumLevels(tree.getLeft());
		else
			return 1 + getNumLevels(tree.getRight());
	}

	//add getNumLeaves, getWidth, getHeight, getNumNodes, and isFull

	public int getNumLeaves() {
		return getNumLeaves(root);
	}

	private int getNumLeaves(TreeNode tree) {
		if (tree == null)
			return 0;
		else if (tree.getLeft() == null && tree.getRight() == null) {
			return 1;
		} else {
			return getNumLeaves(tree.getLeft()) + getNumLeaves(tree.getRight());
		}
	}

	public int getWidth() {
		return getWidth(root);
	}

	private int getWidth(TreeNode tree) {
		// find max distance between the root and left side, and max distance between root and right side
		// then add one
		int width = 1;
		width += 1 + getHeight(tree.getRight());
		width += 1 + getHeight(tree.getLeft());
		return width;
	}

	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(TreeNode tree) {
		if (tree == null) {
			return -1;
		} else {
			return Math.max(1 + getHeight(tree.getLeft()), 1 + getHeight(tree.getRight()));
		}
	}

	// get numNodes

	public boolean isFull() {
		return isFull(root);
	}

	private boolean isFull(TreeNode tree) {
		if (tree == null) {
			return true;
		} else if ((tree.getLeft() == null && tree.getRight() != null) || (tree.getLeft() != null && tree.getRight() == null)) {
			return false;
		} else {
			return isFull(tree.getLeft()) && isFull(tree.getRight());
		}
	}

	// --------------------------


	//search !!
	public boolean search(Comparable val) {
		return search(val, root);
	}

	private boolean search(Comparable val, TreeNode tree) {
		if (tree != null) {
			int dirTest = val.compareTo(tree.getValue());
			if (dirTest == 0) {
				return true;
			} else if (dirTest < 0)
				return search(val, tree.getLeft());
			else if (dirTest > 0)
				return search(val, tree.getRight());
		}
		return false;
	}

	//maxNode
	public TreeNode getLargest() {
		return getLargest(root);
	}

	private TreeNode getLargest(TreeNode tree) {
		// essentially get the right most node
		TreeNode current = tree;
		while (current.getRight() != null) {
			current = current.getRight();
		}
		return current;
	}

	//minNode
	public TreeNode getSmallest() {
		return getSmallest(root);
	}

	private TreeNode getSmallest(TreeNode tree) {
		TreeNode current = tree;
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current;
	}

	//level order
	public void levelOrder(){
		levelOrder(root);
		System.out.println("\n\n");
	}

	private void levelOrder(TreeNode tree){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty()){
			TreeNode tempnode = q.poll();
			System.out.print(tempnode.getValue() + " ");

			if(tempnode.getLeft() != null){
				q.add(tempnode.getLeft());
			}

			if(tempnode.getRight() != null) {
				q.add(tempnode.getRight());
			}
		}
	}

	public int getNumNodes(){
		return getNumNodes(root);
	}

	private int getNumNodes(TreeNode tree){
		if(tree==null){
			return 0;
		} else {
			return 1 + getNumNodes(tree.getRight()) + getNumNodes(tree.getLeft());
		}
	}

	//display like a tree
	public void displayTree(){
		//
	}

	private void displayTree(TreeNode tree){
		//

	}

	//remove
	public TreeNode remove(Comparable target)
	{
		if(root == null) return null;
		TreeNode temp = root;
		TreeNode inorderSuccessor;
//check to see if root is to be removed
		if(root.getValue().equals(target))
		{
//remove root degree 0
			if(root.getLeft() == null && root.getRight() == null)
			{
				root = null;
				return temp;
			}
//remove root degree 1 – right child
			else if(root.getLeft() == null)
			{
				root = root.getRight();
				temp.setRight(null);;
				return temp;
			}
//remove root degree 1 – left child
			else if(root.getRight() == null)
			{
				root = root.getLeft();
				temp.setLeft(null);
				return temp;
			}
//remove root degree 2
			{
				inorderSuccessor = successor(root);
				swap(root,inorderSuccessor);
				if(root.getRight()==inorderSuccessor)
				{
					root.setRight(inorderSuccessor.getRight());
					inorderSuccessor.setRight(null);
					return inorderSuccessor;
				}
				return remove(root.getRight(),target);
			}
		}
//if root is not removed call remove helper method
		return remove(root.getRight(),target);
	}
	private TreeNode search(TreeNode parent, Comparable target)
	{
		if(parent == null) return null;
		if(parent.getLeft()!=null && parent.getLeft().getValue().equals(target)||
				parent.getRight()!=null && parent.getRight().getValue().equals(target))
			return parent;
		else if(target.compareTo(parent.getValue()) < 0)
			return search(parent.getLeft(),target);
		else
			return search(parent.getRight(),target);
	}
	private TreeNode remove(TreeNode startNode, Comparable target)
	{
		TreeNode nodeToRemove, inorderSuccessor;
		TreeNode parent = search(startNode,target);
		if(parent == null) return null;
//decide if it is a left or right child
		boolean isLeft = parent.getLeft()!=null &&
				parent.getLeft().getValue().equals(target);
		nodeToRemove = isLeft ? parent.getLeft() : parent.getRight();
//degree 0
		if(nodeToRemove.getLeft() == null && nodeToRemove.getRight() == null)
		{
			if(isLeft)
				parent.setLeft(null);
			else
				parent.setRight(null);
			return nodeToRemove;
		}
//degree 1
		else if(nodeToRemove.getLeft() == null)
		{
			if(isLeft)
				parent.setLeft(nodeToRemove.getRight());
			else
				parent.setRight(nodeToRemove.getRight());
			nodeToRemove.setRight(null);
			return nodeToRemove;
		}
		else if(nodeToRemove.getRight() == null)
		{
			if(isLeft)
				parent.setLeft(nodeToRemove.getLeft());
			else
				parent.setRight(nodeToRemove.getLeft());
			nodeToRemove.setLeft(null);
			return nodeToRemove;
		}
//degree 2
		else
		{
			inorderSuccessor = successor(nodeToRemove);
			swap(inorderSuccessor, nodeToRemove);
			if(nodeToRemove.getRight()==inorderSuccessor)
			{
				nodeToRemove.setRight(inorderSuccessor.getLeft());
				inorderSuccessor.setRight(null);
				return inorderSuccessor;
			}
			return remove(nodeToRemove.getRight(), target);
		}
	}
	private TreeNode successor(TreeNode k)
	{
		TreeNode temp = k;
		temp = temp.getRight();
		while(temp.getLeft() != null)
			temp = temp.getLeft();
		return temp;
	}

	private void swap(TreeNode x, TreeNode y)
	{
		Comparable k = x.getValue();
		x.setValue(y.getValue());
		y.setValue(k);
	}

	public String toString()
	{
		return toString(root);
	}

	private String toString(TreeNode tree)
	{
		String ret = "";
		if (tree != null){
			ret+=toString(tree.getLeft());
			ret += tree.getValue() + " ";
			ret+=toString(tree.getRight());
		}
		return ret;
	}
}