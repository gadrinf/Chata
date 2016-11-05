package ChatStuff;
import java.sql.*;


public class Server {
	 private static Connection connect = null;
	 private static Statement statement = null;
	 private static PreparedStatement preparedStatement = null;
	 private static ResultSet resultSet = null;

	 final private static String host = "ftp.flowrstuff.com";
	 final private static String user = "flowrstu";
	 final private static String passwd = "D317t816!";
	 
	  public void readMessages() throws Exception {
		    try {
		      // This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://" + host + "/flowrstu_Chat?"
		              + "user=" + user + "&password=" + passwd );

		      // Statements allow to issue SQL queries to the database
		      statement = connect.createStatement();
		      // Result set get the result of the SQL query
		      resultSet = statement
		          .executeQuery("select * from flowrstu_Chat.Messages");
		      writeResultSet(resultSet);

		      
		    } catch (Exception e) {
		      throw e;
		    } finally {
		     
		    }

		  }

		  

		  private void writeResultSet(ResultSet resultSet) throws SQLException {
		    // ResultSet is initially before the first data set
		    while (resultSet.next()) {
		      // It is possible to get the columns via name
		      // also possible to get the columns via the column number
		      // which starts at 1
		      // e.g. resultSet.getSTring(2);
		      //Timestamp TimeStamp = resultSet.getTimestamp("TimeStamp");
		      String Name = resultSet.getString("Name");
		      String Message = resultSet.getString("Message");
		      System.out.println(Name + ": " + Message);

		    }
		  }
		  public void sendMessage(String name, String message) throws Exception
		  {
			  preparedStatement = connect
			          .prepareStatement("insert into  flowrstu_Chat.Messages values (Default, ?, ?)");
			    preparedStatement.setString(1, name);
			    preparedStatement.setString(2, message);
			    preparedStatement.executeUpdate();
		  }
		  // You need to close the resultSet
		  public void close() {
		    try {
		      if (resultSet != null) {
		        resultSet.close();
		      }

		      if (statement != null) {
		        statement.close();
		      }

		      if (connect != null) {
		        connect.close();
		      }
		    } catch (Exception e) {

		    }
		  }
		  public static ResultSet getResultSet() {
			return resultSet;
		}



		public static void setResultSet(ResultSet resultSet) {
			Server.resultSet = resultSet;
		}



		public boolean checkForNew(ResultSet results)
		  {
			  if(results != null && results.equals(resultSet))
			  {
				  return false;
			  }else return true;
			
		  }
}
