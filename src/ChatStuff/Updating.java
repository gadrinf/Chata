package ChatStuff;

import java.sql.*;



public class Updating extends Thread {
	@Override
	public void run()
	{
		ResultSet results;
		Server serv = new Server();
		results = Server.getResultSet();
		while(true){
			if(serv.checkForNew(results))
			{
				try {
					serv.readMessages();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				results = Server.getResultSet();
			}

		}
	}
}
