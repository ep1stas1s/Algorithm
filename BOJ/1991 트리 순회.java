import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		
		Tree tree = new Tree(arr[0].charAt(0), arr[1].charAt(0), arr[2].charAt(0));
		for(int i = 0; i < N - 1; i++) {
			arr = br.readLine().split(" ");
			tree.add(arr[0].charAt(0), arr[1].charAt(0), arr[2].charAt(0));
		}
		
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}
}

class Node{
	char data;
	Node left;
	Node right;
	
	public Node(char data) {
		this.data = data;
	}
}

class Tree{
	
	Node root;
	
	public Tree(char data, char left, char right) {
		root = new Node(data);
		
		if(left != '.') {
			root.left = new Node(left);
		}
		if(right != '.') {
			root.right = new Node(right);
		}
	}
	
	public void add(char data, char left, char right) {
		if(root == null) {
			root = new Node(data);
			if(left != '.') {
				root.left = new Node(left);
			}
			if(right != '.') {
				root.right = new Node(right);
			}
		}else {
			search(root, data, left, right);
		}
	}

	public void search(Node root, char data, char left, char right) {
		if(root == null) {
			return;
		}else if(root.data == data) {
			if(left != '.') {
				root.left = new Node(left);
			}
			if(right != '.') {
				root.right = new Node(right);
			}
		}else {
			// °¢°¢ ¿ÞÂÊ, ¿À¸¥ÂÊ Àç±Í
			search(root.left, data, left, right);
			search(root.right, data, left, right);
		}
	}
	
	public void preOrder(Node node) {
		System.out.print(node.data);
		if(node.left != null) {
			preOrder(node.left);
		}
		if(node.right != null) {
			preOrder(node.right);
		}
	}
	
	public void inOrder(Node node) {
		if(node.left != null) {
			inOrder(node.left);
		}
		System.out.print(node.data);
		if(node.right != null) {
			inOrder(node.right);
		}
	}
	
	public void postOrder(Node node) {
		if(node.left != null) {
			postOrder(node.left);
		}
		if(node.right != null) {
			postOrder(node.right);
		}
		System.out.print(node.data);
	}
}