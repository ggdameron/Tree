


public class Tree <E extends Comparable> {

	private TreeNode <E> root;
	
	private Object values[];
	
	private int index;
	
	
	public <E> Tree(){
		
		root = null;
		
	}
	
	public void insertItem(E insertValue ){
		
		if(root == null){
			root = new TreeNode(insertValue);
		}
		else{
			insert(root, insertValue);
		}
		
	}
	
	private void insert(TreeNode <E> node, E insertValue){
		

		
		if(node.getData().compareTo(insertValue) == 0){
			//Do nothing
			return;
		}
		else if(node.getData().compareTo(insertValue) > 0){
			if(node.getLeftNode() == null){
				TreeNode <E> temp = new TreeNode(insertValue);
				node.setLeftNode(temp);
			}
			else{
				insert(node.getLeftNode(), insertValue);
			}
		}
		else if(node.getData().compareTo(insertValue) < 0){
			if(node.getRightNode() == null){
				TreeNode <E> temp = new TreeNode(insertValue);
				node.setRightNode(temp);
			}
			else{
				insert(node.getRightNode(), insertValue);
			}
		}
		
	}
	
	public int count(){
		
		return countNodes(root);
		
		
	}
	
	private int countNodes(TreeNode <E> tree){
		
		if(tree == null){
			return 0;
		}
		
			return countNodes(tree.getLeftNode()) + countNodes(tree.getRightNode()) + 1;
		
	}
	
	public void printInOrder(){
		
		printInOrderRecursive(root);
		
		System.out.println();
	}
	
	private void printInOrderRecursive(TreeNode<E> node){
		
		if(node != null){
			
			printInOrderRecursive(node.getLeftNode());
			
			System.out.print(node.getData());
			
			printInOrderRecursive(node.getRightNode());
			
		}	
		
	}
	
	public void printPreOrder(){
		
		printPreOrderRecursive(root);
		System.out.println();

	}
	
	private void printPreOrderRecursive(TreeNode<E> node){
		
		if(node != null){
			
			System.out.print(node.getData());
			
			printPreOrderRecursive(node.getLeftNode());
			
			printPreOrderRecursive(node.getRightNode());
			
		}
	}
	
	public void printPostOrder(){
		
		printPostOrderRecursive(root);
		System.out.println();

	}
	
	private void printPostOrderRecursive(TreeNode<E> node){
		
		if(node != null){
			
		printPostOrderRecursive(node.getLeftNode());

		printPostOrderRecursive(node.getRightNode());

		System.out.print(node.getData());
		
		}
	}
	
	public boolean isEmpty(){
		
		if(root == null){
			return true;
		}
		else
			return false;
	}
	
	public void clear(){
		
		root = null;
		
	}
	
	public boolean findItem(E item){
		
		return findItemRecursive(root, item);
		
	}
	
	private boolean findItemRecursive(TreeNode<E> tree, E item){
		
		if(tree == null){
			
			return false;
			
		}
		else if(tree.getData().compareTo(item) == 0 ){
			return true;
		}
		else if(tree.getData().compareTo(item) > 0){
			
			return findItemRecursive(tree.getLeftNode(), item);
			
		}
		else{
			
			return findItemRecursive(tree.getRightNode(), item);
			
		}
			
			
	}
	
	public void deleteItem(E item){
		
		deleteRecursive(root, item);
		
	}
	
	private TreeNode<E> deleteRecursive(TreeNode<E> node, E item){
		
		TreeNode<E> temp;
		
		int nodeCase = 0;
		
		if(!isEmpty()){
			
			node = search(item);
			
			
		}
				
		if(node.getLeftNode() != null){
			
			nodeCase ++;
			
		}
		if(node.getRightNode() != null){
			
			nodeCase ++;
			
		}
			
		
		switch(nodeCase){
		
		case 0:{
			
			node = null;
			
			
		}
		
		case 1:{
			
			if(node.getLeftNode() != null){
				node = node.getLeftNode();
			}
			if(node.getRightNode() != null){
				node = node.getRightNode();
			}
			
		}
		
		case 2:{
			
			temp = node.getLeftNode();
			if(temp.getRightNode() != null){
			while(temp.getRightNode().getRightNode() != null){
				
				temp = temp.getRightNode();
	
			}
			
			
			node.setData(temp.getRightNode().getData());
						
			temp.setRightNode(null);
				
		}
			else{
				node.setData(temp.getData());
				node.setLeftNode(null);
				
			}
		}
		
		}
			
			return node;
			
		
	}
	
	public TreeNode<E> search(E item){
		
		return searchRecursive(root, item);
		
	}
	
	private TreeNode<E> searchRecursive(TreeNode<E> node, E item){
		
		if(node == null){
			
		return null;
			
		}
		
		else if(node.getData().compareTo(item) == 0 ){
			return node;
		}
		else if(node.getData().compareTo(item) > 0){
			
			return searchRecursive(node.getLeftNode(), item);
			
		}
		else{
			
			return searchRecursive(node.getRightNode(), item);
			
		}
		
		
	}
	
	public void balance(){
		
		if(isEmpty()){
			
			System.out.println("Empty Tree ");
			
			return;
		}
		else{
			
		values = (E[]) new Comparable[count()];
		 
		index = 0;
		
		createAscendingArray(root);
		
		clear();
		
		balanceRecursive(0, index-1);		 
				
		}
		
	}
	
	private void createAscendingArray(TreeNode<E> current){
		
		if(current == null){
			return;
		}
		
		createAscendingArray(current.getLeftNode());


		values[index ++] = current.getData();

		
		createAscendingArray(current.getRightNode());

		
	}
	
	private void balanceRecursive(int low, int high){
	
		if(low > high){
			
			return;
		}
		
		int bound = (low+high)/2;
				
		insertItem((E) values[bound]);
		
		balanceRecursive(low, bound-1);
		
		balanceRecursive(bound + 1, high);
		
	}
	
	public void printTree(){
		
		printTreeRecursive(root, 0);
		
	}
	
	private void printTreeRecursive(TreeNode <E> node, int spaces ){
	
		if(node == null){

			return;
			
		}
		
		spaces ++;
		
		printTreeRecursive(node.getRightNode(), spaces);
		
		spaces --;
		
		
		for(int x = 0; x < spaces; x ++){

			System.out.print("     ");
		
		}

		System.out.println(node.getData());
		
		spaces ++;
		printTreeRecursive(node.getLeftNode(), spaces);
		
		spaces --;
		
	}
	
}
