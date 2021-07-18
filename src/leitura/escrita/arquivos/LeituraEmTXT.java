package leitura.escrita.arquivos;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeituraEmTXT {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		try {
			
			FileInputStream entradaDoArquivo = new FileInputStream("E:\\Users\\Igor\\Desktop\\Meus Projetos - Java\\2 - Eclipse\\Leitura-Escrita-Arquivos\\src\\leitura\\escrita\\arquivos\\pessoas.txt");
		
			Scanner leituraDoArquivo = new Scanner(entradaDoArquivo, "UTF-8");
			
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			
			while(leituraDoArquivo.hasNext()) {
				
				String linha = leituraDoArquivo.nextLine();
				
				if(linha != null && !linha.isEmpty()) {
					
					String[] dados = linha.split("\\;");
					
					Pessoa pessoa = new Pessoa(dados[0], dados[1], Long.parseLong(dados[2]));
					
					pessoas.add(pessoa);
				}
			}
			
			System.out.println(pessoas);
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
}
