public class MyStack<AnyType> extends MyLinkedList<AnyType> {
	public static void main(String[] args) {	
		MyStack<String> stack = new MyStack<>();
		String[] test = {"[","(","{","}","{","}",")","]"};
		System.out.println("Demonstrating MyStack program for the input: ");
		for(int i=0;i<test.length;i++)
			System.out.println(test[i]);
		for(int i=0;i<test.length;i++)
		{
			if(stack.size()==0)
			{
				stack.add(0,test[i]);
			}
			else if((test[i].equals("["))||(test[i].equals("("))||(test[i].equals("{")))
			{
				stack.add(0,test[i]);
			}
			else if((test[i].equals("]"))||(test[i].equals(")"))||(test[i].equals("}")))
			{
				String d = stack.remove(0);
				if(d.equals("["))
				{
					if(!(test[i].equals("]")))
					{
						System.out.println("there are errors in the code!!!!!!!!!!!!!!");
						System.out.println("the open/closing braces do not match!!!");
						throw new ArrayIndexOutOfBoundsException();
					}
				}
				if(d.equals("("))
				{
					if(!(test[i].equals(")")))
					{
						System.out.println("there are errors in the code!!!!!!!!!!!!!!");
						System.out.println("the open/closing braces do not match!!!");
						throw new ArrayIndexOutOfBoundsException();
					}
				}
				if(d.equals("{"))
				{
					if(!(test[i].equals("}")))
					{
						System.out.println("there are errors in the code!!!!!!!!!!!!!!");
						System.out.println("the open/closing braces do not match!!!");
						throw new ArrayIndexOutOfBoundsException();
					}
				}
			}
		}
		if(stack.size()!=0)
		{
			System.out.println("there are errors in the code!!!!!!!!!!!!!!");
			System.out.println("the number of open/closing braces do not match!!!");
			throw new ArrayIndexOutOfBoundsException();
		}
		else
		{
			System.out.println("All the opening and closing braces match and is good to go!!!!");
		}
	}
}
