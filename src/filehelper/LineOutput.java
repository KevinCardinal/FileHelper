package filehelper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class LineOutput 
{
	private String name;
	private PrintWriter src;
	
	public LineOutput(String name)
	{
		this.name = name;
	}
	
	public void open()
	{
		try
		{
			FileWriter fw = new FileWriter(name);
			BufferedWriter bw = new BufferedWriter(fw);
			src = new PrintWriter(bw);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			throw new RuntimeException("IOException when attempting open");
		}
	}
	
	public void write(String s)
	{
		src.println(s);
	}
	
	public void write(Collection<String> c)
	{
		for(String s : c)
		{
			write(s);
		}
	}
	
	public void write(String[] c)
	{
		for(String s : c)
		{
			write(s);
		}
	}
	
	public void close()
	{
		src.close();
	}
}
