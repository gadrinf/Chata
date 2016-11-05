package ChatStuff;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveLog {
	String path;
	boolean append = true;
	
	public SaveLog(String file_path)
	{
		path = file_path;
	}
	
	public SaveLog(String file_path, boolean append)
	{
		path = file_path;
		this.append = append;
	}
	
	public void write(String textLine) throws IOException
	{
		FileWriter write = new FileWriter(path, append);
		PrintWriter print_line = new PrintWriter(write);
		print_line.println(textLine);
		print_line.close();
	}
}
