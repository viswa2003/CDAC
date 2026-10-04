package practice;

public class Binary_AVL_Trees {
	
	static class BST{
		
		class Node {
			int data;
			Node left;
			Node right;
			
			Node(int data) {
				this.data = data;
			}
		}
		
		Node root;
		
		public boolean isEmpty() {
			return root == null;
		}
		
		public int height() {
			return heightRecursive(root);
		}
		
		private int heightRecursive(Node current) {
			if(current == null)
				return -1;
			
			int leftHeight = heightRecursive(current.left);
			int rightHeight = heightRecursive(current.right);
			
			return 1 + Math.max(leftHeight, rightHeight);
		}
		
		public void insert(int value) {
			root = insertRecursive(root, value);
		}
		
		private Node insertRecursive(Node current, int value) {
			if(current == null)
				return new Node(value);
			if(value < current.data) {
				current.left = insertRecursive(current.left, value);
			}
			else if(value > current.data) {
				current.right = insertRecursive(current.right, value);
			}
			return current;
		}
		
		
		public void delete(int value) {
			root = deleteRecursive(root, value);
		}
		
		private Node deleteRecursive(Node current, int value) {
			
			if(current == null)
				return current;
			
			if(value < current.data) {
				current.left = deleteRecursive(current.left, value);
			}
			else if(value > current.data) {
				current.right = deleteRecursive(current.right, value);
			}
			else {
				if(current.right == null)
					return current.left;
				else if(current.left == null)
					return current.right;
				
				Node successor = successor(current.right);
				current.data = successor.data;
				current.right = deleteRecursive(current.right, successor.data);
			}
			return current;
		}
		
		private Node successor(Node current) {
			while(current.left != null) {
				current = current.left;
			}
			return current;
		}
		
		
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
		
		
	}
	
	
	
	
//	====================================================
	
	static class AVLTree {
		
		class Node {
			int data;
			Node left;
			Node right;
			int height;
			
			public Node(int data) { 
				this.data = data;
				this.height = 0;
			}
		}
		
		Node root;
		
		public int getHeight(Node node) {
			if(node == null)
				return -1;
			System.out.println("get height" + node.height);
			return node.height;
		}
		
		public void updateHeight(Node node) {
			System.out.println("update height");
			node.height = heightRecursive(node);		
	}
		
		private int heightRecursive(Node node) {
			if(node == null)
				return -1;
			
			int leftHeight = heightRecursive(node.left);
			System.out.println("Left height : " + leftHeight);
			int rightHeight = heightRecursive(node.right);
			System.out.println("right height : " + rightHeight);
			
			return 1 + Math.max(leftHeight, rightHeight);
		}
		
		
		public int balanceFactor(Node node) {
			System.out.println("Balance factor");
			return getHeight(node.left) - getHeight(node.right);
		}
		
		
		private Node rotateRight(Node node) {
			Node leftChild = node.left;
			Node subtree = leftChild.right;

			leftChild.right = node;
			node.left = subtree;
			
			updateHeight(node);
			updateHeight(leftChild);
			
			return leftChild;
		}
		
		private Node rotateLeft(Node node) {
			Node rightChild = node.right;
			Node subtree = rightChild.left;
			
			rightChild.left = node;
			node.right = subtree;
			
			updateHeight(node);
			updateHeight(rightChild);
			
			return rightChild;
		}
		
		
		private Node rebalance(Node node) {
			
			updateHeight(node);
			
			int balance = balanceFactor(node);
			System.out.println("balance : " + balance);
//			LL case
			if(balance > 1 && balanceFactor(node.left) >= 0) {
				return rotateRight(node);
			}
//			RR case
			if(balance < -1 && balanceFactor(node.right) <= 0) {
				return rotateLeft(node);
			}
//			LR case
			if(balance > 1 && balanceFactor(node.left) < 0) {
				node.left = rotateLeft(node.left);
			
				return rotateRight(node);
			}
			if(balance < -1 && balanceFactor(node.right) > 0) {
				node.right = rotateRight(node.right);
				
				return rotateLeft(node);
			}
			
			return node;
		}
		
		
		public void insert(int value) {
			System.out.println("public insert");
			root = insertRecursive(root, value);
		}
		
		private Node insertRecursive(Node node, int value) {
			if(node == null) {
				System.out.println("inserted new node");
				return new Node(value);
			}
			else if(value < node.data) {
				System.out.println("left");
				node.left = insertRecursive(node.left, value);
			}
			else if(value > node.data) {
				System.out.println("right");
				node.right = insertRecursive(node.right, value);
			}
			else 
				return node;
			
			return rebalance(node);
		}
		
		
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
			else {
				if(node.right == null)
					return node.left;
				else if(node.left == null)
					return node.right;
				else {
					Node successor = successor(node.right);
					node.data = successor.data;
					node.right = deleteRecursive(node.right, successor.data);
				}
				return node;
			}
			return rebalance(node);
		}
		
		private Node successor(Node current) {
			while(current.left != null) {
				current = current.left;
			}
			return current;
		}
		
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
		
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BST bst = new BST();
		
		AVLTree avl = new AVLTree();
		
		System.out.println("==========BST=============");
		bst.insert(10);
		bst.insert(20);
		bst.insert(30);
		bst.insert(25);
		bst.insert(15);
		bst.inorder();
		
		bst.delete(20);
		bst.delete(10);
		
		bst.inorder();
		
		System.out.println("==========AVL=============");
		
		avl.insert(10);
		avl.insert(20);
//		avl.insert(30);
//		avl.insert(40);
//		avl.insert(15);
//		avl.insert(35);
//		
//		avl.inorder();
//		
//		avl.delete(10);
//		avl.delete(30);
//		avl.delete(40);
//		
//		avl.inorder();
	
	}

}
