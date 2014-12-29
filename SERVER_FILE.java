//import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
//import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SERVER_FILE {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(14999);
		//Scanner sc = new Scanner(System.in);
		//System.out.println("SERVER STARTED");
		
		Socket gotit = server.accept();
		System.out.println("LAPTOP ACCEPTED");
		Socket android = server.accept();
		System.out.println("ANDROID ACCEPTED");
		Socket sync = new Socket("localhost",13999);
		FileOutputStream fos;
		BufferedOutputStream bos;
		//System.out.println("SERVER STARTED");
		
	
		BufferedReader help2 = new BufferedReader( new InputStreamReader(System.in));
		//System.out.println("ACCEPTED CLIENT");
		PrintWriter out = new PrintWriter(gotit.getOutputStream(),true);
		Scanner sc = new Scanner(System.in);
		InputStream in = (gotit.getInputStream());
		InputStream in1 = (android.getInputStream());
		int test=0;
		
		String name="";
		OutputStream os = sync.getOutputStream();
		OutputStream as = android.getOutputStream();
		//below, change the path of the file to a path on the server,also please dont forget to
		//change another path below in the code, it is marked by"THIS IS THE PLACE", change that
		//path to the same path that you enter below.
		File myFile = new File("C:\\Users\\Reliance\\workspace\\ACN_PROJECT\\TRANSFER.txt");//this one

		while(true)
		{
			BufferedInputStream help = new BufferedInputStream(System.in);
			if( (test=(help).available())>0 || in.available()>0 || in1.available()>0)
			{
				//help.skip(test);
				if(in.available()>0)
				{
					if(in.available()>0)
					{
						System.out.println("writing something");
						
						if(!(myFile.exists()))
						{
							//THIS IS THE PLACE
							//please change the below path to the same as the previous one.
							fos = new FileOutputStream("C:\\Users\\Reliance\\workspace\\ACN_PROJECT\\TRANSFER.txt");
							bos = new BufferedOutputStream(fos);
						
					byte[] mybytes = new byte[10000000];
					int bytesRead = in.read(mybytes,0,mybytes.length);
					bos.write(mybytes,0,bytesRead);
					bos.close();
						}
						else
						{
							System.out.println("it exists");
							fos = new FileOutputStream(myFile);
							bos = new BufferedOutputStream(fos);
						
					byte[] mybytes = new byte[10000000];
					int bytesRead = in.read(mybytes,0,mybytes.length);
					bos.write(mybytes,0,bytesRead);
					bos.close();
						}
						
						////update android
						BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
						byte[] mybytearray = new byte[(int) myFile.length()];
						bis.read(mybytearray, 0, mybytearray.length);
						as.write(mybytearray, 0, mybytearray.length);
						as.flush();	
					}
				}
				
				
				
				
				//////
				
				if(in1.available()>0)
				{
					if(in1.available()>0)
					{
						System.out.println("writing something from android");	
						if(!(myFile.exists()))
						{
							//THIS IS THE PLACE
							//please change the below path to the same as the previous one.
							fos = new FileOutputStream("C:\\Users\\Reliance\\workspace\\ACN_PROJECT\\TRANSFER.txt");
							bos = new BufferedOutputStream(fos);
						
					byte[] mybytes = new byte[10000000];
					int bytesRead = in1.read(mybytes,0,mybytes.length);
					bos.write(mybytes,0,bytesRead);
					bos.close();
						}
						else
						{
							System.out.println("it exists");
							fos = new FileOutputStream(myFile);
							bos = new BufferedOutputStream(fos);
						
					byte[] mybytes = new byte[10000000];
					int bytesRead = in1.read(mybytes,0,mybytes.length);
					bos.write(mybytes,0,bytesRead);
					bos.close();
						}
					}
				}
				if(test>0)
				{
					System.out.println("IT WORKS");
					byte[] mybytearray = new byte[(int) myFile.length()];
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
					bis.read(mybytearray, 0, mybytearray.length);
					os.write(mybytearray, 0, mybytearray.length);
					os.flush();	
					test=help.read();
					
					///for android
					bis.read(mybytearray, 0, mybytearray.length);
					as.write(mybytearray, 0, mybytearray.length);
					as.flush();	
				}
			}
			test=0;
		}
	}

}