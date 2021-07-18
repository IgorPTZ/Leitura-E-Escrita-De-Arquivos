package leitura.escrita.arquivos;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class EscritaEmCSV {
	public static void main(String[] args) {
		
		try {
			
			Pessoa pessoa1 = new Pessoa("Igor", "igor.ptw@hotmail.com", 27L);
			
			Pessoa pessoa2 = new Pessoa("Maria", "maria.ptw@hotmail.com", 28L);
			
			Pessoa pessoa3 = new Pessoa("Jose", "jose.ptw@hotmail.com", 29L);
			
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			
			pessoas.add(pessoa1);
			
			pessoas.add(pessoa2);
			
			pessoas.add(pessoa3);
			
			
			File arquivo = new File("E:\\Users\\Igor\\Desktop\\Meus Projetos - Java\\2 - Eclipse\\Leitura-Escrita-Arquivos\\src\\leitura\\escrita\\arquivos\\pessoas.csv");
		
			if(!arquivo.exists()) {
				
				arquivo.createNewFile();
			}
			
			FileWriter escritaNoarquivo = new FileWriter(arquivo);
			
			for(Pessoa pessoa : pessoas) {
				
				escritaNoarquivo.write(pessoa.getNome() + ";" + pessoa.getEmail() + ";" + pessoa.getIdade() + "\n");
			}
			
			escritaNoarquivo.flush();
			
			escritaNoarquivo.close();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
}
