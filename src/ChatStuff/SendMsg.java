package ChatStuff;

import java.io.IOException;

public class SendMsg {
	public static void Send(String str) throws IOException
	{

		Server serve = new Server();
		try {
			serve.sendMessage(Chat.name, str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}