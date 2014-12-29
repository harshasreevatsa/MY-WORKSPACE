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

public class CLIENT_SIDE {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket sync = new Socket("localhost",14999);
		ServerSocket server = new ServerSocket(13999);
		//Scanner sc = new Scanner(System.in);
		//System.out.println("SERVER STARTED");
		
		Socket gotit = server.accept();
		System.out.println("CLIENT ACCEPTED");
		
		
		
		
		//System.out.println("SERVER STARTED");
		
		//System.out.println("ACCEPTED CLIENT");
		PrintWriter out = new PrintWriter(gotit.getOutputStream(),true);
		Scanner sc = new Scanner(System.in);
		InputStream in = (gotit.getInputStream());
		FileOutputStream fos;
		BufferedOutputStream bos;
		String name="";
		int test=0;
		OutputStream os = sync.getOutputStream();
		File myFile = new File("C:\\Users\\Reliance\\Desktop\\UTD SEM1\\EXP.txt");
		File myFile1 = new File("C:\\Users\\Reliance\\workspace\\ACN_PROJECT\\TRANSFER1.txt");
		while(true)
		{
			BufferedInputStream help = new BufferedInputStream(System.in);
			if((test=(help).available())>0 || in.available()>0)
			{
				if(in.available()>0)
				{
					if(in.available()>0)
					{
						System.out.println("writing something");
						if(!(myFile1.exists()))
						{
							fos = new FileOutputStream("C:\\Users\\Reliance\\workspace\\ACN_PROJECT\\TRANSFER1.txt");
							bos = new BufferedOutputStream(fos);
						
					byte[] mybytes = new byte[1024];
					int bytesRead = in.read(mybytes,0,mybytes.length);
					bos.write(mybytes,0,bytesRead);
					bos.close();
						}
						else
						{
							System.out.println("it exists");
							fos = new FileOutputStream(myFile1);
							bos = new BufferedOutputStream(fos);
						
					byte[] mybytes = new byte[1024];
					int bytesRead = in.read(mybytes,0,mybytes.length);
					bos.write(mybytes,0,bytesRead);
					bos.close();
						}
					}
				}
		
		
				if(test>0)     // for updating the server from client
				{
					test=0;
					System.out.println("IT WORKS");
					byte[] mybytearray = new byte[(int) myFile.length()];
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
					bis.read(mybytearray, 0, mybytearray.length);
					os.write(mybytearray, 0, mybytearray.length);
					os.flush();
					
					test=help.read();
				}
			
			}
			test=0;
		}
	}

}
