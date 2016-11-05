package ChatStuff;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Chat extends Thread {
	public static String path;
	public static String name;
	public static void logs() throws Exception
	{
		BufferedReader br = new BufferedReader(
		        new InputStreamReader(new FileInputStream(path)));
		try {
		    String line;
		    while ((line = br.readLine()) != null) {
		        System.out.println(line);
		    }
		} finally {
		    br.close();
		}
	}
	   @Override
	   public void run()
	   {
			System.out.println("================Chat===============");
			Server serv = new Server();
			try {
				serv.readMessages();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			name = JOptionPane.showInputDialog("Please select your name: ");
			String text;
			Boolean open = true;
			while(open == true)
			{
				//try {
				//	serv.readMessages();
				//} catch (Exception e) {
					// TODO Auto-generated catch block
			//		e.printStackTrace();
			//	}
				Scanner sc = new Scanner(System.in);
				text = "";
				text = JOptionPane.showInputDialog("Message: ");
				if(text == null)
				{
					open = false;
					serv.close();
				} 
				else
				{
				try {
					SendMsg.Send(text);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				text = "";
				sc.close();
				}
			}
	   }

}
