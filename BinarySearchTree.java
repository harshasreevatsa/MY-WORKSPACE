public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

	/**
	 * @param args
	 */
	int count = 0;
	int sum = 0;
	int i =1;
	boolean visited = false;
	BinaryNode<AnyType> root = null;
	StringBuilder sb1 = new StringBuilder();
	String str1 = "";
	BinaryNode<AnyType> t2;
	BinaryNode<AnyType> t1;
	BinaryNode<AnyType> t3;
	boolean visited1 = false;
	String d = "";
	StringBuilder sb = new StringBuilder("[ ");
	public BinarySearchTree()
	{
		root = new BinaryNode<>();
	}
	public class BinaryNode<AnyType>
	{
		AnyType data;
		BinaryNode<AnyType> leftchild;
		BinaryNode<AnyType> rightchild;
		public void createNode(AnyType x,BinaryNode<AnyType> lc,BinaryNode<AnyType> rc)
		{
			data = x;
			leftchild = lc;
			rightchild = rc;
		}
	}
	public boolean find(AnyType x)
	{
		if(find(x,root))
		{
			rotate(x);
			return true;
		}
		return false;
	}
	public boolean find(AnyType x,BinaryNode<AnyType> t)
	{
		if(t == null)
		{
			return false;
		}
		int compare_result = x.compareTo(t.data);
		if(compare_result<0)
		{
			return find(x, t.leftchild);
		}
		else if(compare_result>0)
		{
			return find(x, t.rightchild);
		}
		else
			return true;
	}
	public void add(AnyType x)
	{
		root = add(x,root);
		rotate(x);
	}
	public BinaryNode<AnyType> add(AnyType x,BinaryNode<AnyType> tx)
	{
		if(tx == null)
		{
			tx = new BinaryNode<AnyType>();
			tx.data = x;
			return tx;
		}
		if(tx.data==null)
		{
			root.data = x;
			t2=root;
			t3=root;
			t1=root;
			return root;
		}
		int compare_result = x.compareTo(tx.data);
		if(compare_result<0)
		{
			tx.leftchild = add(x, tx.leftchild);
		}
		else if(compare_result>0)
		{
			tx.rightchild = add(x, tx.rightchild);
		}
		else
			;
		//System.out.println("before return123456");
		return tx;
	}
	public void rotate(AnyType x)
	{

		//System.out.println(root.data);
		rotate(x,root);
		//System.out.println(root.data);
	}
	public void rotate(AnyType x,BinaryNode<AnyType> t)
	{
		boolean found = false;
		
		int c=0;
		BinaryNode<AnyType> parent;
		BinaryNode<AnyType> grandparent;
		BinaryNode<AnyType> child;
		BinaryNode<AnyType> greatgrandparent;
		child = t;
		parent = null;
		grandparent = null;
		greatgrandparent = null;
		//System.out.println("inside rotate");
		
		if((t.leftchild==null)&&(t.rightchild==null))
			root = t;
		else
		{
			//System.out.println(i);
			
			
			while(i==1)
			{	
				System.out.println(i);
				child = t;
				parent = null;
				grandparent = null;
				greatgrandparent = null;
				found = false;
				c++;
				t = root;
				//System.out.println(c);
				System.out.println("hello");

				while(!found)
				{
					//System.out.println("inside");
					//System.out.println(root.data);
					int compare_result = x.compareTo(t.data);

					if(compare_result<0)
					{
						System.out.println("1st if");
						greatgrandparent = grandparent;
						grandparent = parent;
						parent = child;
						child = t.leftchild;
						t = t.leftchild;
						System.out.println("inside here!!!");
					}
					else if(compare_result>0)
					{
						System.out.println("2nd if");
						greatgrandparent = grandparent;
						grandparent = parent;
						parent = child;
						child = t.rightchild;
						t = t.rightchild;
						//System.out.println(parent.data);
					}
					else
					{
						found = true;
						//System.out.println(t.data);
					}
				}
				if(grandparent==null)
				{
					//System.out.println(parent==null);
					//System.out.println(child.data);
					if(parent.leftchild==child)
					{
						parent.leftchild=child.rightchild;
						child.rightchild=parent;
						root = child;
						child = root;
						i =0;
					}
					else if(parent.rightchild==child)
					{
						parent.rightchild=child.leftchild;
						child.leftchild=parent;
						root = child;
						child = root;
						i=0;
						//System.out.println(done);
						//System.out.println(child.data);
					}
					//done = false;
				}
				else if((grandparent.leftchild == parent)&&(parent.leftchild == child))
				{
					if(greatgrandparent==null)
					{
						root = child;
						i=0;
					}
					else
					{
						greatgrandparent.leftchild = child;
					}
					parent.leftchild=child.rightchild;
					grandparent.leftchild=parent.rightchild;
					child.rightchild=parent;
					parent.rightchild=grandparent;
					parent = greatgrandparent;
					t = root;
				}
				else if((grandparent.rightchild == parent)&&(parent.rightchild == child))
				{
					if(greatgrandparent==null)
					{
						root = child;
						i=0;
					}
					else
					{
						greatgrandparent.rightchild = child;
						System.out.println(root.data + " here!!!!");
					}
					grandparent.rightchild = parent.leftchild;
					parent.rightchild=child.leftchild;
					child.leftchild=parent;
					parent.leftchild=grandparent;
					System.out.println(root.rightchild.data);
					System.out.println(root.rightchild.leftchild.data);
					System.out.println(root.rightchild.leftchild.leftchild.data);
					t = root;
				}
				else if((grandparent.leftchild==parent)&&(parent.rightchild==child))
				{
					if(greatgrandparent==null)
					{
						root = child;
						i=0;
					}
					else
					{
						greatgrandparent.leftchild=child;
					}
					parent.rightchild=child.leftchild;
					grandparent.leftchild=child.rightchild;
					child.leftchild=parent;
					child.rightchild=grandparent;
					t = root;
				}
				else if((grandparent.rightchild==parent)&&(parent.leftchild==child))
				{
					if(greatgrandparent==null)
					{
						root = child;
						i=0;
					}	
					else
					{
						greatgrandparent.rightchild=child;
					}
					grandparent.rightchild=child.leftchild;
					parent.leftchild=child.rightchild;
					child.leftchild=grandparent;
					child.rightchild=parent;
					t = root;
				}
				//System.out.println(i);//System.out.println(child==root);
			}
			//System.out.println("trying to return");
			//if(i==0)
				//i=0;
		}
		//System.out.println("outside else");
	//	System.out.println(i);
		//System.out.println(root.data);
		
	}

	//public int leafCount()
	//{
	//	return leafCount(root);
	//}
	public int leafCount(BinaryNode<AnyType> t)
	{
		if((t.leftchild==null)&&(t.rightchild==null))
		{
			count++;
		}
		else
		{
			while(t.leftchild!=null)
			{
				t = t.leftchild;
				count = leafCount(t);
			}
			while(t.rightchild!=null)
			{
				t = t.leftchild;
				count = leafCount(t);
			}
		}
		return count;
	}
	public int treeSum()
	{
		//System.out.println(root.data);
		this.sum = 0;
		return treeSum(root);
	}
	public int treeSum(BinaryNode<AnyType> t)
	{
		System.out.println(t.data);
		if((t.leftchild==null)&&(t.rightchild==null))
		{
			this.sum = sum + (Integer)t.data;
		}
		else
		{
			while(t.leftchild!=null)
			{
				this.sum = this.sum + (Integer)t.data;
				t = t.leftchild;
				this.sum = treeSum(t);
				visited = true;
			}
			while(t.rightchild!=null)
			{
				if(!visited)
				{
					this.sum = this.sum + (Integer)t.data;
				}
				t = t.rightchild;
				this.sum = treeSum(t);
			}
		}
		return this.sum;
	}
	public String toString()
	{
		return toString(root);
	}
	public String toString(BinaryNode<AnyType> t)
	{
		if((t.leftchild==null)&&(t.rightchild==null))
		{
			sb.append(t.data);
		}
		else
		{
			if(t.leftchild!=null)
			{
				d = " " + t.data + " ";
				t = t.leftchild;
				//str1 = toString();
				sb.append(d + " ");
				toString(t);
				visited1 = true;
			}
			if(t.rightchild!=null)
			{
				if(!visited1)
				{
					d = " " + t.data + " ";
				}
				t = t.rightchild;
				toString(t);
				if(!visited1)
				{
					sb.append(d + " ");
					visited1 = false;
				}
			}
		}
		return new String(sb);
	}
	public void printLevels()
	{
		printLevels(root);
	}
	public void printLevels(BinaryNode<AnyType> t)
	{
		if((t.leftchild==null)&&(t.rightchild==null))
		{
			sb.append(t.data + " ");
		}
		else
		{
			if(t.leftchild!=null)
			{
				d = " " + t.data;
				sb.append(d);
				t = t.leftchild;
				//str1 = toString();
				visited1 = true;
				printLevels(t);
			}
			if(t.rightchild!=null)
			{
				if(!visited1)
				{
					d = " " + t.data + " ";
					sb.append(d + " ");
					visited1 = false;
				}
				t = t.rightchild;
				//toString();
				printLevels(t);
			}
		}
		sb.append(" ]");
		System.out.println(new String(sb));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer> st = new BinarySearchTree<>();
		st.add(8);
		//System.out.println(st.root.data);
		st.add(12);
		//System.out.println(st.root.data);
		st.add(6);
		System.out.println(st.root.data);
		//		System.out.println(st.root.data);
		st.add(16);
		//	System.out.println(st.root.data);
		/*st.add(4);
		st.add(5);*/
		//System.out.println(st.find(90));
		System.out.println(st.root.data);
	}
}