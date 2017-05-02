package filehelper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

public class LineInputIterator implements Iterator<String>
{

	private String nextLine;
	private BufferedReader src;
	
	public LineInputIterator(String name)
	{
		try
		{
			InputStream ips = new FileInputStream(name);
			InputStreamReader ipsr = new InputStreamReader(ips);
			src = new BufferedReader(ipsr);
			nextLine = src.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			throw new RuntimeException("File " + name + " not found or IOException when attempting readLine mehtod");
		}
	}
	
	@Override
	public boolean hasNext() 
	{
		try
		{
			if(nextLine == null)
			{
				src.close();
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
			throw new RuntimeException("IOException when attempting close");
		}
	}

	@Override
	public String next() 
	{
		try
		{
			String res = nextLine;
			nextLine = src.readLine();
			return res;
		}
		catch(IOException e)
		{
			e.printStackTrace();
			throw new RuntimeException("IOException when attempting readLine");
		}
	}
}
