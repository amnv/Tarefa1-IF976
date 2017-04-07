package tarefa1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;

public class Indexer
{
	private Leitor leitor;
	private int count;
	
	public Indexer()
	{
		this.leitor = new Leitor(new File("documentos"));
		this.count = 0;
	}
	
	private Document createDocument() throws IOException  
	{
			Document document = new Document();	
			String texto = this.leitor.getNextTexto();
			count++;
			System.out.println(count);
			if (texto.equals("erro")) return null;
			
			document.add(new Field("fieldname", texto, TextField.TYPE_STORED));		
			return document;	
	}
	
	public void indexer() throws IOException, FileNotFoundException
	{
		Directory dir = FSDirectory.open(FileSystems.getDefault().getPath("result"));
		Analyzer analyzer = new StandardAnalyzer();
		Document doc;
		IndexWriterConfig conf = new IndexWriterConfig(analyzer);
		IndexWriter iw = new IndexWriter(dir, conf);
		while (true) {
			doc = createDocument();
			if (doc == null) break;
			iw.addDocument(doc);
		} 
		iw.close();
	}
}
