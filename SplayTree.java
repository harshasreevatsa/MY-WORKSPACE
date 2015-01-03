public class SplayTree{

	
	/**
	 * @param args
	 */
	String tostring = "";
	StringBuilder sb = new StringBuilder("[ ");
	StringBuilder pl = new StringBuilder("[ ");
	boolean tsum = false;
	int sum = 0;
	int count = 0;
	boolean findl = false;
	boolean findr = false;
	Node root;
	Node find_left;
	Node find_right;
	boolean l = false;
	int s =0;
	Node child=null;
	Node greatgrandparent=null;
	Node grandparent=null;
	Node parent=null;
	int c =0;
	/*
	 * Node class is used to declare a Node with values for data , pointers to
	 * left and right child.*/
	private class Node
	{
		Integer data;
		Node left;
		Node right;
		private Node(int x,Node l,Node r)  // Node class Constructor which calls the
		{                                  // create Node() method.
			createNode(x,l,r);
		}
		private void createNode(int x,Node l,Node r)// Used to initialize values for data , left and right
		{                                           // right child.
			data = x;
			left = l;
			right = r;
		}
	}
	public void add(Integer x)    
	{
		root = add(x,this.root);//call the add(int x, Node t) private method passing the reference of root
		s=0;
		c=0;
		l=false;
		rotate(x,root); 
		s=0;    // reset flags to 0 and false which are used in the rotate(int x,Node t), for rotating the integer x 
		c=0;   // to the root.
		l=false; 
	}
	/*
	 * private add method which takes the integer x to be added and also the root of the tree.
	 * First we calculate the compare by comparing the value of the integer to the data of passed value of the Node.
	 * This is done recursively until a null is detected. At this point a new Node is created and initialized to the passed data.
	 * The linking of the new Node happens by returning the node up to higher layers. 
	 * */
	private Node add(Integer x,Node t)  
	{
		if(t==null)
		{
			Node val = new Node(x,null,null);//create new node and initialize its data to the passed value.
			return val;//return the the new node.
		}
		int compare = x.compareTo(t.data);//compare the value of x with that of data of the passed Node.
		if(compare<0)  // of compare<0 than x must be lesser than data of the passes node hence 
		{
			t.left = add(x,t.left); // call the add method recursively on t.left.
		}
		else if(compare>0)// of compare<0 than x must be greater than data of the passes node hence
		{
			t.right = add(x,t.right);// call the add method recursively on t.right.
		}
		else  // if compare=0 then the node already exists and hence do nothing.
		;
		return t; //return the node after each call ends to the caller method.
	}
	/*The find method inturn calls the find(int x, Node t) private method.
	 * This method return true if the integer x is found.
	 * If the integer x is not found, then the find method calls the rotate method on the integer that was last last accessed  
	 * */
	public boolean find(Integer x)
	{
		if(find(x,root)) 
		{
			s=0;            // the flags are reset to 0 and false before calling rotate method. 
			c=0;
			l=false;
			rotate(x,root); // call the rotate method on the integer if it is found.
			s=0;            // the flags are reset to 0 and false before calling rotate method. 
			c=0;
			l=false;
			return true;    // if the integer is found return true.
		}
		else               // if not found call the rotate method on
		{                  // last accessed integer.
			if(findl)    // if the last access was on a left branch of  the tree.
			{
				System.out.println(root.data);
				s=0;
				c=0;
				l=false;
				rotate(find_left.data,root);//find_left is the last accessed node on the left branc of the tree.
				s=0;            // the flags are reset to 0 and false before calling rotate method. 
				c=0;
				l=false;
				System.out.println("fixing code");
				System.out.println(root.data);
			}
			if(findr) // if the last access was on the right branch of the tree.
			{
				s=0;
				c=0;
				l=false;
				rotate(find_right.data,root);//find_right is the last accessed node on the right branch of the tree.
				s=0;            // the flags are reset to 0 and false before calling rotate method. 
				c=0;
				l=false;
			}
			findl=false;
			findr=false;
		}
		return false;
	}
	/*
	 * in private find method if a recursive method return false then the caller method stores the 
	 * its value in a variable which mite be find_left or find_right.
	 * then a flag findl or findr is set so that successive false returns does not overwrite the last accessed value.
	 */
	private boolean find(Integer x,Node t)
	{
		if(t==null)
		{
			return false;
		}
		int compare = x.compareTo(t.data);
		if(compare<0)
		{
			if(!(find(x,t.left)))
			{
				if((findl)||(findr))
					return false;
				find_left = t;
				System.out.println("inside find false: " + find_left.data);
				findl = true;
				return false;
			}
			return true;
		}
		if(compare>0)
		{
			if(!(find(x,t.right)))
			{
				if((findl)||(findr))
					return false;
				find_right=t;
				findr = true;
				return false;
			}		
			return true;
		}
			//return find(x,t.right);
			else
				return true;
		
	}
	/*The rotate method first declare references to parent, child,grandparent and greatgrandparent nodes.
	 *Then we find the node by comparing the x.data with t.data. At each find we pass the reference of the parent, child,
	 *grandparent a step back so that the parent has the reference of child, ranparent has reference of parent.. etc until the node is found.At this point we have references to parents three levels back.
	 * these reference fit into one of the left left or left right or their mirror image cases.Which are then rotated accordingly.
	 * Again the find procedure is carried.Hence the entire procedure is carried out until the child becomes the root.   
	 * */
	private void rotate(Integer x, Node t)
	{
		int compare=1;/*
		boolean found = false;
		boolean set = false;
		set = false;*/
		//System.out.println("this is dancing");
		while(s==0)// s is set to 1 only when child becomes the root.
		{
			//System.out.println(c);
			l = false; // l is used to keep track f which child the nodes are, ie if the parent is a left or right child of the grandparent
						// this is because we only have references of nodes but no knowledge of weather they were left or right child after grandparent node. 
		greatgrandparent=null;
		grandparent=null;
		parent=null;
		child = t;
		//found = false;
		t = root;//t is always set to root so that we start the comparison from root.
		//c = 0;
			while(c==0)// c is set to 1 when the integer we are looking for is found.
			{
				l = false;
				//System.out.println(found);
				//System.out.println(root.data);
				//System.out.println("last iteration: " + t.data);
				//System.out.println("cross-checking: " + root.data);
				compare = x.compareTo(t.data);
				if(compare<0)
				{
					greatgrandparent = grandparent;
					grandparent = parent;
					parent = child;
					child = t.left;
					t = t.left;
				}
				else if(compare>0)
				{
					greatgrandparent = grandparent;
					grandparent = parent;
					parent = child;
					child = t.right;
					t = t.right;
				}
				else if(compare==0)
				{
					//found = true;
					c=1;
					//System.out.println("data found: "+ x);
					//found = true;
					t = root;
				}
			}
			if(parent == null)
			{
				//set = true;
				//System.out.println("oops in here");
				s=1;
			}
			else if(grandparent==null)
			{
				if(parent.left==child)
				{
					parent.left = child.right;
					child.right = parent;
					root = child;
					//set = true;
					s = 1;
					//System.out.println("last hurdle, smashing it now => " + root.data);
				}
				if(parent.right==child)
				{
					parent.right = child.left;
					child.left = parent;
					root = child;
					//set = true;
					s = 1;
				}
			}
			else if((grandparent.left==parent)&&(parent.left==child))
			{
				if(greatgrandparent!=null)
				{
					//System.out.println("greatgrandparent.data: " + greatgrandparent.data);
					//System.out.println(greatgrandparent.left.data);
					//System.out.println(parent.data);
					if(greatgrandparent.left==grandparent)
					{
						//System.out.println("inside");
						l = true;
						//System.out.println("greatgrandparent.data: " + greatgrandparent.data);
					}
				}
				parent.left = child.right;
				grandparent.left = parent.right;
				parent.right = grandparent;
				child.right = parent;
				if(greatgrandparent==null)
				{
					root = child;
					child = root;
					//set = true;
					//System.out.println("here also");
				}
				else
				{
					if(l)
						greatgrandparent.left = child;
					else
						greatgrandparent.right = child;
				}
				//System.out.println("root.left: " + root.left.data);
				c=0;
			}
			else if((grandparent.right==parent)&&(parent.right==child))
			{
				if(greatgrandparent!=null)
				{
					if(greatgrandparent.left==grandparent)
					{
						l = true;
					}
				}
				grandparent.right = parent.left;
				parent.left = grandparent;
				parent.right = child.left;
				child.left = parent;
				if(greatgrandparent==null)
				{
					root = child;
					child = root;
					//set = true;
				}
				else
				{
					if(l)
						greatgrandparent.left = child;
					else
						greatgrandparent.right = child;
				}
				c=0;
			}
			else if((grandparent.left==parent)&&(parent.right==child))
			{
				if(greatgrandparent!=null)
				{
					if(greatgrandparent.left==grandparent)
					{
						l = true;
					}
				}
				parent.right=child.left;
				grandparent.left=child.right;
				child.left=parent;
				child.right=grandparent;
				if(greatgrandparent==null)
				{
					root = child;
					child = root;
					//set = true;
				}
				else
				{
					if(l)
					{
						greatgrandparent.left = child;
					}
					else
						greatgrandparent.right = child;
				}
				c=0;
			}
			else if((grandparent.right==parent)&&(parent.left==child))
			{
				if(greatgrandparent!=null)
				{
					if(greatgrandparent.left==grandparent)
					{
						l = true;
					}
				}
				grandparent.right = child.left;
				parent.left = child.right;
				child.left = grandparent;
				child.right = parent;
				if(greatgrandparent==null)
				{
					root = child;
					child = root;
					//set = true;
				}
				else
				{
					if(l)
					{
						greatgrandparent.left = child;
					}
					else
						greatgrandparent.right = child;
				}
				c=0;
			}
		}
	}
	public int leafCount()
	{
		int x=0;
		x = leafCount(root);
		count =0;
		return x; 
	}
	/*
	 * The private leafCount method compares the data x with that of the passed node.
	 * After comparision the procedure is recursively called until a leaf is found. At this point the count variable is incremented.
	 */
	private int leafCount(Node t)
	{
		if((t.left==null)&&(t.right==null)) // base case for the recursive method.
		{
			count++;                        // increment count after finding each leaf
			return count;                   // return leafcount.
		}
		if(t.left!=null)
		{
			count = leafCount(t.left);
			//System.out.println("left wing data: " + t.data);
		}
		if(t.right!=null)
		{
			count = leafCount(t.right);
		}
		return count;
	}
	public int treeSum()// public treeSum calls the private treeSum.
	{
		int s = treeSum(root);//root of the tree is passed as the parameter for the private treeSum method.
		sum = 0;
		return s;
	}
	/*
	 * private treeSum method takes Node as a parameter.
	 * Here base case is a leaf which adds its data to sum and returns sum.
	 * At each step the tree traverses to its left and then to its right.
	 * we add at each step on the left traversal, but we ass on the right only 
	 * on a node which does not have a left child.
	 */
	private int treeSum(Node t)
	{
		if((t.left==null)&&(t.right==null))
		{
			sum = sum + t.data;
			return sum;
		}
		if(t.left!=null)
		{
			sum = treeSum(t.left);
			sum = sum + t.data;
		}
		if(t.right!=null)
		{
			sum = treeSum(t.right);
			if(t.left==null)
				sum = sum + t.data;
		}
		return sum;
	}
	public String toString()
	{
		String s = toString(root) + " ]";
		sb = new StringBuilder("[ ");//clearing stringbuilder sb to avoid multiple appends on previous values.
		return s;
	}
	private StringBuilder toString(Node t)
	{
		if((t.left==null)&&(t.right==null))
		{
			sb.append(" " + t.data + " ");
			return sb;
		}
		if(t.left!=null)
		{
			sb = toString(t.left);
			sb.append(" " + t.data + " ");
		}
		if(t.right!=null)
		{
			sb = toString(t.right);
			if(t.left==null)
			{
				sb.append(" " + t.data + " ");
			}
		}
		return sb;
	}
	/*
	 * public printlevels method calls the private printLevels method.
	 */
	public String printLevels()
	{
		String sx = printLevels(root)+" ]";
		pl = new StringBuilder(" [");
		return sx;
	}
	/*
	 * In private printLevels method we first append the value of the node data only if its the root.
	 * Next we append the values of left and right child data, and recursively call the printLevel method on the left child
	 * first and then the right child.
	 */
	private StringBuilder printLevels(Node t)
	{
		if(t==root)
		{
			pl.append(" " + t.data + " ");
			//System.out.println(pl + " ");
		}
		if(t.left!=null)
		{
			pl.append(" " + t.left.data + " ");
			//pl = printLevels(t.left);
		}
		if(t.right!=null)
		{
			pl.append(" " + t.right.data + " ");
			//pl = printLevels(t.right);
		}
		if(t.left!=null)
			pl = printLevels(t.left);
		if(t.right!=null)
			pl = printLevels(t.right);
		return pl;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplayTree sp = new SplayTree();
		sp.add(50);
		sp.add(10);
		sp.add(60);
		sp.add(5);
		sp.add(15);
		sp.add(70);
		sp.add(20);
		//sp.add(7);
		System.out.println("leafCount: " + sp.leafCount());
		System.out.println("treeSum: " + sp.treeSum());
		System.out.println("toString(): " + sp.toString());
		System.out.println("printLevels(): " + sp.printLevels());
		/*System.out.println("confirming the root value before calling find function: " + sp.root.data);
		System.out.println("trying to find 4 in the tree = sp.find(4): " + sp.find(4));
		System.out.println("confirming the root value after find function: " + sp.root.data);
		System.out.println("printLevels(): " + sp.printLevels());
		System.out.println("toString(): " + sp.toString());
		System.out.println("confirming the root value before calling find function on value that does not exist in the tree: " + sp.root.data);
		System.out.println("trying to find 21(which is not there in the tree) in the tree = sp.find(21): " + sp.find(21));
		//System.out.println("21 does not exist in the tree and the last value accessed in the tree would be 20");
		System.out.println("confirming the root value after find function: " + sp.root.data);*/
	}
}