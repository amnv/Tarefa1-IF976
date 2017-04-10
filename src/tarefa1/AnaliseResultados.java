package tarefa1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.lucene.search.IndexSearcher;

public class AnaliseResultados 
{
	private int mat[][];
	
	public AnaliseResultados() {
	 this.mat = new int[2][200];
	 
		 for (int i = 0; i < mat.length; i++) {
			 for (int j = 0; j < mat[i].length; j++) {
				 this.mat[i][j] = 0;
			 }
		}
	}
	
	public void geraMatrizRelevancia(boolean flag) throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter(new File("matrizRelevancia.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append(",");
        for (int i = 1; i <= 200; i++) {
        	String aux = "Doc " + i;
        	sb.append(aux);
        	sb.append(",");
		}
        sb.append("\n");
               
        sb.append("Consulta 1");
        sb.append(',');
     
        for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				sb.append(this.mat[i][j]);
				sb.append(",");
			}
			sb.append("\n");
			if (i <= 0)
			{
				sb.append("Consulta 2");
				sb.append(",");
			}
		}
        
        
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
        
	}
		
	public void addDoc(String doc, boolean flag) throws IOException
	{
		int coluna = 0;
		if (flag == false) coluna = 1; 
		String str = doc.replaceAll("\\D+","");
		int valor = Integer.parseInt(str);
		this.mat[coluna][valor-1] = 1;
	}
}

