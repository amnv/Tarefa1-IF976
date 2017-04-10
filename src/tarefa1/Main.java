package lucene;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		boolean stopword = false;
		boolean stemming = false;
		String resposta;

		System.out.println("Enter path: ");
		String docsPath = in.nextLine();
		
		System.out.println("Escolha entre as opções abaixo: " +
							"\n 1 - SEM stopword e SEM stemming" +
							"\n 2 - SEM stopword e COM stemming" +
							"\n 3 - COM stopword e SEM stemming" +
							"\n 4 - COM stopword e COM stemming");
		int opcao = in.nextInt();
		
		switch (opcao) {
		case 1:
			// continua oq ja esta (false false)
			break;
		
		case 2:
			stemming = true;
			break;
		
		case 3: 
			stopword = true;
			break;
			
		case 4:
			stopword = true;
			stemming = true;
			break;
			
		default:
			break;
		}

		IndexFiles indexacao = new IndexFiles(stopword, stemming, docsPath);
		indexacao.main(args);
		SearchFiles recuperacao = new SearchFiles(stopword, stemming);

		try {
			recuperacao.main(args);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
