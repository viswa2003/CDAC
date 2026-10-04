package day5;

class BinarySearchTree {
	static class Node {
		int data;
		Node left;
		Node right;
	
	public Node(int data) {
		this.data = data;
	}
	}
	Node root;
	
	public void insert(int value) {
		root = insertRecursive(root, value);
	}
	
	private Node insertRecursive(Node current, int value) {
		if(current == null) {
			Node newNode = new Node(value);
			return newNode;
		}
		
		if(value < current.data) {
			current.left = insertRecursive(current.left, value);
		}
		else if(value > current.data) {
			current.right = insertRecursive(current.right, value);
		}
		return current;
	}
	
	
	public boolean search(int value) {
		return searchRecursively(root, value);
	}
	
	private boolean searchRecursively(Node current, int value) {
		if(current == null)
			return false;
		
		if(current.data == value) {
			return true;
		}
		if(value < current.data)
			return searchRecursively(current.left, value);
		else
			return searchRecursively(current.right, value);
	}
	
	public int findMin() {
		if(root == null) 
			throw new IllegalStateException("Empty tree");
		return minRecursive(root);
	}
	
	private int minRecursive(Node current) {

		if(current.left == null) {
			return current.data;
		}
		else {
			return minRecursive(current.left);
		}
	}
	
	
	public int findMax() {
		if(root == null) 
			throw new IllegalStateException("Empty tree");
		return maxRecursive(root);
	}
	
	private int maxRecursive(Node current) {
		if(current.right == null) 
			return current.data;
		else
			return maxRecursive(current.right);
	}
	
	public int height() {
		if(root == null)
			throw new IllegalStateException("Empty!!");
		return heightRecursive(root);	
		}
	
	private int heightRecursive(Node current) {
		if(current == null) 
			return -1;
		
		int leftHeight = heightRecursive(current.left);
		int rightHeight = heightRecursive(current.right);
		
		return 1 + Math.max(leftHeight,  rightHeight);
	}
	
	public void delete(int value) {
		root =  deleteRecursive(root, value);
	}
	
	
	private Node deleteRecursive(Node current, int value) {
		if(current == null)
			return null;
		
//		check left subtree
		if(value < current.data)
			current.left =  deleteRecursive(current.left, value);
		
//		check right subtree
		else if(value > current.data) 
			current.right = deleteRecursive(current.right, value);
		
//		Node found!!
//	    if only one child : 
		else {
			if(current.left == null)
				return current.right; //The parent stores the current.right 
			
			if(current.right == null)
				return current.left; //The parent stores the current.left
			else {
				//Two child : 
				Node successor = findMinNode(current.right); //find smallest node in right subtree
				current.data = successor.data; //replace the value to be deleted with successer value
				current.right = deleteRecursive(current.right, successor.data); //delete the duplicate successor value				
			}
		}
		return current;
	}
	
	private Node findMinNode(Node current) {
		if(current.left == null)
			return current;
		return findMinNode(current.left);
	}
//	
	
//	public void delete(int value) {
//		root = deleteRecursive(root, value);
//	}
//	
//	private Node deleteRecursive(Node current, int value) {
//		if(current == null)
//			return null;
//		
//		if(value < current.data)
//			current.left = deleteRecursive(current.left, value);
//		else if(value > current.data)
//			current.right = deleteRecursive(current.right, value);
//		else {
//			if(current.left == null)
//				return current.right;
//			else if(current.right == null) 
//				return current.left;
//			else {
//				Node successor = findMinNode(current.right);
//				current.data = successor.data;
//				current.right = deleteRecursive(current.right, successor.data);
//			}
//		}
//		return current;
//	}
//	
//	private Node findMinNode(Node current) {
//		if(current.left == null)
//			return current;
//		return findMinNode(current.left);
//	}
//	
	
//		==============
//		||Traversal ||
//		==============
	
//	INORDER TRAVERSAL
	public void inorder() {
		inorderRecursive(root);
	}
	
	private void inorderRecursive(Node current) {
		if(current == null)
			return;
		inorderRecursive(current.left);
		System.out.println(current.data + " ");
		inorderRecursive(current.right);
	}
	
	
	public void preorder() {
		preorderRecursive(root);
	}
	
	private void preorderRecursive(Node current) {
		if(current == null)
			return;
		System.out.println(current.data + " ");
		preorderRecursive(current.left);
		preorderRecursive(current.right);
	}
	
	
	public void postorder() {
		postorderRecursive(root);
	}
	
	private void postorderRecursive(Node current) {
		if(current == null)
			return;
		postorderRecursive(current.left);
		postorderRecursive(current.right);
		System.out.println(current.data + " ");
	}
	
	public static void main(String[] main) {
		
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(10);
		bst.insert(0);
		bst.insert(20);
		bst.insert(15);
		bst.insert(25);
		bst.insert(35);
		bst.insert(21);
		bst.insert(1);
		bst.insert(40);
		bst.insert(12);
		bst.insert(33);
		
		bst.delete(25);
		bst.delete(33);
		bst.delete(12);
		bst.inorder();
		bst.preorder();
		bst.postorder();
		
		
	}
	
	
}



































