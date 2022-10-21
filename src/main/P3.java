package main;

import java.util.Arrays;
import java.util.Iterator;

public class P3 {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1, null, null);
		
		root.left = new TreeNode(2, null, null);
		root.left.left = new TreeNode(4, null, null);
		root.left.left.right = new TreeNode(6, null, null);
		root.right = new TreeNode(3, null, null);
		root.right.left = new TreeNode(5, null, null);
		root.right.right = new TreeNode(7, null, null);
		
		// (1, (2, (4, #, (6, #, #)), #), (3, (5, #, #), (7, #, #)))
		
		StringBuffer serializedTree = new StringBuffer();
		serializeTree(root, serializedTree);
		System.out.println(serializedTree);
		
		TreeNode deserializedRoot = deSerializeTree(serializedTree.toString());
		
		//verify
		serializedTree = new StringBuffer();
		serializeTree(deserializedRoot, serializedTree);
		System.out.println(serializedTree);
	}
	
	private static void serializeTree(TreeNode root, StringBuffer ser) {
		if(root==null) {
			ser.append("#");
			return;
		}
		ser.append(root.val);
		ser.append(",");
		serializeTree(root.left, ser);
		ser.append(",");
		serializeTree(root.right, ser);
	}
	
	private static TreeNode deSerializeTree(String ser) {
		Iterator<String> iter = Arrays.asList(ser.split(",")).iterator();
		return deSerializeTreeRec(iter);
	}
	
	private static TreeNode deSerializeTreeRec(Iterator<String> iter) {
		
		TreeNode node = null;
		if(iter.hasNext()) {
			String s = iter.next();
			if(s.equals("#")) {
				return null;
			}
			node = new TreeNode(Integer.parseInt(s), deSerializeTreeRec(iter), deSerializeTreeRec(iter));
		}
		return node;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int val, TreeNode left, TreeNode right){
		this.val = val;
		this.right = right;
		this.left = left;
	}
}