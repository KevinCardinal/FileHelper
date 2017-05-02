package filehelper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

public class LineInput implements Iterable<String>
{
	private String name;
	private BufferedReader src;
	
	public LineInput(String name)
	{
		this.name = name;
	}
	
	public void open() throws FileNotFoundException
	{
		InputStream ips = new FileInputStream(name);
		InputStreamReader ipsr = new InputStreamReader(ips);
		src = new BufferedReader(ipsr);
	}
	
	public String read() throws IOException
	{
		return src.readLine();
	}
	
	public void close() throws IOException
	{
		src.close();
	}
	
	@Override
	public Iterator<String> iterator() 
	{
		return new LineInputIterator(name);
	}
	
	public static void main(String[] args)
	{
		LineInput i = new LineInput("yolo.txt");
		for(String s : i)
		{
			System.out.println(s);
		}
	}

}
