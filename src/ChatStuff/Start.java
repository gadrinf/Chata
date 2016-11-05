package ChatStuff;

public class Start {
	public static void main(String[] args)
	{
		Chat chat = new Chat();
		Updating update = new Updating();
		chat.start();
		update.start();
	}
}
