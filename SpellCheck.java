//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.*;
import java.util.Scanner;


public class SpellCheck extends LinearHashTable<String>{

	/**
	 * @param args
	 * @throws IOException 
	 */
	StringBuilder sb = new StringBuilder("[ ");
	static int size;
	int count = 0; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		LinearHashTable<String> load = new LinearHashTable<>();
		String store="";
		String reset = "";
		String path="";
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Please enter the path of Dictionary File");
		path = sc1.nextLine();//if you are not able to enter the path correctly, please assign path directly to path instead of the code sc1.nextLine() 
		//BufferedReader bf = new BufferedReader(new FileReader("src/dictionary.txt"));
		BufferedReader bf = new BufferedReader(new FileReader(path));
		SpellCheck sc = new SpellCheck();
		long start = System.currentTimeMillis( );
		while((store=bf.readLine())!=null)
		{
			//System.out.println(store);
			load.insert(store);
		}
		long end = System.currentTimeMillis( );
		System.out.println(load.theSize);
		size = load.theSize;
		System.out.println("elapsed time= " + (end-start));
		long start1 = System.currentTimeMillis( );
		System.out.println("Please enter the path of paragraph File that needs to be verified: ");
		path = sc1.nextLine();//if you are not able to enter the path correctly, please assign path directly to path instead of the code sc1.nextLine()
		//BufferedReader bf2 = new BufferedReader(new FileReader("src/nosilverbullet.txt"));
		BufferedReader bf2 = new BufferedReader(new FileReader(path));
		while((store=bf2.readLine())!=null)
		{
			//System.out.println(store);
		for(int f=0;f<store.length();f++)
		{
			if((store.charAt(f)==' ')||(store.charAt(f)==',')||(store.charAt(f)=='.')||(store.charAt(f)=='-')||(store.charAt(f)==';'))
			{
				if(!reset.equals(""))
				{
					reset = reset.toLowerCase();
					sc.Analyse(reset,load);
				}
				reset = "";
			}
			else
			{
				reset = reset + store.charAt(f);
			}
		}
		}
		long end1 = System.currentTimeMillis( );
		System.out.println("time to : " + (end1-start1));
	}
	public void Analyse(String s, LinearHashTable<String> load)
	{
		//System.out.println("inside analyse: s= " + s);
		if(load.contains(s))
		{
			//System.out.println("repeating words: "+ s);
			return;
		}
		else
		{
			for(int i=0;i<load.array.length;i++)
			{
				if(load.array[i]!=null)
				{
					if((this.compareTwo(s,(String)load.array[i].element))==1)
					{
						sb.append(load.array[i].element + " ");
					}
					else
						;
				}
			}
		}
		System.out.println("the word " + s + " is misspelled, below is a list of suggested words: ");
		sb.append(" ]");
		System.out.println(sb);
		sb = new StringBuilder("[ ");
	}
	public int compareTwo(String x,String s)
	{
		if(s.length()!=x.length())
			return -1;
		else
		{
			for(int j=0;j<s.length();j++)
			{
				if(s.charAt(j)!=x.charAt(j))
				{
					count++;
				}
			}
			if(count<=1)
			{
				count=0;
				return 1;
			}
			else
			{
				count=0;
			}
		}
		return 0;
	}
}