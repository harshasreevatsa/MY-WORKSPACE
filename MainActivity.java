package com.example.server_client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.support.v7.app.ActionBarActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener{

	Socket client;
	boolean send=false;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b = (Button) findViewById(R.id.CONNECT);
		Button b1 = (Button) findViewById(R.id.SEND);
		Button b2 = (Button) findViewById(R.id.RECEIVE);
		b.setOnClickListener(new View.OnClickListener(){
	
			
			public void onClick(View v)
			{
				new test().execute();//this is to connect
			}
		});	
		
		b1.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v)
			{
				send=true;
				new test1().run();//this is to send files,
			}
		});
		
		b2.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v)
			{
				new receive().run();//this is to receive files, run this only once
			}
		});
	}
		public class test extends AsyncTask<Void,Void,Void>
		{
			@Override
			protected  Void doInBackground(Void... params) 
			{
				// TODO Auto-generated method stub
				
					//f.createNewFile();
					
					//if(f.exists())
						//f.createNewFile();
					//f.createNewFile();
					try {
						client = new Socket("10.0.2.2",14999);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					File f = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(),"TRANSFER.pdf");
					try {
						f.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try
					{
						Log.i("WORKING0","WORKING0");
						//f.createNewFile();
						
						//if(f.exists())
							//f.createNewFile();
						//f.createNewFile();
						//client = new Socket("10.0.2.2",14999);
						Log.i("WORKING1","WORKING1");
						InputStream in = client.getInputStream();
						
						byte[] mba = new byte[10000];
						FileOutputStream fo = new FileOutputStream(f);
						BufferedOutputStream bo = new BufferedOutputStream(fo);
						int byteread=0;
						while(true)
						{
						while(in.available()>0)
						{	
							//f = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(),"TRANSFER.txt");
							//f.delete();
							//f = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(),"TRANSFER.txt");
							//f.createNewFile();
							/*PrintWriter pw = new PrintWriter(Environment.getExternalStorageDirectory().getAbsoluteFile(),"TRANSFER.txt");
							pw.write("");
							pw.close();*/
							fo = new FileOutputStream(f);
							bo = new BufferedOutputStream(fo);
							byteread = in.read(mba,0,mba.length);
							bo.write(mba,0,byteread);
							bo.close();
						}
						//bo.close();
						}
						//
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				return null;
			}
			
		}
		
		public class receive implements Runnable
		{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				File f = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(),"TRANSFER.pdf");
				try {
					f.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try
				{
					Log.i("WORKING0","WORKING0");
					//f.createNewFile();
					
					//if(f.exists())
						//f.createNewFile();
					//f.createNewFile();
					//client = new Socket("10.0.2.2",14999);
					Log.i("WORKING1","WORKING1");
					byte[] mba = new byte[(int)f.length()];
					FileOutputStream fo = new FileOutputStream(f);
					BufferedOutputStream bo = new BufferedOutputStream(fo);
					InputStream in = client.getInputStream();
					int byteread=0;
					while(true)
					{
					while(in.available()>0)
					{
						byteread = in.read();
						bo.write(byteread);
						bo.flush();
					}
					//bo.close();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		}
		
		public class test1 implements Runnable
		{
			//@Override
			@Override
			public void run() {
				// TODO Auto-generated method stub
				File f1 = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(),"TRANSFER.pdf");
				if(f1.exists())
					Log.i("SENDING","OUT1");
				try
				{
					
					
					if(send){
					//File f1 = new File("/mnt/sdcard/TRANSFER.txt");
					byte[] mba = new byte[(int)f1.length()];
					FileInputStream in = new FileInputStream(f1);
					BufferedInputStream bin = new BufferedInputStream(in);
					OutputStream os1 = client.getOutputStream();
					Log.i("SENDING","OUT");
					bin.read(mba,0,mba.length);
					os1.write(mba,0,mba.length);
					os1.flush();
					Log.i("FINISHED","SENDING");
					send=false;
					}
				}
				catch(Exception e)
				{
					
				}
			}
			
		}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
}
