package tarefa1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Start {

	public static void main(String[] args) {
		Indexer i = new Indexer();
		try {
			i.indexer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
