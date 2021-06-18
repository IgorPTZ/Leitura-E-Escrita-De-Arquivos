package leitura.escrita.arquivos;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class EscritaEmTXT {
	
	public static void main(String[] args) {
		
		try {
			
			/* *************************************************************************** */
			
			File arquivo1 = new File("E:\\Users\\Igor\\Desktop\\Meus Projetos - Java\\2 - Eclipse\\Leitura-Escrita-Arquivos\\src\\leitura\\escrita\\arquivos\\textos.txt");
		
			if(!arquivo1.exists()) {
				
				arquivo1.createNewFile();
			}
			
			FileWriter escritaNoArquivo1 = new FileWriter(arquivo1);
			
			escritaNoArquivo1.write("Alguma coisa escrita no arquivo");
			
			escritaNoArquivo1.write("\n");
			
			escritaNoArquivo1.write("Alguma coisa escrita no arquivo²");
			
			escritaNoArquivo1.write("\n"); 
			
			for(int i = 0; i < 10; i++) {
				
				escritaNoArquivo1.write((i + 1) + "\n");
			}
			
			escritaNoArquivo1.flush();
			
			escritaNoArquivo1.close();
			
			/* *************************************************************************** */
			
			Pessoa pessoa1 = new Pessoa("Igor", "igor.ptw@hotmail.com", 27L);
			
			Pessoa pessoa2 = new Pessoa("Maria", "maria.ptw@hotmail.com", 28L);
			
			Pessoa pessoa3 = new Pessoa("Jose", "jose.ptw@hotmail.com", 29L);
			
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			
			pessoas.add(pessoa1);
			
			pessoas.add(pessoa2);
			
			pessoas.add(pessoa3);
			
			
			File arquivo2 = new File("E:\\Users\\Igor\\Desktop\\Meus Projetos - Java\\2 - Eclipse\\Leitura-Escrita-Arquivos\\src\\leitura\\escrita\\arquivos\\pessoas.txt");
		
			if(!arquivo2.exists()) {
				
				arquivo2.createNewFile();
			}
			
			FileWriter escritaNoArquivo2 = new FileWriter(arquivo2);
			
			for(Pessoa pessoa : pessoas) {
				
				escritaNoArquivo2.write(pessoa.getNome() + ";" + pessoa.getEmail() + ";" + pessoa.getIdade() + "\n");
			}
			
			escritaNoArquivo2.flush();
			
			escritaNoArquivo2.close();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
}
