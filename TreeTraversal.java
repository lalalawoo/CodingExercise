public class TreeTraversal {
	private class TreeNode {
		private int val;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	public List<Integer> inOrderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack();
		TreeNode pNode = root;
		while(!stack.isEmpty() || pNode != null) {
			if(pNode != null) {
				stack.push(pNode);
				pNode = pNode.left;
			} else {
				pNode = stack.pop();
				result.add(pNode.val);
				pNode = pNode.right;
			}
		}
		return result;
	}
	
	public List<Integer> preOrderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
		return result;
	}
	
	public List<Integer> postOrderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(root);
		while(!s1.isEmpty()) {
			TreeNode node = s1.pop();
			s2.push(node);
			if(node.left != null) {
				s1.push(node.left);
			}
			if(node.right != null) {
				s1.push(node.right);
			}
		}
		while(!s2.isEmpty()) {
			TreeNode node = s2.pop();
			result.add(node.val);
		}
		return result;
	}
	
	public List<List<Integer>> levelOrderTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<Integer>();
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
			}
			result.add(level);
		}
		return result;
	}
}
