package tarefa1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leitor 
{
	File file;
	List filesList;
	
	public Leitor (File file) 
	{ 
		this.file = file;
		this.filesList = new ArrayList<File>();
		this.setCollection();
	}
		
	public String getTexto(FileReader reader) 
	{
		BufferedReader  br = new BufferedReader(reader);
		StringBuilder sb = new StringBuilder();
		
		try 
		{
			String line = br.readLine();
			while (line != null) 
			{
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return sb.toString();
	}
	
	private void setCollection() 
	{
		File[] files = this.file.listFiles();
		
		for (int i = 0; i < files.length; i++) 
		{
			if (files[i].isFile()) this.filesList.add(files[i]);
		}
	}
	
	public FileReader getNextFile() throws FileNotFoundException
	{
		if (this.filesList.isEmpty()) return null;
		
		FileReader f = new FileReader(((File) this.filesList.get(0)).getPath()); 
		this.filesList.remove(0);
		return f;
	}
	
	public String getNextTexto() throws FileNotFoundException
	{
		FileReader f = this.getNextFile();
		if (f == null) return "erro";
		return this.getTexto(f);
	}
}
