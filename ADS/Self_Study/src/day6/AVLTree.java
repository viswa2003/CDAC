package day6;

public class AVLTree {
	class Node {
		int data;
		Node left;
		Node right;
		int height;
		
		Node(int data) {
			this.data = data;
			this.height = 0;
		}
	}
	
	Node root;
	
	static int getHeight(Node node) {
		if(node == null)
			return -1;
		return node.height;
	}

	
	static void updateHeight(Node node) {
		node.height = 1 + (Math.max(getHeight(node.left), getHeight(node.right)));
	}
	
	static int getBalanceFactor(Node node) {
		return getHeight(node.left) - getHeight(node.right);
	}

//	Right Rotation
	Node rotateRight(Node node) {
		Node leftChild = node.left;
		Node subTree = leftChild.right;
		
		leftChild.right = node;
		node.left = subTree;
		
		updateHeight(node);
		updateHeight(leftChild);
		
		return leftChild;
	}
	
	
//	Left Rotation
	Node rotateLeft(Node node) {
		Node rightChild = node.right;
		Node subTree = rightChild.left;
		
		rightChild.left = node;
		node.right = subTree;
		
		updateHeight(node);
		updateHeight(rightChild);
		
		return rightChild;
	}
	
//	Balancing
	Node rebalance(Node node) {
		
//		update height after insertion or deletion
		updateHeight(node);
		int balanceFactor = getBalanceFactor(node);
		
//		LL case - node is left heavy and left child is also left heavy
		if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
			return rotateRight(node);
		}
		
//		RR case - node is right heavy and right child is also right heavy
		if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
			return rotateLeft(node);
		}
		
//		LR case - node is left heavy && left child is right heavy
		if(balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
			node.left = rotateLeft(node.left);
			
			return rotateRight(node);
		}
		
//		RL case - node is right heavy and right child is left heavy
		if(balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
			node.right = rotateRight(node.right);
			
			return rotateLeft(node);
		}
		
		return node;
		
	}
	
	
//	public insert method
	void insert(int value) {
		root = insertRecursive(root, value);
	}
	
//	recursive insert
	private Node insertRecursive(Node node, int value) {
		if(node == null) {
			return new Node(value);
		}
		
		if(value < node.data) {
			node.left = insertRecursive(node.left, value);
		}
		else if(value > node.data) {
			node.right = insertRecursive(node.right, value);
		}
		
		else 
			return node;
		
		return rebalance(node);
		
	}
	
//	inorder traversal
	
	public void inorder() {
		inorderRecursive(root);
	}
	
	private void inorderRecursive(Node node) {
		if(node == null)
			return;
		inorderRecursive(node.left);
		System.out.println(node.data + " ");
		inorderRecursive(node.right);
		
	}
	
//	preorder traversal
	public void preorder() {
		preorderRecursive(root);
	}
	
	public  void preorderRecursive(Node node) {
		if(node == null)
			return;
		System.out.println(node.data + " ");
		preorderRecursive(node.left);
		preorderRecursive(node.right);
	}
	
	
//	postorder traversal
	public void postorder() {
		postorderRecursive(root);
	}
	
	private void postorderRecursive(Node node) {
		if(node == null)
			return;
		postorderRecursive(node.left);
		postorderRecursive(node.right);
		System.out.println(node.data + " ");
	}
	
//	delete
	public void delete(int value) {
		root = deleteRecursive(root, value);
	}
	
	private Node deleteRecursive(Node node, int value) {
		if(node == null)
			return null;
		
		if(value < node.data) {
			node.left = deleteRecursive(node.left, value);
		}
		else if(value > node.data) {
			node.right = deleteRecursive(node.right, value);
		}
//		node found!!
		else {
			//no child
			if(node.left == null && node.right == null)
				return null;
			
			//one child
			else if(node.left == null)
				return node.right;
			else if(node.right == null)
				return node.left;
			
			//Two child
			Node successor = successor(node.right);
			node.data = successor.data;
			node.right = deleteRecursive(node.right, successor.data);
			
		}
		return rebalance(node);
	}
	
	private Node successor(Node current) {
		while(current.left != null)
			current = current.left;
		return current;
	}
	
	
	
	public static void main(String[] args) {
		
		AVLTree tree = new AVLTree();
		
		tree.insert(10);
		tree.insert(20);
		tree.insert(50);
		tree.insert(1);
		tree.insert(50);
		tree.insert(45);
		tree.insert(96);
		
		tree.inorder();
		
		tree.delete(45);
		
		tree.inorder();
	}
	
}

















