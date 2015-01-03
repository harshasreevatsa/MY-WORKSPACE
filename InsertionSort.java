
public class InsertionSort{

	/**
	 * @param args
	 */
	public static 
	void insertionSort( Integer [ ] a )
	 {
	 int j;
	
	 for( int p = 1; p < a.length; p++ )
	 {
	 Integer tmp = a[ p ];
	 for( j = p; j > 0 && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
	 {
		 System.out.println("p= " + p);
		 System.out.println( a[j-1] + " was greater than temp= " + tmp);
		 System.out.println("for reference j= " + j);
		 a[ j ] = a[ j - 1 ];
		 System.out.println("last val= " + j);
	 }
	 System.out.println("out of loop, now j val= " + j);
	 a[ j ] = tmp;
	 }
	 System.out.println("printing sorted array: " );
	 for(int i=0;i<a.length;i++)
		 System.out.println(a[i]);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSort s = new InsertionSort();
		Integer a[] = new Integer[6];
		a[0]=34;
		a[1]=8;
		a[2]=64;
		a[3]=51;
		a[4]=32;
		a[5]=21;
		s.insertionSort(a);
}
}