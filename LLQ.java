class LLQ<AnyType> implements Iterable<AnyType> {

	/**
	 * @param args
	 */
	private int theSize=0;
	private static final int minSize=10;
	AnyType[] list;
	public LLQ()
	{
		clear();
	}
	public void clear()
	{
		
		BeginMarker = new Node<>(null,null,null);
	    EndMarker = new Node<>(null,BeginMarker,null);
	    BeginMarker.next = EndMarker;
		theSize=0;
		createArray(minSize);
	}
	public int size()
	{
		return theSize;
	}
	public void createArray(int idx) 
	{
		if(idx<size())
			return;
		
		if(idx<0)
			throw new IndexOutOfBoundsException();
		
		AnyType[] old = list;
		list =(AnyType[]) new Object[2*idx];
		for(int i=0;i<size();i++)
		{
			list[i] = old[i];
		}
	}
	public void add(int idx,AnyType x)
	{
		if((idx<0)||(idx>list.length))
			throw new ArrayIndexOutOfBoundsException();
		if(size()==list.length)
			createArray(2*size()+1);
		
		Node<AnyType> p;
		p = getNode(idx);
		Node<AnyType> p1 = new Node<>(x,p.prev,p);
		(p.prev).next = p1;
		p.prev = p1;
		theSize++;
	}
	public void add(AnyType x)
	{
		add(size(),x);
	}
	public Node<AnyType> getNode(int idx)
	{
		Node<AnyType> p;
		p = BeginMarker.next;
		for(int i=0;i<idx;i++)
			p = p.next;
		return p;
	}
	public Node<AnyType> getNode(AnyType x)
	{
		Node<AnyType> p;
		p = BeginMarker.next;
		for(int i=0;i<size();i++)
		{
			if(p.data==x)
			{
				return p;
			}
			p = p.next;
		}
		return p;
	}
	public void remove(AnyType x)
	{
		Node<AnyType> p = getNode(x);
		p.prev.next = p.next;
		p.next.prev = p.prev;
	}
	public java.util.Iterator<AnyType> iterator()
	{
		return new LinkedListIterator();
	}
	
	public class LinkedListIterator implements java.util.Iterator<AnyType>
	{
		Node<AnyType> current = BeginMarker.next;
		boolean okToRemove = false;
		public boolean hasNext()
		{
			if(current==EndMarker)
				return false;
			else
				return true;
		}
		public AnyType next()
		{
			if(!hasNext())
				throw new ArrayIndexOutOfBoundsException();
			else
			{
				AnyType item = current.data;
				current = current.next;
				okToRemove = true;
				return item;
			}
		}
		public void remove()
		{
			if(!okToRemove)
			{
				throw new IllegalArgumentException();
			}
			else
			{
				LLQ.this.remove(current.prev.data);
			}
		}
	}
	public String toString()
	{
		StringBuilder sb = new StringBuilder("[ ");
		for(AnyType x:this)
		{
			sb.append(x + " ");
		}
		sb.append(" ]");
		return new String(sb);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LLQ<Integer> list = new LLQ<>();
		for(int i=0;i<10;i++)
		{
			list.add(i,i);
		}
		java.util.Iterator<Integer> itr = list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
			itr.remove();
		}
	}
	private static class Node<AnyType>
	{
		public Node(AnyType x,Node<AnyType> p1,Node<AnyType> n1)
		{
			data = x;
			prev = p1;
			next = n1;
		}
		AnyType data;
		Node<AnyType> prev;
		Node<AnyType> next;
		
	}
	public Node<AnyType> BeginMarker;
	public Node<AnyType> EndMarker;
}