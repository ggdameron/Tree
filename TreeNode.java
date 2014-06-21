
public class TreeNode <E extends Comparable> {

		private E data;
		
		private TreeNode<E> leftNode;
		
		private TreeNode<E> rightNode;
	
		public TreeNode(E d){
			
			data = d;
			
			leftNode = null;
			
			rightNode = null;
			
			
		}
		
		public void setData(E d){
			
			data = d;
			
		}
		
		public E getData(){
			
			return data;
		}
		
		public void setLeftNode(TreeNode<E> left){
			
			leftNode = left;
			
		}
		
		public TreeNode<E> getLeftNode(){
			
			return leftNode;
			
		}
		
		public void setRightNode(TreeNode <E> right){
			
			rightNode = right;
			
		}
		
		public TreeNode<E> getRightNode(){
			
			return rightNode;
			
		}
		
	
}
